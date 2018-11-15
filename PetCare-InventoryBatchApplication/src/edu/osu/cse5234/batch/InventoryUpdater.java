package edu.osu.cse5234.batch;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;

public class InventoryUpdater {
	
	public static void main(String[] args) {

		System.out.println("Starting Inventory Update ...");
		try {
				Connection conn = createConnection();
				Collection<Integer> newOrderIds = getNewOrders(conn);
				Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds, conn);
				udpateInventory(orderedItems, conn);
				udpateOrderStatus(newOrderIds, conn);
				conn.close();
			} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = (Connection) DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		return conn;
	}

	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException {
		Collection<Integer> orderIds = new ArrayList<Integer>();
		ResultSet rset = ((java.sql.Connection) conn).createStatement().executeQuery(
                     "select ID from CUSTOMER_ORDER where STATUS = 'New'");
		while (rset.next()) {
			orderIds.add(new Integer(rset.getInt("ID")));
		}
		return orderIds;
	}

	private static Map<Integer, Integer> getOrderedLineItems(Collection<Integer> newOrderIds,
                Connection conn)  throws SQLException {
		// TODO Auto-generated method stub
		// This method returns a map of two integers. The first Integer is item ID, and 
        // the second is cumulative requested quantity across all new orders
		
		Map<Integer, Integer> newResult = new HashMap<>();
		
		ResultSet rset = ((java.sql.Connection) conn).createStatement().executeQuery(
				"select ITEM_NUMBER, QUANTITY, CUSTOMER_ORDER_ID_FK from CUSTOMER_ORDER_LINE_ITEM");
		
		while(rset.next())
		{
			int cust_order_ID = rset.getInt("CUSTOMER_ORDER_ID_FK");
			int item_number = rset.getInt("ITEM_NUMBER");
			int quantity = rset.getInt("QUANTITY");
			
			if(newOrderIds.contains(cust_order_ID))
			{
				if(newResult.containsKey(item_number))
					newResult.replace(item_number, newResult.get(item_number) + quantity );
				else
					newResult.put(item_number, quantity);
			}
			else
			{
				System.out.println("It was not a new order:"+cust_order_ID);
			}
		}
		
		return null;
	}

	private static void udpateInventory(Map<Integer, Integer> orderedItems, 
                Connection conn) throws SQLException {
		// TODO Auto-generated method stub	
		//Just subtract the count of available items from the ITEM table.
		
		//Get the rset to ITEM Table
		ResultSet dataquery = ((java.sql.Connection) conn).createStatement().executeQuery(
				"select ITEM_NUMBER, AVAILABLE_QUANTITY from ITEM");
		
		while(dataquery.next())
		{
			int item_numb = dataquery.getInt("ITEM_NUMBER");
			int qty = dataquery.getInt("AVAILABLE_QUANTITY");
			
			if(orderedItems.containsKey(item_numb))
			{
				if(qty <= orderedItems.get(item_numb)) {
				int update_qty = orderedItems.get(item_numb) - qty;
				ResultSet tempQuery = ((java.sql.Connection) conn).createStatement().executeQuery(
						"update ITEM set AVAILABLE_QUANTITY=update_qty where ITEM_NUMBER=item_numb");
				}
				else
				{
					System.out.println("Too many qty specified. Try with lower qty..");
				}
			}
		}

	}

	private static void udpateOrderStatus(Collection<Integer> newOrderIds, 
                Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
		// Since the order was processed, update the order to "Processed"
		for(int i: newOrderIds)
		{
			ResultSet tempQuery = ((java.sql.Connection) conn).createStatement().executeQuery(
					"update CUSTOMER_ORDER set STATUS=Processed where ID=i");
		}

	}

}

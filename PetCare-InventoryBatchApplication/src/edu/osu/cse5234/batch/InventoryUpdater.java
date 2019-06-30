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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:h2:C:/Users/kevin/Documents/workspace/cse5234/PetCare/h2db/PetCareDB;AUTO_SERVER=TRUE", "sa", "");

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

	private static Map<Integer, Integer> getOrderedLineItems(
			Collection<Integer> newOrderIds, Connection conn)  throws SQLException {
		// TODO Auto-generated method stub
		// This method returns a map of two integers. The first Integer is item ID, and 
        // the second is cumulative requested quantity across all new orders
		
		Map<Integer, Integer> newResult = new HashMap<>();
		
		ResultSet rset = ((java.sql.Connection) conn).createStatement().executeQuery(
				"select ITEM_ID, QUANTITY, CUSTOMER_ORDER_ID_FK from CUSTOMER_ORDER_LINE_ITEM");
		
		while(rset.next()) {
			int customerOrderId = rset.getInt("CUSTOMER_ORDER_ID_FK");
			int itemId = rset.getInt("ITEM_ID");
			int quantity = rset.getInt("QUANTITY");
			
			if(newOrderIds.contains(customerOrderId)) {
				newResult.put(itemId, newResult.getOrDefault(itemId, 0) + quantity);
			}
			else {
				System.out.println("It was not a new order:" + customerOrderId);
			}
		}
		
		return newResult;
	}

	private static void udpateInventory(Map<Integer, Integer> orderedItems, 
                Connection conn) throws SQLException {
		// TODO Auto-generated method stub	
		//Just subtract the count of available items from the ITEM table.
		
		//Get the rset to ITEM Table
		ResultSet dataquery = ((java.sql.Connection) conn).createStatement().executeQuery(
				"select ITEM_ID, QUANTITY from ITEM");
		
		while(dataquery.next()) {
			int itemId = dataquery.getInt("ITEM_ID");
			int quantity = dataquery.getInt("QUANTITY");
			
			if(orderedItems.containsKey(itemId)) {
				if(quantity <= orderedItems.get(itemId)) {
				int updateQuantity = orderedItems.get(itemId) - quantity;
				ResultSet tempQuery = ((java.sql.Connection) conn).createStatement().executeQuery(
						"update ITEM set QUANTITY=" + updateQuantity +" where ITEM_ID=" + itemId);
				}
				else {
					System.out.println("Too many qty specified. Try with lower qty..");
				}
			}
		}
	}

	private static void udpateOrderStatus(Collection<Integer> newOrderIds, 
                Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
		// Since the order was processed, update the order to "Processed"
		for(int i: newOrderIds) {
			ResultSet tempQuery = ((java.sql.Connection) conn).createStatement().executeQuery(
					"update CUSTOMER_ORDER set STATUS=Processed where ID=" + i);
		}
	}
}

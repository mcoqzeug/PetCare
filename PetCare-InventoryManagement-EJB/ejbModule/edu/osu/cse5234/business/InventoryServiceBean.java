package edu.osu.cse5234.business;

import java.util.Collection;
//import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
//import edu.osu.cse5234.model.LineItem;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	@PersistenceContext
	EntityManager entityManager;
	
	public static final String MY_QUERY = "Select i from Item i";
	
//	private HashMap<String, Integer> map = new HashMap<>();
	
    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		List<Item> items = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
		Inventory inventory = new Inventory();
		inventory.setItems(items);
		return inventory;
	}

	@Override
	public boolean validateQuantity(Collection<Item> items) {
		boolean valid = true;
//		Inventory inventory = getAvailableInventory();
//		List<Item> items = inventory.getItems();
//		
//		for (Item item: items) {
//			map.put(item.getName(), item.getAvailableQuantity());
//		}
//		
//		for (LineItem lineItem: lineItems) {
//			String itemName = lineItem.getItemName();
//			int quantity = lineItem.getQuantity();
//			if (!map.containsKey(itemName) || quantity > map.get(itemName)) {
//				valid = false;
//			}
//		}
		
		return valid;
	}

	@Override
	public boolean updateInventory(Collection<Item> Items) {  // TODO LineItems?
//		Inventory inventory = getAvailableInventory();
//		List<Item> items = inventory.getItems();
//		int availableQuantity;
//		String itemName;
//		int quantity;
//		
//		for (LineItem lineItem: lineItems) {
//			itemName = lineItem.getItemName();
//			quantity = lineItem.getQuantity();
//			for (Item item: items) {
//				if (item.getName().equals(itemName)) {
//					availableQuantity = item.getAvailableQuantity();
//					item.setAvailableQuantity(availableQuantity - quantity);
//				}
//			}
//		}
//		
//		inventory.setItems(items);
		
		return true;  // TODO ?
	}

}

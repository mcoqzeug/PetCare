package edu.osu.cse5234.business;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	@PersistenceContext
	EntityManager entityManager;
	
	private static final String MY_QUERY = "Select i from Item i";
	
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
	public boolean validateQuantity(List<Item> orderItems) {
		boolean valid = true;
		Inventory inventory = getAvailableInventory();
		List<Item> items = inventory.getItems();
		Item orderItem, item;
		
		for (int i=0; i<orderItems.size() && i<items.size(); i++) {
			orderItem = orderItems.get(i);
			item = items.get(i);
			
			if (item.getAvailableQuantity() < orderItem.getItemNumber()) {
				valid = false;
			}
		}

		return valid;
	}

	@Override
	public boolean updateInventory(List<Item> orderItems) {
		Inventory inventory = getAvailableInventory();
		List<Item> items = inventory.getItems();
		Item orderItem, item;
		int availableQuantity, quantity;
		
		for (int i=0; i<orderItems.size() && i<items.size(); i++) {
			orderItem = orderItems.get(i);
			item = items.get(i);
			
			availableQuantity = item.getAvailableQuantity();
			quantity = orderItem.getAvailableQuantity();
			
			item.setAvailableQuantity(availableQuantity - quantity);
		}
		
		inventory.setItems(items);
		
		return true;  // TODO ?
	}

}

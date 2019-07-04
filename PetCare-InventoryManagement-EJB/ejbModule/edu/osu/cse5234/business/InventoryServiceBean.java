package edu.osu.cse5234.business;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		// query is case sensitive and should match the class name and field name in java
		String query = "SELECT i FROM Item i WHERE i.quantity > 0";
		List<Item> items = entityManager.createQuery(query, Item.class).getResultList();

		// List --> Map
		Map<Integer, Item> map = new HashMap<>();
		for (Item item: items) {
			map.put(item.getId(), item);
		}

		Inventory inventory = new Inventory();
		inventory.setMap(map);
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<Item> orderItems) {
		Map<Integer, Item> map = getAvailableInventory().getMap();

		for (Item orderItem: orderItems) {
			int itemId = orderItem.getId();
			if (!map.containsKey(itemId)) return false;
			Item inventoryItem = map.get(itemId);
			if (inventoryItem.getQuantity() < orderItem.getQuantity()) return false;
		}

		return true;
	}

	@Override
	public boolean updateInventory(List<Item> orderItems) {
		Map<Integer, Item> map = getAvailableInventory().getMap();

		for (Item orderItem: orderItems) {
			int itemId = orderItem.getId();
			if (!map.containsKey(itemId)) {
				System.out.println("Ordered item not found!");
				continue;
			}

			int inventoryQuantity = map.get(itemId).getQuantity() - orderItem.getQuantity();

			String updateQuery = "update Item set quantity = " + Integer.toString(inventoryQuantity) + 
					" where id = " + Integer.toString(itemId);
			System.out.println(updateQuery);
			entityManager.createQuery(updateQuery).executeUpdate();
			entityManager.flush();
		}

		return true;  // TODO: why?
	}

}

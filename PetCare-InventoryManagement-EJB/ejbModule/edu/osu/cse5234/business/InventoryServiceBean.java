package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.List;
import java.util.Arrays;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless

@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	@PersistenceContext
	private EntityManager entityManager;
	
	public static final String MY_QUERY = "Select i from Item i";
	
    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		Inventory inv = new Inventory();
//		List<Item> items = entityManager.createQuery(MY_QUERY, Item.class).getResultList();
//		inv.setItems(items);
		List<Item> items = Arrays.asList(
				new Item("Dry Cat Food", "12.99", "0"), 
				new Item("Wet Cat Food", "15.99", "0"),
				new Item("Cat Litter", "19.99", "0"));
		inv.setItems(items);
		
		
		return inv;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		Inventory inv = getAvailableInventory();
		List<Item> availableItems = inv.getItems();
		
		boolean valid = false;
		
		for (int i=0; i<items.size(); i++) {
			
		}
		
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

}

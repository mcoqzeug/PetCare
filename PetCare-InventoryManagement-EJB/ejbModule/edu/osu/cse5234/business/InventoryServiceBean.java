package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	
    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public Inventory getAvailableInventory() {
    	List<Item> items = Arrays.asList(
			new Item("Dry Cat Food", "12.99", "0"), 
			new Item("Wet Cat Food", "15.99", "0"),
			new Item("Cat Litter", "19.99", "0")
		);
    	
    	Inventory inventory = new Inventory(items);
    	
    	return inventory;
    }
    
    public boolean validateQuantity(List<Item> items) {
    	return true;
    }
    
	public boolean updateInventory(List<Item> items) {
		return true;
	}

}

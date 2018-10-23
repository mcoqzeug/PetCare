package edu.osu.cse5234.business.view;

import java.util.Collection;

//import edu.osu.cse5234.model.LineItem;

public interface InventoryService {
	public Inventory getAvailableInventory();
	public boolean validateQuantity(Collection<Item> Items);
	public boolean updateInventory(Collection<Item> Items);
}

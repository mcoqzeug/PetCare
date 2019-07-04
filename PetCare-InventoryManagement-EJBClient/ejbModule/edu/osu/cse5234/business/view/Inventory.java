package edu.osu.cse5234.business.view;

//import java.util.List;
import java.util.Map;

public class Inventory implements java.io.Serializable {
	private static final long serialVersionUID = 4880922429803008945L;
//	private List<Item> items;
	private Map<Integer, Item> map;  // item_id --> item

	public Inventory() {}

//	public Inventory(List<Item> items) {
//		this.items = items;
//	}

//	public List<Item> getItems() {
//		return items;
//	}

//	public void setItems(List<Item> items) {
//		this.items = items;
//	}

	public Map<Integer, Item> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Item> map) {
		this.map = map;
	}
}

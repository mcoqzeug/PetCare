package edu.osu.cse5234.model;

import java.util.*;

import edu.osu.cse5234.business.view.Item;

public class Order {
	private List<Item> items;
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
}

package edu.osu.cse5234.business.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ITEM")
public class Item implements java.io.Serializable{
	@Transient
	private static final long serialVersionUID = 5238185927943559551L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="ITEM_NUMBER")
	private int itemNumber;

	@Column(name="UNIT_PRICE")
	private double unitPrice;
	
	@Column(name="AVAILABLE_QUANTITY")
	private int availableQuantity;
	
//	@Transient
//	private String quantity;
//	
//	@Transient
//	private String price;
	
	public Item() {}
	
//	public Item(String name, String price, String quantity) {
//		this.name = name;
//		this.price = price;
//		this.quantity = quantity;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

//	public String getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(String quantity) {
//		this.quantity = quantity;
//	}

//	public String getPrice() {
//		return price;
//	}
//
//	public void setPrice(String price) {
//		this.price = price;
//	}
}

package edu.osu.cse5234.business.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ITEM")
public class Item implements java.io.Serializable {
	@Transient
	private static final long serialVersionUID = 5238185927943559551L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "ITEM_NAME")
	private String name;

	@Column(name = "ITEM_DESCRIPTION")
	private String description;

	@Column(name = "UNIT_PRICE")
	private double unitPrice;

	@Column(name = "QUANTITY")
	private int quantity;

	public Item() {
	}

	public Item(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

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

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

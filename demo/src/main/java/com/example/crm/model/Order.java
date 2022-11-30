package com.example.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int")
	private Long id;
	@Column(name = "type_presta")
	private String typePresta;
	@Column(name = "designation")
	private String designation;
	@Column(name = "nb_days")
	private int nbDays;
	@Column(name = "unit_price")
	private double unitPrice;
	@Column(name = "state", columnDefinition = "BIT")
	private OrderState state;
	
	@ManyToOne
	private Client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getTypePresta() {
		return typePresta;
	}

	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getNbDays() {
		return nbDays;
	}

	public void setNbDays(int nbDays) {
		this.nbDays = nbDays;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public Order() {
	}

	public Order(Long clientId, String typePresta, String designation, int nbDays, double unitPrice, OrderState state,
			double totalExcludeTaxe, double totalWithTaxe) {
		this.typePresta = typePresta;
		this.designation = designation;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = OrderState.OPTION;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", typePresta=" + typePresta + ", designation="
				+ designation + ", nbDays=" + nbDays + ", unitPrice=" + unitPrice + ", state=" + state
			 + "]";
	}

}

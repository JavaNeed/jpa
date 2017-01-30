package net.javabeat.springdata.jpa.data;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;


/**
 * The persistent class for the orderdetails database table.
 * 
 */
@Entity
@Table(name="orderdetails")
@NamedQuery(name="Orderdetail.findAll", query="SELECT o FROM Orderdetail o")
@DynamicUpdate(true)
public class Orderdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderdetailPK id;

	private short orderLineNumber;

	private double priceEach;

	private int quantityOrdered;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderNumber", updatable=false, insertable=false)
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productCode",updatable=false, insertable=false)
	private Product product;

	public Orderdetail() {
	}

	public OrderdetailPK getId() {
		return this.id;
	}

	public void setId(OrderdetailPK id) {
		this.id = id;
	}

	public short getOrderLineNumber() {
		return this.orderLineNumber;
	}

	public void setOrderLineNumber(short orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public double getPriceEach() {
		return this.priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public int getQuantityOrdered() {
		return this.quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
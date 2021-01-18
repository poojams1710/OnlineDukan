package com.springboot.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order_item")


public class OrderItem {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Long id;

	    @Column(name="image_url")
	    private String imageUrl;

	    @Column(name="unit_price")
	    private BigDecimal unitPrice;

	    @Column(name="quantity")
	    private int quantity;

	    

	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private Order order;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public BigDecimal getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(BigDecimal unitPrice) {
			this.unitPrice = unitPrice;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		

		

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}
}









package com.h.myapp.orderdetails;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.h.myapp.goods.Goods;
import com.h.myapp.order.Order;

@Entity(name = "torderdetails")
public class OrderDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderdetailsId;
	@ManyToOne(targetEntity = Order.class)
	@JoinColumn(name = "orderId", referencedColumnName = "orderId", nullable = false)
	@JsonIgnore
	private Order order;
	@ManyToOne(targetEntity = Goods.class)
	@JoinColumn(name = "goodsId", referencedColumnName = "goodsId", nullable = false)
	private Goods goods;
	private Integer orderNum;
	private Double orderPrice;

	public OrderDetails() {
		super();
	}

	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}



	public Integer getOrderdetailsId() {
		return orderdetailsId;
	}



	public void setOrderdetailsId(Integer orderdetailsId) {
		this.orderdetailsId = orderdetailsId;
	}



	public Integer getOrderNum() {
		return orderNum;
	}



	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}



	public Double getOrderPrice() {
		return orderPrice;
	}



	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderdetailsId == null) ? 0 : orderdetailsId.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		if (orderdetailsId == null) {
			if (other.orderdetailsId != null)
				return false;
		} else if (!orderdetailsId.equals(other.orderdetailsId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "OrderDetails [orderdetailsId=" + orderdetailsId + ", order=" + order + ", goods=" + goods
				+ ", orderNum=" + orderNum + ", orderPrice=" + orderPrice + "]";
	}

	

}

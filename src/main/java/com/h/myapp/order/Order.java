package com.h.myapp.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.h.myapp.customer.Customer;
import com.h.myapp.orderdetails.OrderDetails;

@Entity(name = "torder")
public class Order implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
	private Customer customer;

	private String orderName;
	private String orderCountry;
	private String orderEmail;
	public String getOrderEmail() {
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	private String orderTel;
	private String orderAddress;
	private String orderPostCode;
	private String orderPostType;
	private String orderPostNo;
	private String note="";
	private Double orderPostMoney;
	//待审核,待发货,已发货,已取消
	private String orderStatus="待发货";
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date orderDate;
	@OneToMany(targetEntity = OrderDetails.class, cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)

	private List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

	public Order() {
		super();
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderCountry() {
		return orderCountry;
	}

	public void setOrderCountry(String orderCountry) {
		this.orderCountry = orderCountry;
	}

	public String getOrderTel() {
		return orderTel;
	}

	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderPostCode() {
		return orderPostCode;
	}

	public void setOrderPostCode(String orderPostCode) {
		this.orderPostCode = orderPostCode;
	}

	public String getOrderPostType() {
		return orderPostType;
	}

	public void setOrderPostType(String orderPostType) {
		this.orderPostType = orderPostType;
	}

	public String getOrderPostNo() {
		return orderPostNo;
	}

	public void setOrderPostNo(String orderPostNo) {
		this.orderPostNo = orderPostNo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Double getOrderPostMoney() {
		return orderPostMoney;
	}

	public void setOrderPostMoney(Double orderPostMoney) {
		this.orderPostMoney = orderPostMoney;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		Order other = (Order) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", orderName=" + orderName + ", orderCountry="
				+ orderCountry + ", orderEmail=" + orderEmail + ", orderTel=" + orderTel + ", orderAddress="
				+ orderAddress + ", orderPostCode=" + orderPostCode + ", orderPostType=" + orderPostType
				+ ", orderPostNo=" + orderPostNo + ", note=" + note + ", orderPostMoney=" + orderPostMoney
				+ ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", orderDetails=" + orderDetails + "]";
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	

	
}

package com.h.myapp.goodsandsupplier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.h.myapp.goods.Goods;
import com.h.myapp.supplier.Supplier;

@Entity(name = "tgoodsAndSupplier")
public class GoodsAndSupplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer goodsandsupplierId;
	@ManyToOne(targetEntity = Goods.class)
	@JoinColumn(name = "goodsId", referencedColumnName = "goodsId", nullable = false)
	
	private Goods goods;

	@ManyToOne(targetEntity = Supplier.class)
	@JoinColumn(name = "supplierId", referencedColumnName = "supplierId", nullable = false)
	private Supplier supplier;
	private Double price;
	private String note="";
	@Column(length=500)
	private String goodsLink="#";

	public GoodsAndSupplier() {
		super();
	}

	public Integer getGoodsandsupplierId() {
		return goodsandsupplierId;
	}

	public void setGoodsandsupplierId(Integer goodsandsupplierId) {
		this.goodsandsupplierId = goodsandsupplierId;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getGoodsLink() {
		return goodsLink;
	}

	public void setGoodsLink(String goodsLink) {
		this.goodsLink = goodsLink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsandsupplierId == null) ? 0 : goodsandsupplierId.hashCode());
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
		GoodsAndSupplier other = (GoodsAndSupplier) obj;
		if (goodsandsupplierId == null) {
			if (other.goodsandsupplierId != null)
				return false;
		} else if (!goodsandsupplierId.equals(other.goodsandsupplierId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoodsAndSupplier [goodsandsupplierId=" + goodsandsupplierId + ", goods=" + goods + ", supplier="
				+ supplier + ", price=" + price + ", note=" + note + ", goodsLink=" + goodsLink + "]";
	}

	

}

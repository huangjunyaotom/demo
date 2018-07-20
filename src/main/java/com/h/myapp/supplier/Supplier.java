package com.h.myapp.supplier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.h.myapp.goodsandsupplier.GoodsAndSupplier;

@Entity(name = "tsupplier")
public class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplierId;
	private String supplierName;
	@Column(length=500)
	private String supplierLink="#";
	private String note="";

	@OneToMany(targetEntity = GoodsAndSupplier.class, cascade = CascadeType.ALL, mappedBy = "supplier",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<GoodsAndSupplier> goodsAndSupplier = new ArrayList<GoodsAndSupplier>();

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	

	

	public List<GoodsAndSupplier> getGoodsAndSupplier() {
		return goodsAndSupplier;
	}

	public void setGoodsAndSupplier(List<GoodsAndSupplier> goodsAndSupplier) {
		this.goodsAndSupplier = goodsAndSupplier;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierLink="
				+ supplierLink + ", note=" + note + ", goodsAndSupplier=" + goodsAndSupplier + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
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
		Supplier other = (Supplier) obj;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		return true;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierLink() {
		return supplierLink;
	}

	public void setSupplierLink(String supplierLink) {
		this.supplierLink = supplierLink;
	}

	public Supplier() {
		super();
	}

}

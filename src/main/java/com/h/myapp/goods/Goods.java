package com.h.myapp.goods;

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

@Entity(name = "tgoods")
public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer goodsId;
	@Column(nullable=false,unique=true)
	private String goodsNo;
	private String goodsName;
	private String note="";
	private String goodsPic;

	@OneToMany(targetEntity = GoodsAndSupplier.class, cascade = CascadeType.ALL, mappedBy = "goods",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<GoodsAndSupplier> goodsAndSupplier = new ArrayList<GoodsAndSupplier>();

	public Goods() {
		super();
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getGoodsPic() {
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	

	public List<GoodsAndSupplier> getGoodsAndSupplier() {
		return goodsAndSupplier;
	}

	public void setGoodsAndSupplier(List<GoodsAndSupplier> goodsAndSupplier) {
		this.goodsAndSupplier = goodsAndSupplier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
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
		Goods other = (Goods) obj;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsNo=" + goodsNo + ", goodsName=" + goodsName + ", note=" + note
				+ ", goodsPic=" + goodsPic  + "]";
	}

	
}

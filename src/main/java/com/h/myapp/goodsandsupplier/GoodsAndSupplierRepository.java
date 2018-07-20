package com.h.myapp.goodsandsupplier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsAndSupplierRepository extends JpaRepository<GoodsAndSupplier, Integer> {

	List<GoodsAndSupplier> findByGoods_goodsId(Integer goodsId);

	Page<GoodsAndSupplier> findByGoods_goodsNoContainingOrGoods_goodsNameContainingOrSupplier_supplierNameContaining(
			String goodsNo, String goodsName, String supplierName, Pageable pageable);

	Integer countBySupplier_supplierId(Integer supplierId);
}

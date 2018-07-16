package com.h.myapp.goodsandsupplier;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GoodsAndSupplierRepository extends JpaRepository<GoodsAndSupplier,Integer> {

	List<GoodsAndSupplier> findByGoods_goodsId(Integer goodsId);
}

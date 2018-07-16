package com.h.myapp.goodsandsupplier;

import java.util.List;

public interface GoodsAndSupplierService {


	List<GoodsAndSupplier> findByGoods_goodsId(Integer goodsId);

	String deleteByid(Integer id);

	GoodsAndSupplier save(GoodsAndSupplier goodsAndSupplier);
}

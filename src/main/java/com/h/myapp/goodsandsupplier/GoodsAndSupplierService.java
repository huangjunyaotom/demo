package com.h.myapp.goodsandsupplier;

import java.util.List;

import com.h.myapp.util.Result;

public interface GoodsAndSupplierService {

	List<GoodsAndSupplier> findByGoods_goodsId(Integer goodsId);

	String deleteByid(Integer id);

	GoodsAndSupplier save(GoodsAndSupplier goodsAndSupplier);

	Result<GoodsAndSupplier> toPage(Integer toPage);
	Result<GoodsAndSupplier> search(Integer toPage,String param);
}

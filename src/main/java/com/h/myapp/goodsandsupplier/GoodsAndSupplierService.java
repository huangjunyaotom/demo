package com.h.myapp.goodsandsupplier;

import java.util.List;
import java.util.Map;

public interface GoodsAndSupplierService {

	List<GoodsAndSupplier> findByGoods_goodsId(Integer goodsId);

	boolean deleteByid(Integer id);

	GoodsAndSupplier save(GoodsAndSupplier goodsAndSupplier);

	Map<String,Object> toPage(Integer toPage);
	Map<String,Object> search(Integer toPage,String param);
}

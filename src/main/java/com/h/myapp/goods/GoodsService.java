package com.h.myapp.goods;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import com.h.myapp.goodsandsupplier.GoodsAndSupplier;

public interface GoodsService {

	Map<String, Object> toPage(int toPage);

	Map<String, Object> toPageSearch(Integer toPage, String param);

	boolean deleteById(Integer goodsId);

	Goods save(Goods goods, Part file) throws Exception;

	List<GoodsAndSupplier> getSupplier(Integer goodsId);

}

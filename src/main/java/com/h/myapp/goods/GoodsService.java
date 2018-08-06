package com.h.myapp.goods;

import java.util.List;

import javax.servlet.http.Part;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.h.myapp.goodsandsupplier.GoodsAndSupplier;

public interface GoodsService {


	Page<Goods> findAll(Pageable pageable);

	Page<Goods> findAllToPage(int toPage);

	Page<Goods> search(String param,Pageable pageable);
	Page<Goods> search(Integer toPage,String param);
	Goods getOne(int id);

	Goods saveInfo(Goods goods);
	Goods savePic(Goods goods,Part file) throws Exception;
	String deleteById(Integer goodsId);
	
	List<GoodsAndSupplier> getSupplier(Integer goodsId);
}

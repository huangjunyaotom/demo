package com.h.myapp.goods;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsService {


	Page<Goods> findAll(Pageable pageable);

	Page<Goods> findAllToPage(int toPage);

	Page<Goods> search(String param,Pageable pageable);
	Page<Goods> search(Integer toPage,String param);
	Goods getOne(int id);

	Goods saveInfo(Goods goods);
	Goods savePic(Goods goods,MultipartFile file) throws Exception;
	String deleteById(Integer goodsId);
}

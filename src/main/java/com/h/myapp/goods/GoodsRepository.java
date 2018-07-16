package com.h.myapp.goods;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer>{
	Page<Goods> findByGoodsNameContainingOrGoodsNoContaining(String goodsName,String goodsNo,Pageable pageable);
	List<Goods> findByGoodsNo(String goodsNo);
}

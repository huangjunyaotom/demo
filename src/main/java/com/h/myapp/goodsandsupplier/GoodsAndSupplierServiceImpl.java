package com.h.myapp.goodsandsupplier;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsAndSupplierServiceImpl implements GoodsAndSupplierService {
	@Autowired
	private GoodsAndSupplierRepository goodsAndSupplierRepository;
	
	public List<GoodsAndSupplier> findByGoods_goodsId(Integer goodsId) {
		// TODO Auto-generated method stub
		return goodsAndSupplierRepository.findByGoods_goodsId(goodsId);
	}

	@Override
	@Transactional
	public String deleteByid(Integer id) {
		// TODO Auto-generated method stub
		goodsAndSupplierRepository.deleteById(id);
		return "删除成功";
	}

	@Override
	@Transactional
	public GoodsAndSupplier save(GoodsAndSupplier goodsAndSupplier) {
		
		return goodsAndSupplierRepository.save(goodsAndSupplier);
	}

}

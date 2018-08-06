package com.h.myapp.supplier;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.h.myapp.goodsandsupplier.GoodsAndSupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private GoodsAndSupplierRepository goodsAndSupplierRepository;
	
	@Value("${my.defaultPageSize}")
	private Integer pageSize;
	@Override
	public Map<String,Object> toPage(int toPage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		Page<Supplier> page = supplierRepository.findAll(PageRequest.of(toPage, pageSize, Direction.ASC, "supplierId"));
		int totalPage = page.getTotalPages();
		map.put("list", page.getContent());
		map.put("totalPage", totalPage);
		return map;
	}



	@Override
	public Map<String,Object> toPageSearch(Integer toPage,String param) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		Page<Supplier> page = supplierRepository.findBySupplierNameContaining(param, PageRequest.of(toPage, pageSize, Direction.ASC, "supplierId"));
		int totalPage = page.getTotalPages();
		map.put("list", page.getContent());
		map.put("totalPage", totalPage);
		return map; 
	}

	@Override
	@Transactional
	public Supplier save(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierRepository.save(supplier);
	}

	@Override
	public Integer countGoods(Integer supplierId) {
		// TODO Auto-generated method stub
		return goodsAndSupplierRepository.countBySupplier_supplierId(supplierId);
	}

	@Override
	public boolean delete(Integer supplierId) {
		// TODO Auto-generated method stub
		supplierRepository.deleteById(supplierId);
		return true;
	}

}

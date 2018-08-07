package com.h.myapp.goodsandsupplier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class GoodsAndSupplierServiceImpl implements GoodsAndSupplierService {
	@Autowired
	private GoodsAndSupplierRepository goodsAndSupplierRepository;
	@Value("${my.defaultPageSize}")
	private Integer pageSize;

	public List<GoodsAndSupplier> findByGoods_goodsId(Integer goodsId) {
		// TODO Auto-generated method stub
		return goodsAndSupplierRepository.findByGoods_goodsId(goodsId);
	}

	@Override
	@Transactional
	public boolean deleteByid(Integer id) {
		// TODO Auto-generated method stub
		goodsAndSupplierRepository.deleteById(id);
		return true;
	}

	@Override
	@Transactional
	public GoodsAndSupplier save(GoodsAndSupplier goodsAndSupplier) {

		return goodsAndSupplierRepository.save(goodsAndSupplier);
	}

	@Override
	public Map<String, Object> toPage(Integer toPage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		Page<GoodsAndSupplier> page = goodsAndSupplierRepository
				.findAll(PageRequest.of(toPage, pageSize, Direction.ASC, "goodsandsupplierId"));
		int totalPage = page.getTotalPages();
		map.put("list", page.getContent());
		map.put("totalPage", totalPage);
		return map;
	}

	@Override
	public Map<String, Object> search(Integer toPage, String param) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Page<GoodsAndSupplier> page = goodsAndSupplierRepository
				.findByGoods_goodsNoContainingOrGoods_goodsNameContainingOrSupplier_supplierNameContaining(param, param,
						param, PageRequest.of(toPage, pageSize, Direction.ASC, "goodsandsupplierId"));

		int totalPage = page.getTotalPages();
		map.put("list", page.getContent());
		map.put("totalPage", totalPage);
		return map;
	}

}

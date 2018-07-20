package com.h.myapp.goodsandsupplier;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.h.myapp.util.Result;

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

	@Override
	public Result<GoodsAndSupplier> toPage(Integer toPage) {
		// TODO Auto-generated method stub
		Page<GoodsAndSupplier> page = goodsAndSupplierRepository
				.findAll(PageRequest.of(toPage, pageSize, Direction.ASC, "goodsandsupplierId"));
		int totalPage = page.getTotalPages() - 1;
		Result<GoodsAndSupplier> result = new Result<GoodsAndSupplier>();

		result.setResultList(page.getContent());
		result.setFirstPage("/goodsAndSupplier/toPage/0");
		result.setPrePage("/goodsAndSupplier/toPage/" + (toPage > 0 ? toPage - 1 : toPage));
		result.setNextPage("/goodsAndSupplier/toPage/" + (toPage < totalPage ? toPage + 1 : totalPage));
		result.setLastPage("/goodsAndSupplier/toPage/" + totalPage);

		return result;
	}

	@Override
	public Result<GoodsAndSupplier> search(Integer toPage, String param) {
		// TODO Auto-generated method stub
		Page<GoodsAndSupplier> page = goodsAndSupplierRepository
				.findByGoods_goodsNoContainingOrGoods_goodsNameContainingOrSupplier_supplierNameContaining(param, param,
						param, PageRequest.of(toPage, pageSize, Direction.ASC, "goodsandsupplierId"));

		int totalPage = page.getTotalPages() - 1;
		Result<GoodsAndSupplier> result = new Result<GoodsAndSupplier>();

		result.setResultList(page.getContent());
		result.setFirstPage("/goodsAndSupplier/toPage/0/search/"+param);
		result.setPrePage("/goodsAndSupplier/toPage/" + (toPage > 0 ? toPage - 1 : toPage)+"/search/"+param);
		result.setNextPage("/goodsAndSupplier/toPage/" + (toPage < totalPage ? toPage + 1 : totalPage)+"/search/"+param);
		result.setLastPage("/goodsAndSupplier/toPage/" + totalPage+"/search/"+param);

		return result;
	}

}

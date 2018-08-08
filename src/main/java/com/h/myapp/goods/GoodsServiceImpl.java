package com.h.myapp.goods;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.h.myapp.goodsandsupplier.GoodsAndSupplier;
import com.h.myapp.goodsandsupplier.GoodsAndSupplierRepository;
import com.h.myapp.util.FileUtil;
import com.h.myapp.util.no.NoUtilService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsRepository goodsRepository;
	@Autowired
	private GoodsAndSupplierRepository goodsAndSupplierRepository;
	@Autowired
	private NoUtilService noUtilService;
	@Value("${my.savePath}")
	private String savePath;
	@Value("${my.defaultPageSize}")
	private Integer pageSize;

	

	@Transactional
	public boolean deleteById(Integer goodsId) {
		// TODO Auto-generated method stub
		Goods goods = goodsRepository.getOne(goodsId);
		if (null != goods) {
			String exitFile = goods.getGoodsPic();

			if (exitFile != null && exitFile.length() > 0) {
				File exit = new File(savePath + exitFile.substring(1));
				if (exit.exists()) {
					exit.delete();
				}
			}

			goodsRepository.delete(goods);
			return true;
		}
		return false;
	}

	
	@Override
	public List<GoodsAndSupplier> getSupplier(Integer goodsId) {
		// TODO Auto-generated method stub
		return goodsAndSupplierRepository.findByGoods_goodsId(goodsId);
	}

	@Override
	public Map<String, Object> toPage(int toPage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Goods> page = goodsRepository.findAll(PageRequest.of(toPage, pageSize, Direction.ASC, "goodsId"));
		int totalPage = page.getTotalPages();
		map.put("list", page.getContent());
		map.put("totalPage", totalPage);
		return map;
	}

	@Override
	public Map<String, Object> toPageSearch(Integer toPage, String param) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Goods> page = goodsRepository.findByGoodsNameContainingOrGoodsNoContaining(param, param,
				PageRequest.of(toPage, pageSize, Direction.ASC, "goodsId"));
		int totalPage = page.getTotalPages();
		map.put("list", page.getContent());
		map.put("totalPage", totalPage);
		return null;
	}

	@Override
	@Transactional
	public Goods save(Goods goods, Part file) throws Exception {
		// TODO Auto-generated method stub

		if (goods.getGoodsNo() == null || goods.getGoodsNo().length() == 0) {
			goods.setGoodsNo(noUtilService.getNo("Goods"));
		}
		String exitFile = goods.getGoodsPic();
		if (file.getSize() > 0) {
			// 如果文件不为空,则上传文件,如果已有文件,则删除旧的
			if (exitFile != null && exitFile.length() > 0) {
				File exit = new File(savePath + exitFile.substring(1));
				if (exit.exists()) {
					exit.delete();
				}
			}
			String fileType = file.getSubmittedFileName().split("\\.")[1];
			String fileName = noUtilService.getUUID() + "." + fileType;

			FileUtil.save(savePath + "image/", fileName, file);

			goods.setGoodsPic("http://localhost:8080/image/" + fileName);
		}
		return goodsRepository.save(goods);
	}
}

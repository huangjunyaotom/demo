package com.h.myapp.goods;

import java.io.File;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.h.myapp.util.FileUtil;
import com.h.myapp.util.NoUtilService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsRepository goodsRepository;
	@Autowired
	private NoUtilService noUtilService;
	@Value("${my.savePath}")
	private String savePath;
	@Value("${my.defaultPageSize}")
	private Integer pageSize;

	private void checkGoods(Goods goods) {

		if (goods.getGoodsId() != null) {
			Goods exitGoods = goodsRepository.getOne(goods.getGoodsId());
			goods.setGoodsAndSupplier(exitGoods.getGoodsAndSupplier());
			goods.setGoodsPic(exitGoods.getGoodsPic());
		}

		if (goods.getGoodsNo() == null || goods.getGoodsNo().length() == 0) {
			goods.setGoodsNo(noUtilService.getNo("Goods"));
		}
	}

	public Goods getOne(int id) {

		if (goodsRepository.existsById(id)) {
			return goodsRepository.getOne(id);
		} else {
			return null;
		}

	}

	public Page<Goods> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return goodsRepository.findAll(pageable);
	}

	public Page<Goods> findAllToPage(int toPage) {
		// TODO Auto-generated method stub
		return findAll(PageRequest.of(toPage, pageSize, Direction.ASC, "goodsId"));
	}

	public Page<Goods> search(String param, Pageable pageable) {
		return goodsRepository.findByGoodsNameContainingOrGoodsNoContaining(param, param, pageable);
	}

	public Page<Goods> search(Integer toPage, String param) {
		// TODO Auto-generated method stub
		return search(param, PageRequest.of(toPage, pageSize, Direction.ASC, "goodsId"));
	}

	@Transactional
	public Goods savePic(Goods goods, MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		goods = goodsRepository.getOne(goods.getGoodsId());
		String exitFile = goods.getGoodsPic();
		if (!file.isEmpty()) {
			// 如果文件不为空,则上传文件,如果已有文件,则删除旧的
			if (exitFile != null && exitFile.length() > 0) {
				File exit = new File(savePath + exitFile.substring(1));
				if (exit.exists()) {
					exit.delete();
				}
			}
			String fileType = file.getOriginalFilename().split("\\.")[1];
			String fileName = noUtilService.getUUID() + "." + fileType;

			FileUtil.save(savePath + "image/", fileName, file);

			goods.setGoodsPic("/image/" + fileName);
		}

		return goodsRepository.save(goods);
	}

	@Transactional
	public String deleteById(Integer goodsId) {
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
			return "删除成功";
		}
		return "删除失败";
	}

	@Override
	@Transactional
	public Goods saveInfo(Goods goods) {
		// TODO Auto-generated method stub
		checkGoods(goods);
		return goodsRepository.save(goods);
	}
}

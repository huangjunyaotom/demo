package com.h.myapp.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoUtilServiceImpl implements NoUtilService {
	@Autowired
	private NoUtilRepository noUtilRepository;

	public String getUUID() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public String getNo(String entityName) {
		// TODO Auto-generated method stub
		NoUtil noUtil = noUtilRepository.findByEntityName(entityName);
		String today = noUtil.getToday();

		String entityPrefix = noUtil.getEntityPrefix();
		int count = noUtil.getCount();
		String now = new SimpleDateFormat("yyMMdd").format(new Date());
		if (now.equals(today) && today != null) {
			count++;
		} else {
			count = 1;
			today = now;
		}
		noUtil.setToday(today);
		noUtil.setCount(count);
		noUtilRepository.save(noUtil);
		return entityPrefix + now + String.format("%03d", count);
	}

}

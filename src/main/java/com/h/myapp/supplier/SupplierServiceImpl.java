package com.h.myapp.supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	@Value("${my.defaultPageSize}")
	private Integer pageSize;
	@Override
	public Page<Supplier> findAllToPage(int toPage) {
		// TODO Auto-generated method stub
		return supplierRepository.findAll(PageRequest.of(toPage, pageSize, Direction.ASC, "supplierId"));
	}

	@Override
	public Page<Supplier> search(Integer toPage, String param) {
		// TODO Auto-generated method stub
		return search(param, PageRequest.of(toPage, pageSize, Direction.ASC, "supplierId"));
	}

	@Override
	public Page<Supplier> search(String param, Pageable pageable) {
		// TODO Auto-generated method stub
		return supplierRepository.findBySupplierNameContaining(param, pageable);
	}

	@Override
	@Transactional
	public Supplier save(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierRepository.save(supplier);
	}

}

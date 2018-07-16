package com.h.myapp.supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplierService {
	Page<Supplier> findAllToPage(int toPage);
	Page<Supplier> search(String param,Pageable pageable);
	Page<Supplier> search(Integer toPage,String param);
	
	Supplier save(Supplier supplier);
}

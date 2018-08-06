package com.h.myapp.supplier;

import java.util.Map;

public interface SupplierService {
	Map<String,Object> toPage(int toPage);
	Map<String,Object> toPageSearch(Integer toPage,String param);
	Integer countGoods(Integer supplierId);
	boolean delete(Integer supplierId);
	Supplier save(Supplier supplier);
}

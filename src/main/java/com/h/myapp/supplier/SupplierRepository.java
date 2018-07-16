package com.h.myapp.supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

	Page<Supplier> findBySupplierNameContaining(String supplierName,Pageable pageable);
}

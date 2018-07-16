package com.h.myapp.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface NoUtilRepository extends JpaRepository<NoUtil, Integer>{
	NoUtil findByEntityName(String entityName);
}

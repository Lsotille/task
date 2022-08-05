package com.rd.h2db.task.repositories;

import com.rd.h2db.task.models.Product;
import com.rd.h2db.task.models.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<ProductDTO> {
}

package com.rd.h2db.task.repositories.specs.products;

import com.rd.h2db.task.models.dto.ProductDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;


@Repository
public class ProductSpecification {

	public static Specification<ProductDTO> params(String q, Double min_price, String description){

		if(!q.isEmpty() && min_price != null && description != null) {
			return (root, query, builder)->builder.and(builder.like(builder.upper(
					builder.concat(root.get("name"), root.get("description"))), "%" + q.toUpperCase() + "%"));
		}
		else if(!q.isEmpty() && min_price != null && description == null) {
			return (root, query, builder)->builder.and(builder.like(builder.upper(
					builder.concat(root.get("name"), root.get("description"))), "%" + q.toUpperCase() + "%"),
					builder.greaterThanOrEqualTo(root.get("price"), min_price));
		}
		else if(!q.isEmpty() && min_price == null && description != null) {
			return (root, query, builder)->builder.and(builder.like(builder.upper(
					builder.concat(root.get("name"), root.get("description"))), "%" + q.toUpperCase() + "%"),
					builder.lessThanOrEqualTo(root.get("price"), description ));
		}
		else if(!q.isEmpty() && min_price == null && description == null) {
			return (root, query, builder)->builder.like(builder.upper(
					builder.concat(root.get("name"), root.get("description"))), "%" + q.toUpperCase() + "%");
		}
		else if(q.isEmpty() && min_price != null && description == null) {
			return (root, query, builder)->builder.greaterThanOrEqualTo(root.get("price"), min_price);
		}
		else if(q.isEmpty() && min_price == null && description != null) {
			return (root, query, builder)->builder.lessThanOrEqualTo(root.get("price"), description);
		}
		else {
			return null;
		}
	}
}
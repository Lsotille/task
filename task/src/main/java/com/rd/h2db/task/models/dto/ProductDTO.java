package com.rd.h2db.task.models.dto;

import com.rd.h2db.task.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author Rodrigo da Cruz
 * @version 1.0
 * @since 2021-02-25
 * 
 */

@Data
@NoArgsConstructor
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;


	private String name;
	private String description;

	private Double price;

	public ProductDTO(Long id, String name, String description, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
	}
}

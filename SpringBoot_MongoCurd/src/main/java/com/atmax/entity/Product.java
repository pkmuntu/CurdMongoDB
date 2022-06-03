package com.atmax.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private String prodId;
	@NonNull
	private String ProdName;
	@NonNull
	private Double prodPrice;
	@NonNull
	private Integer ProdQuantity;

}

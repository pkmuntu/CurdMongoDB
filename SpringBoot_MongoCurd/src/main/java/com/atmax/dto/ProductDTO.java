package com.atmax.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = -3391450168664193234L;
	private String prodId;
	private String ProdName;
	private Double prodPrice;
	private Integer ProdQuantity;
}

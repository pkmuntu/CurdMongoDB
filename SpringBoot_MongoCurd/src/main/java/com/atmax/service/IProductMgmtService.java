package com.atmax.service;

import java.util.List;

import com.atmax.dto.ProductDTO;

public interface IProductMgmtService {

	public String registerProduct(ProductDTO dto);

	public List<ProductDTO> getAllProduct();

	public ProductDTO getOneProductById(String id);

	public String updateProductById(ProductDTO dto);

	public String deleteProductById(String id);

}

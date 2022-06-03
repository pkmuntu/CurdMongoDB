package com.atmax.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmax.dao.ProductRepo;
import com.atmax.dto.ProductDTO;
import com.atmax.entity.Product;
import com.atmax.exception.ProductNotFoundException;

@Service("productService")
public class ProductMgmtServiceImpl implements IProductMgmtService {

	@Autowired
	private ProductRepo repo;

	@Override
	public String registerProduct(ProductDTO dto) {
		// convert dto to document object
		Product prod = new Product();
		BeanUtils.copyProperties(dto, prod);
		// save document
		prod = repo.insert(prod);
		return "Document is saved having id::" + prod.getProdId();
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		// get the all product
		List<Product> listProd = repo.findAll();
		// create list object having productDTO
		List<ProductDTO> listdto = new ArrayList<ProductDTO>();
		for (Product p : listProd) {
			// convert entity to dto
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(p, dto);
			listdto.add(dto);
		}
		return listdto;
	}

	@Override
	public ProductDTO getOneProductById(String id) {
		Optional<Product> prod = repo.findById(id);
		if (prod.isPresent()) {
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(prod.get(), dto);
			return dto;
		}
		throw new ProductNotFoundException();
	}

	@Override
	public String updateProductById(ProductDTO dto) {
		Optional<Product> prod = repo.findById(dto.getProdId());
		if (prod.isPresent()) {
			Product updateProduct = new Product();
			BeanUtils.copyProperties(dto, updateProduct);
			repo.save(updateProduct);
			return "Product Updated::" + dto.getProdId();
		}
		throw new ProductNotFoundException();
	}

	@Override
	public String deleteProductById(String id) {
		Optional<Product> prod = repo.findById(id);
		if (prod.isPresent()) {
			repo.deleteById(id);
			return "Product deleted::" + id;
		}
		throw new ProductNotFoundException();
	}

}

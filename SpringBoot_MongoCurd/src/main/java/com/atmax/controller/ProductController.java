package com.atmax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atmax.dto.ProductDTO;
import com.atmax.service.IProductMgmtService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductMgmtService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody ProductDTO product) {
		try {
			String saveResponse = service.registerProduct(product);
			ResponseEntity<String> res = new ResponseEntity<String>(saveResponse, HttpStatus.OK);
			return res;
		} catch (Exception e) {
			ResponseEntity<String> res = new ResponseEntity<String>("Problem with save product::" + product,
					HttpStatus.BAD_REQUEST);
			return res;
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllProduct() {
		try {
			ResponseEntity<List<ProductDTO>> res = new ResponseEntity<>(service.getAllProduct(), HttpStatus.OK);
			return res;
		} catch (Throwable t) {
			ResponseEntity<String> res = new ResponseEntity<>("Problem while getting record from db",
					HttpStatus.EXPECTATION_FAILED);
			return res;
		}
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") String id) {
		try {
			ResponseEntity<ProductDTO> res = new ResponseEntity<>(service.getOneProductById(id), HttpStatus.OK);
			return res;
		} catch (Throwable t) {
			ResponseEntity<String> res = new ResponseEntity<>(t.getMessage(), HttpStatus.BAD_REQUEST);
			return res;
		}
	}

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String id) {
		try {
			ResponseEntity<String> res = new ResponseEntity<>(service.deleteProductById(id), HttpStatus.OK);
			return res;
		} catch (Throwable t) {
			ResponseEntity<String> res = new ResponseEntity<>(t.getMessage(), HttpStatus.BAD_REQUEST);
			return res;
		}
	}

	@PutMapping("/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDTO dto) {
		try {
			ResponseEntity<String> res = new ResponseEntity<>(service.updateProductById(dto), HttpStatus.OK);
			return res;
		} catch (Throwable t) {
			ResponseEntity<String> res = new ResponseEntity<>(t.getMessage(), HttpStatus.BAD_REQUEST);
			return res;
		}
	}
}

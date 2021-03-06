package com.ecommerceapp.Groceries.service;



	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.ecommerceapp.Groceries.dao.ProductRepository;
import com.ecommerceapp.Groceries.model.Product;

	
	@Service
	public class ProductService {

		@Autowired
		ProductRepository productRepository;

		public void save(Product product) throws Exception {
			try {
				productRepository.save(product);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

		public List<Product> findAll() throws Exception {
			List<Product> listProduct = null;
			try {
				listProduct = productRepository.findAll();

			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
			return listProduct;
		}

		public void deleteById(Integer id) throws Exception {
			try {
				productRepository.deleteById(id);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

		public void update(Integer id, Product product) throws Exception {
			try {
				//product.setId(id);
				productRepository.save(product);

			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	public Product findById(Integer id) {
			
			Optional<Product> product = productRepository.findById(id);
			if (product.isPresent()) {
				Product productObj = product.get();
				return productObj;
			} else {
				return null;
			}
		}

		
	}



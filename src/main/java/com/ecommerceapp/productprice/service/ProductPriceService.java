package com.ecommerceapp.productprice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecommerceapp.productprice.dao.ProductPriceRepository;
import com.ecommerceapp.productprice.model.ProductPrice;
import com.ecommerceapp.productprice.validation.PriceValidation;



@Component
public class ProductPriceService {
	@Autowired
	ProductPriceRepository productpriceRepository;

	public void save(ProductPrice productprice) throws Exception {
		try {
			PriceValidation.validate(productprice);
			Optional<ProductPrice> pPrice = productpriceRepository.findByProductId(productprice.getProductId());
		
			if (pPrice.isPresent()) {
				System.out.println(pPrice);
				ProductPrice oldProductPrice = pPrice.get();
				oldProductPrice.setEndDate(productprice.getStartDate().minusDays(1));
				productpriceRepository.save(oldProductPrice);

			}

			productpriceRepository.save(productprice);

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}

	}
	public List<ProductPrice> findProducts() throws Exception {
		List<ProductPrice> listProductPrice =productpriceRepository.findAll();
		return listProductPrice;
}
}
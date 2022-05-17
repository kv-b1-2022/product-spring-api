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

	public void save(ProductPrice producrprice) throws Exception {
		try {
			PriceValidation.validate(producrprice);
			Optional<ProductPrice> pPrice = productpriceRepository.findByProductId(producrprice.getProductId());
		
			if (pPrice.isPresent()) {
				System.out.println(pPrice);
				ProductPrice oldProductPrice = pPrice.get();
				oldProductPrice.setEndDate(producrprice.getStartDate().minusDays(1));
				productpriceRepository.save(oldProductPrice);

			}

			productpriceRepository.save(producrprice);

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}

	}
	public List<ProductPrice> findAll() throws Exception {
		List<ProductPrice> listProductPrice = null;
		try {
			listProductPrice = productpriceRepository.findAll();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return listProductPrice;
}
}
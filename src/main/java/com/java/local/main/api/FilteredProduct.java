package com.java.local.main.api;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.java.local.main.model.domain.Product;

public class FilteredProduct {

	protected Set<Product> checkProductByManf(List<Product> productList, String filterParm,
			Map<String, List<String>> filterParams) {
		return productList.stream().filter(product -> filterParams.get("brand").contains(product.getManufacturer()))
				.collect(Collectors.toSet());
	}

	protected Set<Product> getMatrixProductsByCategory(List<Product> productList, String filterParm,
			Map<String, List<String>> filterParms) {
		return productList.stream().filter(product -> filterParms.get("category").contains(product.getCategory()))
				.collect(Collectors.toSet());
	}

	protected Set<Product> productsByLowAndHigh(List<Product> productList) {
		return null;
	}
}

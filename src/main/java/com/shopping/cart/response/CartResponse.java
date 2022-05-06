package com.shopping.cart.response;

import java.util.List;

public class CartResponse {
	private Double totalAmount;
	private List<ProductResponse> productResponse;

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<ProductResponse> getProductResponse() {
		return productResponse;
	}

	public void setProductResponse(List<ProductResponse> productResponse) {
		this.productResponse = productResponse;
	}

}

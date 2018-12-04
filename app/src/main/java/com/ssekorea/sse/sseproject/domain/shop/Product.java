package com.ssekorea.sse.sseproject.domain.shop;

import java.util.List;

public class Product {
    private String productId;

    private List<String> productImageUrls;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<String> getProductImageUrls() {
        return productImageUrls;
    }

    public void setProductImageUrls(List<String> productImageUrls) {
        this.productImageUrls = productImageUrls;
    }
}

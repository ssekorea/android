package com.ssekorea.sse.sseproject.domain.shop;

import java.util.List;

public class Product {
    private String productId;
    private List<String> imgs;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}

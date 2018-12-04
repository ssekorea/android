package com.ssekorea.sse.sseproject.data.remote.model;

import com.ssekorea.sse.sseproject.domain.shop.Product;

import java.util.List;

public class ShopResponse {
    public String statusCode;
    public class GetShopList extends ShopResponse{
        public List<Product> productList;
    }
}

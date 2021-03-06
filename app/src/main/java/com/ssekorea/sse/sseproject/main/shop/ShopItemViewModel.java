package com.ssekorea.sse.sseproject.main.shop;

import android.databinding.ObservableField;
import com.ssekorea.sse.sseproject.domain.shop.Product;
public class ShopItemViewModel {
    public final ObservableField<String> title;
    public final ObservableField<String> description;
    public final ObservableField<String> cost;
    private final Product product;
    private final ShopItemViewModelListener listener;

    public ShopItemViewModel(Product product, ShopItemViewModelListener listener) {
        this.product = product;
        this.title = new ObservableField<>(product.getName());
        this.description = new ObservableField<>(product.getExplanation());
        this.cost = new ObservableField<>(product.getPrice()+"원 / 개");
        this.listener = listener;
    }

    public void onMoreButtonClick(){
        listener.onMoreClick(product.getProductId());
    }

    public interface ShopItemViewModelListener{
        void onMoreClick(String productId);
    }
}

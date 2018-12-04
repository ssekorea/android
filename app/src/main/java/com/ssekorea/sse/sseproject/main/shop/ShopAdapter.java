package com.ssekorea.sse.sseproject.main.shop;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ssekorea.sse.sseproject.base.BaseViewHolder;
import com.ssekorea.sse.sseproject.common.GlideApp;
import com.ssekorea.sse.sseproject.databinding.ItemShopViewBinding;
import com.ssekorea.sse.sseproject.domain.shop.Product;
import com.ssekorea.sse.sseproject.main.shop.detail.ShopDetailActivity;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<Product> shopItemList;
    private ShopFragment shopFragment;

    public ShopAdapter(List<Product> shopItemList) {
        this.shopItemList = shopItemList;
    }
    public void setFragment(ShopFragment shopFragment){
        this.shopFragment = shopFragment;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemShopViewBinding itemShopViewBinding = ItemShopViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new ShopViewHolder(itemShopViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        if (shopItemList != null && shopItemList.size() > 0) {
            return shopItemList.size();
        } else {
            return 0;
        }
    }

    public void addItems(List<Product> productList) {
        this.shopItemList.addAll(productList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        shopItemList.clear();
    }

    public class ShopViewHolder extends BaseViewHolder implements ShopItemViewModel.ShopItemViewModelListener {
        private ItemShopViewBinding binding;
        private ShopItemViewModel shopItemViewModel;

        public ShopViewHolder(ItemShopViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        @Override
        public void onBind(int position) {
            Product shopItem = shopItemList.get(position);
            shopItemViewModel = new ShopItemViewModel(shopItem, this);
            binding.setViewModel(shopItemViewModel);
            binding.executePendingBindings();
            if (shopItem.getProductImageUrls().size() > 0) {
                GlideApp.with(binding.imgShopItem)
                        .load(shopItem.getProductImageUrls().get(0))
                        .centerCrop()
                        .into(binding.imgShopItem);
            }
        }

        @Override
        public void onMoreClick(String productId) {
            for (Product product : shopItemList) {
                if (product.getProductId().equals(productId)){
                    Intent intent = new Intent(shopFragment.getActivity(),ShopDetailActivity.class);
                    intent.putExtra("product",product);
                    shopFragment.getActivity().startActivity(intent);
                }
            }
        }
    }
}

package com.ssekorea.sse.sseproject.main.shop;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ssekorea.sse.sseproject.base.BaseViewHolder;
import com.ssekorea.sse.sseproject.databinding.ItemShopViewBinding;
import com.ssekorea.sse.sseproject.domain.shop.Product;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<Product> shopItemList;

    public ShopAdapter(List<Product> shopItemList){
        this.shopItemList = shopItemList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemShopViewBinding itemShopViewBinding = ItemShopViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup,false);
        return new ShopViewHolder(itemShopViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        if (shopItemList != null && shopItemList.size()>0){
            return shopItemList.size();
        }else {
            return 0;
        }
    }

    public void addItems(List<Product> productList){
        this.shopItemList.addAll(productList);
        notifyDataSetChanged();
    }

    public void clearItems(){
        shopItemList.clear();
    }

    public class ShopViewHolder extends BaseViewHolder implements ShopItemViewModel.ShopItemViewModelListener{
        private ItemShopViewBinding binding;
        private ShopItemViewModel shopItemViewModel;
        public ShopViewHolder(ItemShopViewBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }


        @Override
        public void onBind(int position) {
            Product shopItem = shopItemList.get(position);
            shopItemViewModel = new ShopItemViewModel(shopItem,this);
            binding.setViewModel(shopItemViewModel);
            binding.executePendingBindings();
            // GlideApp.with(itemView).load(shopItem.getImgUrls())
        }

        @Override
        public void onMoreClick(String productId) {
            //todo make click action
        }
    }
}

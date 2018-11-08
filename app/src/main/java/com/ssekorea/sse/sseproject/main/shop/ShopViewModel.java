package com.ssekorea.sse.sseproject.main.shop;

import android.arch.lifecycle.MutableLiveData;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.domain.shop.Product;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import java.util.List;

public class ShopViewModel extends BaseViewModel<ShopNavigator> {
    private final MutableLiveData<List<Product>> shopItemsLiveData;
    private final ApiHelper apiHelper;

    public ShopViewModel(SchedulerProvider mSchedulerProvider, ApiHelper apiHelper) {
        super(mSchedulerProvider);
        this.apiHelper = apiHelper;
        this.shopItemsLiveData = new MutableLiveData<>();
        fetchShopLists();
    }

    private void fetchShopLists() {
        setIsLoading(true);
        getCompositeDisposable().add(apiHelper.getShopItems()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    if (response.productDTO != null)
                        getShopItemsLiveData().setValue(response.productDTO);
                }, throwable -> {
                    setIsLoading(false);
                    getUiHandleError().setValue(throwable);
                }));
    }

    public MutableLiveData<List<Product>> getShopItemsLiveData() {
        return shopItemsLiveData;
    }
}

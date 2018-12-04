package com.ssekorea.sse.sseproject.main.shop.detail;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.util.Log;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.common.SSECode;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.data.remote.model.BuyRequest;
import com.ssekorea.sse.sseproject.domain.shop.Product;
import com.ssekorea.sse.sseproject.domain.user.UserRepository;
import com.ssekorea.sse.sseproject.util.DateUtil;
import com.ssekorea.sse.sseproject.util.FormatUtil;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

public class ShopDetailViewModel extends BaseViewModel<ShopDetailNavigator> {
    private UserRepository userRepository;
    private ApiHelper apiHelper;
    private Product product;
    public ObservableField<String> productName = new ObservableField<>();
    public ObservableField<String> cost = new ObservableField<>();
    public ObservableField<String> desc = new ObservableField<>();
    public ObservableField<String> recipientName = new ObservableField<>();
    public ObservableField<String> recipientPhone = new ObservableField<>();
    public ObservableField<String> address = new ObservableField<>();
    public ObservableField<String> count = new ObservableField<>("0");
    public ObservableField<String> totalCost = new ObservableField<>("0");
    public MutableLiveData<Integer> paymentMethod = new MutableLiveData<>();

    public ShopDetailViewModel(SchedulerProvider mSchedulerProvider, ApiHelper apiHelper,UserRepository userRepository) {
        super(mSchedulerProvider);
        this.apiHelper = apiHelper;
        this.userRepository = userRepository;
    }

    public void onBuyClick() {
        setIsLoading(true);
        getCompositeDisposable().add(apiHelper.buyProduct(
                userRepository.getUser().getId(), new BuyRequest(
                        DateUtil.getCurrentDateTime(),
                        Integer.valueOf(count.get()),
                        Integer.valueOf(count.get())*product.getPrice(),
                        SSECode.PAYMENT_BANK,
                        product.getProductId(),
                        recipientName.get(),
                        address.get(),
                        recipientPhone.get()
                ))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response->{
                    setIsLoading(false);
                    getNavigator().finishBuyWithSuccess();
                },throwable -> {
                    setIsLoading(false);
                    Log.e("아오진짜",throwable.toString());
                    getUiHandleError().setValue(throwable);
                }));
    }

    public void onProductLoad(Product product) {
        this.product = product;
        this.productName.set(product.getName());
        this.cost.set(product.getPrice() + "원 / 개");
        this.desc.set(product.getExplanation());
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        try{
            totalCost.set("총액 : "+(product.getPrice()*Integer.valueOf(s.toString()))+"원");

        }catch (NumberFormatException e){

            totalCost.set("총액 : 0 원");
        }
    }

    public void onBankClick(){
        paymentMethod.setValue(SSECode.PAYMENT_BANK);
    }

    public void onCardClick(){
        paymentMethod.setValue(SSECode.PAYMENT_CARD);
    }

    public MutableLiveData<Integer> getPayMethodLiveData(){
        return paymentMethod;
    }
}

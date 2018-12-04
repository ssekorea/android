package com.ssekorea.sse.sseproject.data.remote.model;

public class BuyRequest {
    public final String orderDate;
    public final int orderNum;
    public final int orderPrice;
    public final String productId;
    public final int paymentInfo;
    public final String recipientName;
    public final String recipientAddress;
    public final String recipientPhoneNumber;

    public BuyRequest(String orderDate, int orderNum, int orderPrice, int paymentType, String productId,String recipientName, String recipientAddress,String recipientPhoneNumber) {
        this.orderDate = orderDate;
        this.orderNum = orderNum;
        this.orderPrice = orderPrice;
        this.paymentInfo = paymentType;
        this.productId=productId;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.recipientPhoneNumber = recipientPhoneNumber;
    }
}

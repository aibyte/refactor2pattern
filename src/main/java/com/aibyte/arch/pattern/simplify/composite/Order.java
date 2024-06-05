package com.aibyte.arch.pattern.simplify.composite;

import java.util.List;

public class Order {

  private static final int ORDER_ID_DEFAULT = -1;

  private final List<Product> productList;
  private final int orderId;

  public Order() {
    this(null);
  }

  public Order(List<Product> productList) {
    this(ORDER_ID_DEFAULT, productList);
  }

  public Order(int orderId, List<Product> productList) {
    this.productList = productList;
    this.orderId = orderId;
  }

  public int getOrderId() {
    return orderId;
  }

  public int getProductCount() {
    return productList == null ? 0 : productList.size();
  }

  public Product getProduct(int j) {
    return productList == null ? null : productList.get(j);
  }
}

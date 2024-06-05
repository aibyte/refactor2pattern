package com.aibyte.arch.pattern.simplify.composite;


import java.util.List;

public class Orders {

  private final List<Order> orderList;

  public Orders() {
    this.orderList = null;
  }

  public Orders(List<Order> orders) {
    this.orderList = orders;
  }

  public int getOrderCount() {
    return orderList == null ? 0 : orderList.size();
  }

  public Order getOrder(int i) {
    return orderList == null ? null : orderList.get(i);
  }
}

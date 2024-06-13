package com.aibyte.arch.pattern.generalization.interpreter;

import java.awt.Color;

public class Product {

  private final String code;
  private final String name;
  private final Color color;
  private final float price;
  private final ProductSize productSize;

  public Product(String code, String name, Color color, float price,
      ProductSize productSize) {
    this.code = code;
    this.name = name;
    this.color = color;
    this.price = price;
    this.productSize = productSize;
  }

  public Color getColor() {
    return color;
  }

  public float getPrice() {
    return price;
  }

  public ProductSize getProductSize() {
    return productSize;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }
}

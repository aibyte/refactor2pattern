package com.aibyte.arch.pattern.simplify.composite;

public class Product {

  public static final int SIZE_NOT_APPLICABLE = -1;

  private final double price;

  private final String name;

  public Product(String name, double price) {
    this.price = price;
    this.name = name;
  }

  public Product(double price) {
    this(null, price);
  }

  public Product(String name) {
    this(name, 0);
  }

  public Product() {
    this(null);
  }

  public int getId() {
    return 0;
  }

  public int getSize() {
    return 0;
  }

  public String getName() {
    return this.name;
  }

  public double getPrice() {
    return this.price;
  }
}

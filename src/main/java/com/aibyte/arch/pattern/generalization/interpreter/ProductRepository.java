package com.aibyte.arch.pattern.generalization.interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepository {

  private final List<Product> products = new ArrayList<>();

  public Iterator<Product> iterator() {
    return products.iterator();
  }

  public void add(Product product) {
    products.add(product);
  }

  public int size() {
    return products.size();
  }
}

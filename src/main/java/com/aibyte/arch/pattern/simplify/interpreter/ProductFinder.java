package com.aibyte.arch.pattern.simplify.interpreter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductFinder {

  private final ProductRepository repository;

  public ProductFinder(ProductRepository productRepository) {
    this.repository = productRepository;
  }

  public List<Product> byColor(Color color) {
    List<Product> foundProducts = new ArrayList<>();
    Iterator<Product> products = repository.iterator();
    while (products.hasNext()) {
      Product product = products.next();
      if (product.getColor().equals(color)) {
        foundProducts.add(product);
      }
    }

    return foundProducts;
  }

  public List<Product> byPrice(float price) {
    List<Product> foundProducts = new ArrayList<>();
    Iterator<Product> products = repository.iterator();
    while (products.hasNext()) {
      Product product = products.next();
      if (product.getPrice() == price) {
        foundProducts.add(product);
      }
    }
    return foundProducts;
  }

  public List<Product> byColorSizeAndBelowPrice(Color color, ProductSize productSize, float price) {
    List<Product> foundProducts = new ArrayList<>();
    Iterator<Product> iterator = repository.iterator();
    while (iterator.hasNext()) {
      Product product = iterator.next();
      if (product.getColor().equals(color) && product.getProductSize().equals(productSize)
          && product.getPrice() < price) {
        foundProducts.add(product);
      }
    }
    return foundProducts;
  }

  public List<Product> belowPriceAvoidColor(float price, Color color) {
    List<Product> foundProducts = new ArrayList<>();
    Iterator<Product> iterator = repository.iterator();
    while (iterator.hasNext()) {
      Product product = iterator.next();
      if (product.getPrice() < price && !product.getColor().equals(color)) {
        foundProducts.add(product);
      }
    }
    return foundProducts;
  }

  public List<Product> byCode(String code) {
    List<Product> foundProducts = new ArrayList<>();
    Iterator<Product> iterator = repository.iterator();
    while (iterator.hasNext()) {
      Product product = iterator.next();
      if (product.getCode().equals(code)) {
        foundProducts.add(product);
      }
    }
    return foundProducts;
  }

  public List<Product> byName(String name) {
    List<Product> foundProducts = new ArrayList<>();
    Iterator<Product> iterator = repository.iterator();
    while (iterator.hasNext()) {
      Product product = iterator.next();
      if (product.getName().equals(name)) {
        foundProducts.add(product);
      }
    }
    return foundProducts;
  }
}

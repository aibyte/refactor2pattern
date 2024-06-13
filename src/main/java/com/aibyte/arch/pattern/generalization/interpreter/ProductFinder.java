package com.aibyte.arch.pattern.generalization.interpreter;

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
    ColorSpec colorSpec = new ColorSpec(color);
    return selectBy(colorSpec);
  }

  public List<Product> byPrice(float price) {
    PriceSpec priceSpec = new PriceSpec(price);
    return selectBy(priceSpec);
  }

  public List<Product> byCode(String code) {
    CodeSpec codeSpec = new CodeSpec(code);
    return selectBy(codeSpec);
  }

  public List<Product> byName(String name) {
    NameSpec nameSpec = new NameSpec(name);
    return selectBy(nameSpec);
  }

  public List<Product> byColorSizeAndBelowPrice(Color color, ProductSize productSize, float price) {

    AndSpec andSpec = new AndSpec(
        new AndSpec(new ColorSpec(color), new ProductSizeSpec(productSize)),
        new BelowPriceSpec(price));

    return selectBy(andSpec);
  }

  public List<Product> belowPriceAvoidColor(float price, Color color) {
    AndSpec andSpec = new AndSpec(
        new BelowPriceSpec(price),
        new NotSpec(new ColorSpec(color)));
    return selectBy(andSpec);
  }

  private List<Product> selectBy(Spec spec) {
    List<Product> foundProducts = new ArrayList<>();
    Iterator<Product> iterator = repository.iterator();
    while (iterator.hasNext()) {
      Product product = iterator.next();
      if (spec.isSatisfiedBy(product)) {
        foundProducts.add(product);
      }
    }
    return foundProducts;
  }

}

package com.aibyte.arch.pattern.simplify.interpreter;

public class BelowPriceSpec extends Spec {

  private final float priceOfProductToFind;

  public BelowPriceSpec(float price) {
    this.priceOfProductToFind = price;
  }

  public float getPriceOfProductToFind() {
    return priceOfProductToFind;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return product.getPrice() < getPriceOfProductToFind();
  }

}

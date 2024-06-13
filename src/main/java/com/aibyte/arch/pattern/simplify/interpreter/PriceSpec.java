package com.aibyte.arch.pattern.simplify.interpreter;

public class PriceSpec extends Spec {

  private final float priceOfProductToFind;

  public PriceSpec(float price) {
    this.priceOfProductToFind = price;
  }

  public float getPriceOfProductToFind() {
    return priceOfProductToFind;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return product.getPrice() == getPriceOfProductToFind();
  }
}

package com.aibyte.arch.pattern.generalization.interpreter;

public class ProductSizeSpec extends Spec {

  private final ProductSize sizeOfProductToFind;

  public ProductSizeSpec(ProductSize size) {
    this.sizeOfProductToFind = size;
  }

  public ProductSize getSizeOfProductToFind() {
    return sizeOfProductToFind;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return product.getProductSize().equals(getSizeOfProductToFind());
  }

}

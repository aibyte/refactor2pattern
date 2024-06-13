package com.aibyte.arch.pattern.generalization.interpreter;

public class NameSpec extends Spec {

  private final String nameOfProductToFind;

  public NameSpec(String name) {
    this.nameOfProductToFind = name;
  }

  public String getNameOfProductToFind() {
    return nameOfProductToFind;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return product.getName().equals(getNameOfProductToFind());
  }

}

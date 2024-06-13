package com.aibyte.arch.pattern.simplify.interpreter;

public class NotSpec extends Spec {

  private final Spec specToNegate;

  public NotSpec(Spec specToNegate) {
    this.specToNegate = specToNegate;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return !specToNegate.isSatisfiedBy(product);
  }
}

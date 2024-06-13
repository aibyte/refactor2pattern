package com.aibyte.arch.pattern.generalization.interpreter;

public class AndSpec extends Spec {

  private final Spec augend;
  private final Spec addend;

  public AndSpec(Spec augend, Spec addend) {
    this.augend = augend;
    this.addend = addend;
  }

  public boolean isSatisfiedBy(Product product) {
    return augend.isSatisfiedBy(product) && addend.isSatisfiedBy(product);
  }

}

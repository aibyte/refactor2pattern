package com.aibyte.arch.pattern.generalization.interpreter;

import java.awt.Color;

public class ColorSpec extends Spec {

  private final Color colorOfProductToFind;

  public ColorSpec(Color color) {
    this.colorOfProductToFind = color;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return colorOfProductToFind.equals(product.getColor());
  }

}

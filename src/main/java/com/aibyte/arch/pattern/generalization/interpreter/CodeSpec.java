package com.aibyte.arch.pattern.generalization.interpreter;

public class CodeSpec extends Spec {

  private final String codeOfProductToFind;

  public CodeSpec(String code) {
    this.codeOfProductToFind = code;
  }

  public String getCodeOfProductToFind() {
    return codeOfProductToFind;
  }

  @Override
  public boolean isSatisfiedBy(Product product) {
    return product.getCode().equals(getCodeOfProductToFind());
  }
}

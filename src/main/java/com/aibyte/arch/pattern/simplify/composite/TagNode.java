package com.aibyte.arch.pattern.simplify.composite;

public class TagNode {

  private final String name;
  private StringBuffer attributes;
  private String value = "";

  public TagNode(String name) {
    this.name = name;
    this.attributes = new StringBuffer();
  }

  public void addAttribute(String attribute, String value) {
    attributes.append(" ");

    attributes.append(attribute);
    attributes.append("='");
    attributes.append(value);
    attributes.append("'");
  }

  public void addValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "<" + name + attributes +">"+value+"</" + name + ">";
  }
}

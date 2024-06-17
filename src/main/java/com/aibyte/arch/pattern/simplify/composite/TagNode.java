package com.aibyte.arch.pattern.simplify.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagNode {

  private final String name;
  private final StringBuffer attributes;
  private String value = "";
  private final List<TagNode> children = new ArrayList<>();

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

  public void add(TagNode child) {
    children.add(child);
  }

  @Override
  public String toString() {
    String result = "";
    result += "<" + name + attributes + ">";
    Iterator<TagNode> it = children.iterator();
    while (it.hasNext()) {
      TagNode node = it.next();
      result += node.toString();
    }

    if (value != null && !value.isEmpty()) {
      result += value;
    }
    result += "</" + name + ">";
    return result;
  }
}

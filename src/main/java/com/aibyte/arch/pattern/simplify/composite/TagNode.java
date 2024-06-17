package com.aibyte.arch.pattern.simplify.composite;

import java.util.ArrayList;
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
    StringBuffer result = new StringBuffer();
    appendContentsTo(result);
    return result.toString();
  }

  private void appendContentsTo(StringBuffer result) {
    writeOpenTagTo(result);
    writeChildrenTo(result);
    writeValueTo(result);
    writeCloseTagTo(result);
  }

  private void writeCloseTagTo(StringBuffer result) {
    result.append("</");
    result.append(name);
    result.append(">");
  }

  private void writeValueTo(StringBuffer result) {
    if (value != null && !value.isEmpty()) {
      result.append(value);
    }
  }

  private void writeChildrenTo(StringBuffer result) {
    children.forEach(node -> node.appendContentsTo(result));
  }

  private void writeOpenTagTo(StringBuffer result) {
    result.append("<");
    result.append(name);
    result.append(attributes);
    result.append(">");
  }
}

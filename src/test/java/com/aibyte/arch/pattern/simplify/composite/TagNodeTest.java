package com.aibyte.arch.pattern.simplify.composite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TagNodeTest {

  @Test
  void should_pass_happy_case_with_empty_tag() {
    TagNode tagNode = new TagNode("price");
    String result = tagNode.toString();
    assertEquals("<price></price>", result);
  }

  @Test
  void should_pass_happy_case_tag_with_one_attribute_and_value() {
    String SAMPLE_PRICE = "100.0";
    TagNode tagNode = new TagNode("price");
    tagNode.addAttribute("currency", "USD");
    tagNode.addValue(SAMPLE_PRICE);
    String result = tagNode.toString();
    assertEquals("<price currency='USD'>100.0</price>", result);
  }

  @Test
  void should_pass_happy_case_empty_tag_with_one_child() {
    TagNode tagNode = new TagNode("product");
    TagNode priceNode = new TagNode("price");
    tagNode.add(priceNode);
    String result = tagNode.toString();
    assertEquals("<product><price></price></product>", result);
  }

  @Test
  void should_pass_happy_case_tag_with_one_child() {
    TagNode tagNode = new TagNode("product");
    TagNode priceNode = new TagNode("price");
    priceNode.addAttribute("currency", "USD");
    priceNode.addValue("100.0");
    tagNode.add(priceNode);
    String result = tagNode.toString();
    assertEquals("<product><price currency='USD'>100.0</price></product>", result);
  }

  @Test
  void should_pass_corner_case_tag_with_two_duplicated_children() {
    TagNode tagNode = new TagNode("product");
    TagNode priceNode = new TagNode("price");
    priceNode.addAttribute("currency", "USD");
    priceNode.addValue("100.0");
    tagNode.add(priceNode);
    tagNode.add(priceNode);
    String result = tagNode.toString();
    assertEquals("<product><price currency='USD'>100.0</price><price currency='USD'>100.0</price></product>", result);
  }

  @Test
  void should_pass_happy_case_tag_with_one_child_and_one_grandchild() {
    TagNode ordersNode = new TagNode("orders");
    TagNode orderNode = new TagNode("order");
    TagNode priceNode = new TagNode("price");
    ordersNode.add(orderNode);
    orderNode.add(priceNode);
    String result = ordersNode.toString();
    assertEquals("<orders><order><price></price></order></orders>", result);
  }

}
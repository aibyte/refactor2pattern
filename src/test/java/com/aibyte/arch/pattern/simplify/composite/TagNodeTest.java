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

}
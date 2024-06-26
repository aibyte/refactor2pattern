package com.aibyte.arch.pattern.simplify.compose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListTest {


  @Test
  void should_pass_create_list() {
    List list = new List();
    assertNotNull(list);
  }

  @Test
  void should_pass_get_empty_size() {
    List list = new List();
    assertEquals(0, list.getSize());
  }

  @Test
  void should_pass_add_one_element() {
    List list = new List();
    list.add("element");
    assertEquals(1, list.getSize());
  }

  @Test
  void should_pass_add_multiple_elements() {
    List list = new List();
    list.add("element1");
    list.add("element2");
    list.add("element3");
    assertEquals(3, list.getSize());
  }

}
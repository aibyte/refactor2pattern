package com.aibyte.arch.pattern.simplify.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class OrdersWriterTest {

  @Test
  void should_pass_happy_case_with_zero_order() {
    Orders orders = new Orders();
    OrdersWriter ordersWriter = new OrdersWriter(orders);
    String contents = ordersWriter.getContents();
    assertEquals("<orders></orders>", contents);
  }

  @Test
  void should_pass_happy_case_with_one_order() {
    Order order = new Order();
    Orders orders = new Orders(List.of(order));
    OrdersWriter ordersWriter = new OrdersWriter(orders);
    String contents = ordersWriter.getContents();
    assertEquals("<orders><order id='-1'></order></orders>", contents);
  }

  @Test
  void should_pass_happy_case_with_one_order_with_one_product_default_price() {
    Product product = new Product();
    Order order = new Order(List.of(product));
    Orders orders = new Orders(List.of(order));
    OrdersWriter ordersWriter = new OrdersWriter(orders);
    String contents = ordersWriter.getContents();
    assertEquals(
        "<orders><order id='-1'><product id='0' color='' size='0'><price currency=''>0.0</price></product></order></orders>",
        contents);
  }

  @Test
  void should_pass_happy_case_with_one_order_with_one_product_with_price() {
    Product product = new Product(100.0);
    Order order = new Order(List.of(product));
    Orders orders = new Orders(List.of(order));
    OrdersWriter ordersWriter = new OrdersWriter(orders);
    String contents = ordersWriter.getContents();
    assertEquals(
        "<orders><order id='-1'><product id='0' color='' size='0'><price currency=''>100.0</price></product></order></orders>",
        contents);
  }

  @Test
  void should_pass_happy_case_with_one_order_with_one_product_with_name_and_price() {
    Product product = new Product("product1", 100.0);
    Order order = new Order(List.of(product));
    Orders orders = new Orders(List.of(order));
    OrdersWriter ordersWriter = new OrdersWriter(orders);
    String contents = ordersWriter.getContents();
    assertEquals(
        "<orders><order id='-1'><product id='0' color='' size='0'><price currency=''>100.0</price>product1</product></order></orders>",
        contents);
  }

  @Test
  void should_pass_happy_case_with_one_order_with_two_product_with_price() {
    Product product = new Product(100.0);
    Product product2 = new Product(200.0);
    Order order = new Order(List.of(product, product2));
    Orders orders = new Orders(List.of(order));
    OrdersWriter ordersWriter = new OrdersWriter(orders);
    String contents = ordersWriter.getContents();
    assertEquals(
        "<orders><order id='-1'><product id='0' color='' size='0'><price currency=''>100.0</price></product><product id='0' color='' size='0'><price currency=''>200.0</price></product></order></orders>",
        contents);
  }

  @Test
  void should_pass_happy_case_with_one_order_with_two_product_with_name_and_price() {
    Product product = new Product("product1", 100.0);
    Product product2 = new Product("product2", 200.0);
    Order order = new Order(List.of(product, product2));
    Orders orders = new Orders(List.of(order));
    OrdersWriter ordersWriter = new OrdersWriter(orders);
    String contents = ordersWriter.getContents();
    assertEquals(
        "<orders><order id='-1'><product id='0' color='' size='0'><price currency=''>100.0</price>product1</product><product id='0' color='' size='0'><price currency=''>200.0</price>product2</product></order></orders>",
        contents);
  }

  @Test
  void should_pass_happy_case_with_one_order_with_id_with_two_product_with_name_and_price() {
    Product product = new Product("product1", 100.0);
    Product product2 = new Product("product2", 200.0);
    Order order = new Order(1, List.of(product, product2));
    Orders orders = new Orders(List.of(order));
    OrdersWriter ordersWriter = new OrdersWriter(orders);
    String contents = ordersWriter.getContents();
    assertEquals(
        "<orders><order id='1'><product id='0' color='' size='0'><price currency=''>100.0</price>product1</product><product id='0' color='' size='0'><price currency=''>200.0</price>product2</product></order></orders>",
        contents);
  }

  @Test
  void should_pass_happy_case_with_two_order_with_id_with_two_product_with_name_and_price() {
    Product product = new Product("product1", 100.0);
    Product product2 = new Product("product2", 200.0);
    Order order = new Order(1, List.of(product, product2));
    Order order2 = new Order(2, List.of(product, product2));
    Orders orders = new Orders(List.of(order, order2));
    OrdersWriter ordersWriter = new OrdersWriter(orders);
    String contents = ordersWriter.getContents();
    assertEquals(
        "<orders><order id='1'><product id='0' color='' size='0'><price currency=''>100.0</price>product1</product><product id='0' color='' size='0'><price currency=''>200.0</price>product2</product></order><order id='2'><product id='0' color='' size='0'><price currency=''>100.0</price>product1</product><product id='0' color='' size='0'><price currency=''>200.0</price>product2</product></order></orders>",
        contents);
  }
}
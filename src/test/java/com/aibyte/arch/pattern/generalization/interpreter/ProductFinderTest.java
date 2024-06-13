package com.aibyte.arch.pattern.generalization.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductFinderTest {

  private ProductFinder finder;
  private final Product fireTruck = new Product("f1234", "Fire Truck", Color.red, 8.95f,
      ProductSize.MEDIUM);
  private final Product barbieClassic = new Product("b7654", "Barbie Classic", Color.yellow, 15.95f,
      ProductSize.SMALL);
  private final Product frisbee = new Product("f4321", "Frisbee", Color.pink, 9.99f,
      ProductSize.LARGE);
  private final Product baseball = new Product("b2343", "Baseball", Color.white, 8.95f,
      ProductSize.NOT_APPLICABLE);
  private final Product toyPorsche = new Product("p1112", "Toy Porsche", Color.red, 230.00f,
      ProductSize.NOT_APPLICABLE);

  private ProductRepository createProductRepository() {
    ProductRepository productRepository = new ProductRepository();
    productRepository.add(fireTruck);
    productRepository.add(barbieClassic);
    productRepository.add(frisbee);
    productRepository.add(baseball);
    productRepository.add(toyPorsche);
    return productRepository;
  }

  @BeforeEach
  void setUp() {
    finder = new ProductFinder(createProductRepository());
  }

  @Test
  void should_pass_when_find_by_color() {
    List<Product> foundProduct = finder.byColor(Color.red);
    assertEquals(2, foundProduct.size());
    assertTrue(foundProduct.contains(fireTruck));
    assertTrue(foundProduct.contains(toyPorsche));
  }

  @Test
  void should_pass_when_find_by_price() {
    List<Product> foundProduct = finder.byPrice(8.95f);
    assertEquals(2, foundProduct.size());
    assertTrue(foundProduct.contains(fireTruck));
    assertTrue(foundProduct.contains(baseball));
  }

  @Test
  void should_pass_when_find_by_code() {
    List<Product> foundProduct = finder.byCode("f1234");
    assertEquals(1, foundProduct.size());
    assertTrue(foundProduct.contains(fireTruck));
  }

  @Test
  void should_pass_when_find_by_name() {
    List<Product> foundProduct = finder.byName("Fire Truck");
    assertEquals(1, foundProduct.size());
    assertTrue(foundProduct.contains(fireTruck));
  }

  @Test
  void should_pass_when_find_by_color_size_and_below_price() {
    List<Product> foundProduct = finder.byColorSizeAndBelowPrice(Color.red, ProductSize.SMALL, 10.00f);
    assertEquals(0, foundProduct.size());
  }

  @Test
  void should_pass_when_find_by_below_price_avoid_color() {
    List<Product> foundProduct = finder.belowPriceAvoidColor(9.00f, Color.white);
    assertEquals(1, foundProduct.size());
    assertTrue(foundProduct.contains(fireTruck));
  }
}
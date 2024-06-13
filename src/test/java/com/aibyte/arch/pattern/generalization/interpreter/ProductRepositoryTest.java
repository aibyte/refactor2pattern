package com.aibyte.arch.pattern.generalization.interpreter;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductRepositoryTest {

  private ProductRepository repository;
  private final Product fireTruck = new Product("f1234", "Fire Truck", Color.red, 8.95f,
      ProductSize.MEDIUM);
  private final Product barbieClassic = new Product("b7654", "Barbie Classic", Color.yellow, 15.95f,
      ProductSize.SMALL);
  private final Product frisbee = new Product("f4321", "Frisbee", Color.pink, 9.99f, ProductSize.LARGE);
  private final Product baseball = new Product("b2343", "Baseball", Color.white, 8.95f,
      ProductSize.NOT_APPLICABLE);
  private final Product toyPorsche = new Product("p1112", "Toy Porsche", Color.red, 230.00f,
      ProductSize.NOT_APPLICABLE);

  @BeforeEach
  void setUp() {
    repository = new ProductRepository();
    repository.add(fireTruck);
    repository.add(barbieClassic);
    repository.add(frisbee);
    repository.add(baseball);
    repository.add(toyPorsche);
  }

  @Test
  void should_pass_when_add_product() {
    assertEquals(5, repository.size());
  }
}
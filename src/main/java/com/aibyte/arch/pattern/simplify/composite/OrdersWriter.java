package com.aibyte.arch.pattern.simplify.composite;

public class OrdersWriter {

  private final Orders orders;

  public OrdersWriter(Orders orders) {
    this.orders = orders;
  }

  public String getContents() {
    StringBuffer xml = new StringBuffer();
    writeOrderTo(xml);
    return xml.toString();
  }

  private void writeOrderTo(StringBuffer xml) {
    TagNode ordersNode = new TagNode("orders");
    for (int i = 0; i < orders.getOrderCount(); i++) {
      Order order = orders.getOrder(i);
      TagNode orderNode = new TagNode("order");
      orderNode.addAttribute("id", String.valueOf(order.getOrderId()));
      writeProductsTo(orderNode, order);
      ordersNode.add(orderNode);
    }
    xml.append(ordersNode);
  }

  private void writeProductsTo(TagNode orderNode, Order order) {
    for (int j = 0; j < order.getProductCount(); j++) {
      Product product = order.getProduct(j);

      TagNode productNode = new TagNode("product");
      productNode.addAttribute("id", String.valueOf(product.getId()));
      productNode.addAttribute("color", colorFor(product));
      if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
        productNode.addAttribute("size", String.valueOf(sizeFor(product)));
      }

      writePriceTo(productNode, product);
      productNode.addValue(product.getName());

      orderNode.add(productNode);
    }
  }

  private void writePriceTo(TagNode productTg, Product product) {
    TagNode priceNode = new TagNode("price");
    priceNode.addAttribute("currency", currencyFor(product));
    priceNode.addValue(String.valueOf(product.getPrice()));
    productTg.add(priceNode);
  }

  private String currencyFor(Product product) {
    return "";
  }

  private int sizeFor(Product product) {
    return 0;
  }

  private String colorFor(Product product) {
    return "";
  }

}

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
    xml.append("<orders>");
    for (int i = 0; i < orders.getOrderCount(); i++) {
      Order order = orders.getOrder(i);
      xml.append("<order");
      xml.append(" id='");
      xml.append(order.getOrderId());
      xml.append("'>");
      writeProductsTo(xml, order);
      xml.append("</order>");
    }
    xml.append("</orders>");
  }

  private void writeProductsTo(StringBuffer xml, Order order) {
    for (int j = 0; j < order.getProductCount(); j++) {
      Product product = order.getProduct(j);
      xml.append("<product");
      xml.append(" id='");
      xml.append(product.getId());
      xml.append("'");
      xml.append(" color='");
      xml.append(colorFor(product));
      xml.append("'");
      if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
        xml.append(" size='");
        xml.append(sizeFor(product));
        xml.append("'");
      }
      xml.append(">");
      writePriceTo(xml, product);
      xml.append(product.getName());
      xml.append("</product>");
    }
  }

  private void writePriceTo(StringBuffer xml, Product product) {
    TagNode priceNode = new TagNode("price");
    priceNode.addAttribute("currency", currencyFor(product));
    priceNode.addValue(String.valueOf(product.getPrice()));
    xml.append(priceNode.toString());
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

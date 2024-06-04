package com.aibyte.arch.pattern.simplify.compose;

public class List {

  public static final int GROWTH_INCREMENT = 10;
  private boolean readOnly;
  private int size;
  private Object[] elements;

  private static final int INIT_SIZE = 10;

  public int getSize() {
    return size;
  }

  public List() {
    size = 0;
    elements = new Object[INIT_SIZE];
  }

  public void add(Object element) {
    // add element to list
    // Guard clause
    if (readOnly) {
      return;
    }

    if (atCapacity()) {
      grow();
    }
    addElement(element);

  }

  private void addElement(Object element) {
    elements[size++] = element;
  }

  private void grow() {
    Object[] newElements = new Object[elements.length + GROWTH_INCREMENT];
    if (size >= 0)
      System.arraycopy(elements, 0, newElements, 0, size);
    elements = newElements;
  }

  private boolean atCapacity() {
    return size + 1 > elements.length;
  }

}

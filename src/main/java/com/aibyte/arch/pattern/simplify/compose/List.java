package com.aibyte.arch.pattern.simplify.compose;

public class List {
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

  public void add (Object element) {
    // add element to list
    if (!readOnly) {
      int newSize = size + 1;
      if (newSize > elements.length) {
        Object[] newElements = new Object[elements.length + 10];
        for (int i = 0; i < size; i++) {
          newElements[i] = elements[i];
        }
        elements = newElements;
      }
      elements[size++] = element;
    }
  }

}

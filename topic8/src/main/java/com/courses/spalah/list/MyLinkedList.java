package com.courses.spalah.list;

import java.util.Iterator;

/**
 * Created by Denis on 04.03.2016.
 */
public class MyLinkedList<E> implements MyList {
    private ListNode first;
    private ListNode next;
    private ListNode current;
    private int index;

    public MyLinkedList() {
        first = new ListNode(null);
    }

    @Override
    public int size() {
        int size = 0;
        if (!isEmpty()) {
            next = first.getNext();
            while (next.getNext() != null) {
                next = next.getNext();
                size++;
            }
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first.getNext() == null;
    }

    @Override
    public boolean add(Object element) {
        ListNode newNode = new ListNode(element, null);
        if (!isEmpty()) {
            next = first.getNext();
            while (next.getNext() != null) {
                next = next.getNext();
            }
            next.setNext(newNode);
        } else {
            first.setNext(newNode);
        }
        return true;
    }

    @Override
    public void add(int index, Object element) {
        ListNode newNode = new ListNode(element, null);
        current = getNodeByIndex(index - 1);
        next = current.getNext();
        current.setNext(newNode);
        newNode.setNext(next);
    }

    @Override
    public void remove(int index) {
        if (!isEmpty()) {
            current = getNodeByIndex(index - 1);
            next = current.getNext();
            current.setNext(next.getNext());
        }
    }

    @Override
    public Object get(int index) {
        if (!isEmpty()) {
            next = getNodeByIndex(index);
        }
        return next.getValue();
    }

    @Override
    public Object set(int index, Object element) {
        if (!isEmpty()) {
            getNodeByIndex(index).setValue(element);
        }
        return next;
    }

    @Override
    public boolean contains(Object element) {
        if (!isEmpty()) {
            next = first.getNext();
            while (next.getNext() != null) {
                if (next.getValue().equals(element)) {
                    return true;
                }
                next = next.getNext();
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        index = 0;
        if (!isEmpty()) {
            next = first;
        }
        Iterator iterator = new Iterator() {

            @Override
            public boolean hasNext() {
                if (next.getNext() != null) {
                    index++;
                    next = next.getNext();
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                return next.getValue();
            }

            @Override
            public void remove() {
                index--;
                MyLinkedList.this.remove(index);
            }
        };
        return iterator;
    }

    private ListNode getNodeByIndex(int index) {
        next = first;
        for (int i = 0; i <= index; i++) {
            next = next.getNext();
        }
        return next;
    }

    @Override
    public String toString() {
        String value = "";
        next = first;
        while (next.getNext() != null) {
            value += next.getNext().getValue().toString();
            next = next.getNext();
        }
        return value;
    }
}

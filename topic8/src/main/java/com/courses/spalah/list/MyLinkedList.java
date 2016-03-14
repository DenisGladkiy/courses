package com.courses.spalah.list;

import java.util.Iterator;

/**
 * Created by Denis on 04.03.2016.
 */
public class MyLinkedList<E> implements MyList<E> {
    private ListNode<E>  first;
    private ListNode<E>  next;
    private ListNode<E>  current;
    private int index;
    private int size;

    public MyLinkedList() {
        first = new ListNode<E> (null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first.getNext() == null;
    }

    @Override
    public boolean add(E element) {
        ListNode<E>  newNode = new ListNode<E> (element, null);
        next = first;
        while (next.getNext() != null) {
            next = next.getNext();
        }
        next.setNext(newNode);
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        ListNode<E>  newNode = new ListNode<E> (element, null);
        current = getNodeByIndex(index - 1);
        next = current.getNext();
        current.setNext(newNode);
        newNode.setNext(next);
        size++;
    }

    @Override
    public void remove(int index) {
        current = getNodeByIndex(index - 1);
        next = current.getNext();
        current.setNext(next.getNext());
        size--;
    }

    @Override
    public E get(int index) {
        next = getNodeByIndex(index);
        return next.getValue();
    }

    @Override
    public E set(int index, E element) {
        next = getNodeByIndex(index);
        next.setValue(element);
        return next.getValue();
    }

    @Override
    public boolean contains(E element) {
        next = first;
        while (next.getNext() != null) {
            next = next.getNext();
            if (next.getValue().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        index = 0;
        next = first;
        Iterator<E> iterator = new Iterator<E>() {

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
            public E next() {
                return next.getValue();
            }

            @Override
            public void remove() {
                index--;
                MyLinkedList.this.remove(index);
                size--;
            }
        };
        return iterator;
    }

    private ListNode<E>  getNodeByIndex(int index) {
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

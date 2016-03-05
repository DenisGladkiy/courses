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
        ListNode tempNext = next;
        int size = 0;
        if (!isEmpty()) {
            next = first.getNext();
            while (next.getNext() != null) {
                next = next.getNext();
                size++;
            }
            size++;
        }
        next = tempNext;
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
        next = first.getNext();
        if(index == 0){
            newNode.setNext(next);
            first.setNext(newNode);
        }else {
            for (int i = 0; i < index; i++) {
                current = next;
                next = next.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(next);
        }

    }

    @Override
    public void remove(int index) {
        if(!isEmpty()){
            next = first;
                for (int i = 0; i <= index; i++) {
                    current = next;
                    next = current.getNext();
                }
                if(index == size()-1){
                    current.setNext(null);
                }else {
                    current.setNext(next.getNext());
                }

        }
    }

    @Override
    public Object get(int index) {
        if(!isEmpty()){
            next = first.getNext();
            for(int i = 0; i < index; i++){
                next = next.getNext();
            }
        }
        return next.getValue();
    }

    @Override
    public Object set(int index, Object element) {
        if(!isEmpty()){
            next = first;
            for(int i = 0; i <= index; i++){
                next = next.getNext();
            }
            next.setValue(element);
        }
        return next;
    }

    @Override
    public boolean contains(Object element) {
        if(!isEmpty()){
            next = first.getNext();
            while(next.getNext() != null){
                if(next.getValue().equals(element)){
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
        if(!isEmpty()){
            next = first;
        }
        Iterator iterator = new Iterator() {

            @Override
            public boolean hasNext() {
                if(next.getNext() != null) {
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
    @Override
    public String toString(){
        String value = "";
        next = first;
        while(next.getNext() != null){
            value += next.getNext().getValue().toString();
            next = next.getNext();
        }
        return value;
    }
}

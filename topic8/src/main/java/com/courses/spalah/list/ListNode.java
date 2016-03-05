package com.courses.spalah.list;

/**
 * Created by Denis on 04.03.2016.
 */
public class ListNode<E> {

    private E value;
    private ListNode<E> next;

    public ListNode(ListNode next){
        value = null;
        this.next = next;
    }

    public ListNode(E value, ListNode next){
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }


}

package com.courses.spalah.memento;

/**
 * Created by Денис on 4/14/16.
 */
public interface Originator {
    public void loadState(Memento memento);
    public Memento saveState();
}

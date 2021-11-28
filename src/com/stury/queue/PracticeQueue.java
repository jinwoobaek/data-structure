package com.stury.queue;

import java.util.ArrayList;

public class PracticeQueue<T> {

    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            return null;
        } else {
            return queue.remove(0);
        }
    }
}

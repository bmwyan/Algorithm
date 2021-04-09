package week02;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package week02
 * @Description: TODO
 * @date Date : 2021年04月06日 23:02
 */
public class MyCircularDeque {

    int capacity;
    int front;
    int tail;
    int[] queue;


    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        queue = new int[k + 1];
        front = 0;
        tail = 0;
        capacity = k + 1;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        queue[front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % capacity;

        return true;

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        }
        tail = (tail - 1 + capacity) % capacity;
        return true;

    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (this.isEmpty()) {
            return -1;
        }
        return queue[front];

    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (this.isEmpty()) {
            return -1;
        }
        return queue[(tail - 1 + capacity) % capacity];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return front == tail ? true : false;

    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % capacity == front ? true : false;
    }
}

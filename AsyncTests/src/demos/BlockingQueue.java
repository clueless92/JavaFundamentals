package demos;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue<T> {

    static final int DEFAULT_CAPACITY = 16;

    final Queue<T> queue;
    int capacity;

    BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    BlockingQueue() {
        this(DEFAULT_CAPACITY);
    }

    void add(T item) {
        synchronized (this.queue) {
            while (this.queue.size() == this.capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException ignored) { }
            }

            this.queue.add(item);
            queue.notifyAll();
        }
    }

    T remove() {
        synchronized (this.queue) {
            while (this.queue.size() == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException ignored) { }
            }

            T result = this.queue.remove();
            this.queue.notifyAll();
            return result;
        }
    }

    T peek() {
        synchronized (this.queue) {
            if (this.queue.size() == 0) {
                throw new UnsupportedOperationException("Queue is empty");
            }

            return this.queue.peek();
        }
    }
}

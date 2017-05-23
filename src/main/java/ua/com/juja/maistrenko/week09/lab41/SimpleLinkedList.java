package ua.com.juja.maistrenko.week09.lab41;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class SimpleLinkedList<E> implements SimpleList<E> {
    private Node<E> first = null; // head
    private Node<E> last = null; // tail
    private int size = 0;

    private static class Node<T> {

        private Node<T> prev;
        private T item;
        private Node<T> next;

        private Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

    }

    private void checkIndex(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private Node<E> node(int index) {
        if (index < size / 2) {
            Node<E> tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private E unlink(Node<E> x) { //todo:
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    @Override
    public boolean add(E newElement) {
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, newElement, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return node(index).item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        return unlink(node(index));
    }

    /*BODY*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleLinkedList<?> that = (SimpleLinkedList<?>) o;

        if (size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (get(i) != null ? !get(i).equals(that.get(i)) : that.get(i) != null) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + size;
        for (int i = 0; i < this.size; i++) {
            result = 31 * result + get(i).hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        //LinkedList
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < this.size; i++) {
            result.append(((i == 0) ? "" : ", ") + get(i));
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator();
    }

    class SimpleIterator<E> implements Iterator {
        Node<E> nextNode = (Node<E>) first;
        Node<E> last = null;
        int index = -1;

        public boolean hasNext() {
            return nextNode != null;
        }

        public E next() {
            if (nextNode == null) {
                throw new NoSuchElementException();
            } else {
                last = nextNode;
                nextNode = nextNode.next;
                index++;
                return last.item;
            }
        }

        public void remove() {
            if (last == null) {
                throw new IllegalStateException();
            }
            SimpleLinkedList.this.remove(index);
            last = null;
        }

    }

}

interface SimpleList<T> {
    public boolean add(T newElement);

    public T get(int index);

    public Iterator<T> iterator();

    public int size();

    public boolean isEmpty();

    public T remove(int index);
}
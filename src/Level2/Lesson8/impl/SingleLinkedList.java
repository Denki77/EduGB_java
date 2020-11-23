package Level2.Lesson8.impl;

import Level2.Lesson8.GBIterator;
import Level2.Lesson8.GBList;

public class SingleLinkedList implements GBList {
    private Node first;
    private Node last;
    private int size = 0;


    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val);
            last = first;
        } else {
            add(first, val);
        }
        size++;
    }

    private void add(Node current, String val) {
        if (current.next == null) {
            current.next = new Node(val, null, current);
            last = current.next;
            return;
        }
        add(current.next, val);
    }

    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
            first.prev = null;
            size--;
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while(current != null) {
            if (current.val.equals(val)) {
                prev.setNext(current.next);
                current.next.setPrev(prev);
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        if (index >= this.size || first == null) {
            return null;
        }
        if (index == 0){
            return first.val;
        }
        Node current = first.next;
        while(current != null) {
            if (--index == 0) {
                return current.val;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public GBIterator iterator() {
        return new StraightIterator(first);
    }

    @Override
    public GBIterator backwardIterator() {
        return new StraightIterator(last);
    }

    @Override
    public String toString() {
        return "SingleLinkedList:\n" + first;
    }

    private static class Node {
        private String val;
        private Node next;
        private Node prev;

        public Node(String val) {
            this(val, null, null);
        }

        public Node(String val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            StringBuilder returnString = new StringBuilder();

            returnString.append("{prev='");

            if (prev == null){
                returnString.append("null");
            } else {
                returnString.append(prev.val);
            }

            returnString.append("', val='").append(val).append("', next='");

            if (next == null){
                returnString.append("null'}");
                return returnString.toString();
            } else {
                returnString.append(next.val).append("'};\n ").append(next.toString());
            }

            return returnString.toString();
        }
    }

    public static class StraightIterator implements GBIterator {
        private Node current;

        public StraightIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public boolean hasPrev() {
            return current != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }

        @Override
        public String prev() {
            String val = current.val;
            current = current.prev;
            return val;
        }
    }
}

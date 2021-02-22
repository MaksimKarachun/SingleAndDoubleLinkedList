package double_linked_list;

import java.util.Objects;

public class DoubleLinkedList<T> {
    private ListItem<T> head;
    private ListItem<T> tail;
    private int size;

    public ListItem<T> getHeadElement() {
        return head;
    }

    public ListItem<T> getTailElement() {
        return tail;
    }

    public ListItem<T> popHeadElement() {
        // TODO
        ListItem<T> item = head;
        if (head != null) {
            if(head.next != null) {
                head = head.next;
                head.prev = null;
            }
            else {
                head = null;
            }
            size--;
        }
        return item;
    }

    public ListItem<T> popTailElement() {
        // TODO
        ListItem<T> item = tail;
        if (tail != null) {
            if(tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            }
            else {
                tail = null;
            }
            size--;
        }
        return item;
    }

    public void removeHeadElement() {
        // TODO
        if (head != null) {
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            }
            else {
                head = null;
            }
            size--;
        }
    }

    public void removeTailElement() {
        // TODO
        if (tail != null) {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            }
            else {
                tail = null;
            }
            size--;
        }
    }

    public void addToHead(T data) {
        // TODO
        ListItem<T> item = new ListItem<>(data);
        if (head != null) {
            head.prev = item;
            item.next = head;
        }
        head = item;
        size++;
        if (tail == null)
            tail = item;
    }

    public void addToTail(T data) {
        // TODO
        ListItem<T> item = new ListItem<>(data);
        if (tail != null) {
            tail.next = item;
            item.prev = tail;
        }
        tail = item;
        size++;
        if (head == null)
            head = item;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleLinkedList<T> that = (DoubleLinkedList<T>) o;
        return Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }

    @Override
    public String toString() {
        if (head != null && tail != null) {
            StringBuilder stringBuilder = new StringBuilder(head.toString());
            ListItem<T> item = head;
            while (item.next != null) {
                if (item.next.prev == item) {
                    stringBuilder.append("<-");
                }

                stringBuilder.append(" -> ").append(item.next);
                item = item.next;
            }

            return "DoubleLinkedList{size=" + size + "\n" + stringBuilder.toString() + "}";
        }
        else return "list is empty";
    }
}
import java.util.Random;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addAtTail(Card data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public Card removeFromHead() {
        if (head == null) return null;
        Card removedCard = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return removedCard;
    }

    public void shuffle(int shuffleCount) {
        Random rand = new Random();
        for (int i = 0; i < shuffleCount; i++) {
            int r1 = rand.nextInt(size);
            int r2 = rand.nextInt(size);
            swap(r1, r2);
        }
    }

    public void swap(int index1, int index2) {
        if (index1 == index2) return;
        Node node1 = getNode(index1);
        Node node2 = getNode(index2);
        if (node1 != null && node2 != null) {
            Card temp = node1.data;
            node1.data = node2.data;
            node2.data = temp;
        }
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            curr.data.printCard();
            curr = curr.next;
        }
    }
}
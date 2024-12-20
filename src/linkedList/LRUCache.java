package linkedList;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/11/02/9:52 PM
 * @Description: 构造双向链表；用map来实现快速查找链表上的node（linkedHashmap）
 */
public class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }

    public void addToHead(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;

    }
    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(Node node){
        this.removeNode(node);
        this.addToHead(node);
    }

    public Node popTail(){
        Node prev = tail.prev;
        this.removeNode(prev);
        return prev;
    }
    private Node head;
    private Node tail;

    private int capacity;
    private int count;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.map = new HashMap<Integer, Node>();

        head = new Node();
        head.prev = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);

        if(n == null){
            return -1;
        }
        this.moveToHead(n);
        return n.val;
    }

    public void put(int key, int value) {
        Node n = map.get(key);

        if(n == null){
            Node newNode = new Node();
            newNode.val = value;
            newNode.key = key;

            this.map.put(key, newNode);
            this.addToHead(newNode);
            count++;

            if(count > capacity){
                Node tail = this.popTail();
                map.remove(tail.key);
                count--;
            }

        } else{
            n.val = value;
            this.moveToHead(n);
        }
    }
}


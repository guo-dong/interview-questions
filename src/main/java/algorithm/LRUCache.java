package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache
 * https://leetcode.com/problems/lru-cache/
 * @Author: guodong
 * @Date: 2019/1/6
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            //deque remove
            removeCurrNode(node);
            //deque insertToHead
            insertToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            //deque remove
            removeCurrNode(node);
            //deque insertToHead
            insertToHead(node);
            //相同的key要更新最后的value
            node.value = value;
        }else {
            Node node = new Node(key,value);
            insertToHead(node);
            map.put(key,node);
            //判断map的size是否超过容量
            if(map.size()>capacity){
                //map remove
                map.remove(tail.pre.key);
                //deque remove
                removeCurrNode(tail.pre);
            }
        }
    }

    private void insertToHead(Node node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private void removeCurrNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


}

package java_mid2.collection.list.linkedList.mains;

import java_mid2.collection.list.linkedList.linkedLists.Node;

public class MainForNode {
    public static void main(String[] args) {
        //노드 생성하고 연결하기: A -> B -> C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");
        //A -> B -> C

        System.out.println(first);

        //모든 노드 탐색하기
        System.out.println("모든 노트 탐색하기");
        printAll(first);

        //마지막 노드 조회하기
        Node lastNode = getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        //특정 index의 노드 조회하기
        int index = 2;
        Node index2Node = getNode(first, index);
        System.out.println("index2Node = " + index2Node.item);

        //데이터 추가하기
        System.out.println("데이터 추가하기");
        add(first, "D");
        System.out.println(first);
        add(first, "E");
        System.out.println(first);
        add(first, "F");
        System.out.println(first);
    }

    static void printAll(Node first) {
        Node curNode = first;
        // 현재 참조 값이 없을때까지
        while(curNode != null) {
            System.out.println(curNode.item);
            curNode = curNode.next;
        }
    }

    static Node getNode(Node first, int index) {
        // index번 다음 노드로 이동
        Node curNode = first;
        for(int i = 0; i < index; i++) {
            curNode = curNode.next;
        }

        return curNode;
    }

    static Node getLastNode(Node first) {
        Node curNode = first;
        
        while(curNode.next != null) {
            curNode = curNode.next;
        }

        return curNode;
    }

    static void add(Node first, Object item) {
        // 마지막 노드를 찾기
        Node lastNode = getLastNode(first);
        lastNode.next = new Node(item);
    }


}

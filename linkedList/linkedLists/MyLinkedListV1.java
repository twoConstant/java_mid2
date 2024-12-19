package java_mid2.linkedList.linkedLists;

public class MyLinkedListV1 {

    private Node first;
    private int size;

    public void add(Object o) {
        // 만약 첫 노드라면 Node first 갱신
        if(size == 0) {
            first = new Node(o);
            size++;
            return;
        }

        // 첫 노드가 아닌경우, 마지막 노드의 Next에 추가
        getLastNode().next = new Node(o);
        size++;
    }
    public Node getLastNode() {
        Node x = first;
        // 특정 노드의 다음 노드가 있으면 다음 노드로 이동
        while(x.next != null) {
            x = x.next;
        }
        return x;
    }
    public Object set(int index, Object o) {
        Object oldItem = getNode(index).item;
        // 교체하기
        getNode(index).item = o;
        return oldItem;
    }

    public Object get(int index) {
        return getNode(index).item;
    }

    private Node getNode(int index) {
        // index번 넘어가서 해당 노드 반환환
        Node x = first;
        for(int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexOf(Object o) {
        // 끝까지 돌면서 Node.item == o일떄 해당 index 반환
        Node x = first;
        for(int i = 0; i < size; i++) {
            if(x.item.equals(o)) {
                return i;
            }
            // 노드로 넘어가기
            x = x.next;
        }
        return -1;    // 일치하는 항목이 없을때 -1 반환환
    }

    public int size() {
        return size;
    }


    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}

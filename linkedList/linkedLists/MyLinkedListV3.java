package java_mid2.linkedList.linkedLists;

// 제네릭 적용용
public class MyLinkedListV3<T> {
    private Node<T> first;
    private int size;

    public void add(T o) {
        // 만약 첫 노드라면 Node first 갱신
        if(size == 0) {
            first = new Node<>(o);
            size++;
            return;
        }

        // 첫 노드가 아닌경우, 마지막 노드의 Next에 추가
        getLastNode().next = new Node<>(o);
        size++;
    }

    public void add(int index, T o) {
        Node<T> newNode = new Node<>(o);

        if(index == 0) {    // head인경우우 first만 변경경
            Node<T> oldHeadNode = first;
            newNode.next = oldHeadNode;
            first = newNode;
            size++;
            return;
        } else {    // 중간 노드 삽입인경우
            Node<T> prevNode = getNode(index - 1);
            // Node nextNode = getNode(index);
            Node<T> nextNode = prevNode.next;    // 이렇게 접근하는게 성능상 유리하다.
            prevNode.next = newNode;
            newNode.next = nextNode;
            size++;
            return;
        }
    }

    public Node<T> remove(int index) {
        if(index != 0) {
            Node<T> removeTargetNode = getNode(index);
            Node<T> prevNode = getNode(index - 1);
            // Node nextNode = getNode(index + 1);
            Node<T> nextNode = removeTargetNode.next;
            prevNode.next = nextNode;
            removeTargetNode.next = null;
            removeTargetNode.item = null; // 항목도 null로 변경하면서 그냥 싹 null
            size--;
            return removeTargetNode;

        } else {    // head를 삭제하는 경우
            Node<T> oldHeadNode = first;
            first = first.next;
            oldHeadNode.next = null;
            oldHeadNode.item = null;
            size--;
            return oldHeadNode;
        }

    }

    public Node<T> getLastNode() {
        Node<T> x = first;
        // 특정 노드의 다음 노드가 있으면 다음 노드로 이동
        while(x.next != null) {
            x = x.next;
        }
        return x;
    }
    public T set(int index, T o) {
        Node<T> oldNode = getNode(index);
        T oldItem = oldNode.item;
        // 교체하기
        getNode(index).item = o;
        return oldItem;
    }

    public T get(int index) {
        Node<T> node = getNode(index);
        return node.item;
    }

    private Node<T> getNode(int index) {
        // index번 넘어가서 해당 노드 반환환
        Node<T> x = first;
        for(int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexOf(T o) {
        // 끝까지 돌면서 Node.item == o일떄 해당 index 반환
        Node<T> x = first;
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

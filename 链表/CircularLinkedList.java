package cn.sjtu.assignment01;
/**
 * �ֶ�ʵ�ֵ���ѭ������
 * �пա�������飨��������ɾԪ��
 * @author j
 *
 */
public class CircularLinkedList<E> {
	private Node head;
	private Node tail;
	private int size;
	
	
	private static class Node{
		Node next;
		Object element;
		@SuppressWarnings("unused")
		public Node(Node next, Object element) {
			super();
			this.next = next;
			this.element = element;
		}	
		
		public Node(Object element) {
			super();
			this.element = element;
		}
	}
	
	//get����
	public Node getNode(int index) {
		Node node = head;
		for(int i=0;i<index;i++) {
			node = node.next;
		}
		return node;
	}
	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E) getNode(index).element;
	}
	
	//����Ԫ��
	public void add(E element) {
		Node node = new Node(element);
		if(element == null) {
			System.out.println("���ӵ�Ԫ��Ϊ��");
		}else if(size == 0) {
			head = node;
			tail = node;
			tail.next = head;
		}else {
			tail.next = node;
			node.next = head;
			tail = node;
		}
		size++;	
	}
	public void add(int index, E element) {
		checkRange(index);
		Node node = new Node(element);
		Node prev = null;
		Node nex = null;
		if(index == 0) {
			node.next = head;
			tail.next = node;
			head = node;
		}else if(index == size-1) {
			prev = getNode(index-1);
			prev.next = node;
			node.next = tail;
		}else {
			prev = getNode(index-1);
			nex = getNode(index);
			prev.next = node;
			node.next = nex;
		}
		size++;
	}
	//ɾ��Ԫ��
	public void remove(int index) {
		checkRange(index);
		Node prev = null;
		Node next = null;
		if(index == 0) {
			tail.next = head.next;
			head = head.next;
		}else if(index == size-1) {
			prev = getNode(index-1);
			prev.next = head;
			tail = prev;
		}else {
			prev = getNode(index-1);
			next = getNode(index+1);
			prev.next = next;
		}
		size--;
	}
	public String toString() {
		Node node = head;
		StringBuilder sb = new StringBuilder("[");
		for(int i=0;i<size;i++) {
			sb.append(node.element+",");
			node = node.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	public void checkRange(int index) {
		if(index<0 || index>size-1) {
			throw new RuntimeException("�������Ϸ�");
		}
	}
	
	public static void main(String[] args) {
		CircularLinkedList<String> list = new CircularLinkedList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		System.out.println(list);
		list.add(3, "dang");
		list.remove(4);
		System.out.println(list);
		System.out.println(list.get(3));
	}
}

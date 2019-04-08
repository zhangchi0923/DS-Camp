package cn.sjtu.assignment01;

public class DoublyLinkedList {
	private int size;
	private Node head;
	private Node tail;
	
	public DoublyLinkedList() {
		super();
		size = 0;
	}
	//两个add方法
	public void add(Object obj) {
		Node newnode = new Node(obj);
		if(size == 0) {
			head = newnode;
			tail = newnode;
			head.next = tail;
			tail.prev = head;
		}else {
			tail.next = newnode;
			newnode.prev = tail;
			tail = newnode;
		}
		size++;
	}
	public void add(int index, Object obj) {
		Node temp = new Node(obj);
		Node nex;
		Node pre;
		checkRange(index);
		if(index == 0) {
			temp.next = head;
			head.prev = temp;
			head = temp;
		}else if(index == size-1) {
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}else {
			pre = getNode(index-1);
			nex = getNode(index);
			pre.next = temp;
			temp.next = nex;
			temp.prev = pre;
			nex.prev = temp;
		}
		size++;
	}
	//获取结点
	public Node getNode(int index) {
		if(!checkRange(index)) {
			throw new NullPointerException("Illegal index!");
		};
		Node temp;
		if(index < size>>1) {
			temp = head;
			for(int i = 0;i<index;i++) {
				temp = temp.next;
			}
			
		}else {
			temp = tail;
			for(int i=size-1;i>index;i--) {
				temp = temp.prev;
			}
		}
		return temp;
	}
	//获取结点的值
	public Object get(int index) {
		checkRange(index);
		return getNode(index).value;
	}
	//移除结点
	public void remove(int index) {
		checkRange(index);
		Node nex;
		Node pre;
		if(index == 0) {
			head = head.next;
			head.prev = null;
		}else if(index == size-1) {
			tail = tail.prev;
			tail.next = null;
		}else {
			nex = getNode(index+1);
			pre = getNode(index-1);
			pre.next = nex;
			nex.prev = pre;
		}
		size--;
	}
	@Override
	public String toString() {
		Node temp = head;
		StringBuilder sb = new StringBuilder();
		while(temp != null) {
			sb.append(temp.value+"<-->");
			temp = temp.next;
		}
		return "DoublyLinkedList [size=" + size + ", head=" + head.value + ", tail=" + tail.value + 
				"] "+sb.toString();
	}
	//检查索引合法性
	public boolean checkRange(int index) {
		return index>=0 && index<=size-1;
	}
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add("aa");
		list.add("bbb");
		list.add("c");
		list.add("dang");
		list.add("qiu");
		list.add(3, 16);
		System.out.println(list);
		System.out.println(list.get(3));
		list.remove(5);
		System.out.println(list);
	}
}
//定义结点
class Node{
	Node next;
	Node prev;
	Object value;
	public Node() {
		super();
	}
	public Node(Object value) {
		super();
		this.value = value;
	}
	
}
package cn.sjtu.assignment01;
/**
 * 单链表手动实现循环队列
 * 入队、出队、访问队首
 * @author j
 *
 */
public class CircularQueue {
	private int size;
	private Node head;
	private Node tail;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 100;
	
	//两种构造器
	public CircularQueue() {
		super();
		size = 0;
		head = null;
		tail = null;
		capacity = DEFAULT_CAPACITY;
	}
	public CircularQueue(int capacity) {
		super();
		size = 0;
		head = null;
		tail = null;
		this.capacity = capacity;
	}
	
	//结点
	class Node{
		Node next;
		Object value;
		//Node构造器
		public Node(Object value) {
			super();
			this.value = value;
		}	
	}
	//入队尾
	public void enque(Object o) {
		Node newnode = new Node(o);
		if(size == 0) {
			head = newnode;
			tail = newnode;
			head.next = tail;
			size++;
			//默认tail.next = null;
		}else if(size == capacity) {
			System.out.println("Full Queue!");
		}else {
			tail.next = newnode;
			tail = newnode;
			//默认tail.next = null;
			size++;
		}
	}
	//出队，队首元素重新排队，当队尾
	public void deque() {
		if(size == 0) {
			System.out.println("Empty Queue!");
		}else if(size == 1){
			return;
		}else {
			Node temp = head.next;
			tail.next = head;
			tail = head;
			head.next = null;
			head = temp;
		}
	}
	//访问队首
	public void peek() {
		if(size == 0) {
			System.out.println("Empty Queue!");
		}else {
			System.out.println(head.value);
		}
		
	}
	@Override
	public String toString() {
		Node temp = head;
		StringBuilder sb = new StringBuilder();
		while(temp != null) {
			sb.append(temp.value+"->");
			temp = temp.next;
		}
		return sb.toString();
	}
	//执行
	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(5);
		cq.enque("aaa");
		cq.enque("bb");
		System.out.println(cq);
		cq.enque("cccc");
		cq.deque();
		System.out.println(cq);
		cq.peek();
	}
}

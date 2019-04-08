package cn.sjtu.assignment01;
/**
 * 用链表手动实现链式队列
 * 头结点、尾节点
 * 入队、出队、返还第一个
 * @author j
 *
 */
public class LinkedQueue<E> {
	private Node head;
	private Node tail;
	private int size;
	class Node{
		Node next;
		Object value;
		
		public Node(Object value) {
			super();
			this.value = value;
		}
	}
	//入队
	public void enqueue(Object value) {
		Node newnode = new Node(value);
		if(size == 0) {
			head = newnode;
			tail = newnode;
			head.next = tail;
		}else {
			tail.next = newnode;
			tail = newnode;
		}
		size++;
	}
	//出队
	public void dequeue() {
		if(size == 0) {
			throw new RuntimeException("The Queue is already empty!");
		}else {
//			Node temp = head;到底需不需要有呢？？
			head = head.next;
//			temp = null;
		}
		size--;
	}
	//访问头部元素
	public void peek() {
		if(size == 0) {
			throw new RuntimeException("Cannot peek an empty Queue!");
		}else {
			System.out.println(head.value);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node temp = head;
		while(temp != null) {
			sb.append(temp.value+",");
			temp = temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedQueue<Integer> q1 = new LinkedQueue<>();
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		q1.enqueue(45);
		q1.enqueue(3);
		System.out.println(q1);
		q1.peek();
		System.out.println(q1.tail.value);
		q1.dequeue();
		System.out.println("###########");
		System.out.println(q1);
		q1.peek();
		System.out.println(q1.tail.value);
		
	}
}

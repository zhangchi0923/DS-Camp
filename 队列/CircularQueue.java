package cn.sjtu.assignment01;
/**
 * �������ֶ�ʵ��ѭ������
 * ��ӡ����ӡ����ʶ���
 * @author j
 *
 */
public class CircularQueue {
	private int size;
	private Node head;
	private Node tail;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 100;
	
	//���ֹ�����
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
	
	//���
	class Node{
		Node next;
		Object value;
		//Node������
		public Node(Object value) {
			super();
			this.value = value;
		}	
	}
	//���β
	public void enque(Object o) {
		Node newnode = new Node(o);
		if(size == 0) {
			head = newnode;
			tail = newnode;
			head.next = tail;
			size++;
			//Ĭ��tail.next = null;
		}else if(size == capacity) {
			System.out.println("Full Queue!");
		}else {
			tail.next = newnode;
			tail = newnode;
			//Ĭ��tail.next = null;
			size++;
		}
	}
	//���ӣ�����Ԫ�������Ŷӣ�����β
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
	//���ʶ���
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
	//ִ��
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

package cn.sjtu.assignment01;

/**
 * �õ������ֶ�ʵ����ʽջ
 * push,pop,peek
 * @author j
 *
 */
public class LinkedStack<E> {
	private int size;
	private int capacity;
	private Node top;
		
	public LinkedStack() {
		super();
		this.capacity = 10;
	}

	public LinkedStack(int capacity) {
		super();
		this.capacity = capacity;
	}

	//��������
	class Node{
		E value;
		Node next;
		public Node(E value) {
			super();
			this.value = value;
		}
		
	}
	//ѹջ����
	public void push(E element) {
		Node newnode = new Node(element);
		if(size == 0) {
			top = newnode;
			top.next = null;
		}else if(size < capacity) {
			newnode.next = top;
			top = newnode;
		}else {
			throw new RuntimeException("Stack OverFlow!");
		}
		size++;
	}
	//��ջ����
	public Node pop() {
		Node temp;
		if(size == 0) {
			throw new RuntimeException("Stack Underflow!");
		}else {
			temp = top;
			top = top.next;	//���⣺��top.next��ֵ������top��topԭ��ָ��Ķ����ʱ��Ȼ�����ڶ���ռ���ڴ棬��������
		}
		size--;
		return temp;
	}
	//���ʶ���Ԫ��
	public void peek() {
		System.out.println(top.value);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node temp = top;
		for(int i=0;i<size;i++) {
			sb.append(temp.value+",");
			temp = temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedStack<String> s = new LinkedStack<>();
		s.push("aa");
		s.push("bb");
		s.push("cc");
		
		System.out.println(s);
		s.peek();
		s.pop();
		System.out.println(s);
		s.peek();
	}
}

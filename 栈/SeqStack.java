package cn.sjtu.assignment01;

/**
 * �ֶ�ʵ��˳��ջ��ʹ�����飩
 * ʵ���пա����ض���Ԫ�ء�����Ԫ�أ�push��������Ԫ�أ�pop������
 * @author j
 *
 */
public class SeqStack {
	private int size;
	private int top;
	private int[] stack;
	
	public SeqStack(int size) {
		super();
		this.size = size;
		top = -1;
		stack = new int[size];
	}
	//�Ӷ���������Ԫ��
	public void push(int element) {
		if(top == size-1) {
			throw new IndexOutOfBoundsException("Stack OverFlow!");
		}
		stack[++top] = element;	
	}
	//��������Ԫ��
	public void pop() {
		stack[top--] = 0;
	}
	//���ʶ���Ԫ��
	public int peekTop() {
		int peek = stack[top];
		return peek;
	}
	
	
	public boolean isEmpty() {
		return (top<0);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(int i=0;i<size;i++) {
			sb.append(stack[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	//ִ�в���
	public static void main(String[] args) {
		SeqStack s = new SeqStack(5);
		System.out.println(s.isEmpty());
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.toString());
		s.push(4);
		s.push(5);
		System.out.println(s);
//		s.push(6);
		System.out.println(s.peekTop());
		s.pop();
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.push(0);
		System.out.println(s);
		System.out.println(s.peekTop());
	}
}

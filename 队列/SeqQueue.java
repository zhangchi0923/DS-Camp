package cn.sjtu.assignment01;

import java.util.Arrays;

/**
 * 数组实现顺序队列
 * 队首、队尾、队列大小
 * 入队、出队、访问队首
 * @author j
 *
 */
public class SeqQueue {
	private int size;
	private int capacity;
	private int[] arr;
	private static final int DEFAULT_CAPACITY = 10;
	
	public SeqQueue(){
		size = 0;
		capacity = DEFAULT_CAPACITY;
		arr = new int[capacity];
	}
	
	public SeqQueue(int capacity) {
		size = 0;
		this.capacity = capacity;
		arr = new int[capacity];
	}
	//入队
	public void enque(int value) {
		if(size == capacity) {
			throw new RuntimeException("Full Queue!");
		}else{
			arr[size] = value;
			size++;
		}
		
	}
	//出队
	public void deque() {
		isEmpty();
		for(int i = 0;i<size-1;i++) {
			arr[i] = arr[i+1];
		}
		arr[size-1] = 0;
		size--;
	}
	//访问队首
	public void peek() {
		isEmpty();
		System.out.println(arr[0]);
	}
	//判空
	public boolean isEmpty() {
		return size==0;
	}
	//队列大小
	public void getSize() {
		isEmpty();
		System.out.println(size);
	}
		
		
	@Override
	public String toString() {
		return "SeqQueue [size=" + size + ", capacity=" + capacity + ", arr=" + Arrays.toString(arr) + "]";
	}

	public static void main(String[] args) {
		SeqQueue q = new SeqQueue(5);
		q.enque(10);
		q.enque(20);
		q.enque(30);
		q.deque();
		q.peek();
//		q.deque();
//		q.peek();
//		q.deque();
//		q.getSize();
		System.out.println(q.isEmpty());
		System.out.println(q);
	}
}

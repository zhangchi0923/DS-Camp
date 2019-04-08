package cn.sjtu.assignment01;
/**
 * �ֶ�ʵ�ֵ�������
 * �����ڲ���Node
 * �пա����ȡ�������顢��ɾ����ȡ�м��㡢��ת
 * @author j
 *
 */
public class SinglyLinkedList<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	private static class Node<E>{
		Node<E> next;
		E element;
		
		public Node(E element) {
			this.element = element;
		}	
	}
	//��ȡ����
	public int getSize() {
		return size;
	}
	//�п�
	public boolean isEmpty() {
		return size == 0? true:false;
	}
	//��ȡ���
	public Node<E> getNode(int index) {
		checkRange(index);
		Node<E> temp = first;
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		return temp;
	}
	//��ȡ�������
	public void get(int index) {
		checkRange(index);
		System.out.println(getNode(index).element);
	}
	@SuppressWarnings("unused")
	public void add(E element) {
		Node<E> newnode = new Node<>(element);
		if(newnode == null) {
			throw new RuntimeException("���ӽ��Ϊ��");
		}else if(size == 0){
			first = newnode;
			last = newnode;
			last.next = null;
		}else {
			last.next = newnode;
			last = newnode;
			last.next = null;
		}
		size++;
	}

	//������index = ��0��size-1��
	@SuppressWarnings("unused")
	public void add(int index,E element) {
		checkRange(index);
		Node<E> newnode = new Node<>(element);
		if(newnode == null) {
			throw new RuntimeException("���ӽ��Ϊ��");
		}else if(index==0){
			newnode.next = first;
			first = newnode;//д��get�����ٻ���д
		}else if(index == size-1){
			Node<E> prev = getNode(index-1);
			prev.next = newnode;
			newnode.next = last;
		}else {
			Node<E> prev = getNode(index-1);
			Node<E> nex = getNode(index);
			prev.next = newnode;
			newnode.next = nex;
		}
		size++;
	}
	//ɾ���ڵ�
	public void remove(int index) {
		checkRange(index);
		if(index == 0) {
			first = first.next;
		}else if(index == size-1) {
			Node<E> prev = getNode(index-1);
			prev.next = null;
			last = prev;
		}else {
			Node<E> prev = getNode(index-1);
			Node<E> nex = getNode(index+1);
			prev.next = nex;
		}
		size--;
	}
	
	//��ת������
	public void reverse() {
		Node<E> prev = null;
		Node<E> current = first;
		Node<E> next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		last = first;
		first = prev;
	}
	
	//��������������


	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> temp = first;
		if(size == 0) {
			System.out.println("����Ϊ�գ�");
		}else {
			while(temp != null) {
				sb.append(temp.element+",");
				temp = temp.next;
			}
			sb.setCharAt(sb.length()-1, ']');
		}
		return sb.toString();
	}
	//��������Ϸ���
	public void checkRange(int index) {
		if(index<0 || index>size-1) {
			throw new RuntimeException("�������Ϸ�");
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
		list2.add(1);
		list2.add(5);
		list2.add(7);
		
		list.add(2);
		list.add(9);
		list.add(13);
		System.out.println(list);
		list.add(2, 10);
		list.add(0,0);
//		list.get(1);
//		list.get(0);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.reverse();
		System.out.println(list);
//		System.out.println(list.first.element);
//		System.out.println(list.last.element);

		System.out.println(list2);
//		System.out.println(merge(list,list2));
	}
}

package cn.sjtu.assignment01;
/**
 * 手动实现单向链表
 * 创建内部类Node
 * 判空、长度、索引检查、增删、获取中间结点、反转
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
	//获取长度
	public int getSize() {
		return size;
	}
	//判空
	public boolean isEmpty() {
		return size == 0? true:false;
	}
	//获取结点
	public Node<E> getNode(int index) {
		checkRange(index);
		Node<E> temp = first;
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		return temp;
	}
	//获取结点数据
	public void get(int index) {
		checkRange(index);
		System.out.println(getNode(index).element);
	}
	@SuppressWarnings("unused")
	public void add(E element) {
		Node<E> newnode = new Node<>(element);
		if(newnode == null) {
			throw new RuntimeException("增加结点为空");
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

	//插入结点index = （0，size-1）
	@SuppressWarnings("unused")
	public void add(int index,E element) {
		checkRange(index);
		Node<E> newnode = new Node<>(element);
		if(newnode == null) {
			throw new RuntimeException("增加结点为空");
		}else if(index==0){
			newnode.next = first;
			first = newnode;//写完get方法再回来写
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
	//删除节点
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
	
	//翻转单链表
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
	
	//联结两个单链表


	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> temp = first;
		if(size == 0) {
			System.out.println("链表为空！");
		}else {
			while(temp != null) {
				sb.append(temp.element+",");
				temp = temp.next;
			}
			sb.setCharAt(sb.length()-1, ']');
		}
		return sb.toString();
	}
	//检查索引合法性
	public void checkRange(int index) {
		if(index<0 || index>size-1) {
			throw new RuntimeException("索引不合法");
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

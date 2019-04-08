package cn.sjtu.assignment01;
/**
 * 手动实现有序（可重复）单链表（数和普通类均可）
 * 头、尾、增删、获取、合并两有序链表
 * @author j
 *
 */
public class MergeLinkedList {
	private int size;
	private Node head;
	private Node tail;
	
	public MergeLinkedList() {
		super();
		size = 0;
	}

	class Node{
		Node next;
		int value;
		
		public Node(int value) {
			super();
			this.value = value;
			next = null;
		}	
	}
	
	public void add(int value) {
		Node newnode = new Node(value);
		if(size == 0) {
			head = newnode;
			tail = newnode;
			head.next = tail;
			size++;
		}else {
			if(newnode.value<tail.value) {
				System.out.println("Wrong element to insert!");
				return;
			}else {
				tail.next = newnode;
				tail = newnode;
				size++;
			}
		}
	}
	public boolean add(int index,int value) {
		checkRange(index);
		Node newnode = new Node(value);
		Node prev = null;
		Node nex = null;
		if(index == 0) {
			if(value>head.value) {
				System.out.println("Wrong element to insert!");
				return false;
			}else {
				newnode.next = head;
				head = newnode;
				size++;
				return true;
			}
		}else if(index == size){
			if(value<tail.value) {
				System.out.println("Wrong element to insert!");
				return false;
			}else {
				tail.next = newnode;
				tail = newnode;
				size++;
				return true;
			}
		}else {
			prev = getNode(index-1);
			nex = getNode(index);
			if(value<prev.value || value>nex.value) {
				System.out.println("Wrong element to insert!");
				return false;
			}else {
				prev.next = newnode;
				newnode.next = nex;
				size++;
				return true;
			}	
		}
	}
	//合并两有序链表，重复元素只保留一个
	public static MergeLinkedList merge(MergeLinkedList list1,MergeLinkedList list2) {
		Node head1;
		Node head2;
		MergeLinkedList newlist = new MergeLinkedList();
		if(list1 == null && list2 == null) {return null;}
		else if(list1 == null) {return list2;}
		else if(list2 == null) {return list1;}
		
		head1 = list1.head;
		head2 = list2.head;
		newlist.head = head1.value<head2.value? head1:head2;
		newlist.tail = newlist.head;
		while(true) {
			if(head1 == null) {
				newlist.tail.next = head2;
				break;
			}
			if(head2 == null) {
				newlist.tail.next = head1;
				break;
			}
			if(head1.value<=head2.value) {
				newlist.tail.next = head1;
				head1 = head1.next;
			}else {
				newlist.tail.next = head2;
				head2 = head2.next;
			}
			newlist.tail = newlist.tail.next;
			
		}
		return newlist;
	}
	//删除元素
	public void remove(int index) {
		checkRange(index);
		if(index == 0) {
			head = head.next;
			size--;
		}else if(index == size-1) {
			tail = getNode(index-1);
			size--;
		}else {
			getNode(index-1).next = getNode(index+1);
			size--;
		}
	}
	//获取
	public void get(int index) {
		System.out.println(getNode(index).value);
	}
	public Node getNode(int index) {
		checkRange(index);
		Node temp = head;
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		return temp;
	}
	public boolean checkRange(int index) {
		return (index<0 || index>size-1)? false:true;
	}
	@Override
	public String toString() {
		Node temp = head;
		StringBuilder sb = new StringBuilder("MergeLinkedList [size=" + 
		size + ", head=" + head.value + ", tail=" + tail.value + "] ");
		while(temp != null) {
			sb.append(temp.value+"->");
			temp = temp.next;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MergeLinkedList list1 = new MergeLinkedList();
		list1.add(2);
		list1.add(3);
		list1.add(5);
		list1.add(10);
		System.out.println(list1);
		
		MergeLinkedList list2 = new MergeLinkedList();
		list2.add(1);
		list2.add(3);
		list2.add(5);
		list2.add(10);
		System.out.println(list2);
		System.out.println(merge(list1,list2));
	}
}

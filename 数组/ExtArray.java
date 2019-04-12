package cn.sjtu.assignment02;

import java.util.Arrays;

/**
 * 手动实现一个支持动态扩容的数组
 * 当数组容量不足时，进行扩容
 * 增、删、改、查
 * @author j
 *
 */
public class ExtArray {
	private int[] arr;
	
	//两种构造器
	public ExtArray() {
		super();
		arr = new int[0];
	}
	//增加元素
	public int[] add(int n) {
		if(arr.length == 0) {
			arr = new int[1];
			arr[0] = n;
		}else {
			arr = Arrays.copyOf(arr,arr.length+1);
			arr[arr.length-1] = n;
		}
		
		return arr;
	}
	//在指定索引位置增加元素
	public int[] add(int index,int n) {
		checkRange(index);
		int[] newarr = new int[arr.length+1];
		System.arraycopy(arr, 0, newarr, 0, index);
		System.arraycopy(arr, index, newarr, index+1, arr.length-index);
		newarr[index] = n;
		arr = newarr;
		return arr;
	}
	//删除指定索引位置的元素
	public int[] remove(int index) {
		checkRange(index);
		int[] newarr = new int[arr.length-1];
		System.arraycopy(arr, 0, newarr, 0, index);
		System.arraycopy(arr, index+1, newarr, index, arr.length-index-1);
		arr = newarr;
		return arr;
	}
	//更改指定位置元素
	public int[] set(int index,int n) {
		checkRange(index);
		arr[index] = n;
		return arr;
	}
	//检索指定位置元素
	public int get(int index) {
		checkRange(index);
		return arr[index];
	}
	
	
	//检查索引合法性
	public void checkRange(int index) {
		if(index<0 || index>arr.length-1) {
			throw new NullPointerException("Illegal Index!");
		}else {
			return;
		}
	}
	@Override
	public String toString() {
		return "ExtArray {length = "+arr.length+"\tarr=" + Arrays.toString(arr) + " }";
	}

	public static void main(String[] args) {
		ExtArray a = new ExtArray();
		a.add(14);
		a.add(5);
		a.add(7);
		System.out.println(a);
		a.add(2,9);
		System.out.println(a);
//		a.remove(1);
		a.set(2, 78);
		System.out.println(a);
		System.out.println(a.get(2));
	}
	
}

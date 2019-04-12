package cn.sjtu.assignment02;

import java.util.Arrays;

/**
 * 有序（升序）数组，增删查改
 * @author j
 *
 */
public class SeqArray {
	int[] arr;
	
	public SeqArray() {
		super();
		arr = new int[0];
	}
	//在数组尾部添加元素
	public int[] add(int n) {
		int[] newarr = Arrays.copyOf(arr, arr.length+1);
		if(arr.length == 0) {
			newarr[0] = n;
		}else if(arr[arr.length-1]<=n) {
			newarr[arr.length] = n;
		}else {
			throw new RuntimeException("Wrong integer to insert!");
		}
		arr = newarr;
		return arr;
	}
	//在指定索引位置添加元素
	public int[] add(int index,int n) {
		checkRange(index);
		int[] newarr = new int[arr.length+1];
		if(index == 0) {
			if(arr[0]<n) {throw new RuntimeException("Wrong element to insert!");}
			else {
				System.arraycopy(arr, 0, newarr, 1, arr.length);
				newarr[0] = n;
				arr = newarr;	
			}
		}else if(index<arr.length-1) {
			if(arr[index-1]<=n && n<=arr[index]) {
				System.arraycopy(arr, 0, newarr, 0, index);;
				System.arraycopy(arr, index, newarr, index+1, arr.length-index);
				newarr[index] = n;
				arr = newarr;
			}else {
				throw new RuntimeException("Wrong element to insert!");
			}
		}else {
			if(n>=arr[index]) {
				System.arraycopy(arr, 0, newarr, 0, arr.length);
				newarr[index+1] = n;
				arr = newarr;
			}else {throw new RuntimeException("Wrong element to insert!");}
		}
		return arr;
	}
	
	//更改指定索引位置的元素
	public int[] set(int index, int n) {
		checkRange(index);
		if(index == 0) {
			if(n<= arr[index+1]) {arr[index] = n;}
			else {throw new RuntimeException("Wrong element to insert!");}
		}else if(index == arr.length-1) {
			if(n>=arr[index-1]) {arr[index] = n;}
			else {throw new RuntimeException("Wrong element to insert!");}
		}else {
			if(arr[index-1] <= n && n <= arr[index+1]) {arr[index] = n;}
			else {throw new RuntimeException("Wrong element to insert!");}
		}
		return arr;
	}
	//按照索引查找
	public void get(int index) {
		System.out.println(arr[index]);
	}
	//将两个有序数组合并成一个有序数组
	public int[] merge(SeqArray b) {
		int[] newarr = new int[this.arr.length+b.arr.length];
		int k=0;
		int i=0;
		int j=0;
		if(this.arr.length == 0 && b.arr.length == 0) {return null;}
		else if(this.arr.length == 0) {return b.arr;}
		else if(b.arr.length == 0) {return this.arr;}
		else {
			while(i<this.arr.length && j<b.arr.length) {
				if(this.arr[i]<=b.arr[j]) {
					newarr[k++] = this.arr[i++];
				}else {
					newarr[k++] = b.arr[j++];
				}
			}
			while(i<this.arr.length) {
				newarr[k++] = this.arr[i++];
			}
			while(j<b.arr.length) {
				newarr[k++] = b.arr[j++];
			}
		}
		return newarr;
	}
	public void checkRange(int index) {
		if(index<0 || index>arr.length-1) {throw new RuntimeException("Illegal Index!");}
		else {return;}
	}
	
	@Override
	public String toString() {
		return "SeqArray [arr=" + Arrays.toString(arr) + "]";
	}

	public static void main(String[] args) {
		SeqArray s = new SeqArray();
		SeqArray s2 = new SeqArray();
		SeqArray s3 = new SeqArray();//空数组
		s.add(1);
		s.add(3);
		s.add(5);
		s.add(0, 0);
		s.add(2,2);
		s.add(3,3);
//		s.get(5);
//		System.out.println(s);
		s.set(5, 6);
		System.out.println("s: "+s);
		
		s2.add(2);
		s2.add(4);
		s2.add(7);
		s2.add(11);
		System.out.println("s2: "+s2);
		
		System.out.println("After merge: "+s.merge(s2));
		for(int e:s2.merge(s3)) {
			System.out.print(e+" ");
		}
	}
}

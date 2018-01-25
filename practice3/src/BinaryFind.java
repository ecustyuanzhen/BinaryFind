import java.util.Scanner;
import java.util.Random;

import javax.naming.spi.DirStateFactory.Result;

//对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。 
//给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。
public class BinaryFind {

	static int[] aus;
	int  result = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("数组大小：");
			int N = sc.nextInt();
			System.out.println("查找元素：");
			int X = sc.nextInt();
			Random random = new Random();
			int[] a = new int[N];
			aus = new int[a.length];
			for(int i=0;i<a.length;i++){
				a[i] = random.nextInt(N);
			}
//			System.out.print("随机数组");
//			for (int i=0;i<N;i++) {
//				System.out.print(a[i]+",");
//			}
			System.out.println();
			BinaryFind binaryFind = new BinaryFind();
			binaryFind.sort(a, 0, a.length-1);
			System.out.print("排序后数组");
			for(int i=0;i<a.length;i++){
				System.out.print(a[i]+",");
			}
			System.out.println();
//			System.out.println(binaryFind.find(a,X,0,a.length-1));
			binaryFind.find(a,X,0,a.length-1);
			System.out.println("返回结果："+binaryFind.result);
		}
		
	}


	private void find(int[] a, int x,int first,int last) {
		// TODO Auto-generated method stub
		int mid = first+(last-first)/2;
		
		if (first > last) {			
				result = -1;			
		}else {
				if(a[mid]<x) {
					find(a, x, mid+1, last);
				}
				else if (a[mid]>x) {
					find(a, x, first, mid-1);
				}
				else {
					while (a[mid]==x) {
						mid--;
						if(mid<0) break;
					}
					result = mid+1;
				}
		}	
	}


	public void sort(int[] a,int first,int last) {
		if (first>=last) {
			return;
		}
		int mid = first+(last-first)/2;
		sort(a, first, mid);
		sort(a, mid+1, last);
		mregesort(a,first,mid,last);
	}

	private void mregesort(int[] a,int first, int mid, int last) {
		// TODO Auto-generated method stub
		
		for(int i=first;i<=last;i++){
			aus[i] = a[i];
		}
		int i = first;
		int j = mid+1;
		for(int i1=first;i1<=last;i1++){
			if(i>mid){
				a[i1]=aus[j++];
			}else
			if(j>last){
				a[i1]=aus[i++];
			}else
			if(aus[i]>aus[j]){
				a[i1] = aus[j++];
				}
			else {
				a[i1] = aus[i++];
				}
		}
	}
}

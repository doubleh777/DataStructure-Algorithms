package mergesort;

import insertsort.InsertSort;

public class MergeSortTest {

	public static void main(String[] args){
		
		int i;
		int[] arr1 = null;  // 배열의 참조값이 없을 경우는 try/catch를 이용해 예외처리하였음 
		int[] arr2 = {};	// 배열이 비어있을 경우 
		int[] arr3 = {1};	// 배열의 원소가 1개인 경우 
		int[] arr4 = {2,1}; // 배열의 원소가 2개인 경우 
		
		int[] arr5 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};  //원소가 20개인 경우의 증가순 
		int[] arr6 = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};  //원소가 20개인 경우의 감소순 
		int[] arr7 = {6,3,1,8,3,9,11,15,7,2,9,10,17,20,6,7,8,14,19,18};		//원소가 20개인 경우의 랜덤&동일숫자를 포함한 경
	
		MergeSort mergeSort1 = new MergeSort(arr1);

		
		MergeSort mergeSort2 = new MergeSort(arr2);
		mergeSort2.sorting(0, arr2.length-1);
		for(i = 0 ; i < arr2.length ; i++){
			System.out.print(arr2[i] + " ");
		}
		System.out.println("");
		System.out.println(mergeSort2.isSorted());
		
		MergeSort mergeSort3 = new MergeSort(arr3);
		mergeSort3.sorting(0, arr3.length-1);
		for(i = 0 ; i < arr3.length ; i++){
			System.out.print(arr3[i] + " ");
		}
		System.out.println("");
		System.out.println(mergeSort3.isSorted());
		
		MergeSort mergeSort4 = new MergeSort(arr4);
		mergeSort4.sorting(0, arr4.length-1);
		for(i = 0 ; i < arr4.length ; i++){
			System.out.print(arr4[i] + " ");
		}
		System.out.println("");
		System.out.println(mergeSort4.isSorted());
		
		MergeSort mergeSort5 = new MergeSort(arr5);
		mergeSort5.sorting(0, arr5.length-1);
		for(i = 0 ; i < arr5.length ; i++){
			System.out.print(arr5[i] + " ");
		}
		System.out.println("");
		System.out.println(mergeSort5.isSorted());
		
		MergeSort mergeSort6 = new MergeSort(arr6);
		mergeSort6.sorting(0, arr6.length-1);
		for(i = 0 ; i < arr6.length ; i++){
			System.out.print(arr6[i] + " ");
		}
		System.out.println("");
		System.out.println(mergeSort6.isSorted());
		
		MergeSort mergeSort7 = new MergeSort(arr7);
		mergeSort7.sorting(0, arr7.length-1);
		for(i = 0 ; i < arr7.length ; i++){
			System.out.print(arr7[i] + " ");
		}
		System.out.println("");
		System.out.println(mergeSort7.isSorted());
	}
		
}


package insertsort;

public class InsertSortTest {

	public static void main(String[] args) {
		
		InsertSort insertSort = new InsertSort();
		int i;
		int[] arr1 = null;  // 배열의 참조값이 없을 경우는 try/catch를 이용해 예외처리하였음 
		int[] arr2 = {};	// 배열이 비어있을 경
		int[] arr3 = {1};	// 배열의 원소가 1개인 경우 
		int[] arr4 = {2,1}; // 배열의 원소가 2개인 경우 
		
		int[] arr5 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};  //원소가 20개인 경우의 증가순 
		int[] arr6 = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};  //원소가 20개인 경우의 감소순 
		int[] arr7 = {6,3,1,8,3,9,11,15,7,2,9,10,17,20,6,7,8,14,19,18};		//원소가 20개인 경우의 랜덤&동일숫자를 포함한 경
	
		insertSort.insertSorting(arr1);
		
		insertSort.insertSorting(arr2);
		for(i = 0 ; i < arr2.length ; i++){
			System.out.print(arr2[i] + " ");
		}
		System.out.println("");
		
		insertSort.insertSorting(arr3);
		for(i = 0 ; i < arr3.length ; i++){
			System.out.print(arr3[i] + " ");
		}
		System.out.println("");
		
		insertSort.insertSorting(arr4);
		for(i = 0 ; i < arr4.length ; i++){
			System.out.print(arr4[i] + " ");
		}
		System.out.println("");
		insertSort.insertSorting(arr5);
		for(i = 0 ; i < arr5.length ; i++){
			System.out.print(arr5[i] + " ");
		}
		System.out.println("");
		insertSort.insertSorting(arr6);
		for(i = 0 ; i < arr6.length ; i++){
			System.out.print(arr6[i] + " ");
		}
		System.out.println("");
		insertSort.insertSorting(arr7);
		for(i = 0 ; i < arr7.length ; i++){
			System.out.print(arr7[i] + " ");
		}
		System.out.println("");
	}

	
}

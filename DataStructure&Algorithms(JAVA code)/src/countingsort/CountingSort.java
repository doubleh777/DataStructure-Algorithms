public class CountingSort {

	public void countingSort(int[] arr, int[] newArr, int k){	//newArr는 출력 배열로 arr와 같은 길이 
		int [] tmpArr = new int[k+1];
		
		for(int i=0; i <= k; i++){
			tmpArr[i] = 0;			// 0으로 초기화 
		}
		for(int i=0; i<= arr.length-1; i++){
			tmpArr[arr[i]] = tmpArr[arr[i]]+1;		//개수 측정 
		}
		for(int i=1; i<= k; i++){
			tmpArr[i] = tmpArr[i] + tmpArr[i-1];	//개수 누적 
		}
		for(int i=arr.length-1; i>=0; i--){
			newArr[tmpArr[arr[i]]-1] = arr[i];
			tmpArr[arr[i]] = tmpArr[arr[i]] - 1;
		}
	}
}
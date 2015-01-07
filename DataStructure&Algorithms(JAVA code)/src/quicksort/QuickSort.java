package quicksort;

public class QuickSort {
	public void quickSort(int [] arr, int start, int end){ 	// 배열과 처리할 위치의 시작과 끝 
		if(start < end) return;
		
		int result = partition(arr, start, end); // result는 값이 큰 블록의 첫 번째 원소 위치  	
		quickSort(arr, start, result-1);
		quickSort(arr, result+1, end);
	}
	
	public int partition(int [] arr, int start, int end){ 
		int pivotValue = arr[end];	// pivot value로 배열의 마지막 원소를 지정 
		int endOfLowBlock = start - 1; // end of low block은 초기화 시점에는 존재하지 않으므로 empty로 시작 
		
		//scanning하면서 partion진행 
		for(int posToBeChecked = start; posToBeChecked < end; posToBeChecked++){
			if(arr[posToBeChecked] <= pivotValue){
				endOfLowBlock = endOfLowBlock + 1;
				
				//swap
				int tmp = arr[endOfLowBlock];
				arr[endOfLowBlock] = arr[posToBeChecked];
				arr[posToBeChecked] = tmp;
			}
		}
		//swap
		int tmp = arr[endOfLowBlock + 1];
		arr[endOfLowBlock + 1] = arr[end];
		arr[end] = tmp;
		
		return endOfLowBlock + 1;	//pivot의 index를 반환
	}
}

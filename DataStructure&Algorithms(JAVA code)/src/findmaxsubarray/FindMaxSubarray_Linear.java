package findmaxsubarray;

public class FindMaxSubarray_Linear {

	public SubarrayInfo find_Linear(int[] arr, int low, int high){
		
		if(arr == null || arr.length == 0){
			SubarrayInfo error = new SubarrayInfo();
			error.setFront(-1);
			error.setEnd(-1);
			error.setSum(-1);
			
			return error;
		}
		//종료 조건 
		if(low == high){
			SubarrayInfo dividedSubarray = new SubarrayInfo();
			dividedSubarray.setFront(low);
			dividedSubarray.setEnd(high);
			dividedSubarray.setSum(arr[low]);
			return dividedSubarray;
		}
		
		SubarrayInfo leftMaxSubarray;
		SubarrayInfo rightMaxSubarray;
		SubarrayInfo crossMaxSubarray;
		
		int mid = low + (high - low)/2;
		
		leftMaxSubarray = find_Linear(arr, low, mid);
		rightMaxSubarray = find_Linear(arr, mid+1, high);
		crossMaxSubarray = findMaxCrossingSubarray(arr,low,mid,high);
		
		if(leftMaxSubarray.getSum() >= rightMaxSubarray.getSum() && leftMaxSubarray.getSum() >= crossMaxSubarray.getSum())
			return leftMaxSubarray;
		else if(rightMaxSubarray.getSum() >= leftMaxSubarray.getSum() && rightMaxSubarray.getSum() >= crossMaxSubarray.getSum())
			return rightMaxSubarray;
		else return crossMaxSubarray;
		
	}

	private SubarrayInfo findMaxCrossingSubarray(int[] arr, int low, int mid, int high) {
		
		SubarrayInfo maxCrossingSubarray = new SubarrayInfo();
		int leftMaxSum = Integer.MIN_VALUE;
		int leftMaxSumIndex = mid;
		int sum = 0;
		
		for(int i = mid ; i >= low ; i--){
			sum += arr[i];
			if(sum > leftMaxSum){
				leftMaxSum = sum;
				leftMaxSumIndex = i;
			}
		}
		
		int rightMaxSum = Integer.MIN_VALUE;
		int rightMaxSumIndex = mid+1;
		sum = 0;
		
		for(int i = mid+1 ; i<=high ; i++){
			sum += arr[i];
			if(sum > rightMaxSum){
				rightMaxSum = sum;
				rightMaxSumIndex = i;
			}
		}
		
		maxCrossingSubarray.setFront(leftMaxSumIndex);
		maxCrossingSubarray.setEnd(rightMaxSumIndex);
		maxCrossingSubarray.setSum(leftMaxSum+rightMaxSum);
		
		return maxCrossingSubarray;
	}
}

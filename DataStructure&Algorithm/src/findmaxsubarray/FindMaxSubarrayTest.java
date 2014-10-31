package findmaxsubarray;

public class FindMaxSubarrayTest {
	
	public static void main(String[] args){
		
		FindMaxSubarray_Square findMaxSubarray_Square = new FindMaxSubarray_Square();
		FindMaxSubarray_Linear findMaxSubarray_Linear = new FindMaxSubarray_Linear();
		
		int[] arr0 = null;
		int[] arr1 = {};
		int[] arr2 = {4};
		int[] arr3 = {1, 9};
		int[] arr4 = {-1, 4, 9, -1};
		int[] arr5 = {2,-4,-2, 1, 5, 10,-4 , 4, 6, -1, -4, 10, -1, 2, -10, 3, -2, 1, 7, -2};
		SubarrayInfo maxSubarray = new SubarrayInfo();
		
		maxSubarray = findMaxSubarray_Square.find_Square(arr0);
		System.out.println("arr0_Square - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		maxSubarray = findMaxSubarray_Linear.find_Linear(arr0, 0, 0);
		System.out.println("arr0_Linear - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());		
		
		maxSubarray = findMaxSubarray_Square.find_Square(arr1);
		System.out.println("arr1_Square - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		maxSubarray = findMaxSubarray_Linear.find_Linear(arr1, 0, arr1.length-1);
		System.out.println("arr1_Linear - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		
		maxSubarray = findMaxSubarray_Square.find_Square(arr2);
		System.out.println("arr2_Square - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		maxSubarray = findMaxSubarray_Linear.find_Linear(arr2, 0, arr2.length-1);
		System.out.println("arr2_Linear - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		
		maxSubarray = findMaxSubarray_Square.find_Square(arr3);
		System.out.println("arr3_Square - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		maxSubarray = findMaxSubarray_Linear.find_Linear(arr3, 0, arr3.length-1);
		System.out.println("arr3_Linear - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		
		maxSubarray = findMaxSubarray_Square.find_Square(arr4);
		System.out.println("arr4_Square - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		maxSubarray = findMaxSubarray_Linear.find_Linear(arr4, 0, arr4.length-1);
		System.out.println("arr4_Linear - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		
		maxSubarray = findMaxSubarray_Square.find_Square(arr5);
		System.out.println("arr5_Square - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		maxSubarray = findMaxSubarray_Linear.find_Linear(arr5, 0, arr5.length-1);
		System.out.println("arr5_Linear - Front : " + maxSubarray.getFront() + ", " + "End : " + maxSubarray.getEnd() + ", " + "Sum : " + maxSubarray.getSum());
		
	
	}
}

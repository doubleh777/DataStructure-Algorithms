package binarysearch;

public class BinarySearch {

	int[] curArray;
	
	public int Searching(int[] arr, int key){
		
		curArray = arr;
		return rightIndexSearching(0,arr.length-1, key)-leftIndexSearching(0, arr.length-1, key) +1;
	}
	
	public int leftIndexSearching(int left,int right, int key){
		
		if(left > right) 
		try {
			throw new notFindKeyException();
		} catch (notFindKeyException e) {
			System.out.println("해당하는 key를 찾을 수 없습니다.");
			System.exit(0);
		}

		int mid = (left+right)/2;
		
		if (curArray[mid] > key) return leftIndexSearching(left, mid-1, key);
		else if (curArray[mid] < key) return leftIndexSearching(mid+1, right, key);
		else{
			if(mid-1 >= 0){		//index가 0보다 작아지는 경우의 예외처리 
				if(curArray[mid-1] == key) return leftIndexSearching(left, mid-1, key);
				else return mid;
			}
			else return 0;
		}
	}
	
	public int rightIndexSearching(int left,int right, int key){
		
		if(left > right) 
			try {
				throw new notFindKeyException();
			} catch (notFindKeyException e) {
				System.out.println("해당하는 key를 찾을 수 없습니다.");
				System.exit(0);
			}

		int mid = (left+right)/2;
		
		if (curArray[mid] > key) return rightIndexSearching(left, mid-1, key);
		else if (curArray[mid] < key) return rightIndexSearching(mid+1, right, key);
		else{
			if(mid+1 <= curArray.length-1){   //index가 배열의 크기를 벗어나는 경우의 예외처리 
				if(curArray[mid+1] == key) return rightIndexSearching(mid+1, right, key);
				else return mid;
			}
			else return curArray.length-1;
		}
	}
}

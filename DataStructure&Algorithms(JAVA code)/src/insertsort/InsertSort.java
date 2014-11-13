package insertsort;

public class InsertSort {
	
	int[] curArray;
	
	public int[] insertSorting(int[] arr){
	
	curArray = arr;
	
	try{
			
			int index;
			int subIndex;
		
			for(index = 1 ; index < curArray.length ; index++){
				int key = curArray[index];
				subIndex = index-1;
			
				while(subIndex >= 0 && curArray[subIndex] > key){
					curArray[subIndex+1] = curArray[subIndex];
					subIndex--;
				}
				curArray[subIndex+1] = key;
			}
		
			return curArray;
			
	}
	
	catch(Exception e){
		System.out.println("arr가 참조하는 인스턴스가 없습니다.");
		return arr;
	}
	
	}
	
}

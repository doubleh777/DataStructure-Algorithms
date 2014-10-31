package searchkey;

public class SearchKeyTest {

	public static void main(String[] args){
		
		SearchKey searchKey = new SearchKey();
		
		int[] arr = {5,2,6,2,8,9,2,1};
		
		System.out.println(searchKey.search(arr, 9));
	}
}

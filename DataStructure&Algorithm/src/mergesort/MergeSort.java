package mergesort;

public class MergeSort {

	int[] array;
	int[] L;
	int[] R;
	
	public MergeSort(int[] array){
		if(array == null) return;
		this.array = array;
		L = new int[array.length+1];
		R = new int[array.length+1];
	}
	
	public void sorting(int p, int r){
		
		if(array == null) return;
		if(p < r){
			int q = p + (r - p) / 2;
			sorting(p,q);
			sorting(q+1,r);
			merge(p,q,r);
		}
		else return;
	}
	
	public void merge(int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		
		for(int i = 0 ; i < n1 ; i++){
			L[i] = array[p+i];
		}
		
		for(int i= 0 ; i < n2 ; i++){
			R[i] = array[q+1+i];
		}
		
		L[n1] = Integer.MAX_VALUE;  //sentinel
		R[n2] = Integer.MAX_VALUE;	//sentinel
		
		int LIndex = 0;
		int RIndex = 0;
		
		for(int i = p ; i < r + 1 ; i++){
			if (L[LIndex] <= R[RIndex]){
				array[i] = L[LIndex];
				LIndex++;
			}
			else {
				array[i] = R[RIndex];
				RIndex++;
			}
		}
		
	}
	
	public boolean isSorted(){
		boolean isSorted = true;
		for(int i = 0 ; i < array.length - 1 ; i++){
			if (array[i] > array[i+1]) isSorted = false;
		}
		
		return isSorted;
	}
		
}	



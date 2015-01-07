public class HeapSort{

	public void heap_Sort(MaxHeap heap){
		build_max_heap(heap);	//max heap 구성
		
		int tmp;
		for(int i = heap.size; i >= 2; i--){
			// root와 맨 마지막 노드를 교체
			tmp = heap.element[1];
			heap.element[1] = heap.element[i];
			heap.element[i] = tmp;
			
			heap.size = heap.size - 1;	//사이즈 줄이고 
			max_heapify(heap, 1);
		}
	}

	public void build_max_heap(MaxHeap heap){	
		for(int i = arr.length / 2; i >= 1; i--){
			max_heapify(heap, i);
		}
	}

	public void max_heapify(MaxHeap heap, int pos){	
		if (heap.element == null && heap.size == 0) {
			return;
		}
		
		int left = pos * 2;
		int right = (pos * 2) + 1;
		int largest;
		
		if(left <= heap.size && heap.element[left] > heap.element[pos]){
			largest = left;
		}
		else largest = pos;
		
		if(right <= heap.size && heap.element[right] > heap.element[largest]){
			largest = right;
		}
		
		if(largest != pos){
			int tmp = heap.element[largest];
			heap.element[largest] = heap.element[pos];
			heap.element[pos] = tmp;
			max_heapify(heap, largest);
		}
	}

	//최댓값 추출 함수
	public int extract_max(MaxHeap heap){
		if(heap.size < 1) return -1;
		
		int tmp;
		tmp = heap.element[1];
		heap.element[1] = heap.element[heap.size];
		heap.element[heap.size] = tmp;
		
		heap.size = heap.size - 1;
		max_heapify(heap, 1);
		
		return heap.element[heap.size + 1];
	}
	
	// 원소의 값 변경 시 삭제 후 추가하지 않고 값을 증가
	public void heap_increase_key(MaxHeap heap, int i, int key){ //i는 변경할 원소의 index, key는 변경할 값
		int tmp;
		
		if(key < heap.element[i])
			System.out.println("New key is smaller than current key.");
		
		heap.element[i] = key; // 값 교체 
		
		while(i > 1 && heap.element[i / 2] < heap.element[i]){
			tmp = heap.element[i];
			heap.element[i] = heap.element[i / 2];
			heap.element[i / 2] = tmp;
			
			i = i / 2;
		}
	}

	// heap에 새로운 원소 추가
	public void max_heap_insert(MaxHeap heap, int key){
		heap.size = heap.size + 1;	//키 값 추가 위해 배열 크기 1 증가 
		heap.element[heap.size] = Integer.MIN_VALUE;	//마지막에 −∞값을 갖는 노드 삽입 
		heap_Increase_Key(heap, heap.size, key);
	}

}

public class Maxheap{
	int element[];
	int size; //노드의 갯수
	int capacity; //배열의 크기 
}
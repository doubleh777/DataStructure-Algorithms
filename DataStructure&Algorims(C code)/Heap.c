#include <stdio.h>

typedef struct heap{  // heap의 배열을 가르키는 포인터 변수와 배열의 크기 정보를 담고있는 구조체 선언
	int size;
	int *element;
}heap_t;


/* isMaxHeap함수
	입력 : heap_t *heap(heap의 정보), int pos(MaxHeap인지를 체크할 최초의 index설정)
	출력 : MaxHeap일 경우 1, 아니라면 0을 출력
	기능 : 입력받은 heap의 pos를 root로 하는 subTree가 MaxHeap인지를 검사하는 기능
*/
int isMaxHeap(heap_t *heap, int pos){
	int left = pos * 2;
	int right = pos * 2 + 1;

	int leftIsMax = 1;  //초기값은 true로 지정(leaf노드의 경우 항상 Max-Heap이기 때문)
	int rightIsMax = 1;

	if (( heap->size >= left && heap->element[pos] < heap->element[left])||  // left child가 있으면서 그 child값이 자신보다 클 경우
						((heap->size >=right && heap->element[pos] < heap->element[right]))){   //right Child가 있으면서 그 child값이 자신보다 클 경우
		return 0; // 위의 두 조건 중 하나라도  만족한다면 MaxHeap이 아니므로 0을 반환
	}

	if (heap->size >= left) // left child가 있다면 left child에 대해서 MaxHeap인지를 재귀적으로 확인
		leftIsMax = isMaxHeap(heap, left);
	if (heap->size >= right) // right child가 있다면 right child에 대해서 MaxHeap인지를 재귀적으로 확인
		rightIsMax = isMaxHeap(heap, right);

	if (leftIsMax && rightIsMax) return 1; //위에서 pos와 left,right간의 관계는 이미 체크하였으므로
	else return 0;						   //Left와 Right가 모두 MaxHeap이라면 MaxHeap, 그렇지 않으면 MaxHeap이 아님. 

}

/* max_heapify함수
	입력 : heap_t *heap(heap의 정보), int pos(hepify를 진행할 pos)
	출력 : 없음.
	기능 : 입력받은 heap의 pos를 기준으로 left SubTree와 right SubTree가 모두 MaxHeap이라 가정할때, pos를 더하여 MaxHeap을 구성해주는 역할.
*/
void max_heapify(heap_t *heap, int pos){

	int left = pos * 2;
	int right = pos * 2 + 1;
	int largest;
	int tmp;

	if (left <= heap->size && heap->element[pos] <= heap->element[left])
		largest = left;
	else largest = pos;

	if (right <= heap->size && heap->element[largest] <= heap->element[right])
		largest = right;

	if (largest != pos){
		tmp = heap->element[largest];
		heap->element[largest] = heap->element[pos];
		heap->element[pos] = tmp;

		max_heapify(heap, largest); 
	}

}
/* printHeap함수
	입력 : heap_t *heap(heap의 정보), int size(heap배열의 크기)
	출력 : 없음
	기능 : printf함수를 통해 입력받은 heap의 배열 정보를 출력하는 기능
*/
void printHeap(heap_t *heap, int size){

	for (int i = 1; i <= size; i++){
		printf("%d\n",heap->element[i]);
	}
	printf("\n");
}

/* makeSampleHeap함수
	Build_Max_Heap함수 구현시 랜덤한 sample 배열을 만드는 함수를 구현할 예정.
*/


int main(){
	heap_t heap;

	heap.element = (int)malloc(sizeof(int)* 11);

	//테스트를 위해 첫번째 노드를 제외한 나머지 노드는 MaxHeap상태인 배열을 입력
	heap.element[1] = 4;
	heap.element[2] = 11;
	heap.element[3] = 7;
	heap.element[4] = 10;
	heap.element[5] = 3;
	heap.element[6] = 1;
	heap.element[7] = 5;
	heap.element[8] = 6;
	heap.element[9] = 9;
	heap.element[10] = 2;

	heap.size = 10;
	
	//heapify를 하기 전
	printHeap(&heap, heap.size);
	if(isMaxHeap(&heap, 1)) printf("It is Max-Heap\n");
	else printf("It is not Max-Heap\n");

	//heapify를 한 후
	max_heapify(&heap, 1);
	printHeap(&heap, heap.size);
	if (isMaxHeap(&heap, 1)) printf("It is Max-Heap\n");
	else printf("It is not Max-Heap\n");
	
	free(heap.element);
	
}
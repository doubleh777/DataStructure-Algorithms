#include <stdio.h>

typedef struct heap{  // heap�� �迭�� ����Ű�� ������ ������ �迭�� ũ�� ������ ����ִ� ����ü ����
	int size;
	int *element;
}heap_t;


/* isMaxHeap�Լ�
	�Է� : heap_t *heap(heap�� ����), int pos(MaxHeap������ üũ�� ������ index����)
	��� : MaxHeap�� ��� 1, �ƴ϶�� 0�� ���
	��� : �Է¹��� heap�� pos�� root�� �ϴ� subTree�� MaxHeap������ �˻��ϴ� ���
*/
int isMaxHeap(heap_t *heap, int pos){
	int left = pos * 2;
	int right = pos * 2 + 1;

	int leftIsMax = 1;  //�ʱⰪ�� true�� ����(leaf����� ��� �׻� Max-Heap�̱� ����)
	int rightIsMax = 1;

	if (( heap->size >= left && heap->element[pos] < heap->element[left])||  // left child�� �����鼭 �� child���� �ڽź��� Ŭ ���
						((heap->size >=right && heap->element[pos] < heap->element[right]))){   //right Child�� �����鼭 �� child���� �ڽź��� Ŭ ���
		return 0; // ���� �� ���� �� �ϳ���  �����Ѵٸ� MaxHeap�� �ƴϹǷ� 0�� ��ȯ
	}

	if (heap->size >= left) // left child�� �ִٸ� left child�� ���ؼ� MaxHeap������ ��������� Ȯ��
		leftIsMax = isMaxHeap(heap, left);
	if (heap->size >= right) // right child�� �ִٸ� right child�� ���ؼ� MaxHeap������ ��������� Ȯ��
		rightIsMax = isMaxHeap(heap, right);

	if (leftIsMax && rightIsMax) return 1; //������ pos�� left,right���� ����� �̹� üũ�Ͽ����Ƿ�
	else return 0;						   //Left�� Right�� ��� MaxHeap�̶�� MaxHeap, �׷��� ������ MaxHeap�� �ƴ�. 

}

/* max_heapify�Լ�
	�Է� : heap_t *heap(heap�� ����), int pos(hepify�� ������ pos)
	��� : ����.
	��� : �Է¹��� heap�� pos�� �������� left SubTree�� right SubTree�� ��� MaxHeap�̶� �����Ҷ�, pos�� ���Ͽ� MaxHeap�� �������ִ� ����.
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
/* printHeap�Լ�
	�Է� : heap_t *heap(heap�� ����), int size(heap�迭�� ũ��)
	��� : ����
	��� : printf�Լ��� ���� �Է¹��� heap�� �迭 ������ ����ϴ� ���
*/
void printHeap(heap_t *heap, int size){

	for (int i = 1; i <= size; i++){
		printf("%d\n",heap->element[i]);
	}
	printf("\n");
}

/* makeSampleHeap�Լ�
	Build_Max_Heap�Լ� ������ ������ sample �迭�� ����� �Լ��� ������ ����.
*/


int main(){
	heap_t heap;

	heap.element = (int)malloc(sizeof(int)* 11);

	//�׽�Ʈ�� ���� ù��° ��带 ������ ������ ���� MaxHeap������ �迭�� �Է�
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
	
	//heapify�� �ϱ� ��
	printHeap(&heap, heap.size);
	if(isMaxHeap(&heap, 1)) printf("It is Max-Heap\n");
	else printf("It is not Max-Heap\n");

	//heapify�� �� ��
	max_heapify(&heap, 1);
	printHeap(&heap, heap.size);
	if (isMaxHeap(&heap, 1)) printf("It is Max-Heap\n");
	else printf("It is not Max-Heap\n");
	
	free(heap.element);
	
}
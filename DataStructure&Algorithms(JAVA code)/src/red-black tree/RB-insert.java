public class RB-insert{

	Rotate rotate = new Rotate();

	public void insert(tree_t T, node_t newNode){
		node_t parantNode = T.nil;  //sentinel 초기화
		node_t curNode = T.root;

		//nil이 나올때 까지(insert될 자리를 찾을 때 까지)반복문 수행
		while(curNode != T.nil){
			parantNode = curNode;
			if (newNode.key < curNode.key)
				curNode = curNode.left;
			else curNode = curNode.right;
		}

		//curNode가 nil이 되어 빠져 나온 이후 그 자리에 newNode를 넣어주는 과정
		newNode.parant = parantNode;

		//T의 root가 nil이었을 경우 newNode가 T의 root가 됨
		if(parantNode == T.nil)
			T.root = newNode;

		//parantNode의 key와 비교하여
		//parantNode의 left에 넣을 것인지 right에 넣을 것인지 결정
		else if(newNode.key >= parant.key)
			parantNode.right = newNode;
		else parantNode.left = newNode;

		//newNode 초기화
		newNode.left = T.nil;
		newNode.right = T.nil;
		newNode.color = "R";

		//newNode의 violation처리
		fixUp(T, newNode);

	}

	public void fixUp(tree_t T, node_t fixUpNode){
		//parant의 color가 Red인 경우(violation인 경우) 계속해서 반복수행
		while(fixUpNode.parant.color == "R"){
			//fixUpNode의 parant가 leftChild일 경우
			if(fixUpNode.parant == fixUpNode.parant.parant.left){
				node_t uncleNode = fixUpNode.parant.parnnt.right;

				//fixUpNode의 parant도 Red, uncle도 Red인 경우
				if(uncleNode.color == "R"){
					fixUpNode.parant.color = "B";
					uncleNode.color = "B";
					fixUpNode.parant.parnat.color = "R";
					fixUpNode = fixUpNode.parant.parnat;  //fixUpNode갱신
				}
				//fixUpNode의 parant는 Red, uncle은 Black일 경우
				else{
					//fixUpNode가 parant의 rightChild일 경우
					// -> fixUpNode가 parant의 leftChild일 경우로 변형
					if(fixUpNode == fixUpNode.parant.right){
						fixUpNode = fixUpNode.parant;
						rotate.leftRotate(T, fixUpNode);
					}

					//fixUpNode가 parant의 leftChild일 경우의 fixUp
					fixUpNode.parant.color = "B";
					fixUpNode.parant.parant.color = "R";
					rotate.rightRotate(T, fixUpNode.parant.parant);
				}
			}
			//fixUpNode의 parant가 rightChild일 경우(위의 코드와 대칭적임)
			else{
				node_t uncleNode = fixUpnode.parant.parant.left;

				//fixUpNode의 parant도 Red, uncle도 Red인 경우
				if(uncleNode.color == "R"){
					fixUpNode.parant.color = "B";
					uncleNode.color = "B";
					fixUpNode.parant.parnat.color = "R";
					fixUpNode = fixUpNode.parant.parant;
				}
				//fixUpNode의 parant는 Red, uncle은 Black일 경우
				else{
					//fixUpNode가 parant의 leftChild일 경우
					//-> fixUpNode가 parant의 rightChil일 경우로 변형
					if(fixUpNode == fixUpNode.parant.left){
						fixUpNode = fixUpNode.parant;
						rotate.rightRotate(T, fixUpNode);
					}

					//fixUpNode가 parant의 rightChild일 경우의 fixUp
					fixUpNode.parant.color = "B";
					fixUpNode.parant.parant.color = "R";
					rotate.leftRotate(T, fixUpnode.parant.parant);
				}
			}
		}
		//root의 color를 B으로 바꿔주기
		//(fixUpNode의 parant와 uncle이 모두 red이면서 grandParant가 root인 경우 적용)
		T.root.color = "B";
	}
}
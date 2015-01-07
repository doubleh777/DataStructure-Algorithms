public class RB-delete{
	
	Rotate rotate = new Rotate();

	public void delete(tree_t T, node_t deleteNode){
		//erasedColor, fixUpNode 초기화
		String erasedColor = deleteNode.color;
		node_t fixUpNode = T.nil;

		//leftChild가 없는 경우 -> rightChild가 successor
		//만약 rightChild가 nil이면 dgree가 0인 경우이므로 그냥 제거하면됨
		if(deleteNode.left == T.nil){
			fixUpNode = node.right;
			transplant(T, deleteNode, node.right);
		}
		//leftChild는 있고 rightChild는 없는 경우 -> leftChild가 successor
		else if(deleteNode.right == T.nil){
			fixUpNode = node.left;
			transplant(T, deleteNode, node.left);
		}
		//leftChild와 rightChild가 모두 있는 경우
		else{
			//successor찾기
			node_t successor = searchMinimum(deleteNode.right);
			//successor를 제거하게 될 것이므로 erasedColor를 successor의 color로 갱신
			erasedColor = successor.color;
			//successor의 right를 fixUpNode로 설정해줌(successor는 leftChild가 없음)
			fixUpNode = successor.right;
			//successor가 deleteNode의 rightChild인 경우
			//  -> rightChild가 nil인 경우 nil의 parant를 successor로 지정해줌 ????
			if(successor.parant == deleteNode)
				fixUpNode.parant = successor;
			//successor를 떼어내고 deleteNode자리에 들어갈 준비하기
			else{
				transplant(T, successor, successor.right);
				successor.right = deleteNode.right;
				successor.right.parant = successor;
			}
			//deleteNode자리에 successor 집어넣기
			transplant(T, deleteNode, successor);
			successor.left = deleteNode.left;
			successor.left.parant = successor;
			successor.color = deleteNode.color;
		}

		if(erasedColor == "B")
			fixUp(T, fixUpNode);
	}

	public node_t searchMinmum(node_t node){
		// node가 nil인 경오는 미리 체크하고 들어오므로 고려하지 않아도 됨.
		node_t curNode = node.left;
		while(curNode != T.nil){
			curNode = curNode.left;
		}
		return curNode.parant;
	}

	public void fixUp(tree_t T, node_t fixUpNode){
		//fixUp을 해줘야 해줘야하는 경우 -> fixUpNode가 root가 아니고 fixUpNode가 Black일 경우
		//Red일 경우는 그냥 색깔만 Black으로 바꿔주면 됨(이에 해당하는 처리는 메소드 가장 아래에 있음)
		while(fixUpNode != T.root && fixUpNode.color = "B"){
			//fixUpNode가 leftChild일 경우
			if(fixUpNode == fixUpNode.parant.left){
				node_t sibling = fixUpNode.parant.right;
				//sibling의 color가 Red인 경우 -> 이 경우, fixUpNode.parant는 무조건 Black임
				if(sibling.color == "R"){
					sibling.color = "B";
					fixUpNode.parant.color = "R";
					rotate.leftRotate(T, fixUpNode.parant);
					//sibling을 갱신
					sibling = fixUpNode.parant.right;
				}

				//여기서 sibling의 color는 Black
				if(sibling.left.color == "B" && sibling.right.color == "B"){
					sibling.color = "R";
					fixUpNode = fixUpNode.parant;
				}
				else{
					if(sibling.right.color == "B"){
						sibling.left.color = "B";
						sibling.color = "R";
						rotate.rightRotate(T, sibling);
						//sibling을 갱신
						sibling = fixUpNode.parant.right;
					}
					sibling.color = fixUpNode.parant.color;
					fixUpNode.parant.color = "B";
					sibling.right.color = "B";
					rotate.leftRotate(T, fixUpNode.parant);

					//반복문 종료
					fixUpNode = T.root;
				}
			}
			//위 코드와 대칭적
			else{
				node_t sibling = fixUpNode.parant.left;
				//case5 -> case1,2,3중 하나로 변형
				if(sibling.color == "R"){
					sibling.color = "B";
					fixUpNode.parant.color = "R"
					rotate.rightRotate(T, fixUpNode.parant);
					sibling = fixUpNode.parant.left;
				}
				//case1 처리
				if(sibling.right.color == "B" && sibling.left.color == "B"){
					sibling.color = "R";
					fixUpNode = fixUpNode.parant;
				}
				else{
					//case3 -> case2로 변형
					if(sibling.left.color == "B"){
						sibling.right.color = "R";
						sibling.color = "R";
						rotate.leftRotate(T, sibling);
						sibling = fixUpNode.parnat.left;
					}
					sibling.color = fixUpNode.parant.color;
					fixUpNode.parant.color = "B";
					sibling.left.color = "B";
					rotate.rightRotate(T, fixUpNode.parant);
					fixUpNode = T.root;
				}
			}
		}
		fixUpNode.color = "B";
	}

	public void transplant(tree_t T, node_t oldNode, node_t plantNode){
		//oldNode.parant가 nil일 경우는 oldNode가 root인 것이므로 T.root에 plantNode를 넣어줌
		if(oldNode.parant == nil)
			T.root = plantNode;
		//oldNode가 leftChild였을 경우
		else if(oldNode == oldNode.parant.left)
			oldNode.parant.left = plantNode;
		//oldNode가 rightChild였을 경우
		else oldNode.parant.right = plantNode;
		//plantNode의 parant설정
		plantNode.parant = oldNode.parant;
	}
}
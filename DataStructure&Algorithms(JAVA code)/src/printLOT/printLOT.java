int printLOT(Node root){
	if(root == null) return -1;

	Queue<Node> queue = new LinkedList<Node>();
	queue.offer(root);

	while(!queue.isEmpty()){
		Node tmp = queue.poll();
		System.out.println(tmp.value);

		if(tmp.left != null)
			queue.offer(tmp.left);
		if(tmp.right != null)
			queue.offer(tmp.right);
	}

	return 0;
}
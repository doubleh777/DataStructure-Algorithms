public class Rotate{

	public void leftRotate(tree_t T, node_t x){
		node_t y = x.right;
		x.right = y.left;

		if(y.left != T.nil)
			y.left.p = x;

		y.p = x.p

		if(x.p == T.nil)
			T.root = y;
		else if(x == x.p.left)
			x.p.left = y;
		else x.p.right = y;

		y.left = x;
		x.p = y;
	}

	public void rightRotate(tree_t T, node_t y){
		node_t x = y.left;
		y.left = x.right;

		if(x.right != T.nil)
			x.right.p = y;

		x.p = y.p

		if(y.p == T.nil)
			T.root = x;
		else if(y == y.p.right)
			y.p.right = x;
		else y.p.left = x;

		x.right = y;
		y.p = x;
	}
}
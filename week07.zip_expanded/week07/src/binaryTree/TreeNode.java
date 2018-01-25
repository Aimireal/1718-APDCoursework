package binaryTree;

public class TreeNode<T extends Comparable<? super T>> {
	T value;
	BTree<T> left, right;
	
	public TreeNode(T value) {
		this.value = value;
		//left = new BinaryTree<T>();
		//right = new BinaryTree<T>();
	}
	
	public T value() {
		return value;
	}
	
	public BTree<T> left() {
		return left;
	}
	
	public BTree<T> right() {
		return right;
	}

}

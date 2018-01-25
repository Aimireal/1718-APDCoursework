package binaryTree;

public interface BTree<T extends Comparable<? super T>> {
	public void insert(T value);
	
	public T value();
	
	public BTree<T> left();
	
	public BTree<T> right();

}

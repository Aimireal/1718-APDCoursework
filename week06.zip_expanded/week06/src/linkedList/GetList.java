package linkedList;

public class GetList<T> implements List<T> {
	
	private Node<T> head = null; // the head of the list
	
	private int noOfNodes = 0; // the number of nodes currently in the list
	
    /**
     * Get a value from the list (do not remove it)
     * @param index the index of the value requested
     * @return the value found at the specified index
     * @throws ListAccessError if the specified index is not a valid index for the list
     */
    public T get(int index) throws ListAccessError {
    	return getNode(index).getValue();
    }

    /**
     * Helper method which accesses the node at the specified value
     * @param index the index of the node to be accessed
     * @return the node at the specified index
     * @throws ListAccessError if the specified index is not a valid index for the list
     */
    private Node<T> getNode(int index) throws ListAccessError {
    	if (index < 0 || index >= noOfNodes) { // invalid index
    		throw new ListAccessError("Index out of bounds");
    	}
    	Node<T> node = head; // start at head of list
    	for (int i = 0; i < index; i++) { // walk through list to desired index
    		node = node.getNext(); // by following next references
    	}
    	return node; // return the node at the required index
    }

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, T value) throws ListAccessError {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) throws ListAccessError {
		// TODO Auto-generated method stub
		return null;
	}
}
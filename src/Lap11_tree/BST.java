package Lap11_tree;

import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			root = new BNode<E>(e);
		} else {
			root.add(e);
		}
	}

	public void print() {
		printRecursive(root);
	}

	private void printRecursive(BNode<E> current) {
		if (current != null) {
			printRecursive(current.getLeft());
			System.out.print(current.getData() + " ");
			printRecursive(current.getRight());
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		col.forEach(this::add);
	}

	// compute the depth of a node in BST
	public int depth(E node) {

		if (root == null) {
			return -1;
		} else {
			return root.depth(node);
		}
	}

	// compute the height of BST
	public int height() {
		if (root == null) {
			return -1;
		} else {
			return root.height();
		}
	}

	// Compute total nodes in BST
	public int size() {

		if (root == null) {
			return -1;
		} else {
			return root.size();
		}
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		if (root == null) {
			return false;
		}
		return this.root.contains(e);
	}

//	
	// Find the minimum element in BST
	public E findMin() {
		if (root == null) {
			return null;
		} else {
			return root.findMin();
		}
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null) {
			return null;
		} else {
			return root.findMax();
		}
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		} else {
			return root.remove(e);
		}
	}

	public BNode<E> findMinLeftRecursive(BNode<E> current) {
		if (current.getLeft() == null) {
			return current;
		}
		return findMinLeftRecursive(current.getLeft());
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		if (root == null) {
			return null;
		}
		return root.descendants(data);
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		if (root == null) {
			return null;
		}
		return root.ancestors(data);
	}

	public void inorder() {
		if (root == null) {
			return;
		} else {
			root.inorder();
		}
	}

	public void preoder() {
		if (root == null) {
			return;
		} else {
			root.preorder();
		}
	}

	public void postoder() {
		if (root == null) {
			return;
		} else {
			root.postorder();
		}
	}

}

package Lap11_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	//
	public void add(E e) {
		if (e.compareTo(this.data) > 0) {
			if (right == null) {
				right = new BNode<E>(e);
			} else {
				right.add(e);
			}
		} else if (e.compareTo(this.data) < 0) {
			if (left == null) {
				left = new BNode<E>(e);
			} else {
				left.add(e);
			}
		}

	}

	//
	public int size() {
		int size =1;
		if(left != null) {
			size += left.size();
		}if(right != null) {
			size += right.size();
		}
		return size;
	}

	//
	public int depth(E e) {

		int comp = e.compareTo(data);
		if (comp == 0) {
			return 0;
		} else if (comp > 0 && right != null) {
			return right.depth(e) + 1;
		} else if (comp < 0 && left != null) {
			return left.depth(e) + 1;
		} else {
			return -1;
		}
	}

	//
	public boolean contains(E e) {
		int comp = e.compareTo(data);
		if (comp == 0) {
			return true;
		} else if (comp > 0) {
			return ((right == null) ? false : right.contains(e));
		} else {
			return ((left == null) ? false : left.contains(e));
		}
	}

	//
	public int height() {

		int maxLeft = (left != null) ? left.height() + 1 : 0;
		int maxRight = (right != null) ? right.height() + 1 : 0;

		return Math.max(maxRight, maxLeft);

	}

	//
	public E findMin() {
		if (left == null) {
			return data;
		} else {
			return left.findMin();
		}
	}

	//
	public E findMax() {
		if (right == null) {
			return data;
		} else
			return right.findMax();
	}

	//
	public boolean remove(E e) {
	    if (e == null) {
	        return false;
	    }
	    int comp = e.compareTo(data);
	    if (comp == 0) {
	        if (left == null && right == null) {
	            return true;
	        } else if (left != null && right != null) {
	            this.data = right.getMinValue();
	            return right.remove(this.data);
	        } else {
	            BNode<E> child = (left != null) ? left : right;
	            this.data = child.data;
	            this.left = child.left;
	            this.right = child.right;
	            return true;
	        }
	    } else if (comp < 0 && left != null) {
	        return left.remove(e);
	    } else if (comp > 0 && right != null) {
	        return right.remove(e);
	    }

	    return false;
	}

	private E getMinValue() {
	    BNode<E> current = this;
	    while (current.left != null) {
	        current = current.left;
	    }
	    return current.data;
	}

	//
	public List<E> descendants(E e) {
		List<E> re = new ArrayList<>();
		int comp = e.compareTo(data);

		if (comp == 0) {
			if (right != null) {
				re.addAll(right.collectDescendants());
			}
			if (left != null) {
				re.addAll(left.collectDescendants());
			}
			re.add(data);
		} else if (comp > 0 && right != null) {
			return right.descendants(e);
		} else if (comp < 0 && left != null) {
			return left.descendants(e);
		}

		return re;
	}

	private List<E> collectDescendants() {
		List<E> descendantsList = new ArrayList<>();
		descendantsList.add(data);

		if (left != null) {
			descendantsList.addAll(left.collectDescendants());
		}

		if (right != null) {
			descendantsList.addAll(right.collectDescendants());
		}

		return descendantsList;
	}

	//
	public List<E> ancestors(E e) {
		int comp = e.compareTo(data);
		List<E> re = new ArrayList<>();
		if (comp == 0) {
			return re;
		}
		if (left != null) {
			if (left.contains(e)) {
				re.addAll(left.ancestors(e));
				re.add(data);
			}
		}
		if (right != null) {
			if (right.contains(e)) {
				re.addAll(right.ancestors(e));
				re.add(data);
			}
		}
		return re;
	}

	public void inorder() {
		// TODO Auto-generated method stub
		if (left != null)
			left.inorder();
		System.out.print(data + " ");
		if (right != null)
			right.inorder();
	}

	public void preorder() {
		// TODO Auto-generated method stub
		System.out.print(data + " ");
		if (left != null)
			left.preorder();
		if (right != null)
			right.preorder();
	}

	public void postorder() {
		// TODO Auto-generated method stub
		if (left != null)
			left.postorder();
		if (right != null)
			right.postorder();
		System.out.print(data + " ");
		
		Set<Integer> m = new TreeSet<>();
	}


}



import java.util.ArrayList;

public class BinaryNode<T extends Number & Comparable<T>>{
	T data;
	BinaryNode<T> left;
	BinaryNode<T> right;
	
	public BinaryNode(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public boolean contains(BinaryNode<T> root, T value){
		if(root == null){
			System.out.println("Tree is empty");
			return false;
		}
		if(root.data == value){
			return true;
		}
		if(root.data.compareTo(value) > 0){
			return contains(root.left, value);
		}
		else{
			return contains(root.right, value);
		}
	}
	
	public void insert(BinaryNode<T> root, T value){
		if(root == null){
			root = new BinaryNode<T>(value);
		}
		else{
			if(root.data.compareTo(value) < 0){
				if(root.right == null){
					root.right = new BinaryNode<T>(value);
				}
				else{
					insert(root.right, value);
				}
			}
			else{
				if(root.left == null){
					root.left = new BinaryNode<T>(value);
				}
				else{
					insert(root.left, value);
				}
			}
		}
	}
	
	public BinaryNode<T> getMin(BinaryNode<T> root){
		if(root == null){
			System.out.println("Tree is empty");
		}
		else if(root.left == null){
			return root;
		}
		
		return getMin(root.left);
	}
	public BinaryNode<T> getMax(BinaryNode<T> root){
		if(root == null){
			System.out.println("Tree is empty");
		}
		else if(root.right == null){
			return root;
		}
		
		return getMax(root.right);
	}
	
	public void remove(BinaryNode<T> root, T value, BinaryNode<T> parent){
		if(root == null){
			System.out.println("Tree is empty");
		}
		else if(root.data.compareTo(value) > 0){
			remove(root.left, value, root);
		}
		else if (root.data.compareTo(value) < 0){
			remove(root.right, value, root);
		}
		else{
			if(!(root.right == null)){
				BinaryNode<T> parentRoot = root.right;
				BinaryNode<T> removeRoot = root.right;
				
				if(root.right.left == null){
					root.data = root.right.data;
					root.right = root.right.right;
					parentRoot = null;
				}
				else{
					while(!(removeRoot.left == null)){
						parentRoot = removeRoot;
						removeRoot = removeRoot.left;
					}
					root.data = removeRoot.data;
					parentRoot.left = removeRoot.right;
					removeRoot = null;
				}
			}
			else if(!(root.left == null)){
				parent.right = root.left;
				root = null;
			}
			else{
				if(parent.left == root){
					parent.left = null;
					root = null;
				}
				else{
					parent.right = null;
					root = null;
				}
			}
		}
	}
	
	public T closest(BinaryNode<T> root, T target){
		if(root == null){
			System.out.println("Tree is empty");
		}
		
		BinaryNode<T> node = root;
		BinaryNode<T> best = node;
		float distance = Math.abs(root.data.floatValue() - target.floatValue());
		
		while(!(node == null)){
			if(Math.abs(node.data.floatValue() - target.floatValue()) < distance){
				best = node;
				distance = Math.abs(node.data.floatValue() - target.floatValue());
			}
			if(node.data.compareTo(target) > 0){
				node = node.left;
			}
			else if(node.data.compareTo(target) < 0){
				node = node.right;
			}
			else{
				System.out.println("The closest value to " + target + " is " + target);
				return target;
			}
		}
		System.out.println("The closest value to " + target + " is " + best.data);
		return best.data;
	}
	public void preOrder(BinaryNode<T> root){
		if(!(root == null)){
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public void inOrder(BinaryNode<T> root){
		if(!(root == null)){
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	public void postOrder(BinaryNode<T> root){
		if(!(root == null)){
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}
	public void breadthFirst(BinaryNode<T> root){
		if(root == null){
			System.out.println("Tree is empty");
		}
		
		ArrayList<BinaryNode<T>> al = new ArrayList<BinaryNode<T>>();
		al.add(root);
		
		for(int i =0; i<al.size(); i++){
			System.out.println(al.get(i).data);
			
			if(!(al.get(i).left == null)){
				al.add(al.get(i).left);
			}
			if(!(al.get(i).right == null)){
				al.add(al.get(i).right);	
			}
		}	
	}
}

//class TreeEmptyException extends Exception{
// 
//	public TreeEmptyException(){}
//	
//	public TreeEmptyException(String message){
//		super(message);
//	}
//}


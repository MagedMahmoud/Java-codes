import java.security.SecureRandom;

public class treeTest {

	private static final SecureRandom sRandom = new SecureRandom();
	static BinaryNode<Double> trunk = new BinaryNode<Double>(50.0);
	
	public static void main(String[] args){
		populate(20);
		
		test();
	
	}
	
	public static void test(){
		if(trunk.contains(trunk, 22.00)){
			System.out.println("Tree contains 22");
		}
		
		System.out.print("Lowest value in tree is ");
		System.out.println(trunk.getMin(trunk).data);
		
		System.out.println("Highest value in tree is ");
		System.out.print(trunk.getMax(trunk).data);
		
		System.out.println("");
		
		System.out.println("Removing highest and lowest values from tree");
		
		System.out.println("");
		
		trunk.remove(trunk, trunk.getMin(trunk).data, trunk);
		trunk.remove(trunk, trunk.getMax(trunk).data, trunk);
		
		System.out.println("New highest and lowest:");
		
		System.out.print("Lowest value in tree is ");
		System.out.println(trunk.getMin(trunk).data);
		
		System.out.print("Highest value in tree is ");
		System.out.println(trunk.getMax(trunk).data);

		System.out.println("");
		
		System.out.println(trunk.closest(trunk, 42.00));
	
		System.out.println("");
		
		System.out.println("Printing the tree");
		
		System.out.println("");
		System.out.println("pre-order");
		
		trunk.preOrder(trunk);
		
		System.out.println("");
		System.out.println("in-order");
		
		trunk.inOrder(trunk);
		
		System.out.println("");
		System.out.println("post-order");
		
		trunk.postOrder(trunk);
		
		System.out.println("");
		System.out.println("level-order");
		
		trunk.breadthFirst(trunk);
		
	}
	
	public static void populate(int num){
		for(int i = 0; i < num; i++){
			trunk.insert(trunk, (sRandom.nextDouble() * 100));
		}
	}
	
	
	
}

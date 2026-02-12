import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AVLMethodsTest {
    @Before
    public void setUp() {
        // Setup code here (if required)
    }

    @After
    public void tearDown() {
        // Teardown code here (if required)
    }

    //Build AVL Tree
    public static AVLMethods buildTree(int[] list)
	{
		AVLMethods tree = new AVLMethods();
		
		for(int i=0; i<list.length; i++)
		{
			tree.add(new BinaryNode(list[i]));
		}
		
		return tree;
	}
    
    //find Binary Node
    public static BinaryNode find(BinaryNode x, int value)
	{
		if(x==null) return null;
		if(x.getValue().equals(value))
			return x;
		else if(x.getValue().compareTo(value)<0)
			return find(x.right(), value);
		else
			return find(x.left(),value);		
	}
    
    @Test (timeout=250)
    public void testHeight() throws Exception {
        	try 
        	{
        		int[] list = {40, 27, 9, 2, 57, 56, 49, 73, 23, 7, 6};
        		int[] height = {5, 4, 3, 2, 2, 1, 0, 0, 0, 1, 0};
        		AVLMethods tree = buildTree(list);
        		for(int i=0; i < list.length; i++)
        		{
        			BinaryNode target = find(tree.getRoot(),list[i]);
        			assertEquals("testing height", height[i], tree.getHeight(target));
        		}
        		assertEquals("testing null", -1, tree.getHeight(null));
        	} 
        	catch(Exception e)
        	{
        		e.setStackTrace(new StackTraceElement[] {});
        		throw e;
        	}
            //assertEquals("forgotSpaces(\"" + tests[i] + "\") incorrect", exp[i], _CLASS_._METHOD_(tests[i]));
        }
    
    @Test (timeout=250)
    public void testBalanceFactorNeg2() throws Exception {
        	try 
        	{
        		int[] list = {10, 50, 49, 26, 87, 79, 77, 74};
        		AVLMethods tree = buildTree(list);
        		BinaryNode target = find(tree.getRoot(),50);
        		assertEquals("testing Balance Factor -2", -2, tree.balanceFactor(target));
        	} 
        	catch(Exception e)
        	{
        		e.setStackTrace(new StackTraceElement[] {});
        		throw e;
        	}
            //assertEquals("forgotSpaces(\"" + tests[i] + "\") incorrect", exp[i], _CLASS_._METHOD_(tests[i]));
        }
    
    @Test (timeout=250)
    public void testBalanceFactorNeg1() throws Exception {
        	try 
        	{
        		int[] list = {40, 27, 9, 2, 57, 56, 49, 73, 23, 7, 6, 67, 14, 22, 36, 97, 89, 28, 42, 99};
        		AVLMethods tree = buildTree(list);
        		BinaryNode target = find(tree.getRoot(),73);
        		assertEquals("testing Balance Factor -1", -1, tree.balanceFactor(target));
        	} 
        	catch(Exception e)
        	{
        		e.setStackTrace(new StackTraceElement[] {});
        		throw e;
        	}
            //assertEquals("forgotSpaces(\"" + tests[i] + "\") incorrect", exp[i], _CLASS_._METHOD_(tests[i]));
        }
    
    @Test (timeout=250)
    public void testBalanceFactorZero() throws Exception {
        	try 
        	{
        		int[] list = {40, 27, 9, 2, 57, 56, 49, 73, 23, 7, 6, 67, 14, 22, 36, 97, 89, 28, 42, 99};
        		AVLMethods tree = buildTree(list);
        		BinaryNode target = find(tree.getRoot(),57);
        		assertEquals("testing Balance Factor 0", 0, tree.balanceFactor(target));
        	} 
        	catch(Exception e)
        	{
        		e.setStackTrace(new StackTraceElement[] {});
        		throw e;
        	}
            //assertEquals("forgotSpaces(\"" + tests[i] + "\") incorrect", exp[i], _CLASS_._METHOD_(tests[i]));
        }
    
    @Test (timeout=250)
    public void testBalanceFactor1() throws Exception {
        	try 
        	{
        		int[] list = {40, 27, 9, 2, 57, 56, 49, 73, 23, 7};
        		AVLMethods tree = buildTree(list);
        		BinaryNode target = find(tree.getRoot(),9);
        		assertEquals("testing Balance Factor 1", 1, tree.balanceFactor(target));
        	} 
        	catch(Exception e)
        	{
        		e.setStackTrace(new StackTraceElement[] {});
        		throw e;
        	}
            //assertEquals("forgotSpaces(\"" + tests[i] + "\") incorrect", exp[i], _CLASS_._METHOD_(tests[i]));
        }
    
    @Test (timeout=250)
    public void testBalanceFactor2() throws Exception {
        	try 
        	{
        		int[] list = {40, 27, 9, 2, 57, 56, 49, 73, 23, 7, 6, 67, 14, 22, 36, 97, 89, 28, 42, 99};
        		AVLMethods tree = buildTree(list);
        		BinaryNode target = find(tree.getRoot(),27);
        		assertEquals("testing Balance Factor 2", 2, tree.balanceFactor(target));
        	} 
        	catch(Exception e)
        	{
        		e.setStackTrace(new StackTraceElement[] {});
        		throw e;
        	}
            //assertEquals("forgotSpaces(\"" + tests[i] + "\") incorrect", exp[i], _CLASS_._METHOD_(tests[i]));
        }
    
    //Test LL
    @Test (timeout=250)
    public void testLL() throws Exception {
        	try 
        	{
        		int[] list = {40, 27, 9, 2, 57, 56, 49, 73, 23, 7, 6, 67, 14, 22, 36, 97, 89, 28, 42, 99};
        		AVLMethods tree = buildTree(list);
        		BinaryNode target = find(tree.getRoot(),27);
        		target.setRight(tree.leftLeftRotation(target.right()));
        		
        		assertEquals("testing LL Rotation","[40, 27, 57, 9, 28, 56, 73, 2, 23, 36, 49, 67, 97, 7, 14, 42, 89, 99, 6, 22]",tree.levelOrder());
        	} 
        	catch(Exception e)
        	{
        		e.setStackTrace(new StackTraceElement[] {});
        		throw e;
        	}
            //assertEquals("forgotSpaces(\"" + tests[i] + "\") incorrect", exp[i], _CLASS_._METHOD_(tests[i]));
        }
    
    //Test LR
    @Test (timeout=250)
    public void testLR() throws Exception {
        	try 
        	{
        		int[] list = {40, 27, 9, 2, 57, 56, 49, 73, 23, 7, 6, 67, 14, 22, 36, 97, 89, 28, 42, 99};
        		AVLMethods tree = buildTree(list);
        		BinaryNode target = find(tree.getRoot(),40);
        		target.setLeft(tree.leftRightRotation(target.left()));
        		
        		assertEquals("testing LR Rotation","[40, 23, 57, 9, 27, 56, 73, 2, 14, 36, 49, 67, 97, 7, 22, 28, 42, 89, 99, 6]",tree.levelOrder());
        	} 
        	catch(Exception e)
        	{
        		e.setStackTrace(new StackTraceElement[] {});
        		throw e;
        	}
            //assertEquals("forgotSpaces(\"" + tests[i] + "\") incorrect", exp[i], _CLASS_._METHOD_(tests[i]));
        }
    
    //Test RR
    @Test (timeout=250)
    public void testRR() throws Exception {
        	try 
        	{
        		int[] list = {40, 27, 9, 2, 57, 56, 49, 73, 23, 7, 6, 67, 14, 22, 36, 97, 89, 28, 42, 99};
        		AVLMethods tree = buildTree(list);
        		BinaryNode target = find(tree.getRoot(),57);
        		target.setRight(tree.rightRightRotation(target.right()));
        		
        		assertEquals("testing RR Rotation","[40, 27, 57, 9, 36, 56, 97, 2, 23, 28, 49, 73, 99, 7, 14, 42, 67, 89, 6, 22]",tree.levelOrder());
        	} 
        	catch(Exception e)
        	{
        		e.setStackTrace(new StackTraceElement[] {});
        		throw e;
        	}
            //assertEquals("forgotSpaces(\"" + tests[i] + "\") incorrect", exp[i], _CLASS_._METHOD_(tests[i]));
        }
    
    //Test RL
    @Test (timeout=250)
    public void testRL() throws Exception {
        	try 
        	{
        		int[] list = {40, 27, 9, 2, 57, 56, 49, 73, 23, 7, 6, 67, 14, 22, 36, 97, 89, 28, 42, 99};
        		AVLMethods tree = buildTree(list);
        		BinaryNode target = find(tree.getRoot(),27);
        		target.setLeft(tree.rightLeftRotation(target.left()));
        		
        		assertEquals("testing RL Rotation","[40, 27, 57, 14, 36, 56, 73, 9, 23, 28, 49, 67, 97, 2, 22, 42, 89, 99, 7, 6]",tree.levelOrder());
        	} 
        	catch(Exception e)
        	{
        		e.setStackTrace(new StackTraceElement[] {});
        		throw e;
        	}
            //assertEquals("forgotSpaces(\"" + tests[i] + "\") incorrect", exp[i], _CLASS_._METHOD_(tests[i]));
        }
    
}

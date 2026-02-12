//THIS EXISTS IN CASE YOU WANT TO WRITE A DRIVER TO TEST YOUR METHODS, IT IS NOT NECESSARY FOR THE ASSIGNMENT
public class AVLMethodsDriver{
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(new BinaryNode(10));
        tree.add(new BinaryNode(5));
        tree.add(new BinaryNode(2));
        tree.add(new BinaryNode(1));
        tree.add(new BinaryNode(6));
        tree.add(new BinaryNode(11));
        System.out.println(tree.levelOrder());
        leftLeftRotation(tree.getRoot());
        System.out.println(tree.levelOrder());
    }


    public static int balanceFactor(BinaryNode x){
        return getHeight(x.left()) - getHeight(x.right());
    }
    public static int getHeight(BinaryNode k){
        if(k == null)
            return -1;
        return 1 + Math.max(getHeight(k.right()), getHeight(k.left()));
    }
    public static BinaryNode leftLeftRotation(BinaryNode x){
        BinaryNode child = x.left();
        x.setLeft(child.right());
        child.setRight(x);
        return child;
    }
    public BinaryNode rightRightRotation(BinaryNode x){
        BinaryNode child = x.right();
        x.setRight(child.left());
        child.setLeft(x);
        return child;
    }
    public BinaryNode leftRightRotation(BinaryNode x){
        BinaryNode leftParent = x.left();
        BinaryNode rightChild = leftParent.right();
        x.setLeft(rightChild);
        if(rightChild.left() != null)
            leftParent.setRight(rightChild.left());
        rightChild.setLeft(leftParent);

        rightChild.setLeft(leftParent);
        leftParent.setRight(null);
        return rightRightRotation(x);
    }
    public BinaryNode rightLeftRotation(BinaryNode x){
        BinaryNode rightParent = x.right();
        BinaryNode leftChild = rightParent.left();

        x.setRight(leftChild);
        rightParent.setLeft(null);
        if(leftChild.right() != null)
            rightParent.setRight(leftChild.right());
        leftChild.setRight(rightParent);
        return leftLeftRotation(x);
    }
}
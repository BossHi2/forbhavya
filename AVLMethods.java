
public class AVLMethods{
    public int balanceFactor(BinaryNode x){
        return getHeight(x.left()) - getHeight(x.right());
    }
    public int getHeight(BinaryNode k){
        if(k == null)
            return -1;
        return Math.max(getHeight(k.right()), getHeight(k.left()));
    }
    public BinaryNode leftLeftRotation(BinaryNode x){
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
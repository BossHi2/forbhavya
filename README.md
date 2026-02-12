[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/ioyGPE_k)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=18168589)
# Lab 14 Quiz -- The AVL Club
```
AVLMethods.java		AVLMethodsDriver.java		BinaryNode.java
BinarySearchTree.java
```
The programmer will write a partial AVL class that will inherit the BinarySearchTree class.

The programmer is expected to write the following classes: balanceFactor, getHeight, leftLeftRotation, leftRightRotation, rightRightRotation, and rightLeftRotation. These methods will have the behavior of the AVL binary search tree.

The balanceFactor will return an int value. The balanceFactor will receive a BinaryNode as a parameter. The method will return the balance factor of that node.

The getHeight will return an int value. The getHeight will receive a Binary Node as a parameter. The method will return the height of that node.

The other four methods will receive one BinaryNode. Consider this node the ancestor. The ancestor will determine the parent and child based on the method name and will rotate accordingly. When the rotation is done, the method will return BinaryNode that is now the subroot of the branch.

A AVLMethodsDriver is provide, in case you want to test your methods. It is not necessary for the test data.

Do not alter the following given code: 
```
BinaryNode.java	BinarySearchTree.java	AVLMethodsTest.java
```
## Supporting Files

You may notice that there are files and folders in this assignment other than the ones that you are working on. Those are part of the autograding system and need to be kept as-is. Modifying these files may cause your code to be incorrectly graded, and in worst case may be considered academic dishonesty. 

Generally these will be folders that start with a period like `.github` or `.devcontainer` or Java files that start with `Test_`. 

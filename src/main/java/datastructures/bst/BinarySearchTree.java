package datastructures.bst;

public class BinarySearchTree {

    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while(true) {
            if(newNode.value == temp.value) {
                return false;
            }
            if(newNode.value > temp.value) {
                if(temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            } else {
                if(temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp!=null) {
            if(temp.value > value) {
                temp = temp.left;
            } else if (temp.value < value){
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean rContains(Node currentNode, int value) {
        if(currentNode == null) {
            return false;
        }
        if(currentNode.value == value) {
            return true;
        }
        if(currentNode.value < value) {
            return rContains(currentNode.right, value);
        } else {
            return rContains(currentNode.left, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if(currentNode == null) {
            return new Node(value);
        }
        if(value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        rInsert(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if(currentNode == null) {
            return null;
        }
        if(value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if(value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if(currentNode.left == null && currentNode.right == null) {
                return null;
            } else if(currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMain = minValue(currentNode.right);
                currentNode.value = subTreeMain;
                currentNode.right = deleteNode(currentNode.right, subTreeMain);
            }
        }

        return currentNode;
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    public int minValue(Node currentNode) {
        while (currentNode.left !=null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

}

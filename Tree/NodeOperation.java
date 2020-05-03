//package Tree;

//import Tree.Node;

public class NodeOperation {

    public Node root;

    public Node CreateTree() {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        // Testing - 123
        n1.left = n2;
        n1.right = n3;

        n2.left = n4;

        root = n1;

        return root;
    }

}
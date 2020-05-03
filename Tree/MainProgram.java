//package Tree;


public class MainProgram {

    public static void main(String[] main) {
        System.out.println("Testing main program");

        NodeOperation nOp = new NodeOperation();
        Node root = nOp.CreateTree();

        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }

}
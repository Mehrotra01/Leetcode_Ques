package Tree;


class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data =d;
        right=null;
        left = null;

    }
}
class height{
    static int h;
}
public class diameterOfTree {
    Node root;

    public void diameterTree(){
        height h = new height();
       System.out.println(diameterTree(root,h));
    }
    @SuppressWarnings("static-access")
    protected int diameterTree(Node root, height h){
        height rightTree = new height();
        height leftTree = new height();

        if(root ==null){
            height.h=0;
            return 0;
        }
        int op1=diameterTree(root.left, leftTree);
        int op2=diameterTree(root.right, rightTree);

        height.h=Math.max(rightTree.h,leftTree.h)+1;
        return Math.max(leftTree.h+height.h+1,Math.max(op1, op2));
    } //O(N) complexity

    // public void diameterOfTree() {
        // System.out.println(diameterOfTree(root));
    // }

    // protected int diameterTree(TreeNode root) {
    //     if(root ==null){return 0;}

    //     int op1= diameterOfTree(root.left);
    //     int op2 =diameterOfTree(root.right);
    //     int op3 =heightOfTree(root.left)+1+heightOfTree(root.right);
    //     int diameter = Math.max(op1,Math.max(op2,op3));
    //     return diameter;
    // } //but complexity of it's is n^2 cause we are calling height function as well

    // public void heightOfTree() {
    //     System.out.println(heightOfTree(root));
    // }

    // protected int heightOfTree(TreeNode root) {
    //    if(root==null){return 0;}
        // return 1+Math.max(heightOfTree(root.left), heightOfTree(root.right));
    // }
    public static void main(String[] args) {
        diameterOfTree tree = new diameterOfTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
    }
}

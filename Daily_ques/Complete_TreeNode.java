
//  * Definition for a binary tree node.
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
class Solution {
    public int countNodes(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int lh=leftHeight(root);
        int rh = rightHeight(root);
        
        if (lh != rh){
                    // System.out.println("hi");
            return 1 + countNodes(root.left)+
                countNodes(root.right);
        }    
        return (1 << lh) - 1;
    }
    
    
    static int leftHeight(TreeNode node){
        int h = 0;
        while(node!=null){
            h++;
            node=node.left;
        }
        // System.out.println(h+"l");
        return h;
    }
    
    
    static int rightHeight(TreeNode node){
        int h = 0;
        while(node!=null){
            h++;
            node=node.right;
        }
                // System.out.println(h+"r");

        return h;
    }
}

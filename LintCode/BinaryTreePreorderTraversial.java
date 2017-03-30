/**
 * Binary Tree Preorder Traversial
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */

     // There algorithm for this problem: 1) recursion - traverse 2) recursion - Divide Conquer 3)iterate
     // 1) recursion - traverse: easy but not suggested. because using an almost
     //    global variable(result as parameter was passed in each level of recursion)
     //     need a helper function

     // 2) recursion - divide and conquer: much better. each level will return a ArrayList as result, and the final result is combined
     // 3) use iteration method. will work on that latter.




    public ArrayList<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        // divide

        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        // conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        // use traverse to find the pre order

        // 2) use recursion - travese
        // traverse(root, result);


        // 3) use iteration

        ArrayList<Integer> preorder = new ArrayList<Integer>();
        Stack <TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        while (!stack.empty()) {
            TreeNode currRoot = stack.pop();
            preorder.add(currRoot.val);

            if (currRoot.right != null) {
                stack.push(currRoot.right);
            }
            if (currRoot.left != null) {
                stack.push(currRoot.left);
            }
        }

        return preorder;



        //return result;
    }


    // 1 recursion: traverse
    // recursion - traverse method can work, but the paramether result
    // is more like a global variabe, which is not that good in style.
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}

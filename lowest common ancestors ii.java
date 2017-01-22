/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        if (root == null || A == null || B == null) {
            return root;
        }
        ArrayList<ParentTreeNode> ancestorsOfA = new ArrayList<>();
        ArrayList<ParentTreeNode> ancestorsOfB = new ArrayList<>();
        
        ancestorsOfA = pathToNode(root, A);
        ancestorsOfB = pathToNode(root, B);
        
        
        int indexA = ancestorsOfA.size() - 1;
        int indexB = ancestorsOfB.size() - 1;
        
        // use this LCA ro record the common ancestor until non common node in path
        ParentTreeNode LCA = null;
        while (indexA >= 0 && indexB >= 0) {
            if (ancestorsOfA.get(indexA) != ancestorsOfB.get(indexB)) {
                return LCA;
            }
            LCA = ancestorsOfA.get(indexA);
            indexA--;
            indexB--;
            
        }
        // 1, 2, 4
        //    2, 4
        return LCA;
        }
        
        private ArrayList<ParentTreeNode> pathToNode(ParentTreeNode root, ParentTreeNode node) {
            ArrayList<ParentTreeNode> path = new ArrayList<>();
            
            while (node != null) {
                path.add(node);
                node = node.parent;
            }
            return path;
        }
}






# LintCode

Just a blog for practice of LintCode. No big deal.

Jan-20

  >  Subset I —> subset with no duplicate element in list
              use DFS
  >  Subset II  —>  subset with duplicate.
              use DFS
              be careful with the duplicate part.

    //Binary Tree and Divide Conquer
  > Maximum Depth of Binary Tree

  > Hash Function
  > Balanced Binary Tree
              two different strategy: 1) create a new class for containing result, with field of maxDepth and isBalanced
                                      2) use only int result to represent maxDepth of subtree when balanced and -1 when the
                                         subtree is not balanced.




Jan-22

   binary tree divide conquer
  > lowest common ancestor (of two given nodes)
  > lowest common ancestor ii
    If the node in tree has parent pointer, we can follow the parent pointer from given node to root. So we will
    have the path from node to root. If we can find the paths of both nodes, compare the path can help find the LCA.

  > Subtree with Maximum Average:
    >use traverse and divide conquer. Since the use of traverse, two global variables is necessary:
        1) ResultType maxAverage (sum ,count) ----> keep max average record
        2) Tree Node subtree ------> keep the subtree with current max average, this is the final return variable

    > The recursion function need to 1)return the class ResultType(int sum, int count), which will be used to
      calculate average of ParentTreeNode as subtree.




  > balanced tree sum:
  > balanced tree sum ii:
              root to any
              root to leaf
              any to any // the most difficult problem for binary divide and conquer

jan-24:

  > subtree with maximum average

  > subtree with minimum sum

  > Binary Tree Longest Consecutive Sequence

jan-25:

> Binary Path Sum

> Binary Tree Path

> Flatten Binary Tree to Linked List

> Validate Binary Search Tree



jan-26:

feb-6:
  about bfs.
  > Number of Islands
  > Binary Tree Level Order Traversal
  > search graph node

feb-7:

  >

import java.util.*;

#  TreeNode

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

#  TreeNodeTest

    public class TreeNodeTest {
    
 ##   高度最小的BST 
  
     /**
	 * 检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
	 * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
	 * 
	 * 思路：
	 * 依次递归遍历根节点的左右子树的高度差
     * 如果不大于1.递归下一层，否则，返回false
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isBalance(TreeNode root) {
		
		if(root==null)
			return true;
		int leftDepth = getDepth(root.left);
		int rigthDepth = getDepth(root.right);
		if(Math.abs(leftDepth-rigthDepth)>1)
			return false;
		
		return isBalance(root.left)&&isBalance(root.right);


	}
	public static int getDepth(TreeNode root) {
		if(root==null ) {
			return 0;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		return (leftDepth>rightDepth?leftDepth:rightDepth)+1;
		
		
	}
        
##   高度最小的BST

        /**
	 * 	给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
	 *	思路
	 *	判断数组的长度是否不大于2；
	 *	是，则返回数组长度；
	 *	否则，利用递归返回左右子树最大的
	 *
	 *	也可以直接计算；
	 * @param vals
	 * @return
	 */
	
	public static int buildMinimalBST(int[] vals) {
        int length = vals.length;
        if(length<=2)
        	return length;

        System.out.println("树的根节点是；"+vals[length/2]);

        int leftLength = buildMinimalBST(Arrays.copyOfRange(vals,0,length/2));
        int rightLength = buildMinimalBST(Arrays.copyOfRange(vals,length/2+1,length));
        return Math.max(leftLength, rightLength)+1;
    }
        
    }

import java.util.*;

#  TreeNode

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
	
# 	ListNode
	    
	 class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
		this.val = val;
	    }
	}

#  TreeNodeTest

    public class TreeNodeTest {
    
 ##     检查是否BST
    
    /**
	 * 	检查一棵二叉树是否为二叉查找树。
	 * 	给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
	 * 	
	 * 	思路：
	 * 1.已知中序遍历排序二叉查找树，得到的序列应是有序的。
	 * 2.因此，可以在非递归遍历二叉查找树的中间过程中，取当前遍历节点的值与上一遍历节点值进行比较，
	 * 	若当前节点的值不小于上一节点的值，则继续遍历至结束，否则，返回false。   
	 * 3.二叉树中序遍历非递归算法需要借助栈来实现。
	 * 
	 * @param root
	 * @return
	 */
	public boolean checkBST(TreeNode root) {
		
		if(root==null)
			return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		stack.add(temp);
		int max = 0;
		boolean isFirstNum = true;
		while(!stack.isEmpty()) {
			if(temp!=null&&temp.left!=null) {
				stack.add(temp.left);
				temp = temp.left;
			}else {
				temp = stack.pop();
				if(isFirstNum) {
					max = temp.val;
					isFirstNum = false;
				}else {
					if(max<temp.val)
						max = temp.val;
					else
						return false;
				}
				if(temp!=null&&temp.right!=null) {
					stack.add(temp.right);
					temp = temp.right;
				}else
					temp=null;
			}
		}
		return true;
	}
    
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
    
  ##   某一深度的全部节点
    
    /**
	 * 	对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
	 * 	给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，代表该深度上所有结点的值，请按树上从左往右		的顺序链接，
	 * 	保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
	 * 
	 * 	思路
	 * 	利用队列实现非递归分层遍历；
	 *      因为深度1为根节点，不需要遍历；并且循环第一次就是深度2，循环dep-1次；
	 * 	
	 * @return
	 */
	 public ListNode getTreeLevel(TreeNode root, int dep) {
		 if(root==null||dep<1)
	        	return null;
	        ListNode tempList = new ListNode(-1);
	        ListNode result = tempList;
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        while(dep>1&&!queue.isEmpty()) {
	        	int size = queue.size();
	        	for(int i=0;i<size;i++) {
		        	TreeNode temp = queue.poll();
		        	if(temp.left!=null)
		        		queue.add(temp.left);
		        	if(temp.right!=null)
		        		queue.add(temp.right);
		        	}
	        	dep--;
	        }
	        while(!queue.isEmpty()) {
	        	ListNode t=new ListNode(queue.poll().val);
	        	tempList.next = t;
	        	tempList = tempList.next;
	        }
	        return result.next;
	    
	 }
        
##    寻找下一节点
	
	/**
	 * 寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
	 * 给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
	 * 保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。
	 * 
	 * 思路：
	 * 要求输出值为P的中序遍历的下一节点的值，我们就可以先中序遍历二叉树；
	 * 设置两个变量一个记录是否有相同的值，然后是是否输出值；
	 *
	 * @param root
	 * @param p
	 * @return
	 */
	public static int findSucc(TreeNode root, int p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        boolean isFind = false;
        boolean isNext = false;
        stack.add(temp);
        while(!stack.isEmpty()) {
        	if(temp!=null&&temp.left!=null) {
        		stack.add(temp.left);
        		temp = temp.left;
        	}else {
        		temp = stack.pop();
        		isFind = temp.val==p?true:false;
        		if(isNext)
        			return temp.val;
        		if(temp!=null&&temp.right!=null) {
        			stack.add(temp.right);
        			temp = temp.right;
        		}else {
        			temp = null;
        		}
        		isNext = isFind?true:false;
        	}
        }
		return -1;
    }
    
  ##   最近公共祖先
    
    /**     
	 *	一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。
	 *	请设计一个算法，求出a和b点的最近公共祖先的编号。
	 *	给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
	 *
	 *	思路：
	 *	满二叉树的子节点与父节点之间的关系为root = child / 2
	 *	利用这个关系，如果a ！= b，就让其中的较大数除以2， 如此循环知道a == b，即是原来两个数的最近公共祖先 
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public int getLCA(int a, int b) {
	    

		if(a==b)
			return a;
		
		return a>b?getLCA(a/2, b):getLCA(a, b/2);
		
    }
	
    
    
	
    }

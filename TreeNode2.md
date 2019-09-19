# TreeNode2


    public class TreeNode2 {


      static class TreeNode {
          int val = 0;
          TreeNode left = null;
          TreeNode right = null;

          public TreeNode(int val) {
              this.val = val;

          }
        public void addLeft (int val) {
           TreeNode root = new TreeNode(val);
           this.left = root;
        }
        public void addRight (int val) {
           TreeNode root = new TreeNode(val);
           this.right = root;
        }

      }

##  二叉搜索树的后序遍历
        /**
	 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
	 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
	 * 
	 * 思路：
	 * 后序遍历 的序列中，最后一个数字是树的根节点 ，数组中前面的数字可以分为两部分：
	 * 第一部分是左子树节点 的值，都比根节点的值小；第二部分 是右子树 节点的值，都比 根 节点 的值大，
	 * 后面用递归分别判断前后两部分 是否 符合以上原则
	 * @param sequence
	 * @return
	 */
	public static boolean VerifySquenceOfBST(int[] sequence) {
		
		if(sequence==null||sequence.length==0)
			return false;
		if(sequence.length==1) {
			return true;
		}
		int root = sequence[sequence.length-1];
		int index = 0;
		List<Integer> leftList = new ArrayList<Integer>();
		List<Integer> rightList = new ArrayList<Integer>();
		for(int i=0;i<sequence.length-1;i++) {
			if(root>sequence[i])
				leftList.add(sequence[i]);
			else {
				index=i;
				break;
			}
		}
		if(leftList.size()!=(sequence.length-1)) {
			for(int i=index;i<sequence.length-1;i++) {
				if(root<sequence[i])
					rightList.add(sequence[i]);
				else {
					return false;
				}
			}
		}
		
		boolean l = leftList.size()==0 ||VerifySquenceOfBST(getArray(leftList));
		boolean r = rightList.size()==0 ||VerifySquenceOfBST(getArray(rightList));
 		return l&&r;

	}
	public  static int[] getArray(List<Integer> list) {
		if(list.size()==0) {
			return null;
		}
		int [] result = new int [list.size()];
		int i=0;
		for(int j :list) {
			result[i]=j;
			i++;
		}
		return result;
		
	}

##  树的子结构

####  得到next数组
      public static int[] getNextArray(List<Integer> list) {
        int[] next = new int [list.size()];
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        for(int i=2;i<list.size();i++) {
          k = next[i-1];
          while(k!=-1) {
            if(list.get(i-1).equals(list.get(k))) {
              next[i] = k+1;
              break;
            }else {
              k = next[k];
            }
            //next[i] = 0;
          }
        }



        return next;
####  kmp匹配算法
      }
      public static boolean kmp(List<Integer> s,List<Integer> m) {
        int[] next = getNextArray(m);
        int i = 0,j = 0;
        while(j<s.size()&&i<m.size()) {
          if(i==-1||s.get(j).equals(m.get(i))) {
            i++;j++;
          }else {
            i=next[i];
          }
        }
        if(i==m.size())
          return true;
        return false;
      }
####  得到二叉树的先序遍历的list
      public static List<Integer> xianxv(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()) {
          TreeNode temp = stack.pop();
          list.add(temp.val);
          if(temp.right!=null) {
            stack.add(temp.right);

          }
          if(temp.left!=null) {
            stack.add(temp.left);
          }
        }
        return list;
      }

    }



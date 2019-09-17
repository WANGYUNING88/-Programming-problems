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



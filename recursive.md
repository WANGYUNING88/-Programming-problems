        
   #        递归recursive
   
   
   ##    魔术索引
   
        /**
             * Q:在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个不下降序列，元素值可能相同，编写一个方法，判断在数组A中是否存在魔术索引。
             * 	请思考一种复杂度优于o(n)的方法。给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
             * 
             * A:复杂度由于O(N)，所以采用顺序比较，最优的是比较递归二分法，
             * @param A
             * @param n
             * @return
             */
            public boolean findMagicIndex(int[] A, int n) {
              // write code here
              if (A == null || A.length != n || n <= 0) {
                return false;
              }
              return find(A, 0, n - 1);
            }

            public boolean find(int[] A, int begin, int end) {
              if (begin > end)
                return false;

              int mid = (begin + end) / 2;
              if (A[mid] == mid)
                return true;

              return find(A, begin, mid - 1) || find(A, mid + 1, end);

            }
            
   ##   字符串排序         
                   
         /**
	 * Q：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
	 * A:将字符串看成两部分，一部分是第一个字符，另一部分是后面的所有字符。
	 * 首先确定第一个字符，该字符可以是字符串中的任意一个；固定第一个字符后，求出后面所有字符的排列（相同步骤，采用递归）。
	 * 实现第一个字符的改变，只需要将第一个字符和后面所有字符进行交换即可（最早自己想的是从原始字符串拿出第i个字符，
	 * 然后合并剩下的字符到后面，其实就是个交换的过程，自己开始时想得太复杂了）。要记得字符串输出后要将字符交换回来，变回原始的字符串。
	 * @param A
	 * @return
	 */
	public ArrayList<String> getPermutation(String A) {
		char[] aChar = A.toCharArray();

		ArrayList<String> list = new ArrayList<>();
		permutation(list, aChar, 0);
		Collections.sort(list);
		Collections.reverse(list);
		return list;
	}

	public void permutation(ArrayList<String> result, char[] aChar, int n) {

		if (n == aChar.length) {
			result.add(new String(aChar));
			return;
		}
		for (int i = n; i < aChar.length; i++) {
			swap(i, n, aChar);
			permutation(result, aChar, n + 1);
			swap(i, n, aChar);
		}
	}

	public void swap(int i, int j,char[] aChar) {

		char temp = aChar[i];
		aChar[i] = aChar[j];
		aChar[j] = temp;
	}



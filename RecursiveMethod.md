# RecursiveMethod
**总结常见的递归问题**

##    第一个只出现一次的字符
      /**第一个只出现一次的字符
	 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
	 * 中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写
	 * 
	 * 思路：
	 * 归并排序
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	
	static int m = 1000000007;

	public static int InversePairs(int[] array) {
		if (array == null || array.length == 0 || array.length == 1)
			return 0;
		return InversePairs(array, 0, array.length - 1);
	}
	
	public static int InversePairs(int[] array, int low, int high) {
		if (!(low < high))
			return 0;
		int mid = (low + high) / 2;
		int left = InversePairs(array, low, mid);
		int right = InversePairs(array, mid + 1, high);

		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		int count = 0;
		int r = j;
		while (i <= mid && j <= high) {
			if (array[i] <= array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];

				count = (count + (r - i) % m) % m;
			}
		}
		while (i <= mid) {
			temp[k++] = array[i++];
		}
		while (j <= high) {

			temp[k++] = array[j++];
		}

		for (int x = 0; x < temp.length; x++) {
			array[x + low] = temp[x];
		}
		return ((left + right) % m + count) % m;
	}


##  hanoi汉诺塔问题

      /**
        * 
        * 思路：
        * 	虽有的问题都可以看做两种情况
        * 		1，一个盘子：A->C
        * 		2,两个盘子：上面所虽有盘子A->B,下面的一个盘A->C,上面所有盘子B->C.
        * 
        * @param n				一共几个盘子
        * @param from			起始盘子的柱子
        * @param in			中间柱子
        * @param to			目标柱子
        */
       public static void hanoi(int n,char from,char in ,char to) {
         if(n==1) {
            System.out.println("第 "+n+" 个盘子从 "+from+" 移动到 "+to);
         }else {
            //移动上面所有的盘子移到中间盘子
            hanoi(n-1,from,to,in);
            System.out.println("第 "+n+" 个盘子从 "+from+" 移动到 "+to);
            //移动下面这一个盘子移到目标盘子
            hanoi(n-1,in,from,to);

         }
       }

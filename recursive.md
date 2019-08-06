        
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

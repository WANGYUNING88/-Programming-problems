#     WolfQueen

##  回溯法
### 代码
 
    public class WolfQueen {
        /**
         * 一共有多少个皇后（此时设置为8皇后在8X8棋盘，可以修改此值来设置N皇后问题）
         */
        static int max = 8;
        /**
         * 计数器
         */
        static int count = 0;
        /**
         * 该数组保存结果，第一个皇后摆在array[0]列，第二个摆在array[1]列
         */
        int[] array = new int[max];

        public static void main(String[] args) {
            new WolfQueen().check(0);
            System.out.println(max+"皇后问题共有"+count+"中解法");
        }

        /**
         * n代表当前是第几个皇后
         * @param n
         * 皇后n在array[n]列
         */
        private void check(int n) {
            //终止条件是最后一行已经摆完，由于每摆一步都会校验是否有冲突，所以只要最后一行摆完，说明已经得到了一个正确解
            if (n == max) {
                print();
                count++;
                return;
            }
            //从第一列开始放值，然后判断是否和本行本列本斜线有冲突，如果OK，就进入下一行的逻辑
            for (int i = 0; i < max; i++) {
                array[n] = i;
                if (judge(n)) {
                    check(n + 1);
                }
            }
        }
        /**
         * 判断第n个皇后是否合法
         * @param n
         * @return
         */
        private boolean judge(int n) {
            for (int i = 0; i < n; i++) {
                if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                    return false;
                }
            }
            return true;
        }
        /**
         * 打印皇后的位置
         */
        private void print()  {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + 1 + " ");
            }
            System.out.println();
        }
    }


### 运行结果
![运行结果](https://github.com/WANGYUNING88/hello/blob/master/WolfQueen.png) 

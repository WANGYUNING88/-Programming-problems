    package com.test.leetcode;

#  Linked

    public class Linked {

##      约瑟夫问题II

      /**
       * Q约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。
       * 	给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。
       * A:动态规划解法，f(1,m) = 0; (n=1)
       * f(n,m)=(f(n-1,m)+m)%n; （n>1）

       * @param n
       * @param m
       * @return
       */
      public static int getResult(int n, int m) {
        // write code here
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
          list.add(i);
        }
        int cursor = 1;
        int index = 0;
        int i = 1;
        while (list.size() > 1) {
          int temp = list.size();
          if (cursor == m) {
            System.out.println("第" + i + "次移除的编号是：" + list.get(index));
            list.remove(index);
            cursor = 1;
            i++;
            if (index == temp - 1)
              index = 0;
          } else {
            cursor++;
            if (index == temp - 1) {
              index = 0;
            } else {
              index++;
            }
          }

        }
        return list.get(0);
      }

      public static int getResult1(int n, int m) {

        int[] result = new int[n + 1];
        result[1] = 0;
        for (int i = 2; i < n + 1; i++) {
          result[i] = (result[i - 1] + m) % i;
        }
        return result[n] + 1;
      }

##      约瑟夫问题II

      /**
       * Q:约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。
       * 	然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。
       *	接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。以此类推直到剩下以后一个人。
       * 	现在需要求的即是这个人的编号。给定一个int n，代表游戏的人数。请返回最后一个人的编号
       * 
       * A,因为要多次删除和插入，所以为了提升效率创建一个链表；
       * 	初始化一个m=2；定义一个游标，游标不会超过m，如果游标不是1，则删除这个元素，
       * 然后m++；循环执行，直到只剩一个元素，他就是那个编号；
       * @param n
       * @return
       */
      public static int getResult(int n) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=1;i<=n;i++) {
          list.add(i);
        }
        int m=2;

        while(list.size()>1) {
          int cursor = 1;
          for(int i=0;i<list.size();) {
            if(cursor!=1) {
              list.remove(i);
            }else {
              i++;
            }
            if(cursor<m)
              cursor ++;
            else
              cursor=1;
            }
          list.addFirst(list.removeLast());
          m++;
        }
        return list.getFirst();
            // write code here
        }

      public static void main(String[] args) {
    //		LinkedList<Integer> list = new LinkedList<Integer>();
    //		for(int i=0;i<5;i++) {
    //			list.add(i);
    //		}
    //		System.out.println(list.removeLast());
    //		System.out.println(list.getLast());
        System.out.println(getResult(5));
      }
    }

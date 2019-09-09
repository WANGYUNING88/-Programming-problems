package com.test.question;


public  class KmpMatch {

	/**
	 * KMP字符匹配
	 * 
	 * @param patternString 模式串
	 * @param primaryString 主串
	 * @return
	 */
	public static int KMP(String patternString, String primaryString) {
		char[] primaryString_arr = primaryString.toCharArray();
		char[] patternString_arr = patternString.toCharArray();
		int[] next = getNextArray(patternString_arr);
		int i = 0, j = 0;
		for (; (i < primaryString_arr.length) && (j < patternString_arr.length);) {

			if (j == -1 || primaryString_arr[i] == patternString_arr[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}

		}
		if(j==patternString_arr.length)
			return i-j;
		return -1;
	}

	/**
	 * 求出一个字符数组的next数组
	 * 
	 * 	算法：
	 *	1.next[0]=-1, next[1]=0。
	 *	2.在求解next[j]时，令k=next[j-1]，
	 *	3.比较T[j-1]与T[k]的值，
	 *		 a. 若T[j-1]等于T[k]，则next[j]=k+1。
	 *		 b. 若T[j-1]不等于T[k]，令k=next[k]，若k等于-1，则next[j]=0，否则跳至3。


	 * 
	 * @param t 字符数组
	 * @return next数组
	 */
	public static int[] getNextArray(char[] t) {
		int[] next = new int[t.length];
		next[0] = -1;
		next[1] = 0;
		int k;
		for (int j = 2; j < t.length; j++) {
			k = next[j - 1];
			while (k != -1) {
				if (t[j - 1] == t[k]) {
					next[j] = k + 1;
					//System.out.println("j=" + j + ",next[" + j + "]=" + next[j]);
					break;
				} else {
					k = next[k];
				}
				next[j] = 0; // 当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
			}
		}
		return next;
	}

	public static void main(String[] args) {
		
		System.out.println(KMP("ababa","asdeaababadada"));
		
	}

}

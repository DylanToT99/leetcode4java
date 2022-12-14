package DynamicPrograming;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/1/4 15:04
 * @description 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 72. 编辑距离
 **/
public class minDistance__ {
    public int minDistance(String word1, String word2) {
        /**
         * dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
         *
         * if (word1[i - 1] == word2[j - 1])
         *     不操作
         * if (word1[i - 1] != word2[j - 1])
         *     增
         *     删
         *     换
         *
         *
         */
        int[][]dp=new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;
        for (int i = 1; i <=word1.length() ; i++) {
            for (int j = 1; j <word2.length()+1; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

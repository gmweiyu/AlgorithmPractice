package leetcode;

/**
 * Created by Weasley on 2017-03-26.
 */
public class Q62_UniquePaths {
    private static int ans=0;
    public static void main(String[] args) {
        int m=19,n=9;
        System.out.println(uniquePaths(m,n));
        System.out.println(uniquePaths_2(m,n));
        System.out.println(dfs(1,1,m,n));
    }

    //动态规划求解：每一个点等于其左边+上边
    public static int uniquePaths(int m, int n) {
        if(m<1||n<1)    return 0;
        int[][] book=new int[m][n];
        for(int i=0;i<m;i++)    book[i][0]=1;
        for(int j=0;j<n;j++)    book[0][j]=1;
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                book[i][j]=book[i-1][j]+book[i][j-1];
            }
        }
        return book[m-1][n-1];
    }

    //动态规划，优化空间复杂度为O(n)
    public static int uniquePaths_2(int m,int n){
        if(m<=0||n<=0)  return 0;
        int[] book=new int[n];
        book[0]=1;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++) {
                book[j]+=book[j-1];     //前一列(book[j-1])+上一行(book[j])
            }
        }
        return book[n-1];
    }

    //暴力深搜
    public static int dfs(int x,int y,int m,int n){
        if(x==m&&y==n)  return 1;
        if(x>m||y>n)    return 0;
        return dfs(x+1,y,m,n)+dfs(x,y+1,m,n);
    }
}

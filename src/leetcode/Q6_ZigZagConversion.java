package leetcode;

/**
 * Created by Weasley on 2017-02-27.
 * AC
 */
public class Q6_ZigZagConversion {
    public static void main(String[] args) {
        String str="A";
        System.out.println(convert(str,1));
    }

    public static String convert(String s,int numRows) {
        char[] array=s.toCharArray();
        if (numRows == 1) {
            return s;
        }
        int row = numRows, col = (s.length() / (numRows * 2 - 2)+1) * (numRows - 1);
        char[][] tempAns = new char[row][col];
        int index=0,i=0,j=0,di=0,dj=0;
        for(int begin=0;begin<array.length;begin++){
            if (i == 0) {
                di=1;
                dj=0;
            } else if (i == row - 1) {
                dj=1;
                di=-1;
            }
            tempAns[i][j] = array[begin];
            i+=di;
            j+=dj;
        }
        StringBuilder ans=new StringBuilder("");
        for(int a=0;a<row;a++) {
            for(int b=0;b<col;b++) {
                if (tempAns[a][b] != '\0') {
                    ans.append(tempAns[a][b]);
                }
            }
        }
        return String.valueOf(ans);
    }
}

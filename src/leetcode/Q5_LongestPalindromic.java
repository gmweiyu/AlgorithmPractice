package leetcode;

/**
 * Created by Weasley on 2017-02-27.
 * 最长回文子串
 */
public class Q5_LongestPalindromic {
    public static void main(String[] args) {
//        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String str="anugnxshgonmqydttcvmtsoaprxnhpmpovdolbidqiyqubirkvhwppcdyeouvgedccipsvnobrccbndzjdbgxkzdbcjsjjovnhpnbkurxqfupiprpbiwqdnwaqvjbqoaqzkqgdxkfczdkznqxvupdmnyiidqpnbvgjraszbvvztpapxmomnghfaywkzlrupvjpcvascgvstqmvuveiiixjmdofdwyvhgkydrnfuojhzulhobyhtsxmcovwmamjwljioevhafdlpjpmqstguqhrhvsdvinphejfbdvrvabthpyyphyqharjvzriosrdnwmaxtgriivdqlmugtagvsoylqfwhjpmjxcysfujdvcqovxabjdbvyvembfpahvyoybdhweikcgnzrdqlzusgoobysfmlzifwjzlazuepimhbgkrfimmemhayxeqxynewcnynmgyjcwrpqnayvxoebgyjusppfpsfeonfwnbsdonucaipoafavmlrrlplnnbsaghbawooabsjndqnvruuwvllpvvhuepmqtprgktnwxmflmmbifbbsfthbeafseqrgwnwjxkkcqgbucwusjdipxuekanzwimuizqynaxrvicyzjhulqjshtsqswehnozehmbsdmacciflcgsrlyhjukpvosptmsjfteoimtewkrivdllqiotvtrubgkfcacvgqzxjmhmmqlikrtfrurltgtcreafcgisjpvasiwmhcofqkcteudgjoqqmtucnwcocsoiqtfuoazxdayricnmwcg";
//        String str = "babadddd";
        System.out.println(longestPalindrome_4(str));
    }

    public static String longestPalindrome(String s) {
        int longest=0;
        if (s.length() == 1) {
            return s;
        }
        String ans="";
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<s.length();j++) {
                String subStr = s.substring(i, j+1);
                int len = isPalindrome(subStr);
                if (longest < len) {
                    ans=subStr;
                    longest=len;
                }
            }
        }
        if (longest == 0) {
            return String.valueOf(s.charAt(0));
        }
        return ans;
    }

    public static int isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return 0;
            }
        }
        return s.length();
    }


    /**
     * 动态规划
     */
    public static String longestPalindrome_2(String s) {
        int n=s.length();   //长度
        boolean[][] dp = new boolean[n][n];
        char[] arr=s.toCharArray();     //字符数组

        /*
        实现1-DP，精简
        */
        int max=1,start=0;
        for(int i=0;i<n;i++) {
            dp[i][i]=true;
            for(int j=0;j<i;j++) {
                dp[j][i] = (arr[j] == arr[i] && (i - 1== j || dp[j + 1][i - 1]));
                if (dp[j][i] && max < i - j + 1) {
                    max=i-j+1;
                    start=j;
                }
            }
        }
        return s.substring(start,start+max);

    }

    /**
     * DP
     */
    public static String longestPalindrome_3(String s){
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        char[] arr=s.toCharArray();


        int start=0,max=1;
        for(int i=0;i<n;i++) {
            dp[i][i]=true;
            for (int j = 0; j < i; j++) {
                if (j == i - 1) {
                    dp[j][i] = (arr[j] == arr[i]);
                } else {
                    dp[j][i] = (arr[j] == arr[i] && dp[j + 1][i - 1]);
                }
                if (dp[j][i]&&max<i-j+1) {
                    max=i-j+1;
                    start=j;
                }
            }
        }

        return s.substring(start, start + max);
    }


    /**
     * 暴力
     */
    public static String longestPalindrome_4(String s) {
        String max_s = "";  // 所求的最大对称子串

        for(int i=0; i<s.length(); i++)
        {
            // 第一种对称模式
            int step = 1;
            try{
                for(;;)
                {
                    if(s.charAt(i-step) != s.charAt(i+step)) break;
                    step++;
                }
            }catch(Exception e){}

            String s1 = s.substring(i-step+1,i+step);     // 填空1


            // 第二种对称模式
            step = 0;
            try{
                for(;;)
                {
                    if(s.charAt(i-step)!=s.charAt(i+step+1)) break;    // 填空2
                    step++;
                }
            }catch(Exception e){}

            String s2 = s.substring(i-step+1,i+step+1);


            if(s1.length() > max_s.length()) max_s = s1;
            if(s2.length() > max_s.length()) max_s = s2;
        }

        return max_s;
    }


    /**
     * 暴力破解：将每一个元素（或相邻两个元素）都当作是子字符串的中心，
     * 并向两遍检查
     */
    public static String longestPalindrome_5(String s){
        String maxAns="";       //最长的回文子串
        for(int i=0;i<s.length()-1;i++) {
            String tempAns = getPalindrome(s, i, i);
            if(tempAns.length()>maxAns.length())
                maxAns=tempAns;

            tempAns = getPalindrome(s, i, i + 1);
            if(tempAns.length()>maxAns.length())
                maxAns=tempAns;
        }
        return maxAns;
    }

    public static String getPalindrome(String s, int start, int end) {
        char[] tempArr=s.toCharArray();
        while (start>=0&&end<s.length()) {
            if(tempArr[start]==tempArr[end]){
                start--;
                end++;
            }else
                break;
        }
        //比目标index少1、多1
        return s.substring(start+1,end);
    }
}

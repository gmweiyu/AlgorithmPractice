package interview;

/**
 * Created by GuoWeiyu on 2017/08/03.
 * Description: 计算1-n整数中1出现的次数
 */
public class Q43 {
    public static void main(String[] args) {
        int n=12;
        System.out.println(count(n));
    }

    private static int count(int n) {
        if (n == 0) {
            return 0;
        }
        int ans=0;
        // 当前数字对应的字符数组
        String str=Integer.toString(n);
        char[] arr = str.toCharArray();
        int length=str.length();
        // 计算首位数字
        int first=arr[0]-'0';

        if (length == 1 && first == 0) {
            return 0;
        }
        if (length == 1 && first > 0) {
            return 1;
        }

        // 计算除最高位的数字，即递归调用的数字n
        int newN=Integer.parseInt(str.substring(1, length));
        // 计算最高位对应的（1000-1999）1出现次数
        if (first == 1) {
            ans += newN + 1;
        } else if(first>1){
            ans+=Math.pow(10,length-1);
        }

        // 计算最后k位数字
        ans += (first * (length - 1) * Math.pow(10,length - 2));

        return ans+count(newN);
    }

}

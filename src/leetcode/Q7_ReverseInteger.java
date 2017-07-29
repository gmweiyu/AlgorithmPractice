package leetcode;

/**
 * Created by Weasley on 2017-02-27.
 */
public class Q7_ReverseInteger {
    public static void main(String[] args) {
        int num=2147483647;
        System.out.println(reverse(num));
    }

    public static int reverse(int x) {
        long res=0;
        while (x != 0) {
            res=res*10+x%10;
            x/=10;
        }
        if(res>2147483647||res<-2147483648)
            return 0;
        return  (int)res;
    }
}

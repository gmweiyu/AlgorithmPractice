package leetcode;

/**
 * Created by Weasley on 2017-03-20.
 */
public class Q50_Pow {
    public static void main(String[] args) {
        System.out.println(myPow(3,3));
    }

    public static double myPow(double x, int n){
        if(n==0)    return 1;
        if(n==1)    return x;
        return myPow(x,n/2)*myPow(x,n/2)*myPow(x,n%2);
    }
}

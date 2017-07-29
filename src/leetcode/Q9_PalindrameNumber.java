package leetcode;

/**
 * Created by Weasley on 2017-02-27.
 */
public class Q9_PalindrameNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }

    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x==0)
            return true;
        int aux=1000000000;
        while (x / aux == 0) {
            aux/=10;
        }

        while (x != 0) {
            int head=x/aux;
            int tail=x%10;
            if (head != tail) {
                return false;
            }
            x%=aux;
            aux/=100;
            x/=10;
        }
        return true;
    }
}

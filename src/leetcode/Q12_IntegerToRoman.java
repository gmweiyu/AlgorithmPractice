package leetcode;

/**
 * Created by Weasley on 2017-03-14.
 */
public class Q12_IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1437));
    }

    public static String intToRoman(int num) {
        char[][] chars={{'I','V','X'},
                        {'X','L','C'},
                        {'C','D','M'},
                        {'M','?','?'}};
        int index=0;
        String ans="";
        while (num != 0) {
            int aux=num%10;     //分离出每一位数字
            if(aux<=3){
                for(int i=1;i<=aux;i++)
                    ans=chars[index][0]+ans;
            } else if (aux == 4) {
                ans=chars[index][1]+ans;
                ans=chars[index][0]+ans;
            } else if (aux <= 8) {
                for (int i = 6; i <= aux; i++)
                    ans = chars[index][0]+ans;
                ans = chars[index][1]+ans;
            } else {
                ans=chars[index][2]+ans;
                ans=chars[index][0]+ans;
            }
            num/=10;
            index++;
        }
        return ans;
    }
}

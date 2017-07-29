package leetcode;

/**
 * Created by Weasley on 2017-03-17.
 */
public class Q38_CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(8));
    }

    public static String countAndSay(int n) {
        String str="1";
        for(int i=1;i<n;i++) {
            String aux="";
            int length=str.length(),times=0;
            for(int j=0;j<length;j++) {
                if(j==0||str.charAt(j)==str.charAt(j-1))
                    times++;        //统计次数
                else{
                    aux+=""+times+str.charAt(j-1);
                    times=1;        //刷新次数
                }
            }
            aux+=""+times+str.charAt(length-1);
            str=aux;        //更新
        }
        return str;
    }
}

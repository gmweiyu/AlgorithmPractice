package interview;

/**
 * Created by GuoWeiyu on 2017/08/09.
 * Description:
 * 题目1-翻转单词顺序：I am a student. --> student. a am I
 * 题目2-左旋转字符串
 */
public class Q58 {
    public static void main(String[] args) {
        String string = "I am a student.";
        System.out.println(reverse(string));

        String string2 = "abcdefg";
        System.out.println(reverse(string2,2));
    }

    private static String reverse(String string) {
        if (string == null) {
            return null;
        }
        char[] arr=string.toCharArray();
        // 翻转整个字符串
        reverse(arr,0,arr.length-1);
        // 再翻转每个单词
        int start=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                reverse(arr,start,i-1);
                start=i+1;
            }
        }
        return String.valueOf(arr);
    }

    private static String reverse(String string, int n) {
        if (string == null) {
            return null;
        }
        n%=string.length();
        char[] arr=string.toCharArray();
        reverse(arr,0,n-1);
        reverse(arr,n,arr.length-1);
        reverse(arr,0,arr.length-1);
        return String.valueOf(arr);
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}

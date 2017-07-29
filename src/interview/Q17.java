package interview;

/**
 * Created by GuoWeiyu on 2017/07/27.
 * Description:
 */
public class Q17 {
    public static void main(String[] args) {
        int n=2;
        char[] arr = new char[n + 1];

        // 模拟
//        print(arr,n);

        //全排列
        for (int i = 0; i < 10; i++) {
            arr[0] = (char) ('0' + i);
            permutation(0,n,arr);
        }

    }

    /**
     * 模拟整数加法
     * @param n
     */
    private static void print(char[] arr,int n) {
        for (int i = 0; i <= n; i++) {
            arr[i]='0';
        }
        arr[n]='1';
        while (arr[0] != '1') {
            format(arr);
            if (arr[n] == '9') {
                arr[n] = '0';
            } else {
                arr[n]++;
            }
            carry(arr);
        }
    }

    private static void carry(char[] arr) {
        int index=arr.length-1;
        while (arr[index] == '0') {
            index--;
            if (arr[index] == '9') {
                arr[index] = '0';
            } else {
                arr[index]++;
            }
        }
    }

    private static void format(char[] arr) {
        boolean flag=false;     //第一个非0元素
        for (int i = 0; i < arr.length; i++) {
            if (!flag && arr[i] != '0') {
                flag=true;
            }
            if (flag) {
                System.out.print(arr[i]);
            }
        }
        System.out.println();
    }

    /**
     * 使用全排列打印
     */
    private static void permutation(int index,int n,char[] arr) {
        if (index == n-1) {
            format(arr);
            return;
        }

        for (int i = 0; i < 10; i++) {
            arr[index+1]= (char) ('0'+i);
            permutation(index+1,n,arr);
        }
    }
}

package interview;

/**
 * Created by GuoWeiyu on 2017/07/26.
 * Description: 统计二进制中1的数目
 */
public class Q15 {
    public static void main(String[] args) {
        int num=1000;
        System.out.println(count(num));
        System.out.println(optimize(num));
    }

    private static int count(int num) {
        int count=0;
        int flag=1;
        while (flag != 0) {
            if ((num & flag) != 0) {
                count++;
            }
            flag=flag<<1;
        }
        return count;
    }

    private static int optimize(int num) {
        int count=0;
        while (num != 0) {
            count++;
            num=(num-1)&num;
        }
        return count;
    }
}

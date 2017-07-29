package leetcode;

/**
 * Created by Weasley on 2017-03-16.
 */
public class Q29_DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide_2(1,-1));
    }

    /**
     * 暴力解，超时
     */
    public static int divide(int dividend, int divisor) {
        //当divisor=MIN_INT,即-2147483648,-divisor会溢出,使用long long
        long a=dividend>0?dividend:-(long)dividend;
        long b=divisor>0?divisor:-(long)divisor;
        boolean flag=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
        //当dividend=MIN_INT,divisor=-1,结果会溢出
        long result=0;
        while (a >= b) {
            a-=b;
            result++;
        }
        if(flag)
            return result>2147483647?2147483647: (int) result;
        else
            return result>2147483648l?-2147483648: (int) -result;
    }

    /**
     * 暴力解的优化，每次将除数翻倍，加速计算
     */
    public static int divide_2(int dividend, int divisor) {
        //当divisor=MIN_INT,即-2147483648,-divisor会溢出,使用long long
        long a=dividend>0?dividend:-(long)dividend;
        long b=divisor>0?divisor:-(long)divisor;
        boolean flag=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
        //当dividend=MIN_INT,divisor=-1,结果会溢出
        long result=0;
        while (a >= b) {
            long c=b;       //c为临时除数
            for(int i=0;a>=c;i++,c<<=1) {
                a-=c;
                i<<=1;
                result+=i;
            }
        }
        if(flag)
            return result>2147483647?2147483647: (int) result;
        else
            return result>2147483648L?-2147483648: (int) -result;
    }
}

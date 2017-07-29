package leetcode;

/**
 * Created by Weasley on 2017-03-07.
 */
public class Q8_StringToInteger {
    public static void main(String[] args) {
        String str = "  -2147483649";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String str) {
        char[] arr=str.toCharArray();
        int n=arr.length;
        final int MAX_INT=2147483647,MIN_INT=-2147483648;
        int index=0;        //遍历数组时的索引
        int sign=1;     //标记为正负数1/-1
        int ans=0;      //最后的结果

        if(arr.length==0)       //处理空字符串""
            return 0;

        //找到第一次不为' '开头的字符
        while(arr[index]==' '&&index<n)
            index++;
        //判断是否为正负号
        if(arr[index]=='-'){
            sign=-1;
            index++;
        }else if(arr[index]=='+')
            index++;

        for(;index<n;index++) {
            //1：以非正负号或数字开头
            //2：正负号后面没有接数字---返回0
            if(arr[index]>'9'||arr[index]<'0')
                break;

            //判断数字是否越界：两种情况
            if(ans>MAX_INT/10||
                    (ans==MAX_INT/10&&arr[index]-'0'>MAX_INT%10))
                return sign==-1?MIN_INT:MAX_INT;

            //更新ans的值
            ans=ans*10+(arr[index]-'0');
        }

        return sign*ans;
    }

    public static int myAtoi_2(String str) {
        char[] arr=str.toCharArray();
        boolean startWithNumber=false;       //是否遇见数字
        int flags=0;        //数字前正负号的数目
        int i=0;
        int flagIndex=0;
        boolean minus=false;        //负数
        for(;i<arr.length;i++) {
            if (arr[i] == ' ') {
                continue;
            } else if ((arr[i] == '-' || arr[i] == '+')) {
                flagIndex=i;
                flags++;
                minus=arr[i]=='+'?false:true;
                continue;
            } else if (arr[i] >= '0' && arr[i] <= '9') {
                startWithNumber=true;
            }
            break;
        }
        if (flags > 1 || !startWithNumber) {
            return 0;
        }

        if (flags==1&&flagIndex + 1 < arr.length&&arr[flagIndex+1]==' ') {
            return 0;
        }

        long ans=0;
        int bits=0;
        for(;i<arr.length;i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                bits++;
                ans = ans * 10 + (arr[i] - 48);
            } else {
                break;
            }
        }

        ans=minus?-ans:ans;

        if(bits>10){
            return minus?-2147483648:2147483647;
        }

        if(ans>2147483647)
            return 2147483647;
        else if (ans<-2147483648)
            return -2147483648;
        return (int) ans;
    }


}
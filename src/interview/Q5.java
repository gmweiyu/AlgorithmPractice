package interview;

/**
 * Created by GuoWeiyu on 2017-05-05.
 * 替换空格
 */
public class Q5 {
    public static void main(String[] args) {
        String str="  a";
        replace(str);
    }

    private static void replace(String str) {
        if(str==null||str.length()==0)  return;
        int spaceCount=0;
        char[] src=str.toCharArray();
        for(int i=0;i<str.length();i++)
            if(src[i]==' ') spaceCount++;       //计算空格，进而计算数组大小

        char[] des=new char[src.length+spaceCount*2];
        int p1=src.length-1,p2=des.length-1;        //两个指针分别指向src、des的最后一个单元
        while (p1>=0&&p2>=0) {
            if(src[p1]!=' ')    des[p2--]=src[p1--];
            else{
                des[p2--]='0';
                des[p2--]='2';
                des[p2--]='%';
                p1--;
            }
        }
        System.out.println(String.valueOf(des));
    }
}

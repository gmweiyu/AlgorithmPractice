package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weasley on 2017-04-06.
 */
public class Q93_RestoreIPAddresses {
    public static void main(String[] args) {
        String s="0000";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        if(s==null) return ans;
        for(int i=0;i<=2;i++){
            dfs(0,i,0,"",ans,s);
        }
        return ans;
    }

    private static void dfs(int start,int inc,int count,String temp,List<String> ans,String s){
        if(count>3||(start+inc)>s.length()-1){      //不合法，剪枝
            return;
        }
        if(!isValid(start,start+inc,s)){      //不合法，剪枝
            return;
        }
        if(count==3&&(start+inc)==s.length()-1){       //已经分为4段，且刚好分完
            ans.add(temp+"."+s.substring(start,start+inc+1));
            return;
        }
        if(count==0)    temp+=s.substring(start,start+inc+1);
        else            temp+="."+s.substring(start,start+inc+1);
        for(int i=0;i<=2;i++){  //每一段占1-3位
            dfs(start+inc+1,i,count+1,temp,ans,s);
        }
    }
    //判断组成的数字是否合法
    private static boolean isValid(int start,int end,String s){
        String t=s.substring(start,end+1);
        if(t.charAt(0)=='0'&&t.length()>1)      //除了0本身，首字符不能为0
            return false;
        int num=Integer.parseInt(t);
        if(num<0||num>255)
            return false;
        return true;
    }
}

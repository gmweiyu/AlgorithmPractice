package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Weasley on 2017-04-03.
 */
public class Q127_WordLadder {
    public static void main(String[] args) {
        String beginWord="hit";
        String endWord="cog";
        List<String> wordList=new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord==null || endWord==null || beginWord.length()==0 || endWord.length()==0 ||
                beginWord.length()!=endWord.length())
            return 0;

        int level=1;        //遍历的层数，即经过了几个单词
        int lastNum=1;     //上一层未遍历的结点
        int curNum=0;       //当前层未遍历的结点，当上一层==0时，说明遍历完成，进入下一层
        LinkedList<String> queue=new LinkedList<>();
        HashSet<String> path=new HashSet<>();
        queue.offer(beginWord);     //加入队列
        path.add(beginWord);        //加入轨迹
        while (!queue.isEmpty()) {
            String cur=queue.poll();        //取出队头元素
            lastNum--;      //上一层未遍历的数目减1
            for(int i=0;i<cur.length();i++) {
                char[] arr=cur.toCharArray();
                for(char c='a';c<='z';c++) {        //搜寻每一个单词，仅一个字母不同
                    arr[i]=c;
                    String str=new String(arr);
                    if (str.equals(endWord)&&wordList.contains(endWord)) {      //搜寻终止，退出
                        return level+1;
                    }
                    //存在与wordList，且未使用过
                    if(wordList.contains(str)&&!path.contains(str)){
                        path.add(str);
                        queue.offer(str);
                        curNum++;       //当前层的数目+1
                    }
                }
            }
            if (lastNum == 0) {     //进入下一层
                lastNum=curNum;
                curNum=0;
                level++;
            }
        }
        return 0;
    }
}

package siflo.dialy;

import java.util.HashSet;

public class LengthOfLongestSubString {

  public int lofs(String s){
    HashSet<Character> set = new HashSet<>();
    int maxC = 0;
    int i=0,j=0;
    while(i<s.length()&&j<s.length()){
      if(!set.contains(s.charAt(j))){
        //不包含当前的
        set.add(s.charAt(j++));
        maxC = Math.max(j-i,maxC);
      }else {
        //包含，所以有重复，那么删掉当前I的元素
       set.remove(s.charAt(i++));
      }
    }
    return maxC;
  }
}

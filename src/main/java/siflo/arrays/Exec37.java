package siflo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Exec37 {
  private static Map<String, List<String>>  stateMachine = new HashMap<>();
  static {

//    stateMachine.put("start",List.of(new String[]{"start","signed","in_number","end"}));
//    stateMachine.put("signed",List.of(new String[]{"end","end","in_number","end"}));
//    stateMachine.put("in_number",List.of(new String[]{"end","end","in_number","end"}));
//    stateMachine.put("end",List.of(new String[]{"end","end","end","end"}));
  }
  static int getInputType(char c){
    switch (c){
      case 32:
        return 0;
      case '+':
      case '-':
        return 1;
      default:
        if(Character.isDigit(c))
          return 2;
        else
          return 3;
    }
  }
  public static int myAtoi(String str) {
    String state="start";
    int ans=0;
    int sign = 1;
    char[] chars = str.toCharArray();
    for(char c: chars){
      int type = getInputType(c);
      state = stateMachine.get(state).get(type);
      if(state.equals("signed"))
        sign = c=='-'?-1:1;
      else if(state.equals("in_number")) {
        int gap = c-'0';
        if(ans>(Integer.MAX_VALUE-gap)/10)
          return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
        ans = ans*10+gap;
      }
    }

    return ans*sign;

  }

  public static void main(String[] args) {
    String[] ss = {""};
    Arrays.sort(ss);

   System.out.println( myAtoi(" +123"));
  }
}

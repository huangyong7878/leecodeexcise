package siflo.dialy;

import java.util.HashMap;
import java.util.HashSet;

public class RandomSort {

  static String random(String a){
    char[] cs = a.toCharArray();
    int[] acs = new int[256];
    for(char ch:cs){
      acs[ch] = acs[ch]+1;
    }
    StringBuilder sb = new StringBuilder();
    HashMap<Integer,Integer> bigChars = new HashMap<>();

    for(int i=0;i<=255;i++){
      if(i>='A'&&i<='Z')
      {
        //upper
        if(acs[i]!=0&&acs[i+32]!=0){
          bigChars.put(i,acs[i]);
          continue;
        }
      }
      for(int j=0;j<acs[i];j++) {

        sb.append((char)i);
        if(bigChars.containsKey(i-32)){
          int bi =bigChars.get(i-32);
          for(int bb=0;bb<bi;bb++)
            sb.append((char) (i-32));
        }
      }

    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String a = "gHhbDDzzFFGeesseghjklopacdefg";
    System.out.println(random(a));
  }
}

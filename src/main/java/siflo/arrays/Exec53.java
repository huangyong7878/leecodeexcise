package siflo.arrays;

public class Exec53 {
  public boolean isBadVersion(int n){
    return true;
  }

  public int firstBadVersion(int n) {
    int l=1,h=n;
    while(l<h){
      //java 里面容易溢出
      int middle = l+(h-l)/2;
      if(isBadVersion(middle)){
        //这个地方也是陷阱啊，要这么想如果找不到更低的，
        h= middle;
      }
      else
        l = middle + 1;
    }
    return l;
  }
}

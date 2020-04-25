package siflo.arrays;

public class Exec36 {

  static boolean isVaChar(char c) {
    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
      return true;
    }
    return false;
  }

  static boolean isAlaphbet(char c) {
    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
      return true;
    }
    return false;
  }

  static boolean isEqual(char c1, char c2) {
    int d = c2 - c1;
    if (d == 0) {
      return true;
    }
    if (Math.abs(d) == 32 && isAlaphbet(c1) && isAlaphbet(c2)) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean isPalindrome(String s) {
    char[] ch = s.toLowerCase().toCharArray();
    if (ch.length == 0) {
      return true;
    }
    int low = 0, high = ch.length - 1;

    while (low <= high) {
      char l = ch[low];
      char h = ch[high];
      if (!Character.isLetterOrDigit(l)) {
        low++;
      } else if (!Character.isLetterOrDigit(h)) {
        high--;
      } else {
        if (l!=h) {
          return false;
        }
        low++;
        high--;
      }


    }
    return true;

  }

  public static void main(String[] args) {

    System.out.println(isPalindrome("a A"));
  }
}

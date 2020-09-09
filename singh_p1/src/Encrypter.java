import java.util.Scanner;
import java.util.Arrays;

public class Encrypter {
  private String encrypt(String plaintext) {
    int[] arr = stringToIntArray(plaintext);

    for(int i = 0; i < arr.length; i++)
      arr[i] = (arr[i] + 7) % 10;
    arr = swap(arr);
    return Arrays.toString(arr);
  }
  private int[] swap(int[] arr) {
    int temp;
    for(int i = 0; i + 2 < arr.length; i++) {
      temp = arr[i];
      arr[i] = arr[i + 2];
      arr[i + 2] = temp;
    }
    return arr;
  }
  private int[] stringToIntArray(String str) {
    int[] arr = new int[4];
    for(int i = 0; i < str.length(); i++)
      arr[i] = Integer.parseInt(str.substring(i, i + 1));
    return arr;
  }
  public static void main(String[] args){
    Encrypter e = new Encrypter();
    Scanner in = new Scanner(System.in);
    String str = in.next();
    System.out.println("Plaintext: " + str);
    System.out.println("Ciphertext: " + e.encrypt(str));
    in.close();
  }
}

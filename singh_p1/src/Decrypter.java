public class Decrypter {
  public String decrypt(String ciphertext) {
    int[] arr = stringToIntArray(ciphertext);

    for(int i = 0; i < arr.length; i++) {
      arr[i] = (arr[i] - 7 + 10) % 10;
    }

    swap(arr);

    return toString(arr);
  }

  private void swap(int[] arr) {
    int temp;
    for(int i = 0; i + 2 < arr.length; i++) {
      temp = arr[i];
      arr[i] = arr[i + 2];
      arr[i + 2] = temp;
    }
  }

  private int[] stringToIntArray(String str) {
    int[] arr = new int[str.length()];
    for(int i = 0; i < str.length(); i++)
      arr[i] = Integer.parseInt(str.substring(i, i + 1));
    return arr;
  }

  private String toString(int[] arr) {
    String str = "";
    for(int i : arr)
      str = str + i;
    return str;
  }
}

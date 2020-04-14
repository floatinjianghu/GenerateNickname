import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sc.useDelimiter("\n");
    int[] nums = new int[6];
    System.out.println("the year you are born: ");
    nums[0]=sc.nextInt();
    System.out.println("the month you are born: ");
    nums[1]=sc.nextInt();
    System.out.println("the day you are born: ");
    nums[2]=sc.nextInt();
    System.out.println("which number is your favorite number: ");
    nums[3]=sc.nextInt();
    System.out.println("input a random number at this moment: ");
    nums[4]=sc.nextInt();
    nums[5] = (int) Math.random();
    Dictionary dic = Dictionary.getDictionary();
    String nickname = dic.getNickName(nums);
    System.out.println("nickname: " + nickname);
  }
}
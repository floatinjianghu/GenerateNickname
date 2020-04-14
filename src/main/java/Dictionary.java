import java.io.*;

public class Dictionary {
  private static String[] p;
  private static String[] n;
  private static volatile Dictionary dic = null;
  private static String filep = "src\\main\\resources\\p.txt";
  private static String filen = "src\\main\\resources\\n.txt";

  private Dictionary() {
    p = readToString(filep).split("\n");
    n = readToString(filen).split("\n");
  }

  public static Dictionary getDictionary() {
    if (dic == null) {
      // 相对于简单懒汉式在方法上加锁，在代码块加锁可以提高效率
      synchronized (Dictionary.class) {
        if (dic == null) {
          dic = new Dictionary();
        }
      }
    }
    return dic;
  }

  public static String getNickName(int[] nums) {
    int p_len = p.length;
    int n_len = n.length;
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 6; i++) {
      int random = (int)(Math.random()*1000);
      if (random%2== nums[i]%2) {
        if (i != 5) {
          int index=(random+nums[i])%p_len;
          sb.append(p[index]);
        }else {
          int index=(random+nums[i])%n_len;
          sb.append(n[index]);
        }
      }
    }
    return sb.toString();
  }
  // 将文件内容存入String
  private static String readToString(String fileName) {
    String encoding = "UTF-8";
    File file = new File(fileName);
    Long fileLength = file.length();
    byte[] fileContent = new byte[fileLength.intValue()];
    try {
      FileInputStream in = new FileInputStream(file);
      in.read(fileContent);
      in.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      return new String(fileContent, encoding);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return null;
    }
  }
}
package org.ayuan.util.file;

/**
 * description: 文件工具
 *
 * @date: 2024/1/10 17:23
 * @author: aYuan
 */
public class FileUtils {

  private FileUtils() {
  }

  /**
   * 将字符串路径中的一个或者连续几个的反斜杠统一替换为Linux斜杠，并返回一个新结果
   * @param inputPath 待转换路径
   * @return 转换后的结果
   */
  public static String replacePathSep2Linux(String inputPath){
    return inputPath.replaceAll("\\\\+","/");
  }

  public static void main(String[] args) {
    String inputPath = "D:\\\\\\";
    System.out.println(replacePathSep2Linux(inputPath));
  }
}

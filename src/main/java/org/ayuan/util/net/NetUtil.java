package org.ayuan.util.net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * description: TODO
 *
 * @date: 2024/1/15 15:32
 * @author: aYuan
 */
public class NetUtil {
  private NetUtil(){}

  /**
   * 获取当前设备的ip地址
   */
  public static List<String> getAllIpAddr(){
    List<String> ipList = new ArrayList<>();
    try {
      // 获取所有网络接口
      Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
      InetAddress ip = null;
      while (networkInterfaces.hasMoreElements()) {
        NetworkInterface netInterface = networkInterfaces.nextElement();
        if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
          continue;
        } else {
          Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
          while (addresses.hasMoreElements()) {
            ip = addresses.nextElement();
            if (ip instanceof Inet4Address) {
              ipList.add(ip.getHostAddress());
            }
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return ipList;
  }

  public static void main(String[] args) {
    System.out.println(getAllIpAddr());
  }

}

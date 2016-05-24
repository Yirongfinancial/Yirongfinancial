package com.edu.zzti.yirongfinancial.syw;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by syw on 2016/5/24.
 */
public class Syw_qiniunet_activity {
    public static final String netLoadPath = "data/data/com.edu.zzti.yirongfinancial.syw/netLoad.properties";
    public static final String downUrl = "http://7xu2vf.com1.z0.glb.clouddn.com/netLoad.properties";


    //逻辑判断
    public static boolean netDoadIsWork() {
        //首先判断文件是否存在,如果存在去七牛上面下载
        if (downExits()) {
            if (connectWithHttpURLConnection()) {
                return true;
            } else {
                return false;
            }
        } else {
           return  false;
        }

    }

    //判断文件是否存在
    private static boolean downExits() {
        File file = new File(netLoadPath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
    // 以下代码实现了以GET方式发起HTTP请求
    // 连接网络是耗时操作，一般新建线程进行
    //下载文件
    private static boolean connectWithHttpURLConnection() {

                HttpURLConnection connection = null;
                try {
                    // 调用URL对象的openConnection方法获取HttpURLConnection的实例
                    URL url = new URL(downUrl);
                    connection = (HttpURLConnection) url.openConnection();
                    // 设置请求方式，GET或POST
                    connection.setRequestMethod("GET");
                    // 设置连接超时、读取超时的时间，单位为毫秒（ms）
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    if (connection.getResponseCode() == 200) {
                        // getInputStream方法获取服务器返回的输入流
                        InputStream in = connection.getInputStream();
                        File file = new File(netLoadPath);
                        FileOutputStream fos = new FileOutputStream(file);
                        int len = 0;
                        byte[] b = new byte[1024];
                        while ((len = in.read(b))>0) {
                            fos.write(b, 0, len);
                        }
                        fos.close();
                        in.close();
                        return true;
                        // 此处省略处理数据的代码
                        // 若需要更新UI，需将数据传回主线程，具体可搜索android多线程编程

                    }
                }
                catch (Exception e) {

                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        // 结束后，关闭连接
                        connection.disconnect();

                    }

                }



       return  false;
    }


}


























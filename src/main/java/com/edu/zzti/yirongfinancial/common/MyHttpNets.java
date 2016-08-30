package com.edu.zzti.yirongfinancial.common;

import android.os.Message;
import android.os.SystemClock;
import android.util.Xml;

import com.edu.zzti.yirongfinancial.entity.Nets;
import com.edu.zzti.yirongfinancial.wf.Wf_login_activity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MyHttpNets {

    private static String downPath = "http://7xu2vf.com1.z0.glb.clouddn.com/nets.xml";//下载的目标路径
    private static String upPath = "http://7xu2vf.com1.z0.glb.clouddn.com/";//上传的路径

    private static String netsSavaPath = "data/data/com.edu.zzti.yirongfinancial.syw";//用户保存的路径
    private static String netsSavaName = "nets";//保存的名字

    private static String netSavaPath = "data/data/com.edu.zzti.yirongfinancial.syw";
    private static String netSavaName = "net";

    private static boolean b = false;

    //读取网址的信息
    public static List<Nets> readNets() {

        List<Nets> netList = new ArrayList<Nets>();//定义一个集合用于存网址的信息

        //如果文件存在
        if (new File(netSavaPath, netSavaName + ".xml").exists()) {

            Message msg = new Message();

            msg.arg1 = 1;

            Wf_login_activity.handler.sendMessage(msg);//通知界面发信息

            netList = readXML(netSavaName);//读取xml信息

        }

        //如果文件不存在
        else {
               //下载文件
            if (downNets()) {

                netList = readXML(netsSavaName);

            }

        }

        return netList;

    }
    //读取xml文件
    public static List<Nets> readXML(String xmlName) {

        List<Nets> netList = new ArrayList<Nets>();
        //解析ML文件
        XmlPullParser parser = Xml.newPullParser();

        try {

            FileInputStream in = new FileInputStream(new File(netsSavaPath, xmlName + ".xml"));
            parser.setInput(in, "utf-8");
            int type = parser.getEventType();
            Nets net = null;

            while (type != XmlPullParser.END_DOCUMENT) {

                switch (type) {
                    case XmlPullParser.START_TAG:

                        if ("net".equals(parser.getName())) {

                            net = new Nets();

                        } else if ("title".equals(parser.getName())) {

                            net.setTitle(parser.nextText());

                        } else if ("net".equals(parser.getName())) {

                            net.setNet(parser.nextText());

                        }
                        break;

                    case XmlPullParser.END_TAG:

                        if ("net".equals(parser.getName())) {

                            netList.add(net);

                        }

                }

                type = parser.next();

            }

            in.close();
            return netList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return netList;

    }


   //从官网下载
    private static boolean downNets() {
        try {

            URL url = new URL(downPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(3000);
            if (conn.getResponseCode() == 200) {
                InputStream in = conn.getInputStream();
                File usersSavaFile = new File(netsSavaPath, netsSavaName + ".xml");
                FileOutputStream fos = new FileOutputStream(usersSavaFile);
                int len = -1;
                byte[] buffer = new byte[100];
                while ((len = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }

                fos.close();
                in.close();
                return true;

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        return false;

    }

}
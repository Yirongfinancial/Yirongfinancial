package com.edu.zzti.yirongfinancial.wf;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyHttp {

    private static String downPath = "http://7xu2vf.com1.z0.glb.clouddn.com/users.xml";
    private static String usersSavaPath = "data/data/com.edu.zzti.yirongfinancial.syw";
    private static String usersSavaName = "users.xml";

    private static String userSavaPath = "data/data/com.edu.zzti.yirongfinancial.syw";
    private static String userSavaName = "user.xml";

    public static List<User> readUsers() {

        List<User> userList = new ArrayList<User>();

        return userList;

    }

    private static List<User> readXML() {

        List<User> userList = new ArrayList<User>();

        return userList;

    }

    public static boolean saveUserSp() {

        return false;

    }

    private static boolean downUsers() {

        try {

            URL url = new URL(downPath);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setConnectTimeout(3000);

            if (conn.getResponseCode() == 200) {

                InputStream in = conn.getInputStream();

                File usersSavaFile = new File(usersSavaPath, usersSavaName);

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
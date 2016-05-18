package com.edu.zzti.yirongfinancial.common;

import android.os.Message;
import android.util.Xml;

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

public class MyHttp {

    private static String downPath = "http://7xu2vf.com1.z0.glb.clouddn.com/users.xml";
    private static String upPath = "http://7xu2vf.com1.z0.glb.clouddn.com/";

    private static String usersSavaPath = "data/data/com.edu.zzti.yirongfinancial.syw";
    private static String usersSavaName = "users.xml";

    private static String userSavaPath = "data/data/com.edu.zzti.yirongfinancial.syw";
    private static String userSavaName = "user.xml";

    public static List<User> readUsers() {

        List<User> userList = new ArrayList<User>();

        if (new File(userSavaPath, userSavaName).exists()) {

            Message msg = new Message();

            msg.arg1 = 1;

            Wf_login_activity.handler.sendMessage(msg);

            userList = readXML(userSavaName);

        } else {

            if (downUsers()) {

                userList = readXML(usersSavaName);

            }

        }

        return userList;

    }

    private static List<User> readXML(String xmlName) {

        List<User> userList = new ArrayList<User>();

        XmlPullParser parser = Xml.newPullParser();

        try {

            FileInputStream in = new FileInputStream(new File(usersSavaPath,
                    xmlName));

            parser.setInput(in, "utf-8");

            int type = parser.getEventType();

            User user = null;

            while (type != XmlPullParser.END_DOCUMENT) {

                switch (type) {
                    case XmlPullParser.START_TAG:

                        if ("user".equals(parser.getName())) {

                            user = new User();

                        } else if ("imei".equals(parser.getName())) {

                            user.setImei(parser.nextText());

                        } else if ("name".equals(parser.getName())) {

                            user.setName(parser.nextText());

                        } else if ("pass".equals(parser.getName())) {

                            user.setPass(parser.nextText());

                        }

                        break;

                    case XmlPullParser.END_TAG:

                        if ("user".equals(parser.getName())) {

                            userList.add(user);

                        }

                }

                type = parser.next();

            }

            in.close();

            return userList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;

    }

    public static boolean saveUser(String imei, String name, String pass) {

        XmlSerializer serializer = Xml.newSerializer();

        try {

            FileOutputStream fos = new FileOutputStream(new File(userSavaPath,
                    userSavaName));

            serializer.setOutput(fos, "utf-8");

            serializer.startDocument("utf-8", true);

            serializer.startTag(null, "users");

            serializer.startTag(null, "user");

            serializer.startTag(null, "imei");
            serializer.text(imei);
            serializer.endTag(null, "imei");

            serializer.startTag(null, "name");
            serializer.text(name);
            serializer.endTag(null, "name");

            serializer.startTag(null, "pass");
            serializer.text(pass);
            serializer.endTag(null, "pass");

            serializer.endTag(null, "user");

            serializer.endTag(null, "users");

            serializer.endDocument();

            fos.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public static boolean isExists(String name) {

        try {

            HttpURLConnection conn = (HttpURLConnection) new URL(upPath + name + ".txt").openConnection();

            conn.setConnectTimeout(3000);

            if (conn.getResponseCode() == 200) {

                return true;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

}
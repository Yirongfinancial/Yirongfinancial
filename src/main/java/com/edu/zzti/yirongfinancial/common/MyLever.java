package com.edu.zzti.yirongfinancial.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wangfei on 16/5/22.
 */
public class MyLever {

    public static final String LEVERPATH = "data/data/com.edu.zzti.yirongfinancial.syw/lever.xml";

    public static boolean toLeverOk() {

        if (!leverExists()) {

            if (downLever()) {

                if (isLever()) {

                    return true;

                } else {

                    return false;

                }

            } else {

                return false;

            }

        } else {

            if (isLever()) {

                return true;

            } else {

                return false;

            }

        }

    }

    private static boolean isLever() {

        try {

            URL url = new URL("http://7xu2vf.com1.z0.glb.clouddn.com/lever.xml");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setConnectTimeout(3000);

            if (conn.getResponseCode() == 200) {

                File file = new File(LEVERPATH);

                InputStream in = conn.getInputStream();

                int len = -1;
                byte[] b = new byte[1];
                long length = 0;

                while ((len = in.read(b)) != -1) {

                    length += 1;

                }

                in.close();

                if (file.length() == length) {

                    return true;

                } else {

                    return false;

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

    public static boolean downLever() {

        try {

            URL url = new URL("http://7xu2vf.com1.z0.glb.clouddn.com/lever.xml");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setConnectTimeout(3000);

            if (conn.getResponseCode() == 200) {

                InputStream in = conn.getInputStream();

                File file = new File(LEVERPATH);

                FileOutputStream fos = new FileOutputStream(file);

                int len = -1;
                byte[] b = new byte[10];

                while ((len = in.read(b)) != -1) {

                    fos.write(b, 0, len);

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

    private static boolean leverExists() {

        File file = new File(LEVERPATH);

        if (file.exists()) {

            return true;

        }

        return false;

    }

}

package com.edu.zzti.yirongfinancial.wf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class MyHttp {

	private static String userGetPath = "http://7xu2vf.com1.z0.glb.clouddn.com/users.xml";
	private static String userSavaPath = "/data/data/com.edu.zzti.yirongfinancial.syw";
	private static String userSaveName = "users.xml";

	private static List<User> userList;
	private static User user;

	public static List<User> readUser(String imei) {

		userList = new ArrayList<User>();

		XmlPullParser parser = Xml.newPullParser();

		File file = new File(userSavaPath, userSaveName);

		try {

			FileInputStream in = new FileInputStream(file);

			parser.setInput(in, "utf-8");

			int type = parser.getEventType();

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

					break;

				}

				type = parser.next();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;

	}

	public static void upUser(URL url) {

	}

	public static boolean getUser() {

		File file = new File(userSavaPath, userSaveName);

		if (file.exists()) {

			try {

				URL url = new URL(userGetPath);

				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();

				conn.setConnectTimeout(5000);

				if (conn.getResponseCode() == 200) {

					InputStream in = conn.getInputStream();

					FileOutputStream fos = new FileOutputStream(file);

					int len = -1;
					byte[] buffer = new byte[100];

					while ((len = in.read(buffer)) != -1) {

						fos.write(buffer, 0, len);

					}

					in.close();
					fos.close();

					return true;

				}

			} catch (Exception e) {
				e.printStackTrace();

				return false;

			}

			return false;

		} else {

			return true;

		}

	}
}

package com.edu.zzti.yirongfinancial.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.Context;
import android.telephony.TelephonyManager;

public class MyUtils {

	public static String getIMEI(Context context) {

		String imei = null;

		TelephonyManager tpm = (TelephonyManager) context
				.getSystemService(context.TELEPHONY_SERVICE);

		imei = tpm.getDeviceId();

		return imei;

	}

	public static StringBuffer getMD5(String password) {

		MessageDigest md5 = null;

		try {

			md5 = MessageDigest.getInstance("MD5");

			md5.update(password.getBytes());

			byte[] bytes = md5.digest();

			StringBuffer sb = new StringBuffer();

			for (byte b : bytes) {

				sb.append(b);

			}

			return sb;

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

			return null;

		}

	}

}

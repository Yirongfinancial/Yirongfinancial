package com.edu.zzti.yirongfinancial.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetWork {
	//网络状态 
	public static boolean isNetWorkConnected(Context context){
		if(context != null){
			ConnectivityManager connManager = (ConnectivityManager)
					context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo netInfo = connManager.getActiveNetworkInfo();
			
			if(netInfo != null)
				return netInfo.isAvailable();
		}
		return false;
	}
}

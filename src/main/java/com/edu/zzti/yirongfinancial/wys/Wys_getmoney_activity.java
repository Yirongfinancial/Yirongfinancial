package com.edu.zzti.yirongfinancial.wys;

import java.util.Timer;
import java.util.TimerTask;

import com.edu.zzti.yirongfinancial.common.CommonWebView;
import com.edu.zzti.yirongfinancial.common.CommonWebView;
import com.edu.zzti.yirongfinancial.syw.R;
import com.edu.zzti.yirongfinancial.wf.Wf_main_activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;



public class Wys_getmoney_activity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.wys_getmoney_activity);
	}

	public void click1_1(View v) {
		Intent intent = new Intent(this,CommonWebView.class);
		intent.putExtra("url", "https://wap.cgbchina.com.cn/mbChangeLimits.do?seqno=0D1xfRUTwdfPuvpst-eycQS44BBb9B_11419BmB94&from=singlemessage&isappinstalled=0");
		intent.putExtra("title", "广发提额");
		startActivity(intent);

	}

	public void click1_2(View v) {
		Intent intent = new Intent(this,CommonWebView.class);
		intent.putExtra("url", "https://xyk.cmbchina.com/login?WT.mc_inner_id=&timestamp=1462010353934&nickname=xRncN2L0EIr5Y5LDpfz8F00tAo2tgVnOaKYdXielDiw=&state=TxRbr8+VhbmFDpZhyyxAbg==&headimgurl=516LM5oktRsbqCHxivT5242eZk8V4u+Hy6jq1ejbiiHFVKEUytjKmU/Wz5mvbhab0errFqswIAKlIDnjOH9ObnOrwe+X2r+cKl0PcCulSygz3tX23mvdE3c5NmBci9RifXlnffZz09hXqXjMy8nrqWENbdIlf1TAgrOySJr0SXA=&channel=WeiXin&signature=e82a391312");
		intent.putExtra("title", "招商提额");
		startActivity(intent);

	}

	public void click1_3(View v) {
		Intent intent = new Intent(this,CommonWebView.class);
		intent.putExtra("url", "https://www.citibank.com.cn/sim/ICARD/creditincrease.htm");
		intent.putExtra("title", "花旗提额");
		startActivity(intent);

	}

	public void click2_1(View v) {
		Intent intent = new Intent(this,CommonWebView.class);
		intent.putExtra("url", "https://creditcardapp.bankcomm.com/idm/sso/login.html?service=https://creditcardapp.bankcomm.com/mdb/shiro-cas#");
		intent.putExtra("title", "交通提额");
		startActivity(intent);

	}

	public void click2_2(View v) {
		Intent intent = new Intent(this,CommonWebView.class);
		intent.putExtra("url", "https://creditcard.ecitic.com/citiccard/cppnew/entry.do?func=entryebank&ebankPage=mainpage");
		intent.putExtra("title", "中信提额");
		startActivity(intent);

	}

	public void click2_3(View v) {
		Intent intent = new Intent(Wys_getmoney_activity.this,Wys_minshengtie_activity.class);
		startActivity(intent);
		

	}

	public void click3_1(View v) {
		Intent intent = new Intent(Wys_getmoney_activity.this,Wys_pufatie_activity.class);
		startActivity(intent);
		

	}

	public void click3_2(View v) {
		Intent intent = new Intent(Wys_getmoney_activity.this,Wys_guangdatie_activity.class);
		startActivity(intent);

	}

	public void click3_3(View v) {
		Intent intent = new Intent(Wys_getmoney_activity.this,Wys_pingantie_activity.class);
		startActivity(intent);

	}
	public void clickback(View v){
		
		finish();
	}
	public void click4_1(View v){
		Intent intent = new Intent(this,CommonWebView.class);
		intent.putExtra("url", "https://wx.abchina.com/WebSite/MultiBindingCardAct.ebf?openId=oHFX_jg1kW-PCQ6nmkDthlz5TBy8&appId=wx51fdf61c0de4ab0b&from=message&isappinstalled=0");
		intent.putExtra("title", "农业提额");
		startActivity(intent);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

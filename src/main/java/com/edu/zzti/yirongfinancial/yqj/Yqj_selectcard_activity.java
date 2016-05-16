package com.edu.zzti.yirongfinancial.yqj;



import java.io.ObjectOutputStream.PutField;

import com.edu.zzti.yirongfinancial.common.CommonWebView;
import com.edu.zzti.yirongfinancial.syw.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class Yqj_selectcard_activity extends Activity {
	private ImageView bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.yqj_selectcard_layout);
        bt1 = (ImageView) findViewById(R.id.bt_1);
        bt2 = (ImageView) findViewById(R.id.bt_2);
        bt3 = (ImageView) findViewById(R.id.bt_3);
        bt4 = (ImageView) findViewById(R.id.bt_4);
        bt5 = (ImageView) findViewById(R.id.bt_5);
        bt6 = (ImageView) findViewById(R.id.bt_6);
        bt7 = (ImageView) findViewById(R.id.bt_7);
        bt8 = (ImageView) findViewById(R.id.bt_8);
        bt9 = (ImageView) findViewById(R.id.bt_9);
        bt10 = (ImageView) findViewById(R.id.bt_10);
        bt11 = (ImageView) findViewById(R.id.bt_11); 
        bt12 = (ImageView) findViewById(R.id.bt_12);
        bt1.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "https://creditcard.ecitic.com/citiccard/wap/cardappquery/app_inq.jsp?main=1&left=1");
				intent.putExtra("title", "中信银行");
				startActivity(intent);
				
			}
		});
        bt2.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "http://xyk.cmbchina.com/LatteSubsite/app/wechat/jdcx.html");
				intent.putExtra("title", "招商银行");
				startActivity(intent);
			}
		});
        bt3.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "https://xyk.cebbank.com/cebmms/apply/fz/card-app-status.htm");
				intent.putExtra("title", "光大银行");
				startActivity(intent);
			}
		});
        bt4.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "https://3g.cib.com.cn/app/00282.html");
				intent.putExtra("title", "兴业银行");
				startActivity(intent);
			}
		});
        bt5.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "https://creditcardapp.bankcomm.com/member/apply/status/preinquiry.html?_channel=WC");
				intent.putExtra("title", "交通银行");
				startActivity(intent);
			}
		});
        bt6.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "https://card.bank-of-china.com/wechatebank/cardapply/list.do?openId=oWnN_jjljIiddWuXXVzaphrc14vw&authCode=DDD1A95663EA3096EE131414E22A6C3C4BE8E43A0C1BC40A0679B2660DB0D513CA6FF49ABECF37F398D2B466137DE64E");
				intent.putExtra("title", "中国银行");
				startActivity(intent);
			}
		});
        bt7.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "http://c.pingan.com/apply/newpublic/credit_card_query/index.html#index");
				intent.putExtra("title", "平安银行");
				startActivity(intent);
			}
		});
        bt8.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "https://creditcloud.hxb.com.cn/hxypt/CridetCardApplySchedule.do?_locale=zh_CN&LoginType=C");
				intent.putExtra("title", "华夏银行");
				startActivity(intent);
			}
		});
        bt9.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "https://ebanks.bankofshanghai.com/pweb/LogoutCreditApplyProQryPre.do?_locale=zh_CN");
				intent.putExtra("title", "上海银行");
				startActivity(intent);
			}
		});
        bt10.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "https://onlinepay.cupdata.com/weixin/apply.do?action=applyProgressInit&bankNum=6403&userId=o6y9OuEypJn4BgFDBYx6UvwF5byE");
				intent.putExtra("title", "北京银行");
				startActivity(intent);
			}
		});
        bt11.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "https://weixin.spdbccc.com.cn/spdbcccWeChatPage/applyProgress/applyProgress.jsp?page=index&noCheck=1");
				intent.putExtra("title", "浦发银行");
				startActivity(intent);
			}
		});
        bt12.setOnClickListener(new android.view.View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Yqj_selectcard_activity.this,CommonWebView.class);
				intent.putExtra("url", "http://wx.creditcard.cmbc.com.cn/wxbankms/creditGetProgresssSea");
				intent.putExtra("title", "民生银行");
				startActivity(intent);
			}
		});
         back = (ImageView) findViewById(R.id.bt_13);
	      back.setOnClickListener(new android.view.View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();	
			}
		});
    }

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

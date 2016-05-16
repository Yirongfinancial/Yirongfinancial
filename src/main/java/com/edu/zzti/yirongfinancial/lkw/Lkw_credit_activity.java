package com.edu.zzti.yirongfinancial.lkw;

import com.edu.zzti.yirongfinancial.common.CommonWebView;
import com.edu.zzti.yirongfinancial.syw.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * 
 * 我自定义了一个带返回按键弹出窗口提示的类Lkw_exit_activity 
 * 这个类已经继承Activity
 * 
 * 
 * 
 * */

public class Lkw_credit_activity extends Activity implements OnClickListener {
	private ImageView return_but;

	private TextView wf_main_textview_shouye;
	private ImageView mybg_imv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lkw_credit_activity);

	}

	// 调用onstart方法 在activity被启动时执行
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		return_but = (ImageView) findViewById(R.id.return_but);

		wf_main_textview_shouye = (TextView) findViewById(R.id.wf_main_textview_shouye);
		mybg_imv = (ImageView) findViewById(R.id.mybg_imv);

		return_but.setOnClickListener(this); // 监听按钮
		wf_main_textview_shouye.setOnClickListener(this);
		mybg_imv.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) { // 触发事件
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.return_but:
			Lkw_credit_activity.this.finish();
			break;

		case R.id.wf_main_textview_shouye:
			Lkw_credit_activity.this.finish();
			break;

		case R.id.mybg_imv: // 为imageview添加点击事件 跳转到指定网页
			Intent intent03 = new Intent();
			intent03.setClass(this, CommonWebView.class);
			intent03.putExtra("url", "https://ipcrs.pbccrc.org.cn/");
			startActivity(intent03);

			break;

		}
	}

}

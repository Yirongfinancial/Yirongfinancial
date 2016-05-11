package com.edu.zzti.yirongfinancial.wf;

import com.edu.zzti.yirongfinancial.syw.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Wf_login_activity extends Activity {

	private EditText login_name;
	private EditText login_pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wf_login_activity);

		findView();

	}

	private void findView() {

		login_name = (EditText) findViewById(R.id.login_name);
		login_pass = (EditText) findViewById(R.id.login_pass);

	}

	public void login(View v) {

		startActivity(new Intent(getApplicationContext(),
				Wf_shanping_activity.class));

		finish();

	}

	// 按“返回键”退出整体应用程序
	// 以避免用户操作失误，第一次按下时提醒，用户再次按下才退出
	private long exitTime = 0;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			// 两次按键的时间间隔在2秒以上
			if (System.currentTimeMillis() - exitTime > 2000) {
				Toast.makeText(getApplicationContext(), "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}

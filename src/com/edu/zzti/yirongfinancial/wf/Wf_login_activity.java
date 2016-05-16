package com.edu.zzti.yirongfinancial.wf;

import java.util.ArrayList;
import java.util.List;

import com.edu.zzti.yirongfinancial.common.MyUtils;
import com.edu.zzti.yirongfinancial.common.NetWork;
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

	private List<User> userList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wf_login_activity);

		userList = new ArrayList<User>();

		findView();

		if (NetWork.isNetWorkConnected(getApplicationContext())) {

			Toast.makeText(getApplicationContext(), "请先开启网络", Toast.LENGTH_LONG)
					.show();

			finish();

		} else {

			new Thread() {
				public void run() {

					if (MyHttp.getUser()) {

						userList = MyHttp.readUser(MyUtils
								.getIMEI(getApplicationContext()));

					} else {

						runOnUiThread(new Runnable() {

							@Override
							public void run() {

								Toast.makeText(getApplicationContext(), "服务器忙",
										Toast.LENGTH_LONG).show();

								return;

							}
						});

					}

				};
			}.start();

		}

	}

	private void findView() {

		login_name = (EditText) findViewById(R.id.login_name);
		login_pass = (EditText) findViewById(R.id.login_pass);

	}

	public void login(View v) {

		if (!userList.equals(null)) {

			int i = 0;

			User user = new User();

			while (MyUtils.getIMEI(getApplicationContext()).equals(
					userList.get(i).getImei())) {

				user.setImei(userList.get(i).getImei());
				user.setName(userList.get(i).getName());
				user.setPass(userList.get(i).getPass());

				i += 1;

			}

			i -= 1;

			if (!user.equals(null)) {

				String name = login_name.getText().toString().trim();
				String pass = MyUtils.getMD5(login_pass.getText().toString()
						.trim());

				if (name.equals(userList.get(i).getName())
						&& pass.equals(userList.get(i).getPass())) {

					startActivity(new Intent(getApplicationContext(),
							Wf_shanping_activity.class));

					finish();

				} else {

					Toast.makeText(getApplicationContext(), "账号密码不匹配",
							Toast.LENGTH_LONG).show();

				}

			} else {
				// 第一次登录。

			}

		} else {

			Toast.makeText(getApplicationContext(), "服务器忙", Toast.LENGTH_LONG)
					.show();

			return;

		}

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

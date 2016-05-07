package com.edu.zzti.yirongfinancial.wf;

import com.edu.zzti.yirongfinancial.common.NetWork;
import com.edu.zzti.yirongfinancial.syw.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Wf_shanping_activity extends Activity {

	private int shanpingtime = 3000; // 闪屏持续时间。

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wf_shanping_activity);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				if (NetWork.isNetWorkConnected(Wf_shanping_activity.this)) {
					startActivity(new Intent(getApplicationContext(),
							Wf_main_activity.class));

				} else {
					Toast.makeText(Wf_shanping_activity.this, "请先开启网络",
							Toast.LENGTH_LONG).show();
				}
				finish();
			}
		}, shanpingtime);

	}
}

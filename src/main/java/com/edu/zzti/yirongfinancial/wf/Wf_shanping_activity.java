package com.edu.zzti.yirongfinancial.wf;

import com.edu.zzti.yirongfinancial.syw.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Wf_shanping_activity extends Activity {

	private int shanpingtime = 3000; // 闪屏持续时间。

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wf_shanping_activity);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				startActivity(new Intent(getApplicationContext(),
						Wf_main_activity.class));

				finish();

			}
		}, shanpingtime);

	}
}

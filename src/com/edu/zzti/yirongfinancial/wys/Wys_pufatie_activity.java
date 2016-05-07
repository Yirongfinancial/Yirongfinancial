package com.edu.zzti.yirongfinancial.wys;



import com.edu.zzti.yirongfinancial.syw.R;
import com.edu.zzti.yirongfinancial.wf.Wf_main_activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Wys_pufatie_activity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.wys_pufatie);
	}
	public void pufaback(View v){
		finish();

	}
	
	
	public void click_pufadianhua(View v){
		Intent intent = new Intent();
		intent.setAction(intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:"+"4008208788"));
		startActivity(intent);
	}

}

package com.edu.zzti.yirongfinancial.wf;

import com.edu.zzti.yirongfinancial.common.MyLever;
import com.edu.zzti.yirongfinancial.syw.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

        new Thread() {
            @Override
            public void run() {

                if (!MyLever.toLeverOk()) {

                    Wf_main_activity.lever = 1;

                }

            }
        }.start();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(),
                        Wf_main_activity.class);

                startActivity(intent);

                finish();

            }
        }, shanpingtime);

    }

}

package com.edu.zzti.yirongfinancial.wf;

import com.edu.zzti.yirongfinancial.common.MyLever;
import com.edu.zzti.yirongfinancial.common.MyMenu;
import com.edu.zzti.yirongfinancial.hwh.Hwh_fastcardaccess_activity;
import com.edu.zzti.yirongfinancial.lkw.Lkw_credit_activity;
import com.edu.zzti.yirongfinancial.syw.R;
import com.edu.zzti.yirongfinancial.syw.Syw_networkload_activity;
import com.edu.zzti.yirongfinancial.wys.Wys_getmoney_activity;
import com.edu.zzti.yirongfinancial.yqj.Yqj_selectcard_activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.util.logging.LogRecord;

public class Wf_main_activity extends Activity {

    private LinearLayout ll_kuakatongdao;
    private LinearLayout ll_yijiantie;
    private LinearLayout ll_bankajindu;
    private LinearLayout ll_wangluoxiaodai;
    private LinearLayout ll_zhengxinchaxun;
    private LinearLayout wf_main_yemian;
    private ImageView wf_main_caidan_button;
    private RelativeLayout wf_rl_caidan;
    private ListView wf_listview_caidan;

    public static int lever = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wf_main_activity);

        findView();
        setOnClick();
        myMenu();

        if (lever == 1) {

            leverNo();

        }

    }

    public void myMenu() {

        MyMenu myMenu = new MyMenu(getApplicationContext(), getWindowManager(),
                wf_main_yemian, wf_main_caidan_button, wf_rl_caidan,
                wf_listview_caidan);

        myMenu.myMenuPeiZhi();

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

    // 找到控件。
    private void findView() {

        ll_kuakatongdao = (LinearLayout) findViewById(R.id.ll_kuakatongdao);
        ll_yijiantie = (LinearLayout) findViewById(R.id.ll_yijiantie);
        ll_bankajindu = (LinearLayout) findViewById(R.id.ll_bankajindu);
        ll_wangluoxiaodai = (LinearLayout) findViewById(R.id.ll_wangluoxiaodai);
        ll_zhengxinchaxun = (LinearLayout) findViewById(R.id.ll_zhengxinchaxun);
        wf_main_yemian = (LinearLayout) findViewById(R.id.wf_main_yiemian);
        wf_main_caidan_button = (ImageView) findViewById(R.id.wf_main_caidan_button);
        wf_rl_caidan = (RelativeLayout) findViewById(R.id.wf_rl_caidan);
        wf_listview_caidan = (ListView) findViewById(R.id.wf_listview_caidan);

    }

    // 设置点击事件。
    private void setOnClick() {

        ll_kuakatongdao.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(new Intent(getApplicationContext(),
                        Hwh_fastcardaccess_activity.class));

            }
        });

        ll_yijiantie.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(new Intent(getApplicationContext(),
                        Wys_getmoney_activity.class));

            }
        });

        ll_bankajindu.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(new Intent(getApplicationContext(),
                        Yqj_selectcard_activity.class));

            }
        });

        ll_wangluoxiaodai.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(new Intent(getApplicationContext(),
                        Syw_networkload_activity.class));

            }
        });

        ll_zhengxinchaxun.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                startActivity(new Intent(getApplicationContext(),
                        Lkw_credit_activity.class));

            }
        });

    }

    private void leverNo() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("版本更新");
        builder.setMessage("您的版本不是最新的");
        builder.setPositiveButton("更新版本", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                downApp();

            }
        });
        builder.setNegativeButton("忽略更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getApplicationContext(), "您可以在菜单中选择更新版本", Toast.LENGTH_SHORT).show();

            }
        });

        builder.show();

    }

    private void downApp() {

        Intent intent = new Intent(Intent.ACTION_VIEW);

        Uri data = Uri.parse(Html.fromHtml(
                "http://7xu2vf.com1.z0.glb.clouddn.com/yirongfinancial.apk")
                .toString());
        intent.setData(data);
        intent.setPackage("com.google.android.browser");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setComponent(new ComponentName("com.android.browser",
                "com.android.browser.BrowserActivity"));

        startActivity(intent);

        new Thread() {
            @Override
            public void run() {

                MyLever.downLever();

            }
        }.start();

    }

}
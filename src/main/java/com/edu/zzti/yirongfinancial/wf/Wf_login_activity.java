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

        findView();

    }

    private void findView() {

        login_name = (EditText) findViewById(R.id.login_name);
        login_pass = (EditText) findViewById(R.id.login_pass);

        new Thread() {
            @Override
            public void run() {

                userList = MyHttp.readUsers();

            }
        }.start();

    }

    public void login(View v) {

        String name = login_name.getText().toString().trim();
        String pass = MyUtils.getMD5(login_pass.getText().toString().trim());

        if (name.equals("") || pass.equals("")) {

            Toast.makeText(getApplicationContext(), "账号密码输入有误", Toast.LENGTH_SHORT).show();

            return;

        } else {
            //  账号密码都不为空。

            if (userList == null || userList.get(0).getImei() == null) {

                Toast.makeText(getApplicationContext(), "服务器忙", Toast.LENGTH_SHORT).show();

                return;

            } else {
                //  云端获取或本地获取的数据正常。

                for (User user : userList) {

                    if (user.getImei().equals("000000000000000")) {
                        //  判断是否第一次登录。

                        if (name.equals(user.getName()) && pass.equals(user.getPass())) {
                            //  账号密码正确。登录。

                            startActivity(new Intent(getApplicationContext(), Wf_shanping_activity.class));

                            finish();

                            return;

                        }

                    } else {
                        //  不是第一次登录。

                        if (user.getImei().equals(MyUtils.getIMEI(getApplicationContext()))) {
                            //  是绑定的设备。

                            if (name.equals(user.getName()) && name.equals(user.getPass())) {
                                //  账号密码正确。登录。

                                startActivity(new Intent(getApplicationContext(), Wf_shanping_activity.class));

                                finish();

                                return;

                            } else {

                                Toast.makeText(getApplicationContext(), "账号密码不匹配", Toast.LENGTH_SHORT).show();

                            }


                        } else {

                            Toast.makeText(getApplicationContext(), "请在该账号绑定的设备登录", Toast.LENGTH_SHORT).show();

                        }


                    }

                }

                Toast.makeText(getApplicationContext(), "账号密码不匹配", Toast.LENGTH_SHORT).show();

            }

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

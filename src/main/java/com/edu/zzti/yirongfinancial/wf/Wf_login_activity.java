package com.edu.zzti.yirongfinancial.wf;

import java.util.List;

import android.os.Handler;

import com.edu.zzti.yirongfinancial.common.MyHttp;
import com.edu.zzti.yirongfinancial.common.MyUtils;
import com.edu.zzti.yirongfinancial.common.User;
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

    private static int isLogin = 1;

    private static final int ISLOGIN_ON = 0;
    private static final int ISLOGIN_OFF = 0;

    public static Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {

            if (msg.arg1 == 1) {

                isLogin = ISLOGIN_ON;

            }

        }

    };

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

        String imei = MyUtils.getIMEI(getApplicationContext());
        String name = login_name.getText().toString().trim();
        String pass = MyUtils.getMD5(login_pass.getText().toString().trim());

        if (name.equals("") || pass.equals(MyUtils.getMD5(""))) {

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

                    String userImei = user.getImei();
                    String userName = user.getName();
                    String userPass = user.getPass();

                    if (name.equals(userName)) {
                        //  账号存在。

                        if (userImei.equals("000000000000000")) {
                            //  该账号第一次登录。

                            if (name.equals(userName) && pass.equals(userPass)) {
                                //  登录成功。

                                if (MyHttp.saveUser(imei, name, pass)) {

                                    startActivity(new Intent(getApplicationContext(), Wf_shanping_activity.class));

                                    finish();

                                } else {

                                    Toast.makeText(getApplicationContext(), "服务器异常", Toast.LENGTH_SHORT).show();

                                }

                            } else {

                                Toast.makeText(getApplicationContext(), "账号密码不匹配", Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            //  该账号有绑定的设备。

                            if (imei.equals(userImei)) {
                                //  该设备是该账号绑定的设备。

                                if (name.equals(userName) && pass.equals(userPass)) {
                                    //  登录成功。

                                    startActivity(new Intent(getApplicationContext(), Wf_shanping_activity.class));

                                    finish();

                                } else {

                                    Toast.makeText(getApplicationContext(), "账号密码不匹配", Toast.LENGTH_SHORT).show();

                                }


                            } else {
                                //  该设备不是该账号绑定的设备。

                                Toast.makeText(getApplicationContext(), "请在该账号绑定的设备上登录", Toast.LENGTH_SHORT).show();

                            }

                        }

                        return;

                    }

                }

                if (isLogin == ISLOGIN_ON) {

                    Toast.makeText(getApplicationContext(), "该设备已有账号绑定", Toast.LENGTH_SHORT).show();

                    return;

                }

                Toast.makeText(getApplicationContext(), "账号不存在", Toast.LENGTH_SHORT).show();

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

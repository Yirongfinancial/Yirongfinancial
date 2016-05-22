package com.edu.zzti.yirongfinancial.common;

import com.edu.zzti.yirongfinancial.syw.R;
import com.edu.zzti.yirongfinancial.wf.Wf_main_activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class MyMenu {

    private Context context;
    private WindowManager wm;
    private LinearLayout yemian;
    private ImageView caidan_button;
    private RelativeLayout rl_caidan;
    private ListView listview_caidan;

    private int width;

    private final int CAIDAN_OFF = 0;
    private final int CAIDAN_ON = 1;
    private int caidan = 0;

    private LayoutParams layoutParams;

    public MyMenu(Context context, WindowManager wm, LinearLayout yemian,
                  ImageView caidan_button, RelativeLayout rl_caidan,
                  ListView listview_caidan) {

        this.context = context;
        this.wm = wm;
        this.yemian = yemian;
        this.caidan_button = caidan_button;
        this.rl_caidan = rl_caidan;
        this.listview_caidan = listview_caidan;

        listview_caidan.setAdapter(new MyAdapter());

    }

    public void myMenuPeiZhi() {

        getWindowWidth();

        layoutParams = new RelativeLayout.LayoutParams(width / 2,
                LayoutParams.MATCH_PARENT);

        layoutParams.setMargins(width, 0, 0, 0);

        rl_caidan.setLayoutParams(layoutParams);

        //  setOnClick();

    }

    private void getWindowWidth() {

        int windowWidth = wm.getDefaultDisplay().getWidth();

        width = windowWidth;

    }

    private void setOnClick() {

        caidan_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (caidan == CAIDAN_OFF) {

                    yemian.scrollTo(width / 2, 0);

                    layoutParams.setMargins(width / 2, 0, 0, 0);

                    rl_caidan.setLayoutParams(layoutParams);

                    caidan = CAIDAN_ON;

                } else if (caidan == CAIDAN_ON) {

                    yemian.scrollTo(0, 0);

                    layoutParams.setMargins(width, 0, 0, 0);

                    rl_caidan.setLayoutParams(layoutParams);

                    caidan = CAIDAN_OFF;

                }

            }
        });

    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            View v = View.inflate(context, R.layout.wf_listview_item, null);

            ImageView lv_im = (ImageView) v.findViewById(R.id.lv_im);
            TextView lv_tv = (TextView) v.findViewById(R.id.lv_tv);

            switch (arg0) {
                case 0:
                    lv_im.setBackgroundResource(R.drawable.wf_guanyu);
                    lv_tv.setText("关于");
                    break;
                case 1:
                    lv_im.setBackgroundResource(R.drawable.wf_jianceshengji);
                    lv_tv.setText("检测升级");
                    break;
                case 2:
                    lv_im.setBackgroundResource(R.drawable.wf_fengxiang);
                    lv_tv.setText("分享");
                    break;
                case 3:
                    lv_im.setBackgroundResource(R.drawable.wf_saoyisao);
                    lv_tv.setText("扫一扫");
                    break;
                case 4:
                    lv_im.setBackgroundResource(R.drawable.wf_qinglihuancun);
                    lv_tv.setText("清理缓存");
                    break;

            }

            return v;
        }
    }

}

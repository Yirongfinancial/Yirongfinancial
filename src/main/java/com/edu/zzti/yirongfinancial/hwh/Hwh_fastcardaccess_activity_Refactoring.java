package com.edu.zzti.yirongfinancial.hwh;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.edu.zzti.yirongfinancial.common.CommonWebView;
import com.edu.zzti.yirongfinancial.common.PropertiesUtil;
import com.edu.zzti.yirongfinancial.syw.R;

import java.io.IOException;
import java.util.Properties;


public class Hwh_fastcardaccess_activity_Refactoring extends Activity {

	private HwhFastCardAccessOnClickListener hwh_listener;
	private LinearLayout ll_jiaotong, ll_zhaoshang, ll_pufa, ll_jianhang, ll_zhongguo, ll_minsheng, ll_zhongxin,
	                     ll_gongshang, ll_nongye, ll_pingan, ll_xingye, ll_guangfa, ll_huaxia,
	                     ll_shanghai, ll_guangda, ll_beijing, ll_zheshang,ll_huaqi;
	private ImageView iv_back;
	private Properties p;
	private PropertiesUtil proEnCoding;
	String web, title;
	private String kajiaotongtitle,kajiaotongnet ,kazhaoshangtitle,kazhaoshangnet,kapufatitle,kapufanet,kajianhangtitle,kajianhangnet,
    kazhognguonet,kazhongguotitle,kaminshengtitle,kaminshengnet,kazhongxintitle,kazhongxinnet,kajdtitle,kajdnet,kanongyetitle,kanongyenet,
    kapingantitle,kapingannet,kaxingyetitle,kaxingyenet,kaguangfatitle,kaguangfanet,kahuaxiatitle,kahuaxianet,kashanghaititle,kashanghainet,
    kaguangdatitle,kaguangdanet,kabeijingtitle,kabeijingnet,kazheshangtitle,kazheshangnet,kahuaqititle,kahuaqinet;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hwh_fastcardaccess_activity);
        //找到控件
        iniFindId();
        //实例化onclick方法
        hwh_listener = new HwhFastCardAccessOnClickListener();
        //添加监听器
        addListener();
    }
    class HwhFastCardAccessOnClickListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			p = new Properties();
			proEnCoding = new PropertiesUtil();
			switch (v.getId()) {
			    //交通银行
			case R.id.ll_jiaotong:
				jiaoTongMethod();
				break;
				//招商银行
			case R.id.ll_zhaoshang:
				zhaoShangMethod();
				break;
                //浦发银行
			case R.id.ll_pufa:
                pufaMethod();
				break;
			case R.id.ll_jianhang://建设银行
                jianhangMethod();
				break;
			case R.id.ll_zhongguo://中国银行
                zhongguoMethod();
				break;
			case R.id.ll_minsheng://民生银行
				minShengMethod();
				break;
			case R.id.ll_zhongxin://中信银行
                zhongXinMethod();
				break;
			case R.id.ll_gongshang://京东白卡
				jdMethod();
				break;
			case R.id.ll_nongye://农业银行
                nongYeMethod();
				break;
			case R.id.ll_pingan://平安银行
				pingAnMethod();
				break;
			case R.id.ll_xingye://兴业银行
                xingYeMethod();
				break;
			case R.id.ll_guangfa://广发银行
				guangFaMethod();
				break;
			case R.id.ll_huaxia://华夏银行
                huaXiaMethod();
				break;
			case R.id.ll_shanghai://上海银行
				shangHaiMethod();
				break;
			case R.id.ll_guangda://光大银行
				guangDaMethod();
				break;
			case R.id.ll_beijing://北京银行
                beiJingMethod();
				break;
			case R.id.ll_zheshang://浙商银行
                zheShangMethod();
				break;
			case R.id.ll_huaqi://花旗银行
                huaQiMethod();

				break;
			case R.id.iv_back:
				finish();
				break;
			}
			
		}



	}




    //花旗银行
    private void huaQiMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kahuaqititle = proEnCoding
                    .getProperty(p, "kahuaqititle", "UTF-8");
            kahuaqinet = p.getProperty("kahuaqinet");
            title = kahuaqititle;
            web = kahuaqinet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //浙商银行
    private void zheShangMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kazheshangtitle = proEnCoding
                    .getProperty(p, "kazheshangtitle", "UTF-8");
            kazheshangnet = p.getProperty("kazheshangnet");
            title = kazheshangtitle;
            web = kazheshangnet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //北京银行
    private void beiJingMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kabeijingtitle = proEnCoding
                    .getProperty(p, "kabeijingtitle", "UTF-8");
            kabeijingnet = p.getProperty("kabeijingnet");
            title = kabeijingtitle;
            web = kabeijingnet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //光大银行
    private void guangDaMethod() {

        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kaguangdatitle = proEnCoding
                    .getProperty(p, "kaguangdatitle", "UTF-8");
            kaguangdanet = p.getProperty("kaguangdanet");
            title = kaguangdatitle;
            web = kaguangdanet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //上海银行
    private void shangHaiMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kashanghaititle = proEnCoding
                    .getProperty(p, "kashanghaititle", "UTF-8");
            kashanghainet = p.getProperty("kashanghainet");
            title = kashanghaititle;
            web = kashanghainet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //华夏银行
    private void huaXiaMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kahuaxiatitle = proEnCoding
                    .getProperty(p, "kahuaxiatitle", "UTF-8");
            kahuaxianet = p.getProperty("kahuaxianet");
            title = kahuaxiatitle;
            web = kahuaxianet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //广发银行
    private void guangFaMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kaguangfatitle = proEnCoding
                    .getProperty(p, "kaguangfatitle", "UTF-8");
            kaguangfanet = p.getProperty("kaguangfanet");
            title = kaguangfatitle;
            web = kaguangfanet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //兴业银行
    private void xingYeMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kaxingyetitle = proEnCoding
                    .getProperty(p, "kaxingyetitle", "UTF-8");
            kaxingyenet = p.getProperty("kaxingyenet");
            title = kaxingyetitle;
            web = kaxingyenet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //平安银行
    private  void  pingAnMethod(){
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kapingantitle = proEnCoding
                    .getProperty(p, "kapingantitle", "UTF-8");
            kapingannet = p.getProperty("kapingannet");
            title = kapingantitle;
            web = kapingannet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //农业银行
    private void nongYeMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kanongyetitle = proEnCoding
                    .getProperty(p, "kanongyetitle", "UTF-8");
            kanongyenet = p.getProperty("kanongyenet");
            title = kanongyetitle;
            web = kanongyenet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //京东白条
    private void jdMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kajdtitle = proEnCoding
                    .getProperty(p, "kajdtitle", "UTF-8");
            kajdnet = p.getProperty("kajdnet");
            title = kajdtitle;
            web = kajdnet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //中兴银行
    private void zhongXinMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kazhongxintitle = proEnCoding
                    .getProperty(p, "kazhongxintitle", "UTF-8");
            kazhongxinnet = p.getProperty("kazhongxinnet");
            title = kazhongxintitle;
            web = kazhongxinnet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //民生银行
    private void minShengMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kaminshengtitle = proEnCoding
                    .getProperty(p, "kaminshengtitle", "UTF-8");
            kaminshengnet = p.getProperty("kaminshengnet");
            title = kaminshengtitle;
            web = kaminshengnet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //交通银行
	private void jiaoTongMethod() {
		try {
			p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
					"netLoad.properties"));
			kajiaotongtitle = proEnCoding
					.getProperty(p, "kajiaotongtitle", "UTF-8");
			kajiaotongnet = p.getProperty("kajiaotongnet");
			title = kajiaotongtitle;
			web = kajiaotongnet;
			getView(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//招商银行
	private void zhaoShangMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kazhaoshangtitle = proEnCoding
                    .getProperty(p, "kazhaoshangtitle", "UTF-8");
            kazhaoshangnet = p.getProperty("kazhaoshangnet");
            title = kazhaoshangtitle;
            web = kazhaoshangnet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }


	}
    //浦发银行
    private void pufaMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kapufatitle = proEnCoding
                    .getProperty(p, "kapufatitle", "UTF-8");
            kapufanet = p.getProperty("kapufanet");
            title = kapufatitle;
            web = kapufanet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //建设银行
    private void jianhangMethod() {
        try {
            p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                    "netLoad.properties"));
            kajianhangtitle = proEnCoding
                    .getProperty(p, "kajianhangtitle", "UTF-8");
            kajianhangnet = p.getProperty("kajianhangnet");
            title = kajianhangtitle;
            web = kajianhangnet;
            getView(web, title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   //中国银行
    private void zhongguoMethod() {
       try {
           p.load(Hwh_fastcardaccess_activity_Refactoring.this.getAssets().open(
                   "netLoad.properties"));
           kazhongguotitle = proEnCoding
                   .getProperty(p, "kazhongguotitle", "UTF-8");
           kazhognguonet = p.getProperty("kazhognguonet");
           title = kazhongguotitle;
           web = kazhognguonet;
           getView(web, title);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

	public void getView(String web,String title){//跳转
		Intent intent=new Intent(this,CommonWebView.class);
		intent.putExtra("url", web);
		intent.putExtra("title", title);
		startActivity(intent);
	}
    public void iniFindId(){//查询所有银行imageview控件。
    	ll_jiaotong = (LinearLayout) findViewById(R.id.ll_jiaotong);
    	ll_zhaoshang = (LinearLayout) findViewById(R.id.ll_zhaoshang);
    	ll_pufa = (LinearLayout) findViewById(R.id.ll_pufa);
    	ll_jianhang = (LinearLayout) findViewById(R.id.ll_jianhang);
    	ll_zhongguo = (LinearLayout) findViewById(R.id.ll_zhongguo);
    	ll_minsheng = (LinearLayout) findViewById(R.id.ll_minsheng);
    	ll_zhongxin = (LinearLayout) findViewById(R.id.ll_zhongxin);
    	ll_gongshang = (LinearLayout) findViewById(R.id.ll_gongshang);
    	ll_nongye = (LinearLayout) findViewById(R.id.ll_nongye);
    	ll_pingan = (LinearLayout) findViewById(R.id.ll_pingan);
    	ll_xingye = (LinearLayout) findViewById(R.id.ll_xingye);
    	ll_guangfa = (LinearLayout) findViewById(R.id.ll_guangfa);
    	ll_huaxia = (LinearLayout) findViewById(R.id.ll_huaxia);
    	ll_shanghai = (LinearLayout) findViewById(R.id.ll_shanghai);
    	ll_guangda = (LinearLayout) findViewById(R.id.ll_guangda);
    	ll_beijing = (LinearLayout) findViewById(R.id.ll_beijing);
    	ll_zheshang = (LinearLayout) findViewById(R.id.ll_zheshang);
    	ll_huaqi = (LinearLayout) findViewById(R.id.ll_huaqi);
    	iv_back = (ImageView) findViewById(R.id.iv_back);
    }
    public void addListener(){//为所有银行imageview添加监听
    	ll_jiaotong.setOnClickListener(hwh_listener);
    	ll_zhaoshang.setOnClickListener(hwh_listener);
    	ll_pufa.setOnClickListener(hwh_listener);
    	ll_jianhang.setOnClickListener(hwh_listener);
    	ll_zhongguo.setOnClickListener(hwh_listener);
    	ll_minsheng.setOnClickListener(hwh_listener);
    	ll_zhongxin.setOnClickListener(hwh_listener);
    	ll_gongshang.setOnClickListener(hwh_listener);
    	ll_nongye.setOnClickListener(hwh_listener);
    	ll_pingan.setOnClickListener(hwh_listener);
    	ll_xingye.setOnClickListener(hwh_listener);
    	ll_guangfa.setOnClickListener(hwh_listener);
    	ll_huaxia.setOnClickListener(hwh_listener);
    	ll_shanghai.setOnClickListener(hwh_listener);
    	ll_guangda.setOnClickListener(hwh_listener);
    	ll_beijing.setOnClickListener(hwh_listener);
    	ll_zheshang.setOnClickListener(hwh_listener);
    	ll_huaqi.setOnClickListener(hwh_listener);
    	iv_back.setOnClickListener(hwh_listener);
    }
}

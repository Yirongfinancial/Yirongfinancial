package com.edu.zzti.yirongfinancial.hwh;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.edu.zzti.yirongfinancial.common.CommonWebView;
import com.edu.zzti.yirongfinancial.syw.R;


public class Hwh_fastcardaccess_activity extends Activity {

    
	private HwhFastCardAccessOnClickListener hwh_listener;
	private LinearLayout ll_jiaotong;
	private LinearLayout ll_zhaoshang;
	private LinearLayout ll_pufa;
	private LinearLayout ll_jianhang;
	private LinearLayout ll_zhongguo;
	private LinearLayout ll_minsheng;
	private LinearLayout ll_zhongxin;
	private LinearLayout ll_gongshang;
	private LinearLayout ll_nongye;
	private LinearLayout ll_pingan;
	private LinearLayout ll_xingye;
	private LinearLayout ll_guangfa;
	private LinearLayout ll_huaxia;
	private LinearLayout ll_shanghai;
	private LinearLayout ll_guangda;
	private LinearLayout ll_beijing;
	private LinearLayout ll_zheshang;
	private LinearLayout ll_huaqi;
	private ImageView iv_back;
	
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
			// TODO Auto-generated method stub
			String web;
			String title;
			switch (v.getId()) {
			case R.id.ll_jiaotong://交通银行
				web="https://creditcardapp.bankcomm.com/applynew/front/apply/new/index.html?trackCode=A123010564295&recomType=01&recomNumber=13213140060&commercial_id=null";
				title="交通银行";
				tiaoZhuan(web,title);
				break;

			case R.id.ll_zhaoshang://招商银行
				web="https://ccclub.cmbchina.com/mca/MPreContract.aspx?cardsel=uc&from=wx&WT.mc_id=N1700WX304A9033100CC&where=&swbrief=&channel=WX&openid=btiwvt2%2FFUo3pnUZjlTApO4S%2FNAl0w0CG6qvOvwkmHM%3D%0D%0A";
				title="招商银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_pufa://浦发银行
				web="https://mbank.spdbccc.com.cn/creditcard/indexActivity.htm?data=Z285209";
				title="浦发银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_jianhang://建设银行
				web="http://creditcard.ccb.com/index.html?id=20110906_1315300801&orgCode=D999111113&flag=standard_form";
				title="建设银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_zhongguo://中国银行
				web="https://apply.mcard.boc.cn/apply/mobile/product/list/mc";
				title="中国银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_minsheng://民生银行
				web="https://creditcard.cmbc.com.cn/wsonline/login/login.jhtml?id=2&time=1462007566334";
				title="民生银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_zhongxin://中信银行
				web="http://creditcard.ecitic.com/h5/shenqing/list.html?sid=SJWXBK&foot_s=0&llqf=wx";
				title="中信银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_gongshang://京东白卡
				web="https://bk.jd.com/m?from=singlemessage&isappinstalled=1";
				title="京东白卡";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_nongye://农业银行
				web="https://eapply.abchina.com/onlinetrade/CreditcardsInfo/CardRequestion";
				title="农业银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_pingan://平安银行
				web="https://c.pingan.com/apply/mobile/apply/index.html?scc=920000210&ccp=9a1a2a3a4a5a8a10a11a12a13&xl=01a02a03a04a05&showt=0#mainPage";
				title="平安银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_xingye://兴业银行
				web="https://ccshop.cib.com.cn:8010/application/cardapp/Fast/ApplyNotice/view";
				title="兴业银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_guangfa://广发银行
				web="https://wap.cgbchina.com.cn/creditCardApplyIn.do?shortUrl=BKbP5Yi";
				title="广发银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_huaxia://华夏银行
				web="https://creditapply.hxb.com.cn/";
				title="华夏银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_shanghai://上海银行
				web="http://www.bankofshanghai.com/creditCardApply.jsp?code=0300001521&id=1676&flag=2";
				title="上海银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_guangda://光大银行
				web="https://xyk.cebbank.com/cebmms/apply/fz/card-apply-index.htm?req_card_id=241&pro_code=XMVX&c2c_recom_flag=&c2c_act_id=";
				title="光大银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_beijing://北京银行
				web="https://card.bankofbeijing.com.cn/coas/channel/mobile/card?cardId=1120";
				title="北京银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_zheshang://浙商银行
				web="https://e.czbank.com/weixinHTML/eApply/creditCardApply.html?wxCustFakeId=bda103a5-3218-469a-bf8a-7ac7e3713886-ptIS4u&wxRandomCode=0";
				title="浙商银行";
				tiaoZhuan(web,title);
				break;
			case R.id.ll_huaqi://花旗银行
				web="https://www.citibank.com.cn/sim/ICARD/forms/longform/index.html?icid=CNCCALFCNWECHAT";
				title="花旗银行";
				tiaoZhuan(web,title);
				break;
			case R.id.iv_back://花旗银行
				finish();
				break;
			}
			
		}
    	
    }
    
    public void tiaoZhuan(String web,String title){//跳转
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

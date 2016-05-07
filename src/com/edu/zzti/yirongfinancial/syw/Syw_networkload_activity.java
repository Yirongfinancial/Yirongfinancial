/**
 * syw
 * 16/05/03
 * 小额贷款
 * 
 */
package com.edu.zzti.yirongfinancial.syw;

import com.edu.zzti.yirongfinancial.common.CommonWebView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Syw_networkload_activity extends Activity {
	private ImageView zhongxin, lexiang, pingan, zhifupay, paipaiload, youme,yiren, pufa, jianhang, renxing, jingd, zhaolian;
	private MyOnClickListener syw_listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.syw_networkload_activity);
		initFindView();
		// 实例化onClick方法
		syw_listener = new MyOnClickListener();
		// 添加监听
		addListener();
	}
	class MyOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			String web, title;
			switch (v.getId()) {
			// 中信圆梦金
			case R.id.zhongxin:
				Log.d("zzti", "中信圆梦金");
				web = "https://creditcard.ecitic.com/citiccard/concreditwap/ymj/index.html?cls=250";
				title="中信圆梦金";
				getview(web, title);
				break;
			// 乐享财智金
			case R.id.lexiang:
				web = "https://creditcard.ecitic.com/citiccard/concreditwap/ymj/index.html?cls=250";
				title="乐享财智金";
				getview(web, title);
				break;
			// 平安普惠
			case R.id.pingan:
				web = "http://www.10100000.com/Market/2016/03/01/index.html?WT.mc_id=CXX-BDPP-PHPC-032&WT.srch=1";
				title="平安普惠";
				getview(web, title);
				break;
			// 支付宝贷
			case R.id.zhifupay:
				web = "https://loan.mybank.cn/growing/alipayLogon.htm?target=http%3A%2F%2Fmy.aliloan.com%2Findex.htm";
				title="支付宝贷";
				getview(web, title);
				break;
			// 拍拍贷
			case R.id.paipaiload:
				web = "https://ac.ppdai.com/User/Register?redirect=";
				title="拍拍贷";
				getview(web, title);
				break;
			// 你我贷
			case R.id.youme:
				web = "http://www.niwodai.com/event.mhtml?artId=3800000642908480";
				title="你我贷";
				getview(web,title);
				break;
			// 宜人贷
			case R.id.yiren:
				web = "https://login.yirendai.com/regist/home";
				title="宜人贷";
				getview(web,title);
				break;
			// 浦发万用金
			case R.id.pufa:
				web = "https://cardsonline.spdbccc.com.cn/icard/icardlogin.do?_locale=zh_CN";
				title="浦发万用金";
				getview(web,title);
				break;
			// 建行龙卡贷
			case R.id.jianhang:
				web = "http://buy.ccb.com/financing/indexPage.jhtml";
				title="建行龙卡贷";
				getview(web,title);
				break;
			// 任性贷
			case R.id.renxing:
				web = "https://paypassport.suning.com/ids/login?service=https%3A%2F%2Frxf.suning.com%2Fepps-cpf%2Fauth%3FtargetUrl%3Dhttp%253A%252F%252Frxf.suning.com%252Fepps-cpf%252FaccountMgt%252FassetOverview.do&loginTheme=defaultTheme";
				title="任性贷";
				getview(web,title);
				break;
			// 京东白条
			case R.id.jingd:
				web = "https://passport.jd.com/uc/login?ltype=logout";
				title="京东白条";
				getview(web,title);
				break;
			// 招联好期待
			case R.id.zhaolian:
				web = "https://hqd.mucfc.com/";
				title="招联好期贷";
				getview(web, title);
				break;

			}

		}

	}
	public void getview(String web, String title) {
		Intent intent = new Intent(this, CommonWebView.class);
		Log.d("zzti", "中信圆梦金2"+title);
		intent.putExtra("title", title);
		intent.putExtra("url", web);
		startActivity(intent);

	}
	// 添加监听
	private void addListener() {
		zhongxin.setOnClickListener(syw_listener);
		lexiang.setOnClickListener(syw_listener);
		pingan.setOnClickListener(syw_listener);
		zhifupay.setOnClickListener(syw_listener);
		paipaiload.setOnClickListener(syw_listener);
		youme.setOnClickListener(syw_listener);
		yiren.setOnClickListener(syw_listener);
		pufa.setOnClickListener(syw_listener);
		jianhang.setOnClickListener(syw_listener);
		renxing.setOnClickListener(syw_listener);
		jingd.setOnClickListener(syw_listener);
		zhaolian.setOnClickListener(syw_listener);
	}

	private void initFindView() {

		zhongxin = (ImageView) findViewById(R.id.zhongxin);
		lexiang = (ImageView) findViewById(R.id.lexiang);
		pingan = (ImageView) findViewById(R.id.pingan);
		zhifupay = (ImageView) findViewById(R.id.zhifupay);
		paipaiload = (ImageView) findViewById(R.id.paipaiload);
		youme = (ImageView) findViewById(R.id.youme);
		yiren = (ImageView) findViewById(R.id.yiren);
		pufa = (ImageView) findViewById(R.id.pufa);
		jianhang = (ImageView) findViewById(R.id.jianhang);
		renxing = (ImageView) findViewById(R.id.renxing);
		jingd = (ImageView) findViewById(R.id.jingd);
		zhaolian = (ImageView) findViewById(R.id.zhaolian);

	}

	

	

}

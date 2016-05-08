/**
 * syw
 * 16/05/03
 * 小额贷款
 * 
 */
package com.edu.zzti.yirongfinancial.syw;

import java.io.IOException;
import java.util.Properties;

import com.edu.zzti.yirongfinancial.common.CommonWebView;
import com.edu.zzti.yirongfinancial.common.PropertiesUtil;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Syw_networkload_activity extends Activity {
	private ImageView zhongxin, lexiang, pingan, zhifupay, paipaiload, youme,
			yiren, pufa, jianhang, renxing, jingd, zhaolian;
	private MyOnClickListener syw_listener;
	private Properties p;
	private String zhognxintitle, zhongxinnet, lexiangtitle, lexiangnet,
			pingantitle, pingannet, zhifupaytitle, zhifupaynet,
			paipailoadtitle, paipailoadnet, youmetitle, youmenet, yirentitle,
			yirennet, pufatitle, pufanet, jianhangnet, jianhangtitle,
			renxingtitle, renxingnet, jingdtitle, jingdnet, zhaoliantitle,
			zhaoliannet;
	private PropertiesUtil proEnCoding;
	String web, title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.syw_networkload_activity);
		initFindView();//初始化组件
		addListener();// 添加监听
		syw_listener = new MyOnClickListener();//实例化onClick方法
	}

	public class MyOnClickListener implements OnClickListener {
		public void onClick(View v) {
			p = new Properties();
			proEnCoding = new PropertiesUtil();
			switch (v.getId()) {
			// 中信圆梦金
			case R.id.zhongxin:
				zhongXinMethod();
				break;
			// 乐享财智金
			case R.id.lexiang:
				leXiangMethod();
				break;
			// 平安普惠
			case R.id.pingan:
				pingAnMethod();
				break;
			// 支付宝贷
			case R.id.zhifupay:
				zhiFuPayMrthod();
				break;
			// 拍拍贷
			case R.id.paipaiload:
				paiPaiLoadMrthod();
				break;
			// 你我贷
			case R.id.youme:
				youMeMethod();
				break;
			// 宜人贷
			case R.id.yiren:
				yiRenMethod();
				break;
			// 浦发万用金
			case R.id.pufa:
				puFaMethod();
				break;
			// 建行龙卡贷
			case R.id.jianhang:
				jianHangMethod();
				break;
			// 任性贷
			case R.id.renxing:
				renXingMethod();

				break;
			// 京东白条
			case R.id.jingd:
				jingdMethod();
				break;
			// 招联好期贷
			case R.id.zhaolian:
				zhaoLianMethod();
				break;
			}

		}

	}

	public void zhaoLianMethod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			zhaoliantitle = proEnCoding
					.getProperty(p, "zhaoliantitle", "UTF-8");
			zhaoliannet = p.getProperty("zhaoliannet");
			title = zhaoliantitle;
			web = zhaoliannet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void jingdMethod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			jingdtitle = proEnCoding.getProperty(p, "jingdtitle", "UTF-8");
			jingdnet = p.getProperty("jingdnet");
			title = jingdtitle;
			web = jingdnet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void renXingMethod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			renxingtitle = proEnCoding.getProperty(p, "renxingtitle", "UTF-8");
			renxingnet = p.getProperty("renxingnet");
			title = renxingtitle;
			web = renxingnet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void jianHangMethod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			jianhangtitle = proEnCoding
					.getProperty(p, "jianhangtitle", "UTF-8");
			jianhangnet = p.getProperty("jianhangnet");
			title = jianhangtitle;
			web = jianhangnet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void puFaMethod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			pufatitle = proEnCoding.getProperty(p, "pufatitle", "UTF-8");
			pufanet = p.getProperty("pufanet");
			title = pufatitle;
			web = pufanet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void yiRenMethod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			yirentitle = proEnCoding.getProperty(p, "yirentitle", "UTF-8");
			yirennet = p.getProperty("yirennet");
			title = yirentitle;
			web = yirennet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void youMeMethod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			youmetitle = proEnCoding.getProperty(p, "youmetitle", "UTF-8");
			youmenet = p.getProperty("youmenet");
			title = youmetitle;
			web = youmenet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paiPaiLoadMrthod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			paipailoadtitle = proEnCoding.getProperty(p, "paipailoadtitle",
					"UTF-8");
			paipailoadnet = p.getProperty("paipailoadnet");
			title = paipailoadtitle;
			web = paipailoadnet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void zhiFuPayMrthod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			zhifupaytitle = proEnCoding
					.getProperty(p, "zhifupaytitle", "UTF-8");
			zhifupaynet = p.getProperty("zhifupaynet");
			title = zhifupaytitle;
			web = zhifupaynet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pingAnMethod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			pingantitle = proEnCoding.getProperty(p, "pingantitle", "UTF-8");
			pingannet = p.getProperty("pingannet");
			title = pingantitle;
			web = pingannet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void leXiangMethod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			lexiangtitle = proEnCoding.getProperty(p, "lexiangtitle", "UTF-8");
			lexiangnet = p.getProperty("zhongxinnet");
			title = lexiangtitle;
			web = lexiangnet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void zhongXinMethod() {
		try {
			p.load(Syw_networkload_activity.this.getAssets().open(
					"net.properties"));
			zhognxintitle = proEnCoding
					.getProperty(p, "zhongxintitle", "UTF-8");
			zhongxinnet = p.getProperty("zhongxinnet");
			title = zhognxintitle;
			web = zhongxinnet;
			getview(web, title);
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	public void getview(String web, String title) {
		Intent intent = new Intent(this, CommonWebView.class);
		intent.putExtra("title", title);
		intent.putExtra("url", web);
		startActivity(intent);

	}
}

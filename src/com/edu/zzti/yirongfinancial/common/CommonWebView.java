package com.edu.zzti.yirongfinancial.common;

import android.app.Activity;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.zzti.yirongfinancial.syw.R;

public class CommonWebView extends Activity {

	private TextView tv_title;
	private WebView mWebView;
	private String title;
	private String url;
	private ImageView iv_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hwh_fastcardaccess_webview);
		iniFindView();
		getData();
		mWebView.setWebViewClient(new MyWebViewClient());
		iv_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	private void getData() {
		Intent intent = getIntent();
		title = intent.getStringExtra("title");
		tv_title.setText(title);
		url = intent.getStringExtra("url");

		WebSettings webSettings = mWebView.getSettings();
		// webSettings.setUseWideViewPort(true);//任意比例缩放
		webSettings.setLoadWithOverviewMode(true);
		// 如果访问的页面中有Javascript，则webview必须设置支持Javascript
		webSettings.setJavaScriptEnabled(true);

		// 设置缓存
		webSettings.setAppCacheEnabled(true);
		// 设置缓存模式
		webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

		// 页面支持缩放
		webSettings.setBuiltInZoomControls(true);
		webSettings.setSupportZoom(true);
		// 获取手势焦点
		mWebView.requestFocusFromTouch();

		mWebView.loadUrl(url);
	}

	private void iniFindView() {
		tv_title = (TextView) findViewById(R.id.syw_title);
		mWebView = (WebView) findViewById(R.id.wvsyw);
		iv_back = (ImageView) findViewById(R.id.iv_back);
	}

	private class MyWebViewClient extends WebViewClient {

		// 使用WebView加载url，而不是跳转到浏览器
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			return true;
		}

		// 处理https问题
		public void onReceivedSslError(WebView view, SslErrorHandler handler,
				SslError error) {
			handler.proceed(); // 接受所有网站的证书
		}

		// 处理资源加载的问题

		// 处理加载出错时响应
		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			view.loadUrl("file:///android_asset/error.html");

			super.onReceivedError(view, errorCode, description, failingUrl);
		}
	}

	// 由于WebView中当点击键盘上的“返回”键时，直接调用浏览器的“finish()”方法退出浏览器
	// 为避免这种情况，“返回”仅是返回浏览器的上一个界面，重写onKeyDown()方法
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
			mWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}

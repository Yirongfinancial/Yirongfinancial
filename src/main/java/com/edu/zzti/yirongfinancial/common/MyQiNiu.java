package com.edu.zzti.yirongfinancial.common;

import com.edu.zzti.yirongfinancial.qiniu.http.Response;
import com.edu.zzti.yirongfinancial.qiniu.util.Auth;

import java.io.IOException;

import com.edu.zzti.yirongfinancial.qiniu.common.QiniuException;
import com.edu.zzti.yirongfinancial.qiniu.storage.UploadManager;

/**
 * Created by wangfei on 16/5/18.
 */

public class MyQiNiu {

    private static String userSavaPath = "data/data/com.edu.zzti.yirongfinancial.syw";
    private static String userSavaName = "user.xml";

    private static Auth auth;
    private static UploadManager uploadManager;

    private static String bucketname;
    private static String key;
    private static String FilePath;

    public MyQiNiu(String name) {

        String ACCESS_KEY = "3qRQLGo0aIIvpeYTtEzye3bVarVPDBGRRv0LLw8Q";
        String SECRET_KEY = "6Lm4Ee52-QhBfx7DqdlKX2aCcyVsvorVL0yXwmXQ";
        //要上传的空间
        bucketname = "yirongfinancial";
        //上传到七牛后保存的文件名
        key = name + ".txt";
        //上传文件的路径
        FilePath = userSavaPath + userSavaName;

        //密钥配置
        auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //创建上传对象
        UploadManager uploadManager = new UploadManager();

        //简单上传，使用默认策略，只需要设置上传的空间名就可以了s

    }

    public String getUpToken() {

        return auth.uploadToken(bucketname);
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传
            com.edu.zzti.yirongfinancial.qiniu.http.Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            //响应的文本信息
        }
    }

}
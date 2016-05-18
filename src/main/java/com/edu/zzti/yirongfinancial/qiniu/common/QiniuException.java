package com.edu.zzti.yirongfinancial.qiniu.common;

import com.edu.zzti.yirongfinancial.qiniu.http.Response;

import java.io.IOException;


public class QiniuException extends IOException {
    public final Response response;


    public QiniuException(Response response) {
        this.response = response;
    }

    public QiniuException(Exception e) {
        super(e);
        this.response = null;
    }

    public String url() {
        return response.url();
    }

    public int code() {
        return response == null ? -1 : response.statusCode;
    }
}
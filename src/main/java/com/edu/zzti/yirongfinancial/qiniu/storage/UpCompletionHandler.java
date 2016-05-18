package com.edu.zzti.yirongfinancial.qiniu.storage;

import com.edu.zzti.yirongfinancial.qiniu.http.Response;

/**
 * Created by bailong on 15/10/8.
 */
public interface UpCompletionHandler {
    void complete(String key, Response r);
}

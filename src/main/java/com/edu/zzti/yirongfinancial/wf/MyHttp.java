package com.edu.zzti.yirongfinancial.wf;

import android.content.Context;

import com.edu.zzti.yirongfinancial.common.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class MyHttp {

    private static List<User> userList;

    public static List<User> readUsers() {

        userList = new ArrayList<User>();

        User user1 = new User();

        user1.setImei("000000000000000");
        user1.setName("111");
        user1.setPass(MyUtils.getMD5("222"));

        userList.add(user1);

        User user2 = new User();

        user2.setImei("000000000000000");
        user2.setName("222");
        user2.setPass(MyUtils.getMD5("333"));

        userList.add(user2);

        User user3 = new User();

        user3.setImei("000000000000000");
        user3.setName("333");
        user3.setPass(MyUtils.getMD5("444"));

        userList.add(user3);

        return userList;

    }

    public static boolean setUsers() {

        return false;

    }

    private static boolean getUsers() {

        return true;

    }

}
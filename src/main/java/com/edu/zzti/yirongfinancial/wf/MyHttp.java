package com.edu.zzti.yirongfinancial.wf;

import android.content.Context;

import com.edu.zzti.yirongfinancial.common.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class MyHttp {

    private static List<User> userList;

    public static List<User> readUsers() {

        userList = new ArrayList<User>();



        return userList;

    }

    private static boolean getUsers() {

        return true;

    }

    public static boolean setUsers() {

        return false;

    }

}
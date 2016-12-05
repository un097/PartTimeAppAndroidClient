package com.pt365.utils;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

/**
 * @author suncr
 * @version 1.0
 * @Descript Activity专用util
 * @date 2014-12-15
 */
public class ActivityUtil {

    private static ArrayList<Activity> arr = new ArrayList<Activity>();
    private static ArrayList<Activity> temp = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        arr.add (activity);
    }

    public static void removeActivity(Activity activity) {
        arr.remove (activity);
    }

    public static void addTempActivity(Activity activity) {
        temp.add (activity);
    }

    public static void finishTempAll() {
        if (temp != null) {
            while (temp.size () > 0) {
                temp.get (0).finish ();
            }
        }
    }

    public static void finishAll() {
        if (arr != null) {
            while (arr.size () > 0) {
                arr.get (0).finish ();
            }
        }
    }

    public static View getFocusView() {
        for(int i = 0; i < arr.size (); i++) {
            View view = arr.get (i).getCurrentFocus ();
            if(view != null) {
                return view;
            }
        }
        return null;
    }

    public static void finishBeforeParamActivity(Class c) {
        while (arr.size () > 1) {
            arr.get (0).finish ();
        }
        Activity a = arr.get (0);
        a.startActivity (new Intent(a, c));
        a.finish ();
    }
}

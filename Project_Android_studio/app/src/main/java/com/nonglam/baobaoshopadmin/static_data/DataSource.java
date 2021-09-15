package com.nonglam.baobaoshopadmin.static_data;

import android.graphics.drawable.Drawable;

import java.io.InputStream;
import java.net.URL;

public class DataSource {
    public static String token;
    public static int nextPage = 1;

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}

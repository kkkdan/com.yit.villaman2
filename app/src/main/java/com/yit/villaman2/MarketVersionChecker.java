package com.yit.villaman2;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MarketVersionChecker {

    public static String getMarketVersionFast(String packageName) {

        String mData = "", mVer = null;
        try {
            URL mUrl = new URL("https://play.google.com/store/apps/details?id=" + packageName);
            HttpURLConnection mConnection = (HttpURLConnection) mUrl.openConnection();
            if (mConnection == null) {
                return null;
            }

            mConnection.setConnectTimeout(5000);
            mConnection.setUseCaches(false);
            mConnection.setDoOutput(true);

            if (mConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
                while(true) {
                    String line = bufferedReader.readLine();
                    if (line == null)
                        break;
                    mData += line;
                }
                bufferedReader.close();
            }
            mConnection.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        String startToken = "softwareVersion\">";
        String endToken = "<";
        int index = mData.indexOf(startToken);

        if (index == -1) {
            mVer = null;
        } else {
            mVer = mData.substring(index + startToken.length(), index + startToken.length() + 100);
            mVer = mVer.substring(0, mVer.indexOf(endToken)).trim();
        }
        return mVer;
    }
}

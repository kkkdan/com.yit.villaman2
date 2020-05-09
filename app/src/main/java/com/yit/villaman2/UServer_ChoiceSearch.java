package com.yit.villaman2;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class UServer_ChoiceSearch {

	private static final String TAG = "■■■";

	private UServer_ChoiceSearch() {
	}

	public static WServerChoiceSearch with(Context pCon) {
		return new WServerChoiceSearch(pCon);
	}

	public static class WServerChoiceSearch {

		private Callback mCallback;
		private Context mCon;
		private ServerConnection mServerConnection;
		private JSONArray data;
		private OptionLoadingDialog dialog;

		private WServerChoiceSearch(Context pCon) {
			mCon = pCon;
		}

		public WServerChoiceSearch forStart(Callback WServerChoiceSearch_Callback, HashMap<String, String> detailMap) {
			mCallback = WServerChoiceSearch_Callback;

			String data  = "";

			try {

				data = URLEncoder.encode("ma_search", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("ma_search"), "UTF-8") + "&"
						+ URLEncoder.encode("sido", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("sido"), "UTF-8") + "&"
						+ URLEncoder.encode("gungu", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("gungu"), "UTF-8") + "&"
						+ URLEncoder.encode("dong", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("dong"), "UTF-8") + "&"
						+ URLEncoder.encode("myconfirm02", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("MyConfirm02"), "UTF-8") + "&"
						+ URLEncoder.encode("mynew02", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("MyNew02"), "UTF-8") + "&"
						+ URLEncoder.encode("usr_id", "UTF-8") + "=" + URLEncoder.encode(Util.getPhoneNumber(mCon), "UTF-8") + "&"
						+ URLEncoder.encode("ma_status1", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("ma_status1"), "UTF-8") + "&"
						+ URLEncoder.encode("ma_gallery", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("ma_gallery"), "UTF-8") + "&"

						+ URLEncoder.encode("viloldnew", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("viloldnew"), "UTF-8") + "&"
						+ URLEncoder.encode("packagename", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("packagename"), "UTF-8") + "&"
						+ URLEncoder.encode("poitype", "UTF-8") + "=" +URLEncoder.encode("" + detailMap.get("poitype"), "UTF-8");

				Log.d(TAG, "..data:WServerChoiceSearch:"+data.toString());
				/*
						+ URLEncoder.encode("gungu", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("gungu"), "UTF-8") + "&"
						+ URLEncoder.encode("dong", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("dong"), "UTF-8") + "&"
						+ URLEncoder.encode("strLat", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("strLat"), "UTF-8") + "&"
						+ URLEncoder.encode("strLon", "UTF-8") + "=" + URLEncoder.encode("" + detailMap.get("strLon"), "UTF-8") + "&"
						+ URLEncoder.encode("strDist", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8") + "&"
				*/

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			String url = Util.getURL_IT() + "/ahh/selectDetail_N.do?YESIT="+ Util.getBase64encode(data).replace("\n","");

			dialog = new OptionLoadingDialog(mCon);
			dialog.showLoading();

			mServerConnection = new ServerConnection(mCon, "GET", mHandler, url);
			mServerConnection.start();
			return this;
		}

		public static interface Callback {
			void onResult(JSONArray json);
		}

		public Handler mHandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				if (msg.what == 1) {
					try {
						JSONArray json = (JSONArray) msg.obj;
						if (mCallback != null) {
							mCallback.onResult(json);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						dialog.hideLoading();
					}
				}else {

					mCallback.onResult(null);
				}
			}
		};
	}

}

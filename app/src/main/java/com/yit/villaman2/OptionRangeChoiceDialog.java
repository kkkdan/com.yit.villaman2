package com.yit.villaman2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;

public class OptionRangeChoiceDialog extends BaseDialog {

	private MainActivity				activity;

	private static final String __TAG__ = "RangeChoice♥♥:";
	private Context context;
	//private CheckBox allCheckBox;
	private Button btnMyItem;
	private Button btnMyNew;
	private Button btnMyConfirm;
	private Button btnMyFavorite;
	private Button btnMyBlank;
	private Button btnMyRecommend;

	private Button btnDialogClose;
	private Button btnRangeCancel;

	private EditText MyNew02;
	private EditText MyConfirm02;

	private RadioGroup MyNewEmptyGR;
	private RadioGroup MyNewPicynGR;
	private RadioGroup MyConEmptyGR;
	private RadioGroup MyConPicynGR;
	private RadioGroup MyBlankPicynGR;


	private HashMap<String, String> addressMap;

	private Callback mCallback;


	public OptionRangeChoiceDialog(MainActivity context, int theme, HashMap<String, String> addressMap) {
		super(context, theme);
		this.context = context;
		this.addressMap  = addressMap;
		this.activity = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		startView();
		startAction();
	}

	private void startView() {
		btnMyItem = (Button) findViewById(R.id.btnMyItem);
		btnMyNew = (Button) findViewById(R.id.btnMyNew);
		btnMyConfirm = (Button) findViewById(R.id.btnMyConfirm);
		btnMyFavorite = (Button) findViewById(R.id.btnMyFavorite);
		btnMyBlank = (Button) findViewById(R.id.btnMyBlank);
		btnMyRecommend = (Button) findViewById(R.id.btnMyRecommend);

		btnDialogClose = (Button) findViewById(R.id.btnDialogClose);
		btnRangeCancel = (Button) findViewById(R.id.btnRangeCancel);

		MyConfirm02  = (EditText) findViewById(R.id.MyConfirm02);
		MyNew02  = (EditText) findViewById(R.id.MyNew02);

		/////////////////////////////////////////////////////////////
		MyNewEmptyGR = (RadioGroup) findViewById(R.id.MyNewEmptyGR);
		RadioButton MyNewEmpty00 = (RadioButton) findViewById(R.id.MyNewEmpty00);;
		RadioButton MyNewEmpty01 = (RadioButton) findViewById(R.id.MyNewEmpty01);;
		RadioButton MyNewEmpty02 = (RadioButton) findViewById(R.id.MyNewEmpty02);;
		if(FProPrefer.with(context).getMyNewEmpty() != null && FProPrefer.with(context).getMyNewEmpty() != ""){
			if (FProPrefer.with(context).getMyNewEmpty().equals("공실"))
			{
				MyNewEmpty01.setChecked(true);
			}
			else if (FProPrefer.with(context).getMyNewEmpty().equals("거주중")) {
				MyNewEmpty02.setChecked(true);
			}
			else {
				MyNewEmpty00.setChecked(true);
			}
		} else {
			MyNewEmpty00.setChecked(true);
		}

		MyNewPicynGR = (RadioGroup) findViewById(R.id.MyNewPicynGR);
		RadioButton MyNewPicyn00 = (RadioButton) findViewById(R.id.MyNewPicyn00);;
		RadioButton MyNewPicyn01 = (RadioButton) findViewById(R.id.MyNewPicyn01);;
		RadioButton MyNewPicyn02 = (RadioButton) findViewById(R.id.MyNewPicyn02);;
		if(FProPrefer.with(context).getMyNewPicyn() != null && FProPrefer.with(context).getMyNewPicyn() != ""){
			if (FProPrefer.with(context).getMyNewPicyn().equals("유"))
			{
				MyNewPicyn01.setChecked(true);
			}
			else if (FProPrefer.with(context).getMyNewPicyn().equals("무")) {
				MyNewPicyn02.setChecked(true);
			}
			else {
				MyNewPicyn00.setChecked(true);
			}
		} else {
			MyNewPicyn00.setChecked(true);
		}
		/////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////
		MyConEmptyGR = (RadioGroup) findViewById(R.id.MyConEmptyGR);
		RadioButton MyConEmpty00 = (RadioButton) findViewById(R.id.MyConEmpty00);;
		RadioButton MyConEmpty01 = (RadioButton) findViewById(R.id.MyConEmpty01);;
		RadioButton MyConEmpty02 = (RadioButton) findViewById(R.id.MyConEmpty02);;

		if(FProPrefer.with(context).getMyConEmpty() != null && FProPrefer.with(context).getMyConEmpty() != ""){
			if (FProPrefer.with(context).getMyConEmpty().equals("공실"))
			{
				MyConEmpty01.setChecked(true);
			}
			else if (FProPrefer.with(context).getMyConEmpty().equals("거주중")) {
				MyConEmpty02.setChecked(true);
			}
			else {
				MyConEmpty00.setChecked(true);
			}

		} else {
			MyConEmpty00.setChecked(true);
		}

		MyConPicynGR = (RadioGroup) findViewById(R.id.MyConPicynGR);
		RadioButton MyConPicyn00 = (RadioButton) findViewById(R.id.MyConPicyn00);;
		RadioButton MyConPicyn01 = (RadioButton) findViewById(R.id.MyConPicyn01);;
		RadioButton MyConPicyn02 = (RadioButton) findViewById(R.id.MyConPicyn02);;
		if(FProPrefer.with(context).getMyConPicyn() != null && FProPrefer.with(context).getMyConPicyn() != ""){
			if (FProPrefer.with(context).getMyConPicyn().equals("유"))
			{
				MyConPicyn01.setChecked(true);
			}
			else if (FProPrefer.with(context).getMyConPicyn().equals("무")) {
				MyConPicyn02.setChecked(true);
			}
			else {
				MyConPicyn00.setChecked(true);
			}

		} else {
			MyConPicyn00.setChecked(true);
		}
		/////////////////////////////////////////////////////////////

		/////////////////////////////////////////////////////////////
		MyBlankPicynGR = (RadioGroup) findViewById(R.id.MyBlankPicynGR);
		RadioButton MyBlankPicyn00 = (RadioButton) findViewById(R.id.MyBlankPicyn00);;
		RadioButton MyBlankPicyn01 = (RadioButton) findViewById(R.id.MyBlankPicyn01);;
		RadioButton MyBlankPicyn02 = (RadioButton) findViewById(R.id.MyBlankPicyn02);;
		if(FProPrefer.with(context).getMyBlankPicyn() != null && FProPrefer.with(context).getMyBlankPicyn() != ""){
			if (FProPrefer.with(context).getMyBlankPicyn().equals("유"))
			{
				MyBlankPicyn01.setChecked(true);
			}
			else if (FProPrefer.with(context).getMyBlankPicyn().equals("무")) {
				MyBlankPicyn02.setChecked(true);
			}
			else {
				MyBlankPicyn00.setChecked(true);
			}

		} else {
			MyBlankPicyn00.setChecked(true);
		}
		/////////////////////////////////////////////////////////////


		/////////////////////////////////////////////////////////////
		if(FProPrefer.with(context).getMyConfirm02() != null && FProPrefer.with(context).getMyConfirm02() != ""){
			MyConfirm02.setText(FProPrefer.with(context).getMyConfirm02());
		} else {
			MyConfirm02.setText("7");
		}
		/////////////////////////////////////////////////////////////


		/////////////////////////////////////////////////////////////
		if(FProPrefer.with(context).getMyNew02() != null && FProPrefer.with(context).getMyNew02() != ""){
			MyNew02.setText(FProPrefer.with(context).getMyNew02());
		} else {
			MyNew02.setText("7");
		}
		/////////////////////////////////////////////////////////////
	}


	private void startAction() {

		// DODO 검색에서 나의매물 버튼
		btnMyItem.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				HashMap<String, String> detailMap = new HashMap<String, String>();
				detailMap.put("sido", addressMap.get("sido").toString());
				detailMap.put("gungu", addressMap.get("gungu").toString());
				detailMap.put("dong", addressMap.get("dong").toString());

				detailMap.put("ma_mae_ney1", "");
				detailMap.put("ma_mae_ney2", "");
				detailMap.put("ma_jeon_area1",  "");
				detailMap.put("ma_jeon_area2",  "");
				detailMap.put("ma_level1",  "");
				detailMap.put("ma_level2",  "");
				detailMap.put("ma_room1",  "");
				detailMap.put("ma_room2",  "");
				detailMap.put("ma_jun_year1",  "");
				detailMap.put("ma_jun_year2",  "");

				String sPhone = Util.getPhoneNumber(context);
				detailMap.put("ma_bld_nm", sPhone);

                detailMap.put("ma_search", "myitem");
				detailMap.put("viloldnew", "");

				// 선택 조회 상태 저장
				FProPrefer.with(context).setChoiceMaSearch("myitem");
				FProPrefer.with(context).setSearchAction("Choice");

				if (mCallback != null) {
					mCallback.onResponse(detailMap);
				}
				dismiss();
			}

		});

		// DODO 검색에서 최신매물 버튼
		btnMyNew.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				HashMap<String, String> detailMap = new HashMap<String, String>();

				detailMap.put("sido", addressMap.get("sido").toString());
				detailMap.put("gungu", addressMap.get("gungu").toString());
				detailMap.put("dong", addressMap.get("dong").toString());

				detailMap.put("ma_mae_ney1", "");
				detailMap.put("ma_mae_ney2", "");
				detailMap.put("ma_jeon_area1", "");
				detailMap.put("ma_jeon_area2", "");
				detailMap.put("ma_level1", "");
				detailMap.put("ma_level2", "");
				detailMap.put("ma_room1", "");
				detailMap.put("ma_room2", "");
				detailMap.put("ma_jun_year1", "");
				detailMap.put("ma_jun_year2", "");
				detailMap.put("ma_bld_nm", "");

				detailMap.put("ma_search", "mynew");
				detailMap.put("viloldnew", "");

				// 선택 조회 상태 저장
				FProPrefer.with(context).setChoiceMaSearch("mynew");
				FProPrefer.with(context).setSearchAction("Choice");

				MyNewEmptyGR = (RadioGroup) findViewById(R.id.MyNewEmptyGR);
				MyNewPicynGR = (RadioGroup) findViewById(R.id.MyNewPicynGR);

				RadioButton MyEmpty = (RadioButton) findViewById(MyNewEmptyGR.getCheckedRadioButtonId());
				String str_MyEmpty = MyEmpty.getText().toString();
				if (str_MyEmpty.equals("공실")) {
					detailMap.put("ma_status1", "E");
				} else if (str_MyEmpty.equals("거주중")) {
					detailMap.put("ma_status1", "B");
				} else {
					detailMap.put("ma_status1", "");
				}
				FProPrefer.with(context).setMyNewEmpty(str_MyEmpty);

				RadioButton MyPicyn = (RadioButton) findViewById(MyNewPicynGR.getCheckedRadioButtonId());
				String str_MyPicyn = MyPicyn.getText().toString();
				if (str_MyPicyn.equals("유")) {
					detailMap.put("ma_gallery", "Y");
				} else if (str_MyPicyn.equals("무")) {
					detailMap.put("ma_gallery", "N");
				} else {
					detailMap.put("ma_gallery", "");
				}
				FProPrefer.with(context).setMyNewPicyn(str_MyPicyn);


				String strMyNew02 = MyNew02.getText().toString();
				if (strMyNew02 == null || strMyNew02.equals("")) {
					Toast.makeText(context, "일자는 필수 항목입니다.", Toast.LENGTH_SHORT).show();
					MyNew02.requestFocus();
				} else {

					FProPrefer.with(context).setMyNew02(MyNew02.getText().toString());

					if (mCallback != null) {
						mCallback.onResponse(detailMap);
					}

					dismiss();
				}

			}

		});

		// DODO 검색에서 확인매물 버튼
		btnMyConfirm.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				HashMap<String, String> detailMap = new HashMap<String, String>();

				detailMap.put("sido", addressMap.get("sido").toString());
				detailMap.put("gungu", addressMap.get("gungu").toString());
				detailMap.put("dong", addressMap.get("dong").toString());

				detailMap.put("ma_mae_ney1", "");
				detailMap.put("ma_mae_ney2", "");
				detailMap.put("ma_jeon_area1",  "");
				detailMap.put("ma_jeon_area2",  "");
				detailMap.put("ma_level1",  "");
				detailMap.put("ma_level2",  "");
				detailMap.put("ma_room1",  "");
				detailMap.put("ma_room2",  "");
				detailMap.put("ma_jun_year1",  "");
				detailMap.put("ma_jun_year2",  "");
				detailMap.put("ma_bld_nm", "");

				detailMap.put("ma_search", "myconfirm");
				detailMap.put("viloldnew", "");

				// 선택 조회 상태 저장
				FProPrefer.with(context).setChoiceMaSearch("myconfirm");
				FProPrefer.with(context).setSearchAction("Choice");

				MyConEmptyGR = (RadioGroup) findViewById(R.id.MyConEmptyGR);
				MyConPicynGR = (RadioGroup) findViewById(R.id.MyConPicynGR);

				RadioButton MyEmpty = (RadioButton) findViewById(MyConEmptyGR.getCheckedRadioButtonId());
				String str_MyEmpty = MyEmpty.getText().toString();
				if (str_MyEmpty.equals("공실")) {
					detailMap.put("ma_status1", "E");
				} else if (str_MyEmpty.equals("거주중")) {
					detailMap.put("ma_status1", "B");
				} else {
					detailMap.put("ma_status1", "");
				}
				FProPrefer.with(context).setMyConEmpty(str_MyEmpty);

				RadioButton MyPicyn = (RadioButton) findViewById(MyConPicynGR.getCheckedRadioButtonId());
				String str_MyPicyn = MyPicyn.getText().toString();
				if (str_MyPicyn.equals("유")) {
					detailMap.put("ma_gallery", "Y");
				} else if (str_MyPicyn.equals("무")) {
					detailMap.put("ma_gallery", "N");
				} else {
					detailMap.put("ma_gallery", "");
				}
				FProPrefer.with(context).setMyConPicyn(str_MyPicyn);

				String strMyConfirm02 = MyConfirm02.getText().toString();
				if (strMyConfirm02 == null || strMyConfirm02.equals("")) {
					Toast.makeText(context, "일자는 필수 항목입니다.", Toast.LENGTH_SHORT).show();
					MyConfirm02.requestFocus();
				} else {

					FProPrefer.with(context).setMyConfirm02(MyConfirm02.getText().toString());

					if (mCallback != null) {
						mCallback.onResponse(detailMap);
					}

					dismiss();
				}

			}

		});

		// DODO 검색에서 즐겨찾기 버튼
		btnMyFavorite.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				HashMap<String, String> detailMap = new HashMap<String, String>();

				detailMap.put("sido", addressMap.get("sido").toString());
				detailMap.put("gungu", addressMap.get("gungu").toString());
				detailMap.put("dong", addressMap.get("dong").toString());

                detailMap.put("ma_mae_ney1", "");
                detailMap.put("ma_mae_ney2", "");
                detailMap.put("ma_jeon_area1",  "");
                detailMap.put("ma_jeon_area2",  "");
                detailMap.put("ma_level1",  "");
                detailMap.put("ma_level2",  "");
                detailMap.put("ma_room1",  "");
                detailMap.put("ma_room2",  "");
                detailMap.put("ma_jun_year1",  "");
                detailMap.put("ma_jun_year2",  "");
                detailMap.put("ma_bld_nm", "");

                detailMap.put("ma_search", "myfavorite");
				detailMap.put("viloldnew", "");

				// 선택 조회 상태 저장
				FProPrefer.with(context).setChoiceMaSearch("myfavorite");
				FProPrefer.with(context).setSearchAction("Choice");

				if (mCallback != null) {
					mCallback.onResponse(detailMap);
				}
				dismiss();

			}

		});

		// DODO 검색에서 공실매물 버튼
		btnMyBlank.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				HashMap<String, String> detailMap = new HashMap<String, String>();

				detailMap.put("sido", addressMap.get("sido").toString());
				detailMap.put("gungu", addressMap.get("gungu").toString());
				detailMap.put("dong", addressMap.get("dong").toString());

				detailMap.put("ma_mae_ney1", "");
				detailMap.put("ma_mae_ney2", "");
				detailMap.put("ma_jeon_area1",  "");
				detailMap.put("ma_jeon_area2",  "");
				detailMap.put("ma_level1",  "");
				detailMap.put("ma_level2",  "");
				detailMap.put("ma_room1",  "");
				detailMap.put("ma_room2",  "");
				detailMap.put("ma_jun_year1",  "");
				detailMap.put("ma_jun_year2",  "");
				detailMap.put("ma_bld_nm", "");

				detailMap.put("ma_search", "myblank");
				detailMap.put("viloldnew", "");

				// 선택 조회 상태 저장
				FProPrefer.with(context).setChoiceMaSearch("myblank");
				FProPrefer.with(context).setSearchAction("Choice");

				RadioButton MyPicyn = (RadioButton) findViewById(MyBlankPicynGR.getCheckedRadioButtonId());
				String str_MyPicyn = MyPicyn.getText().toString();
				if (str_MyPicyn.equals("유")) {
					detailMap.put("ma_gallery", "Y");
				} else if (str_MyPicyn.equals("무")) {
					detailMap.put("ma_gallery", "N");
				} else {
					detailMap.put("ma_gallery", "");
				}
				FProPrefer.with(context).setMyBlankPicyn(str_MyPicyn);

				if (mCallback != null) {
					mCallback.onResponse(detailMap);
				}
				dismiss();

			}

		});

		// DODO 검색에서 추천매물 버튼
		btnMyRecommend.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				HashMap<String, String> detailMap = new HashMap<String, String>();

				detailMap.put("sido", addressMap.get("sido").toString());
				detailMap.put("gungu", addressMap.get("gungu").toString());
				detailMap.put("dong", addressMap.get("dong").toString());

				detailMap.put("ma_mae_ney1", "");
				detailMap.put("ma_mae_ney2", "");
				detailMap.put("ma_jeon_area1",  "");
				detailMap.put("ma_jeon_area2",  "");
				detailMap.put("ma_level1",  "");
				detailMap.put("ma_level2",  "");
				detailMap.put("ma_room1",  "");
				detailMap.put("ma_room2",  "");
				detailMap.put("ma_jun_year1",  "");
				detailMap.put("ma_jun_year2",  "");
				detailMap.put("ma_bld_nm", "");

				detailMap.put("ma_search", "myrecommend");
				detailMap.put("viloldnew", "");

				// 선택 조회 상태 저장
				FProPrefer.with(context).setChoiceMaSearch("myrecommend");
				FProPrefer.with(context).setSearchAction("Choice");

				if (mCallback != null) {
					mCallback.onResponse(detailMap);
				}
				dismiss();

			}

		});


		// DODO 검색에서 닫기버튼
		btnRangeCancel.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {

				FProPrefer.with(context).setMyConfirm02(MyConfirm02.getText().toString());
				FProPrefer.with(context).setMyNew02(MyNew02.getText().toString());

				dismiss();
			}
		});

		btnDialogClose.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();
			}
		});

	}
	public OptionRangeChoiceDialog forStart(Callback OptionSelectDialog_Callback) {
		mCallback = OptionSelectDialog_Callback;
		return this;
	}
	
	public static interface Callback {
		void onResponse(HashMap<String, String> detailMap);
	}

}

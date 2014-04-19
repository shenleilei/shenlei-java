package com.amaker.wlo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.OnCameraChangeListener;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.SupportMapFragment;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.VisibleRegion;
import com.amapv2.cn.apis.util.AMapUtil;
import com.amapv2.cn.apis.util.Constants;
import com.amapv2.cn.apis.util.ToastUtil;

/**
 * AMapV2��ͼ����ʾ�����һ��marker���Ҷ�marker��Ӧ����¼�
 */
public class BasicMapActivity extends FragmentActivity implements
		OnMarkerClickListener {
	private AMap aMap;
	private Marker defaultMarker;
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyyMMddHHmmss", Locale.CHINA);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basic_demo);
		init();
	}

	/**
	 * ��ʼ��AMap����
	 */

	private void init() {
		if (aMap == null) {
			aMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			aMap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(Constants.HUASHI, 11));
			if (AMapUtil.checkReady(this, aMap)) {
				setUpMap();
			}
		}
	}

	private void setUpMap() {
		// �Ե�ͼ���һ��marker
		defaultMarker = aMap.addMarker(new MarkerOptions()
				.position(Constants.HUASHI).title("xx ��ѧ").snippet("xxxx")
				.icon(BitmapDescriptorFactory.defaultMarker()));
		aMap.getUiSettings().setZoomControlsEnabled(true);// ����ϵͳĬ�����Ű�ť�ɼ�
		aMap.setOnMarkerClickListener(this);// ��marker��ӵ��������
		aMap.setOnCameraChangeListener(new OnCameraChangeListener() { // ���ÿ�������ı������

			@Override
			public void onCameraChange(CameraPosition cameraPosion) {
				
			}

			@Override
			public void onCameraChangeFinish(CameraPosition cameraPosion) {
				VisibleRegion visibleRegion = aMap.getProjection()
						.getVisibleRegion(); // ��ȡ��������
				LatLngBounds latLngBounds = aMap.getProjection()
						.getVisibleRegion().latLngBounds;// ��ȡ���������Bounds
				boolean isContain = latLngBounds.contains(Constants.SHANGHAI);// �ж��Ϻ���γ���Ƿ�����ڱ�������
				Log.d("BasicMapActivity",
						"visible region: " + visibleRegion.toString()
								+ "LatLngBounds��" + latLngBounds.toString()
								+ "�Ϻ���γ���Ƿ����人��Χ��" + isContain);
			}

		});
	}

	/**
	 * ��marker��ע������Ӧ�¼�
	 */
	@Override
	public boolean onMarkerClick(Marker marker) {
		if (marker.equals(defaultMarker)) {
			ToastUtil.show(BasicMapActivity.this, marker.getSnippet());
		}
		return false;
	}

	/**
	 * �Ե�ͼ���н���
	 */
	public void getMapScreenShot(View v) {

		aMap.getMapPrintScreen(new AMap.onMapPrintScreenListener() {

			@Override
			public void onMapPrint(Drawable r) {
				Bitmap bitmap = ((BitmapDrawable) r).getBitmap();
				try {
					FileOutputStream fos = new FileOutputStream(Environment
							.getExternalStorageDirectory()
							+ "/test_"
							+ sdf.format(new Date()) + ".png");
					boolean b = bitmap.compress(CompressFormat.PNG, 100, fos);
					try {
						fos.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					if (b)
						Toast.makeText(BasicMapActivity.this, "�����ɹ�",
								Toast.LENGTH_SHORT).show();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

		});

	}
	/**
	 * 1���ش��������
	 */
	public void getScale(View v) {
		float scale = aMap.getScalePerPixel();
		Toast.makeText(BasicMapActivity.this, "ÿ���ش���" + scale + "��",
				Toast.LENGTH_SHORT).show();
	}
}

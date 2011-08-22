package com.codeskraps.ocras;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapViewActivity extends MapActivity {
	
	private MapController mapController;
	private MapView mapView;
	private LocationManager locationManager;
	private GeoUpdateHandler geoUpdate = new GeoUpdateHandler();
	
	List<Overlay> mapOverlays;
	Drawable drawable;
	CustomItemizedOverlay itemizedOverlay;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.map_view);
		
		// create a map view
		mapView = (MapView) findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);
		mapView.setStreetView(true);
		mapController = mapView.getController();
		mapController.setZoom(14); // Zoon 1 is world view
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, geoUpdate);
		
		mapOverlays = mapView.getOverlays();
		drawable = this.getResources().getDrawable(R.drawable.pin);
		itemizedOverlay = new CustomItemizedOverlay(drawable);
		
		for (OverlayItem o : getOverlayItem()) 
			itemizedOverlay.addOverlay(o);
				
		mapOverlays.add(itemizedOverlay);
	}

	public class GeoUpdateHandler implements LocationListener {

		@Override
		public void onLocationChanged(Location location) {
			int lat = (int) (location.getLatitude() * 1E6);
			int lng = (int) (location.getLongitude() * 1E6);
			GeoPoint point = new GeoPoint(lat, lng);
			mapController.animateTo(point); //	mapController.setCenter(point);
			locationManager.removeUpdates(geoUpdate);
		}

		@Override
		public void onProviderDisabled(String provider) {
		}

		@Override
		public void onProviderEnabled(String provider) {
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	}
	
	private List<OverlayItem> getOverlayItem(){
		List<OverlayItem> o = new ArrayList<OverlayItem>();
		
		o.add(new OverlayItem(new GeoPoint(53269723,-9053721), "", "")); //Galway City Museum
		o.add(new OverlayItem(new GeoPoint(53272513,-9057289), "", "")); //Nuns Island
		o.add(new OverlayItem(new GeoPoint(53269981,-9054344), "", "")); //Spanish Arch
		o.add(new OverlayItem(new GeoPoint(532725,-905435), "", "")); //St. Nicolas Curch
		o.add(new OverlayItem(new GeoPoint(53269601,-9053842), "", "")); //Ard Bia
		o.add(new OverlayItem(new GeoPoint(53269946,-9059688), "", "")); //Massimos
		o.add(new OverlayItem(new GeoPoint(53270637,-9054395), "", "")); //Pura Vida 
		
		return o;
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
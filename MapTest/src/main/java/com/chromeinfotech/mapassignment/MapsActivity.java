package com.chromeinfotech.mapassignment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chromeinfotech.BaseActivity.BaseActivity;
import com.chromeinfotech.utils.Utils;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends BaseActivity implements OnMapReadyCallback ,GoogleMap.OnMapLongClickListener, GoogleMap.OnMapClickListener ,View.OnClickListener ,GoogleMap.OnInfoWindowClickListener ,GoogleMap.OnMarkerClickListener , GoogleMap.OnCameraChangeListener {

    private GoogleMap mMap;
    private PolylineOptions polylineOptions;
    private Polyline polyline;
    private List<LatLng> listPoint;
    private  Button btnClear ;
    private Polygon polygon;
    private String title ="" ;
    private String[] offer;
    private Bitmap bitmap , bitmap1 ;
    private  int [] price ;
    private Double [] latitude ;
    private Double [] longitude ;
    final  int markerCount = 10 ;
    private PolygonOptions polygonOptions = new PolygonOptions();
    private ArrayList<MyMarkaerData> markersArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        this.reference();
        this.init();
        this.addMarkerinList();
        this.setListenrs();

    }

    /**
     * add Marker DAta into list
     */
    private void addMarkerinList() {
        for(int i = 0 ; i< markerCount ; i++){
            MyMarkaerData  markerdata = new MyMarkaerData() ;
            markerdata.setLatitude(latitude[i]);
            markerdata.setLongitude(longitude[i]);
            markerdata.setIconbitmap(getMarkerBitmapFromView(bitmap ,bitmap1 , offer[i], price[i]));
            markerdata .setTitle(getTitle(latitude[i] ,longitude[i]));
            markersArrayList.add(markerdata) ;
        }

    }

    /**
     * merge two bitmap and return  final bitmap
     * @param top
     * @param base
     * @param offer
     * @param price
     * @return
     */
    private Bitmap getMarkerBitmapFromView(Bitmap top, Bitmap base,String offer, int price) {
        Bitmap bitmap = null;
        int width;
        int height = top.getHeight() + base.getHeight();
        if (top.getWidth() < base.getWidth()) {
            width = top.getWidth();
        } else {
            width = base.getWidth();
        }
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config. ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = getPaint() ;
        canvas.drawBitmap(top, 0, 0, paint);
        canvas.drawText(offer,100, 100, paint);
        canvas.drawBitmap(base, 0, top.getHeight(),paint);
        canvas.drawText(String.valueOf(price), 100, 200, paint);
        return bitmap;
    }

    /**
     * initialize variable and object
     */
    @Override
    public void init() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        listPoint    = new ArrayList<LatLng>() ;
        markersArrayList = new ArrayList<MyMarkaerData>();
        price        = new int[]{100 ,200 ,300 ,400 , 500 , 600 ,700 , 800 ,900 ,1000};
        offer        = new String[] {"offer1" , "offer2" , "offer3" , "offer4" , "offer5" , "offer6" , "offer7" , "offer8" , "offer9", "offer10"};
        latitude     = new Double[]{33.69539713278257 , 31.351660191869005,26.640131080546208 ,27.568322802767366 ,24.474706701706236,20.17884581522505 ,17.887691318299925 ,19.918989599934434,23.593335872074483,22.378782166828987};
        longitude    = new Double[]{76.02980956435204 ,76.96478337049484 ,71.83885462582111 ,80.3322260454297 , 84.21882033348083 ,84.18963957577944,79.45270758122206 ,74.59052413702013 ,77.79409155249596 , 71.17286950349808};
        bitmap       = BitmapFactory.decodeResource(getResources(), R.drawable.red_curved_bg);
        bitmap1      = BitmapFactory.decodeResource(getResources(), R.drawable.indecation_bg);
    }

    /**
     * clear the clearPolyline
     */
    private void clearPolyline() {
        if (polyline != null) {
            polyline.remove();
            mMap.clear();
        } else {
            polylineOptions = new PolylineOptions();
            polylineOptions.color(Color.RED);
            listPoint.clear();
            mMap.clear();
        }
    }

    /**
     * initialize the map and perform lisner on map
     * @param googleMap
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        Utils.printLog("onMapClick", "inside onMapReady()");
        mMap = googleMap;
        mMap.setMapType(googleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.setOnMapClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnMarkerClickListener(this);
        mMap.setOnCameraChangeListener(this);
        clearPolyline();
        setMarker();
        Utils.printLog("onMapClick", "outside onMapReady()");
    }

    /**
     * set marker on map
     */
    private void setMarker() {
        Utils.printLog("mapsActivity" ,"arraysize" + markersArrayList.size());
        for(int i = 0; i < markersArrayList.size() ; i ++ ) {

            addCustomMarker( markersArrayList.get(i).getLatitude(),  markersArrayList.get(i).getLongitude(),  markersArrayList.get(i).getTitle(),  markersArrayList.get(i).getIconbitmap());
        }
    }

    /**
     * add custome marker
     * @param latitude
     * @param longitude
     * @param title
     * @param bitmap
     */
    private void addCustomMarker(double latitude, double longitude, String title, Bitmap bitmap) {
        Utils.printLog("mapsActivity" ,"latitude=" +latitude+ "longitude="+longitude);
        LatLng latlnag = new LatLng(latitude,longitude) ;
        mMap.addMarker(new MarkerOptions()
                .position(latlnag)
                .icon(BitmapDescriptorFactory.fromBitmap((bitmap)))
                .title(title)
        );
    }

    /**
     * perform operation on map click
     * @param latLng
     */
    @Override
    public void onMapClick(LatLng latLng) {
//        Utils.printLog("onMapClick", "inside onMapClick()");
        //mMap.setInfoWindowAdapter(new InfoAdapter(getLayoutInflater()));
        setMarker();
        Utils.printLog("onMapClick", "outside onMapClick()     longitude="+latLng.longitude +"latitude="+ latLng.latitude);
    }

    /**
     * return paint object
     * @return
     */
    private Paint getPaint() {
        Paint color = new Paint();
        color.setTextSize(50);
        color.setColor(Color.WHITE);
        return color;
    }

    /**
     * get the title of marker
     * @param latitude  marker latitude
     * @param longitude marker  longitude
     * @return
     */
    private String getTitle(double latitude, double longitude) {
        Utils.printLog("time" ,"="+System.currentTimeMillis());
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 4);
            if (addresses.size() == 0) {
                title ="ocean" ;
            } else {

                Address obj = addresses.get(0);
                title = obj.getAddressLine(0);
                title = title + "\n" + obj.getCountryName();
                title = title + "\n" + obj.getAdminArea();

            }}catch(IOException e){
            e.printStackTrace();
            Utils.showToast(this, e.getMessage());

        }
        Utils.printLog("time" ,"=" + System.currentTimeMillis());
        return title;
    }

    /**
     * perform operation on button click
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clear:
                clearPolyline();
                break;
        }
    }

    /**
     * create the reference
     */
    @Override
    public void reference() {
        btnClear           = (Button)findViewById(R.id.clear);
    }

    /**
     * set listner on button
     */
    @Override
    public void setListenrs() {
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        Utils.showToast(getApplicationContext() ,""+ marker.getTitle());
    }

    /**
     * return the title of marker on marker click
     * @param marker
     * @return
     */
    @Override
    public boolean onMarkerClick(Marker marker) {
//        countPolygonPoints();
//        polygonOptions.add(marker.getPosition());
//        polylineOptions.add(marker.getPosition());
//        if(polyline != null){
//            polyline.remove();
//        }
//        polyline = mMap.addPolyline(polylineOptions);
//        listPoint.add(marker.getPosition());
        Utils.showToast(getApplicationContext() , marker.getTitle() );
        return true;
    }

    /**
     *
     * @param cameraPosition
     */
    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        Utils.printLog("TestLog", "OnCameraChange: " + cameraPosition);

    }

    /**
     * call when maplong click
     * @param latLng
     */
    @Override
    public void onMapLongClick(LatLng latLng) {

    }

    /**
     * count the PolygonPoints
     */
    public void countPolygonPoints(){
        if(polygonOptions.getPoints().size() > 3){
            polygonOptions.strokeColor(Color.RED);
            polygonOptions.strokeWidth((float) 0.30);
            polygonOptions.fillColor(Color.BLUE);
            polygon = mMap.addPolygon(polygonOptions);
        }}
}

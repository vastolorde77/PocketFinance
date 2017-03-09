package com.example.muammar.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.muammar.myapplication.MainActivity;
import com.example.muammar.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

public class LocationFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap googleMap;
    private MapView mMapView;

    private static View view;
    /**
     * Note that this may be null if the Google Play services APK is not
     * available.
     */

    private static GoogleMap mMap;
    private static Double latitude, longitude;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location, container, false);
//        mMapView = (MapView) v.findViewById(R.id.mapView);
//        mMapView.onCreate(savedInstanceState);
//        MapFragment mapFragment = (MapFragment)getFragmentManager();
//        mMapView.onResume();
//
//        try{
//            MapsInitializer.initialize(getActivity().getApplicationContext());
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        googleMap = mMapView.getMap();
//        double l = -6.1745;
//        double lon = 106.8227;
//        MarkerOptions marker = new MarkerOptions().position(new LatLng(l,lon)).title("25 March 2016 14:05 , Rp 45.000");
//
//        marker.icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_RED));
//
//        // adding marker
//        googleMap.addMarker(marker);
//        double l1 = -6.1625;
//        double lon1 = 106.9227;
//        MarkerOptions marker1 = new MarkerOptions().position(new LatLng(l1,lon1)).title("12 April 2016 15:45 , Rp 790.000");
//
//        marker.icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
//        googleMap.addMarker(marker);
//        double l2 = -6.1700;
//        double lon2 = 106.7727;
//        MarkerOptions marker2 = new MarkerOptions().position(new LatLng(l2,lon2)).title("Yesterday 14:12 , Rp 50.000 ");
//
//        marker.icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
//
//        // adding marker
//        googleMap.addMarker(marker);
//        googleMap.addMarker(marker1);
//        googleMap.addMarker(marker2);
//
//
//        CameraPosition cameraPosition = new CameraPosition.Builder()
//                .target(new LatLng(-6.1745, 106.8227)).zoom(10).build();
//        googleMap.animateCamera(CameraUpdateFactory
//                .newCameraPosition(cameraPosition));


        return v;
    }
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();
        mMapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        double l = -6.1745;
        double lon = 106.8227;
        MarkerOptions marker = new MarkerOptions().position(new LatLng(l,lon)).title("25 March 2016 14:05 , Rp 45.000");

        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED));

        // adding marker
        googleMap.addMarker(marker);
        double l1 = -6.1625;
        double lon1 = 106.9227;
        MarkerOptions marker1 = new MarkerOptions().position(new LatLng(l1,lon1)).title("12 April 2016 15:45 , Rp 790.000");

        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        googleMap.addMarker(marker);
        double l2 = -6.1700;
        double lon2 = 106.7727;
        MarkerOptions marker2 = new MarkerOptions().position(new LatLng(l2,lon2)).title("Yesterday 14:12 , Rp 50.000 ");

        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

        // adding marker
        googleMap.addMarker(marker);
        googleMap.addMarker(marker1);
        googleMap.addMarker(marker2);



        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(-6.1745, 106.8227)).zoom(10).build();
        googleMap.moveCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

    }
}
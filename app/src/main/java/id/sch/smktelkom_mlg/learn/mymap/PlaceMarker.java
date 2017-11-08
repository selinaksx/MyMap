package id.sch.smktelkom_mlg.learn.mymap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.

 */
public class PlaceMarker extends Fragment implements OnMapReadyCallback {

    static final CameraPosition MLG = CameraPosition.builder()
            .target(new LatLng(7.9666, 112.6326))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions rmh;
    MarkerOptions pasar;
    MarkerOptions sekolah;
    MarkerOptions msjd;

    public PlaceMarker() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_marker, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int imageresources = getResources().getIdentifier("@drawable/ic_location_on_black_24dp", "drawable", getActivity().getPackageName());

        rmh = new MarkerOptions()
                .position(new LatLng(8.1769, 112.6973))
                .title("My Hometown")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        pasar = new MarkerOptions()
                .position(new LatLng(-8.199056, 112.690509))
                .title("Pasar Turen")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        sekolah = new MarkerOptions()
                .position(new LatLng(-8.171040, 112.688500))
                .title("SMP 1 Turen")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));

        msjd = new MarkerOptions()
                .position(new LatLng(-8.150973, 112.713123))
                .title("Masjid Tiban")
                .icon(BitmapDescriptorFactory.fromResource(imageresources));
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.addMarker(rmh);
        m_map.addMarker(pasar);
        m_map.addMarker(sekolah);
        m_map.addMarker(msjd);
        flyTo(MLG);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}

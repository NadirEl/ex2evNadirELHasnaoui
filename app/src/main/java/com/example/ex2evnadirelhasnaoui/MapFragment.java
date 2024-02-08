package com.example.ex2evnadirelhasnaoui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class MapFragment extends Fragment {

    MapView mapView;
    ArrayList<OverlayItem> puntos = new ArrayList<>();

    IMapController mapController;
    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_fragment, container, false);

        mapView = view.findViewById(R.id.mapView);

        // Inicializar el mapa
        Configuration.getInstance().load(getActivity(), getActivity().getSharedPreferences("map_prefs", 0));

        mapView.setMultiTouchControls(true);
        mapView.setMultiTouchControls(true);
        //centramos el mapa
        GeoPoint centro = new GeoPoint(41.400604, 2.203648);

        mapController = mapView.getController();
        mapController.setCenter(centro);
        mapController.setZoom(16.0);
        // Añadir puntos al mapa
        añadirPuntos();


        ItemizedOverlayWithFocus<OverlayItem> overlays = new ItemizedOverlayWithFocus<>(getContext(), puntos, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }

            public boolean onItemLongPress(int index, OverlayItem item) {
                InformationFragment newFragment = new InformationFragment();

                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragmentContainer, newFragment);

                transaction.addToBackStack(null);

                transaction.commit();

                return true;
            }
        });

        overlays.setFocusItemsOnTap(true);
        mapView.getOverlays().add(overlays);

        return view;
    }

    void añadirPuntos() {

        GeoPoint point = new GeoPoint(41.400604, 2.203648);
        OverlayItem overlayItem = new OverlayItem("Camp Nou", "Este es el campo del Barcelona", point);
        puntos.add(overlayItem);
    }
}

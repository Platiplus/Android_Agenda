package com.platiplus.agenda;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.platiplus.agenda.DAO.AlunoDAO;
import com.platiplus.agenda.Model.Aluno;

import java.io.IOException;
import java.util.List;

public class MapaFragment extends SupportMapFragment implements OnMapReadyCallback {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng posicaoDaEscola = getCoordinates("Rua Vergueiro 3185, Vila Mariana, São Paulo");
        if(posicaoDaEscola != null){
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(posicaoDaEscola, 17);
            googleMap.moveCamera(update);
        }

        AlunoDAO alunoDAO = new AlunoDAO(getContext());
        for (Aluno aluno: alunoDAO.buscaAlunos()){
            LatLng coordenada = getCoordinates(aluno.getEndereco());
            if (coordenada != null){
                MarkerOptions marcador = new MarkerOptions();
                marcador.position(coordenada);
                marcador.title(aluno.getNome());
                marcador.snippet(String.valueOf(aluno.getNota()));
                googleMap.addMarker(marcador);
            }
        }
        alunoDAO.close();

        new Localizador(getContext(), googleMap);
    }

    private LatLng getCoordinates(String address){
        try {
            Geocoder geocoder = new Geocoder(getContext());
            List<Address> results = geocoder.getFromLocationName(address, 1);
            if(!results.isEmpty()){
                LatLng position = new LatLng(results.get(0).getLatitude(), results.get(0).getLongitude());
                return position;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.example.android.gymkhagymkha;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment_Eventos extends Fragment {

        @Override public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_eventos, container, false);
            return view; }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // do your variables initialisations here except Views!!!
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        ListView listaEventos = (ListView) view.findViewById(R.id.lvEventos);
        ArrayList<Evento> arrayEvent = new ArrayList<Evento>();
        Evento event;

        event = new Evento(1,"Evento22","13:00", true);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", false);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", true);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", false);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", true);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", false);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", true);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", false);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", true);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", false);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", true);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", false);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", true);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", false);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", true);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", false);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", true);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", false);
        arrayEvent.add(event);
        event = new Evento(1,"Evento1","13:00", true);
        arrayEvent.add(event);
        event = new Evento(1,"Evento33","13:00", false);
        arrayEvent.add(event);

        // Creo el adapter personalizado
        AdapterEvento adapter2 = new AdapterEvento(getActivity(), arrayEvent);

        listaEventos.setAdapter(adapter2);
    }
}


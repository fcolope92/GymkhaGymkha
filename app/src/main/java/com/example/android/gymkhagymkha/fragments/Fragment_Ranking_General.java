package com.example.android.gymkhagymkha.fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.gymkhagymkha.classes.Clase_Ranking;
import com.example.android.gymkhagymkha.R;
import com.example.android.gymkhagymkha.adapters.AdapterRanking;
import com.example.android.gymkhagymkha.bbdd.BDManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Fragment_Ranking_General extends Fragment {

    @Override public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking_general, container, false);
        return view; }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // do your variables initialisations here except Views!!!
    }

    String resul;
    ArrayList<Clase_Ranking> arrayRank;
    ListView listaRankingGeneral;
    BDManager manager;

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        /* Rellenamos el ListView manualmente, más adelante con un servicio lo rellenamos con
        información del servidor */
        listaRankingGeneral = (ListView) view.findViewById(R.id.lvRankingGeneral);
        arrayRank = new ArrayList<Clase_Ranking>();
        Clase_Ranking rank;

        rank = new Clase_Ranking(55,"Hector","10");
        arrayRank.add(rank);
        rank = new Clase_Ranking(2,"Victor","75");
        arrayRank.add(rank);
        rank = new Clase_Ranking(3,"Fran","25");
        arrayRank.add(rank);
        rank = new Clase_Ranking(4,"Fernando","1");
        arrayRank.add(rank);
        rank = new Clase_Ranking(1,"Hector","10");
        arrayRank.add(rank);
        rank = new Clase_Ranking(2,"Victor","75");
        arrayRank.add(rank);
        rank = new Clase_Ranking(3,"Fran","25");
        arrayRank.add(rank);
        rank = new Clase_Ranking(4,"Fernando","1");
        arrayRank.add(rank);
        rank = new Clase_Ranking(1,"Hector","100");
        arrayRank.add(rank);
        rank = new Clase_Ranking(2,"Victor","75");
        arrayRank.add(rank);
        rank = new Clase_Ranking(3,"Fran","25");
        arrayRank.add(rank);
        rank = new Clase_Ranking(4,"Fernando","1");
        arrayRank.add(rank);
        rank = new Clase_Ranking(1,"Hector","100");
        arrayRank.add(rank);
        rank = new Clase_Ranking(2,"Victor","75");
        arrayRank.add(rank);
        rank = new Clase_Ranking(3,"Fran","25");
        arrayRank.add(rank);
        rank = new Clase_Ranking(4,"Fernando","1");
        arrayRank.add(rank);
        rank = new Clase_Ranking(1,"Hector","100");
        arrayRank.add(rank);
        rank = new Clase_Ranking(2,"Victor","75");
        arrayRank.add(rank);
        rank = new Clase_Ranking(3,"Fran","25");
        arrayRank.add(rank);
        rank = new Clase_Ranking(4,"Fernando","1");
        arrayRank.add(rank);
        rank = new Clase_Ranking(1,"Hector","10");
        arrayRank.add(rank);
        rank = new Clase_Ranking(2,"Victor","75");
        arrayRank.add(rank);
        rank = new Clase_Ranking(3,"Fran","25");
        arrayRank.add(rank);
        rank = new Clase_Ranking(10,"Fernando","1");
        arrayRank.add(rank);
        rank = new Clase_Ranking(200,"Hector","10");
        arrayRank.add(rank);
        rank = new Clase_Ranking(2,"Victor","75");
        arrayRank.add(rank);
        rank = new Clase_Ranking(3,"Fran","25");
        arrayRank.add(rank);
        rank = new Clase_Ranking(4,"Fernando","1");
        arrayRank.add(rank);
        rank = new Clase_Ranking(1,"Hector","100");
        arrayRank.add(rank);
        rank = new Clase_Ranking(2,"Victor","75");
        arrayRank.add(rank);
        rank = new Clase_Ranking(3,"Fran","25");
        arrayRank.add(rank);
        rank = new Clase_Ranking(50,"Fernando","1");
        arrayRank.add(rank);

        manager = new BDManager(getActivity());
        Cursor cursor = manager.cursorLogin();
        cursor.moveToFirst();

        int idCentro = cursor.getInt(cursor.getColumnIndex(manager.CN_IDCENTRO));
        new AsyncRanking().execute("http://www.victordam2b.hol.es/rankingAcceso.php?idCentro=" + idCentro);

    }

    public class AsyncRanking extends AsyncTask<String, Void, StringBuilder> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            //progressBarEventos.setVisibility(View.VISIBLE);
        }

        @Override
        protected StringBuilder doInBackground(String... _url) {
            HttpURLConnection urlConnection=null;
            StringBuilder sb = new StringBuilder();
            String linea;
            resul = "";
            try {
                URL url = new URL(_url[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream is = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                while ((linea = br.readLine()) != null) {
                    resul = resul + linea;
                }
            }
            catch (MalformedURLException e) {
                Log.e("TESTNET", "URL MAL FORMADA");

            }
            catch (IOException e) {
                Log.e("TESTNET", "IO ERROR");
            }  finally {
                urlConnection.disconnect();
            }
            return sb;
        }
        protected void onPostExecute(StringBuilder sb) {
            if(resul.compareTo("-1") == 0 && resul.compareTo("-2") == 0 && resul.compareTo("-3") == 0 && resul.compareTo("-4") == 0 ){
                Log.i("Eventos","no admin");
            }
            else{
                JSONObject resultadoJSON;
                Clase_Ranking auxRanking;
                try {
                    resultadoJSON = new JSONObject(resul);
                    for (int i = 0; i < resultadoJSON.length(); i++) {
                        auxRanking = new Clase_Ranking(resultadoJSON.getJSONObject(i+""));
                        Clase_Ranking auxAux = new Clase_Ranking(59,auxRanking.getNombre(),String.valueOf(auxRanking.getPuntos()));
                        //manager.guardarEvento(evento.getIdEvento(), evento.getDescripcion(),evento.getNombre());
                        arrayRank.add(auxAux);
                    }
                    //listaEventos = (ListView) Fragment_Ranking_General.this.getActivity().findViewById(R.id.);
                    //adapterEventos = new AdapterEvento(getActivity(), arrayEvent);

                    // Creo el adapter personalizado
                    AdapterRanking adapter = new AdapterRanking(getActivity(), arrayRank);
                    // Lo aplico
                    listaRankingGeneral.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            //progressBarEventos.setVisibility(View.INVISIBLE);
            //cursorEventos = manager.cursorEventos();
        }
    }
}
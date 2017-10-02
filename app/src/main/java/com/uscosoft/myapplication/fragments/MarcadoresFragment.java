package com.uscosoft.myapplication.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.uscosoft.myapplication.R;
import com.uscosoft.myapplication.model.Marcador;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarcadoresFragment extends Fragment {


    Button btnGuardar;
    EditText txtLatitud;
    EditText txtLongitud;
    EditText txtNombre;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMarcador = database.getReference("marcadores");

    public MarcadoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marcadores, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnGuardar = view.findViewById(R.id.btnGuardar);
        txtLatitud = view.findViewById(R.id.txtLatitud);
        txtLongitud = view.findViewById(R.id.txtLongitud);
        txtNombre = view.findViewById(R.id.txtNombreMarcador);





        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Marcador marcador = new Marcador();
                marcador.setLatitud(Double.parseDouble(txtLatitud.getText().toString().trim()));
                marcador.setLongitud(Double.parseDouble(txtLongitud.getText().toString().trim()));
                marcador.setNombre(txtNombre.getText().toString().trim());

                refMarcador.child(marcador.getNombre()).setValue(marcador);
                Toast.makeText(view.getContext(), "Marcador guardado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

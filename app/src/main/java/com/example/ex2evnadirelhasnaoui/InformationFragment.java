package com.example.ex2evnadirelhasnaoui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ex2evnadirelhasnaoui.R;

public class InformationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);

        // Obtener referencias a los elementos de la interfaz de usuario
        TextView tituloTextView = view.findViewById(R.id.id_titulo);
        TextView descripcionTextView = view.findViewById(R.id.textView3);
        ImageView imageView = view.findViewById(R.id.imageView);
        Button backButton = view.findViewById(R.id.id_volvarmapa);


        tituloTextView.setText("Camp Nou");
        descripcionTextView.setText("The stadium's maximum height is 48 metres, and it covers a surface area of 55,000 square metres (250 metres long and 220 metres wide). In accordance with UEFA stipulations, the playing area has been downsized to 105 metres x 68 metres. With a capacity of 99,354, it is now the biggest stadium in Europe.");


        imageView.setImageResource(R.drawable.campnou);

        // Configurar un listener para el botón para volver al mapa
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerrar el fragmento actual y volver al mapa
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}

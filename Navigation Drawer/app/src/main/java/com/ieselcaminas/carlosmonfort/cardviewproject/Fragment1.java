package com.ieselcaminas.carlosmonfort.cardviewproject;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by alu20472135l on 08/11/16.
 */

public class Fragment1 extends Fragment{

    RecyclerView recyclerView;
    AdaptadorCard adaptador;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_fragment1, container, false);

        Toolbar toolbarCard = (Toolbar) rootView.findViewById(R.id.toolbarCard);

        final Card[] cards = new Card[]{
                new Card(R.drawable.whale, "Card 1"),
                new Card(R.drawable.whale2, "Card 2"),
                new Card(R.drawable.whale3, "Card 3"),
                new Card(R.drawable.whale4, "Card 4"),
                new Card(R.drawable.whale5, "Card 5"),
                new Card(R.drawable.whale6, "Card 6"),
                new Card(R.drawable.whale7, "Card 7"),
                new Card(R.drawable.whale8, "Card 8"),
        };

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adaptador = new AdaptadorCard(cards);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LaunchedbyF1.class);
                final View sharedtextview = v.findViewById(R.id.toolbarCard);
                final View sharedImageView = v.findViewById(R.id.imagen);
                Pair<View, String> p1 =  new Pair(sharedtextview,sharedtextview.getTransitionName());
                Pair<View, String> p2 =  new Pair(sharedImageView,sharedImageView.getTransitionName());
                Card item = cards[recyclerView.getChildPosition(v)];
                Bundle options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), p1,p2).toBundle();
                intent.putExtra("TEXTO",item.getTexto());
                intent.putExtra("IMAGE",item.getImagen());
                getActivity().startActivity(intent, options);
            }
        });
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return rootView;


    }

}

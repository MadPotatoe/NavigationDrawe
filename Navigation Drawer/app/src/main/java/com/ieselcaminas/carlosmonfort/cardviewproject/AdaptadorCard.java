package com.ieselcaminas.carlosmonfort.cardviewproject;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorCard extends RecyclerView.Adapter<AdaptadorCard.CardViewHolder>  implements View.OnClickListener{

    private static ArrayList<Card> fotos;
    private View.OnClickListener listener;

    public AdaptadorCard(Card[] fotos){
        this.fotos = new ArrayList<Card>();
        for(Card c : fotos){
            this.fotos.add(c);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }


    public class CardViewHolder extends RecyclerView.ViewHolder{

        private ImageView txtImagen;
        private Toolbar toolbarCard;

        public CardViewHolder(View itemView){
            super(itemView);
            txtImagen = (ImageView)itemView.findViewById(R.id.imagen);
            toolbarCard = (Toolbar) itemView.findViewById(R.id.toolbarCard);
        }

        public void bindCard(final Card card){
            txtImagen.setImageResource(card.getImagen());
            toolbarCard.setTitle(card.getTexto());
            toolbarCard.inflateMenu(R.menu.menu_card);

            toolbarCard.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){
                @Override
                public boolean onMenuItemClick(MenuItem item){
                    switch (item.getItemId()){
                        case R.id.action_copiar:
                            fotos.add(getAdapterPosition(), new Card(card.getImagen(), card.getTexto()));
                            notifyItemInserted(getAdapterPosition());
                            break;
                        case R.id.action_eliminar:
                            fotos.remove(getAdapterPosition());
                            notifyItemRemoved(getAdapterPosition());
                            break;
                    }
                    return true;
                }
            });
        }
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem, viewGroup, false);
        itemView.setOnClickListener(this);
        CardViewHolder tvh = new CardViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder viewHolder, int pos) {
        Card item = fotos.get(pos);

        viewHolder.bindCard(item);
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

}
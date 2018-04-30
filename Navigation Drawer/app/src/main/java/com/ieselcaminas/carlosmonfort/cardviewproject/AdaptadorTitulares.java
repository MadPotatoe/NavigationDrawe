package com.ieselcaminas.carlosmonfort.cardviewproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class AdaptadorTitulares extends ArrayAdapter<Titular> {


    public AdaptadorTitulares(Context context, Titular[] datos) {
        super(context, R.layout.listitemfragment2, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;

        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.listitemfragment2, null);

            holder = new ViewHolder();
            holder.titulo = (TextView) item.findViewById(R.id.LblTitulo);
            holder.subtitulo = (TextView) item.findViewById(R.id.LblSubTitulo);
            holder.img = (ImageView) item.findViewById(R.id.image);

            item.setTag(holder);

        } else {
            holder = (ViewHolder) item.getTag();
        }

        Bitmap bm = BitmapFactory.decodeResource(getContext().getResources(),getItem(position).getImage());
        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getContext().getResources(), bm);
        drawable.setCircular(true);

        holder.img.setImageDrawable(drawable);
        holder.titulo.setText(getItem(position).getTitulo());
        holder.subtitulo.setText(getItem(position).getSubtitulo());


        return (item);
    }

    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
        ImageView img;
    }
}
package com.ieselcaminas.carlosmonfort.cardviewproject;

/**
 * Created by alu20472135l on 18/10/16.
 */

public class Card {

    private String texto;
    private int imagen;

    public Card(int imageCard, String textCard){
        texto = textCard;
        imagen = imageCard;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

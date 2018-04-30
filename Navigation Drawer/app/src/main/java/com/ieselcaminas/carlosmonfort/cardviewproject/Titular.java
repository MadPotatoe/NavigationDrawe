package com.ieselcaminas.carlosmonfort.cardviewproject;

/**
 * Created by alu53789415m on 06/10/16.
 */
public class Titular {
    private String titulo;
    private String subtitulo;
    private int image;

    public Titular(int img, String tit, String sub) {
        titulo = tit;
        subtitulo = sub;
        image = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }
    public int getImage(){
        return image;
    }
}

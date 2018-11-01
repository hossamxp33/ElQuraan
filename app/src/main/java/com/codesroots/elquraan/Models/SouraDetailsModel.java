package com.codesroots.elquraan.Models;

/**
 * Created by Ali on 3/28/2018.
 */

public class SouraDetailsModel {

    private String name;
    private int id,number,gozaa,imagenumber;
    private byte[] image;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGozaa() {
        return gozaa;
    }

    public void setGozaa(int gozaa) {
        this.gozaa = gozaa;
    }

    public int getImagenumber() {
        return imagenumber;
    }

    public void setImagenumber(int imagenumber) {
        this.imagenumber = imagenumber;
    }
}

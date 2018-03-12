package com.mihisa.bitsandpizzas;

/**
 * Created by Mihisa on 12-Mar-18.
 */

public class Pasta {
    private String name;
    private int imageResourceId;

    public static final Pasta[] pasta = {
            new Pasta("Spaghetti Bolonese", R.drawable.bolognai_spagetti),
            new Pasta("Pasta Primavera", R.drawable.primavera_pasta)
    };
    private Pasta(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}

package com.mihisa.bitsandpizzas;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Mihisa on 28-Jan-18.
 */

public class OrderActivity extends AppCompatActivity {

    int orderPasta;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        if (getIntent().getExtras().get("piNo") == null) {
            orderPasta = (Integer) getIntent().getExtras().get("paNo");
            image = Pasta.pasta[orderPasta].getImageResourceId();
        } else {
            orderPasta = (Integer) getIntent().getExtras().get("piNo");
            image = Pizza.pizzas[orderPasta].getImageResourceId();
        }

        ImageView orderImage = findViewById(R.id.order_image);
        orderImage.setImageResource(image);
    }
}

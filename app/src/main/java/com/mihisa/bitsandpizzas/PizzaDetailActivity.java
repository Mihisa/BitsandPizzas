package com.mihisa.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import android.widget.TextView;

/**
 * Created by Mihisa on 26-Feb-18.
 */

public class PizzaDetailActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;
    public static final String EXTRA_PIZZANO = "pizzaNo";
    int pizzaNo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        //Включение кнопки вверх
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        pizzaNo = (Integer)getIntent().getExtras().get(EXTRA_PIZZANO);
        String pizzaName = Pizza.pizzas[pizzaNo].getName();
        TextView textView = (TextView) findViewById(R.id.pizza_text);
        textView.setText(pizzaName);
        int pizzaImage = Pizza.pizzas[pizzaNo].getImageResourceId();
        ImageView imageView = (ImageView) findViewById(R.id.pizza_image);
        imageView.setImageDrawable(getResources().getDrawable(pizzaImage));
        imageView.setContentDescription(pizzaName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //Использование названия пиццы в действии Share
        TextView textView = (TextView)findViewById(R.id.pizza_text);
        CharSequence pizzaName = textView.getText();
        MenuItem menuItem = menu.findItem(R.id.action_share);
//        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, pizzaName);
        shareActionProvider.setShareIntent(intent);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                intent.putExtra("piNo", pizzaNo);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}

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
 * Created by Mihisa on 12-Mar-18.
 */

public class PastaDetailActivity extends AppCompatActivity {

    ShareActionProvider shareActionProvider;
    public static final String EXTRA_PASTANO = "pastaNo";
    int pastaNo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pastaNo = (Integer) getIntent().getExtras().get(EXTRA_PASTANO);
        String pastaName = Pasta.pasta[pastaNo].getName();
        TextView textView = (TextView) findViewById(R.id.pasta_text);
        textView.setText(pastaName);
        int pastaImage = Pasta.pasta[pastaNo].getImageResourceId();
        ImageView imageView = (ImageView) findViewById(R.id.pasta_image);
        imageView.setImageDrawable(getResources().getDrawable(pastaImage));
        imageView.setContentDescription(pastaName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //Использование названия пиццы в действии Share
        TextView textView = (TextView) findViewById(R.id.pasta_text);
        CharSequence pastaName = textView.getText();
        MenuItem menuItem = menu.findItem(R.id.action_share);
//        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, pastaName);
        shareActionProvider.setShareIntent(intent);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                intent.putExtra("paNo", pastaNo);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}

package com.mihisa.bitsandpizzas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends android.app.Fragment {


    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_top, container, false);
        RecyclerView pizzaRecycle = (RecyclerView)layout.findViewById(R.id.pizza_recycler);
        String[] pizzaNames = new String[2];
        for(int i = 0; i < 2; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }
        int[] pizzaImages = new int[2];
        for(int i = 0; i < 2; i++){
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycle.setLayoutManager(layoutManager);

        CaptionedImageAdapter adapter = new CaptionedImageAdapter(pizzaNames, pizzaImages);
        pizzaRecycle.setAdapter(adapter);
        adapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO, position);
                getActivity().startActivity(intent);
            }
        });
        return layout;
    }

}
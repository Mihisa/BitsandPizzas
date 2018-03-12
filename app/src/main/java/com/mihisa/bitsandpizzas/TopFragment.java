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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
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
//        RelativeLayout layout1 = (RelativeLayout) inflater.inflate(R.layout.fragment_top, container, false);
        RecyclerView pastaRecycle = layout.findViewById(R.id.pasta_recycler);
        String[] pastaNames = new String[2];
        for (int i = 0; i < 2; i++) {
            pastaNames[i] = Pasta.pasta[i].getName();
        }
        int[] pastaImages = new int[2];
        for(int i = 0; i < 2; i++) {
             pastaImages[i] = Pasta.pasta[i].getImageResourceId();
        }
        GridLayoutManager layoutManager1 = new GridLayoutManager(getActivity(), 2);
        pastaRecycle.setLayoutManager(layoutManager1);

        CaptionedImageAdapter adapter1 = new CaptionedImageAdapter(pastaNames, pastaImages);
        pastaRecycle.setAdapter(adapter1);
        adapter1.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PastaDetailActivity.class);
                intent.putExtra(PastaDetailActivity.EXTRA_PASTANO, position);
                getActivity().startActivity(intent);
            }
        });

        return layout;
    }



}

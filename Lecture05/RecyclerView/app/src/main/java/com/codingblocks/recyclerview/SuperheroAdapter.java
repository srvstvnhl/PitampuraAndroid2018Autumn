package com.codingblocks.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SuperheroAdapter extends RecyclerView.Adapter<SuperheroAdapter.SuperheroHolder> {

    private ArrayList<SuperHero> superHeroes;

    public SuperheroAdapter(ArrayList<SuperHero> superHeroes) {
        this.superHeroes = superHeroes;
    }

    @NonNull
    @Override
    public SuperheroHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
        View inflatedView = li.inflate(R.layout.layout_row,viewGroup,false);
        return new SuperheroHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperheroHolder superheroHolder, int position) {
        SuperHero currentHero = superHeroes.get(position);

        superheroHolder.name.setText(currentHero.getName());
        superheroHolder.power.setText(currentHero.getSuperPower());
        superheroHolder.universe.setText(currentHero.getUniverse());
    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }

    class SuperheroHolder extends RecyclerView.ViewHolder {

        TextView name, universe, power;

        public SuperheroHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.superheroName);
            universe = view.findViewById(R.id.superheroUniverse);
            power = view.findViewById(R.id.superheroPower);
        }
    }

}

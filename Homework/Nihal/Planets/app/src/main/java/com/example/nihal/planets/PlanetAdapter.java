package com.example.nihal.planets;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /*public interface onItemClickListener{

        void onItemClick(int position);
    }
*/



    private ArrayList<Object> arrayList;
    public Context ctx;
    /*onItemClickListener listener;*/


    public PlanetAdapter(ArrayList<Object> arrayList,Context ctx/*,onItemClickListener listener*/) {
        this.arrayList = arrayList;
        this.ctx=ctx;
        /*this.listener=listener;*/
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View view = li.inflate(R.layout.item_planet,parent,false);

        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

        Object currentObject = arrayList.get(position);


        final Planet currentPlanet = (Planet) currentObject;
        final PlanetHolder planetHolder = (PlanetHolder) holder;

        Picasso.get()
                .load(currentPlanet.url)
                .into(planetHolder.imageView);

        planetHolder.title.setText(currentPlanet.title);
        planetHolder.subtitle.setText(currentPlanet.subtitle);

        /*planetHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(planetHolder.title.getContext(),"hi", Toast.LENGTH_SHORT).show();
            }
        });*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//               // ctx=view.getContext();
                Intent intent = new Intent(ctx,PlanetDetail.class);
                intent.putExtra("image_url",currentPlanet.url);
                intent.putExtra("image_name",currentPlanet.title);
                ctx.startActivity(intent);
//                Toast.makeText(planetHolder.itemView.getContext(),"hi", Toast.LENGTH_SHORT).show();

                /*listener.onItemClick(holder.getAdapterPosition());*/

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class PlanetHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView title,subtitle;
        ImageView imageView;

        public PlanetHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            title = itemView.findViewById(R.id.tvPlanetName);
            subtitle=itemView.findViewById(R.id.tvPlanetDesc);
            imageView=itemView.findViewById(R.id.ivPlanet);
        }
    }

}

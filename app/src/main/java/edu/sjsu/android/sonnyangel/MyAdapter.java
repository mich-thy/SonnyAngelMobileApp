package edu.sjsu.android.sonnyangel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    public List<SonnyAngelInfo> values;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgHeader;
        public TextView nameHeader;

        public ViewHolder(View v){
            super(v);
            imgHeader = (ImageView) v.findViewById(R.id.icon);
            nameHeader = (TextView) v.findViewById(R.id.name);
        }



    }
    public MyAdapter(List<SonnyAngelInfo> data){
        values = data;
    }
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.roy_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.nameHeader.setText(values.get(position).getName());
        holder.imgHeader.setImageResource(values.get(position).getImg());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), SonnyDetail.class);
                intent.putExtra("nameInfo", values.get(position).getName());
                intent.putExtra("imgNum",values.get(position).getImg());
                intent.putExtra("descInfo", values.get(position).getInfo());
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
                if (position == getItemCount() - 1){
                    builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("The Sonny is very scary. Do you want to proceed?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int id){
                                    v.getContext().startActivity(intent);
                                }
                            })
                            .setNegativeButton("No", null);
                    AlertDialog x = builder.create();
                    x.show();

                }
                else{
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}

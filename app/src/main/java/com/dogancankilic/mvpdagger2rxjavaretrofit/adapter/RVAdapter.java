package com.dogancankilic.mvpdagger2rxjavaretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dogancankilic.mvpdagger2rxjavaretrofit.R;
import com.dogancankilic.mvpdagger2rxjavaretrofit.model.Model;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    List<Model> models;
    private Context context;



    public RVAdapter(Context context,List<Model> models) {
        this.models = models;
        this.context =context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        //ViewHolder moviesHolder = new ViewHolder(v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(models.get(position).getTitle());
        Picasso.get().load(models.get(position).getThumbnailUrl()).into(holder.image);

    }


    @Override
    public int getItemCount() {
        return models.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.image)
        ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }


}



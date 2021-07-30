package com.example.mainscreen2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Model.Song;
import com.example.mainscreen2.PlayMusicActivity;
import com.example.mainscreen2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    Context context;
    ArrayList<Song> mangBaiHat;

    public SearchAdapter(Context context, ArrayList<Song> mangBaiHat) {
        this.context = context;
        this.mangBaiHat = mangBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_search_song,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song baiHat = mangBaiHat.get(position);
        holder.txtTenBaiHat.setText(baiHat.getSongName());
        holder.txtCaSi.setText(baiHat.getSingerName());
        Picasso.with(context).load(baiHat.getSongImageUrl()).into(holder.imageViewBaiHat);
    }

    @Override
    public int getItemCount() {
        return mangBaiHat.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTenBaiHat,txtCaSi;
        ImageView imageViewBaiHat, imageViewLuotThich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenBaiHat = itemView.findViewById(R.id.textviewsearchtenbaihat);
            txtCaSi = itemView.findViewById(R.id.textviewsearchtencasi);
            imageViewBaiHat = itemView.findViewById(R.id.imageviewsearchbaihat);
            imageViewLuotThich = itemView.findViewById(R.id.imageviewsearchluotthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("playsong",mangBaiHat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imageViewLuotThich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageViewLuotThich.setImageResource(R.drawable.iconloved);
                    ApiService.apiService.updateLike("1", mangBaiHat.get(getPosition()).getSongId() ).enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
//                            Toast.makeText(context, "Liked", Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
//                            Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    });
                    imageViewLuotThich.setEnabled(false);
                }
            });
        }
    }
}

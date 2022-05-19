package com.android.appmusic11.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.appmusic11.Activity.PlayNhacActivity;
import com.android.appmusic11.Model.BaiHatModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DsBaiHatThuongNgheAdapter extends  RecyclerView.Adapter<DsBaiHatThuongNgheAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHatModel> arrayBaiHat;

    public DsBaiHatThuongNgheAdapter(Context context, ArrayList<BaiHatModel> arrayBaiHat) {
        this.context = context;
        this.arrayBaiHat = arrayBaiHat;
    }

    @NonNull
    @Override
    public DsBaiHatThuongNgheAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_baihat, parent, false);
        return new DsBaiHatThuongNgheAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHatModel baiHat = arrayBaiHat.get(position);
        holder.txttenbaihat.setText(baiHat.getTenBaiHat());
        Picasso.get().load(baiHat.getHinhBaiHat()).into(holder.hinhbaihat);
    }


    @Override
    public int getItemCount() {
        return arrayBaiHat.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttenbaihat, txttencasi;
        ImageView hinhbaihat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.textviewBaiHatThuongNghe);
            hinhbaihat = itemView.findViewById(R.id.imageviewbaihatThuongNghe);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc", arrayBaiHat.get(getBindingAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}

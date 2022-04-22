package com.android.appmusic11.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.appmusic11.Activity.DanhSachBaiHatActivity;
import com.android.appmusic11.Model.ThuVienPlayListModel;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ThuVienPlayListAdapter extends RecyclerView.Adapter<ThuVienPlayListAdapter.ViewHolder>{
    Context context;
    ArrayList<ThuVienPlayListModel> arrayThuVienPlayList;
    View view;

    public ThuVienPlayListAdapter(Context context, ArrayList<ThuVienPlayListModel> arrayThuVienPlayList) {
        this.context = context;
        this.arrayThuVienPlayList = arrayThuVienPlayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_thuvien_playlist,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThuVienPlayListModel thuVienPlayList = arrayThuVienPlayList.get(position);
        holder.txttenthuvienplaylist.setText(thuVienPlayList.getTenThuVienPlayList());
        holder.txttennguoidung.setText("Danh sách phát nhạc của bạn ");
        Picasso.get().load(thuVienPlayList.getHinhThuVienPlayList()).into(holder.imgthuvienplaylist);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("idthuvienplaylist", arrayThuVienPlayList.get(position));
                context.startActivity(intent);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setTitle("Xóa thư viện")
                        .setMessage("Bạn có muốn xóa thư viện "+thuVienPlayList.getTenThuVienPlayList()+" ?")
                        .setPositiveButton("Xóa", null)
                        .setNegativeButton("Hủy", null)
                        .show();

                Button pos = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                Button neg = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                pos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        deletethuvien(thuVienPlayList.getIDThuVienPlayList());
//                        deletenhieubaihatthuvien(thuVienPlayList.getIDThuVienPlayList());
                        alertDialog.dismiss();
                    }
                });
                neg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayThuVienPlayList != null ? arrayThuVienPlayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgthuvienplaylist;
        TextView txttenthuvienplaylist, txttennguoidung;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgthuvienplaylist = view.findViewById(R.id.imageviewthuvienplaylist);
            txttenthuvienplaylist = view.findViewById(R.id.textviewthuvienplaylist);
            txttennguoidung = view.findViewById(R.id.txtusetname);
        }

    }
}

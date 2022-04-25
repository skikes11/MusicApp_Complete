package com.android.appmusic11.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.appmusic11.Adapter.DanhSachBaiHatAdapter;
import com.android.appmusic11.Adapter.dsbhthuvienplaylistAdapter;
import com.android.appmusic11.Model.BaiHatModel;
import com.android.appmusic11.Model.BangXepHangModel;
import com.android.appmusic11.Model.ChuDeModel;
import com.android.appmusic11.Model.NgheSiModel;
import com.android.appmusic11.Model.PlayListModel;
import com.android.appmusic11.Model.ThinhHanhModel;
import com.android.appmusic11.Model.ThuVienPlayListModel;
import com.android.appmusic11.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DanhSachBaiHatActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    TextView txtcollapsing;
    PlayListModel playlist = null;
    NgheSiModel ngheSi = null;
    ThinhHanhModel thinhHanh=null;
    ChuDeModel chuDe = null;
    BangXepHangModel bangXepHang = null;
    ThuVienPlayListModel thuVienPlayList = null;
    ImageView imgdanhsachcakhuc;
    ArrayList<BaiHatModel> mangbaihat;
    DanhSachBaiHatAdapter danhsachbaihatAdapter;
    dsbhthuvienplaylistAdapter dsbhthuvienplaylistadapter;
    ImageView btnThemnhac;
    SwipeRefreshLayout swipeRefreshLayout;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hat);
        AnhXa();
        floatingActionButton.setEnabled(false);
        DataIntent();
        overridePendingTransition(R.anim.anim_intent_in, R.anim.anim_intent_out);
        if (ngheSi != null && !ngheSi.equals("")){
            setValueInView(ngheSi.getHinhNgheSi());
            GetDataNgheSi(ngheSi.getMaNgheSi());
            txtcollapsing.setText(ngheSi.getTenNgheSi());
            getSupportActionBar().setTitle(ngheSi.getTenNgheSi());
        }
        if (playlist != null && !playlist.equals("")){
            setValueInView(playlist.getHinhPlayList());
            GetDataPlaylist(playlist.getMaPlayList());
            txtcollapsing.setText(playlist.getTenPlayList());
            getSupportActionBar().setTitle(playlist.getTenPlayList());
        }
        if (thinhHanh != null && !thinhHanh.equals("")){
            setValueInView(thinhHanh.getHinhThinhHanh());
            GetDataThinhHanh(thinhHanh.getMaThinhHanh());
            txtcollapsing.setText(thinhHanh.getTenThinhHanh());
            getSupportActionBar().setTitle(thinhHanh.getTenThinhHanh());
        }
        if (chuDe != null && !chuDe.equals("")){
            setValueInView(chuDe.getHinhChuDe());
            GetDataChuDe(chuDe.getMaChuDe());
            txtcollapsing.setText(chuDe.getTenChuDe());
            getSupportActionBar().setTitle(chuDe.getTenChuDe());
        }
        if (bangXepHang != null && !bangXepHang.equals("")){
            setValueInView(bangXepHang.getHinhBangXepHang());
         GetDataBangXepHang(bangXepHang.getMaBangXepHang());
            txtcollapsing.setText(bangXepHang.getTenBangXepHang());
            getSupportActionBar().setTitle(bangXepHang.getTenBangXepHang());
        }
        if (thuVienPlayList != null && !thuVienPlayList.equals("")){
            setValueInView(thuVienPlayList.getHinhThuVienPlayList());
//            GetDataThuVienPlayList(String.valueOf(thuVienPlayList.getMaThuVienPlayList()));
            txtcollapsing.setText(thuVienPlayList.getTenThuVienPlayList());
            getSupportActionBar().setTitle(thuVienPlayList.getTenThuVienPlayList());
        }

     floatActionButtonClick();
        btnThemnhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                if(intent.hasExtra("idthuvienplaylist")){
                    intent = new Intent(DanhSachBaiHatActivity.this, InsertNhacThuVienActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            }
        });

        swipeRefreshLayout = findViewById(R.id.swipedanhsachbaihat);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Intent intent = getIntent();
                if(intent.hasExtra("idthuvienplaylist")){
//                    GetDataThuVienPlayList(String.valueOf(thuVienPlayList.getMaThuVienPlayList()));
//                    dsbhthuvienplaylistadapter.notifyDataSetChanged();
                }
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    private void setValueInView(String hinh) {
        Picasso.get().load(hinh).into(imgdanhsachcakhuc);
    }
    private void GetDataPlaylist(String id) {
        mangbaihat = new ArrayList<>();
        mangbaihat.clear();
        Cursor dataBaiHat = TrangChuActivity.databaseHelper.getData("SELECT MaBaiHat, TenBaiHat, HinhBaiHat, TenCaSi, LinkBaiHat FROM BaiHat WHERE BaiHat.MaIdPlayList = '"+id+"'");
        while (dataBaiHat.moveToNext()) {
            int MaBaiHat = dataBaiHat.getInt(0);
            String TenBaiHat = dataBaiHat.getString(1);
            String HinhBaiHat = dataBaiHat.getString(2);
            String TenNgheSi = dataBaiHat.getString(3);
            String LinkBaiHat = dataBaiHat.getString(4);
            mangbaihat.add(new BaiHatModel(MaBaiHat, TenBaiHat, HinhBaiHat, TenNgheSi, LinkBaiHat));
        }
        danhsachbaihatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this, mangbaihat);
        recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
        recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
        dataBaiHat.close();
    }
    private void GetDataBangXepHang(String id) {
        mangbaihat = new ArrayList<>();
        mangbaihat.clear();
        Cursor dataBaiHat = TrangChuActivity.databaseHelper.getData("SELECT MaBaiHat, TenBaiHat, HinhBaiHat, TenCaSi, LinkBaiHat FROM BaiHat WHERE BaiHat.MaBangXepHang = '"+id+"'");
        while (dataBaiHat.moveToNext()) {
            int MaBaiHat = dataBaiHat.getInt(0);
            String TenBaiHat = dataBaiHat.getString(1);
            String HinhBaiHat = dataBaiHat.getString(2);
            String TenNgheSi = dataBaiHat.getString(3);
            String LinkBaiHat = dataBaiHat.getString(4);
            mangbaihat.add(new BaiHatModel(MaBaiHat, TenBaiHat, HinhBaiHat, TenNgheSi, LinkBaiHat));
        }
        danhsachbaihatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this, mangbaihat);
        recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
        recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
        dataBaiHat.close();
    }
    private void GetDataChuDe(String id) {
        mangbaihat = new ArrayList<>();
        mangbaihat.clear();
        Cursor dataBaiHat = TrangChuActivity.databaseHelper.getData("SELECT MaBaiHat, TenBaiHat, HinhBaiHat, TenCaSi, LinkBaiHat FROM BaiHat WHERE BaiHat.MaChuDe = '"+id+"'");
        while (dataBaiHat.moveToNext()) {
            int MaBaiHat = dataBaiHat.getInt(0);
            String TenBaiHat = dataBaiHat.getString(1);
            String HinhBaiHat = dataBaiHat.getString(2);
            String TenNgheSi = dataBaiHat.getString(3);
            String LinkBaiHat = dataBaiHat.getString(4);
            mangbaihat.add(new BaiHatModel(MaBaiHat, TenBaiHat, HinhBaiHat, TenNgheSi, LinkBaiHat));
        }
        danhsachbaihatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this, mangbaihat);
        recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
        recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
        dataBaiHat.close();
    }
    private void GetDataNgheSi(String id) {
        mangbaihat = new ArrayList<>();
        mangbaihat.clear();
        Cursor dataBaiHat = TrangChuActivity.databaseHelper.getData("SELECT MaBaiHat, TenBaiHat, HinhBaiHat, TenCaSi, LinkBaiHat FROM BaiHat WHERE BaiHat.MaNgheSi = '"+id+"'");
        while (dataBaiHat.moveToNext()) {
            int MaBaiHat = dataBaiHat.getInt(0);
            String TenBaiHat = dataBaiHat.getString(1);
            String HinhBaiHat = dataBaiHat.getString(2);
            String TenNgheSi = dataBaiHat.getString(3);
            String LinkBaiHat = dataBaiHat.getString(4);
            mangbaihat.add(new BaiHatModel(MaBaiHat, TenBaiHat, HinhBaiHat, TenNgheSi, LinkBaiHat));
        }
                danhsachbaihatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
                dataBaiHat.close();
    }
    private void GetDataThinhHanh(String id) {
        mangbaihat = new ArrayList<>();
        mangbaihat.clear();
        Cursor dataBaiHat = TrangChuActivity.databaseHelper.getData("SELECT MaBaiHat, TenBaiHat, HinhBaiHat, TenCaSi, LinkBaiHat FROM BaiHat WHERE BaiHat.MaThinhHanh = '"+id+"'");
        while (dataBaiHat.moveToNext()) {
            int MaBaiHat = dataBaiHat.getInt(0);
            String TenBaiHat = dataBaiHat.getString(1);
            String HinhBaiHat = dataBaiHat.getString(2);
            String TenNgheSi = dataBaiHat.getString(3);
            String LinkBaiHat = dataBaiHat.getString(4);
            mangbaihat.add(new BaiHatModel(MaBaiHat, TenBaiHat, HinhBaiHat, TenNgheSi, LinkBaiHat));
        }
        danhsachbaihatAdapter = new DanhSachBaiHatAdapter(DanhSachBaiHatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
                dataBaiHat.close();
            }
//    private void GetDataThuVienPlayList(String id) {
//        Dataservice dataservice = APIService.getService();
//        Call<List<BaiHatThuVienPlayListModel>> callback = dataservice.GetDanhsachbaihatthuvienplaylist(id);
//        callback.enqueue(new Callback<List<BaiHatThuVienPlayListModel>>() {
//            @Override
//            public void onResponse(Call<List<BaiHatThuVienPlayListModel>> call, Response<List<BaiHatThuVienPlayListModel>> response) {
//                mangbaihatthuvienplaylist = (ArrayList<BaiHatThuVienPlayListModel>) response.body();
//                dsbhthuvienplaylistadapter = new dsbhthuvienplaylistAdapter(DanhsachbaihatActivity.this, mangbaihatthuvienplaylist);
//                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
//                recyclerViewdanhsachbaihat.setAdapter(dsbhthuvienplaylistadapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<BaiHatThuVienPlayListModel>> call, Throwable t) {
//
//            }
//        });
//    }

    private void AnhXa() {
        toolbar = findViewById(R.id.toolbardanhsachbaihat);
        recyclerViewdanhsachbaihat = findViewById(R.id.recyclerviewdanhsachbaihat);
        imgdanhsachcakhuc = findViewById(R.id.imageviewdanhsachcakhuc);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        txtcollapsing = findViewById(R.id.textViewcollapsing);
        btnThemnhac = findViewById(R.id.btnthemnhacthuvien);

         setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void DataIntent() {
        Intent intent = getIntent();
        btnThemnhac.setVisibility(View.GONE);
        if (intent != null){
            if (intent.hasExtra("intentnghesi")){
                ngheSi = (NgheSiModel) intent.getSerializableExtra("intentnghesi");
            }else
            if (intent.hasExtra("intentplaylist")){
                playlist = (PlayListModel) intent.getSerializableExtra("intentplaylist");
            }
            else
            if (intent.hasExtra("intentthinhhanh")){
                thinhHanh = (ThinhHanhModel) intent.getSerializableExtra("intentthinhhanh");
            }else
            if (intent.hasExtra("intentchude")){
                chuDe = (ChuDeModel) intent.getSerializableExtra("intentchude");
            }else
            if (intent.hasExtra("intentbangxephang")){
                bangXepHang = (BangXepHangModel) intent.getSerializableExtra("intentbangxephang");
            }else
            if(intent.hasExtra("idthuvienplaylist")){
                thuVienPlayList = (ThuVienPlayListModel) intent.getSerializableExtra("idthuvienplaylist");
                id = thuVienPlayList.getMaThuVienPlayList();
                btnThemnhac.setVisibility(View.VISIBLE);
            }
        }
    }
    private void floatActionButtonClick(){
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DanhSachBaiHatActivity.this, PlayNhacActivity.class);
                if (mangbaihat!=null){
                    if (mangbaihat.size() > 0){
                        intent.putExtra("cacbaihat", mangbaihat);
                        startActivity(intent);
                    }else {
                        Toast.makeText(DanhSachBaiHatActivity.this, "Danh sách không có bài hát nào cả :(", Toast.LENGTH_SHORT).show();
                    }
                }
//                else{
//                    if (mangbaihatthuvienplaylist != null){
//                        if (mangbaihatthuvienplaylist.size() > 0){
//                            intent.putExtra("cacbaihatthuvien", mangbaihatthuvienplaylist);
//                            startActivity(intent);
//                        }else {
//                            Toast.makeText(DanhSachBaiHatActivity.this, "Danh sách không có bài hát nào cả :(", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
            }
        });
    }
}
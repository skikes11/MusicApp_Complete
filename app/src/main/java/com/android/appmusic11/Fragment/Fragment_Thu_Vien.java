package com.android.appmusic11.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.android.appmusic11.Activity.DanhSachBaiHatActivity;
import com.android.appmusic11.Activity.TrangChuActivity;
import com.android.appmusic11.Adapter.ViewPagerThuVien;
import com.android.appmusic11.Model.ThuVienPlayListModel;
import com.android.appmusic11.R;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Thu_Vien extends Fragment implements Dialog_insert_thu_vien_playlist.ExampleDialogListenerthuvien{
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView imgAddThuVien;
    CircleImageView imguser;
    ProgressDialog progressDialog;
    View view;
    private String tenThuVien;
    private TrangChuActivity hm;
    ArrayList<ThuVienPlayListModel> mangthuvienplaylist;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thu_vien, container, false);
        AnhXa();
        init();
        imgAddThuVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        return  view;
    }
    private void init() {
        ViewPagerThuVien viewPagerThuVien = new ViewPagerThuVien(getChildFragmentManager());
        viewPagerThuVien.addFragment(new com.android.appmusic11.Fragment.Fragment_ThuVien_Playlist(), "Playlist");
        viewPager.setAdapter(viewPagerThuVien);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void AnhXa() {
        hm = (TrangChuActivity) getActivity();
        tabLayout = view.findViewById(R.id.tabLayouttv);
        viewPager = view.findViewById(R.id.viewPagertv);
        imgAddThuVien = view.findViewById(R.id.idaddthuvien);
    }
    private void openDialog() {
        Dialog_insert_thu_vien_playlist exampleDialog = new Dialog_insert_thu_vien_playlist();
        exampleDialog.show(getFragmentManager(), "Dialog_insert_thu_vien_playlist");
        exampleDialog.setTargetFragment(Fragment_Thu_Vien.this, 1);
    }

    @Override
    public void apply(String tenthuvien) {
        tenThuVien = tenthuvien;
        insertthuvien(tenthuvien);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                GetData();
            }
        }, 3000);
    }
    private void insertthuvien(String tenThuVien) {

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Creating...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        TrangChuActivity.databaseHelper.QueryData("INSERT INTO ThuVienPlayList VALUES (null,'"+tenThuVien+"','https://kenh14cdn.com/thumb_w/660/203336854389633024/2021/12/8/d04735780ac715fd325abffee4627f11-16389696872851695463984.jpg')");

    }
    private void GetData() {
        mangthuvienplaylist = new ArrayList<>();
        mangthuvienplaylist.clear();
        Cursor dataThuVienPlayList = TrangChuActivity.databaseHelper.getData("SELECT * FROM ThuVienPlayList ");
        while (dataThuVienPlayList.moveToNext()) {
            int MaThuVienPlayList = dataThuVienPlayList.getInt(0);
            String TenThuVienPlayList = dataThuVienPlayList.getString(1);
            String HinhThuVienPlayList = dataThuVienPlayList.getString(2);
            mangthuvienplaylist.add(new ThuVienPlayListModel(MaThuVienPlayList, TenThuVienPlayList,HinhThuVienPlayList));
        }
                ThuVienPlayListModel thuVienPlayList = mangthuvienplaylist.get(mangthuvienplaylist.size()-1);
                progressDialog.dismiss();
                Intent intent = new Intent(getActivity(), DanhSachBaiHatActivity.class);
                intent.putExtra("idthuvienplaylist", thuVienPlayList);
                startActivity(intent);
            }
    }

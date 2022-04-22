package com.android.appmusic11.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
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
        imguser = view.findViewById(R.id.imageviewuserthuvien);
    }
    private void openDialog() {
//        Dialog_insert_thu_vien_playlist exampleDialog = new Dialog_insert_thu_vien_playlist();
//        exampleDialog.show(getFragmentManager(), "Dialog_insert_thu_vien_playlist");
//        exampleDialog.setTargetFragment(Fragment_Thu_Vien.this, 1);
    }

    @Override
    public void apply(String tenthuvien) {

    }


//    public void apply(String tenthuvien) {
//        HashMap<String, String> params = new HashMap<>();
//        tenThuVien = tenthuvien;
//        params.put("tenthuvien", tenThuVien);
//        params.put("UserName", hm.getTaikhoan());
//        insertthuvien(params);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                GetData();
//            }
//        }, 3000);
//    }
//    private void insertthuvien(HashMap<String, String> params) {
//
//        progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setTitle("Please wait");
//        progressDialog.setMessage("Creating...");
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//
//        Dataservice networkService = APIService.getService();
//        Call<PhanHoiDangKyModel> registerCall = networkService.insertthuvien(params);
//        registerCall.enqueue(new Callback<PhanHoiDangKyModel>() {
//            @Override
//            public void onResponse(@NonNull Call<PhanHoiDangKyModel> call, @NonNull Response<PhanHoiDangKyModel> response) {
//                PhanHoiDangKyModel responseBody = response.body();
//                if (responseBody != null) {
//                    if (responseBody.getSuccess().equals("1")) {
//                        Toast.makeText(getActivity(), "Tạo thành công !", Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<PhanHoiDangKyModel> call, @NonNull Throwable t) {
//            }
//        });
//    }
//    private void GetData() {
//        hm = (HomeActivity) getActivity();
//        Dataservice dataservice = APIService.getService();
//        Call<List<ThuVienPlayListModel>> callback = dataservice.GetBangThuVienPlayList(hm.getTaikhoan());
//        callback.enqueue(new Callback<List<ThuVienPlayListModel>>() {
//            @Override
//            public void onResponse(Call<List<ThuVienPlayListModel>> call, Response<List<ThuVienPlayListModel>> response) {
//                ArrayList<ThuVienPlayListModel> mangthuvienplaylist = (ArrayList<ThuVienPlayListModel>) response.body();
//                ThuVienPlayListModel thuVienPlayList = mangthuvienplaylist.get(mangthuvienplaylist.size()-1);
//
//                progressDialog.dismiss();
//                Intent intent = new Intent(getActivity(), DanhsachbaihatActivity.class);
//                intent.putExtra("idthuvienplaylist", thuVienPlayList);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onFailure(Call<List<ThuVienPlayListModel>> call, Throwable t) {
//
//            }
//
//        });
//    }

}

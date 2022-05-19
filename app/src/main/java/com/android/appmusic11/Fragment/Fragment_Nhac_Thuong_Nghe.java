package com.android.appmusic11.Fragment;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.appmusic11.Activity.TrangChuActivity;
import com.android.appmusic11.Adapter.DsBaiHatThuongNgheAdapter;
import com.android.appmusic11.Model.BaiHatModel;
import com.android.appmusic11.R;

import java.util.ArrayList;

public class Fragment_Nhac_Thuong_Nghe extends Fragment {
    View view;
    DsBaiHatThuongNgheAdapter danhsachbaihatAdapter;
    RecyclerView recyclerViewDanhSachBaiHat;
    TextView tenBaiHat;
    ArrayList<BaiHatModel> arrayBaihat;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_nhacthuongnghe, container, false);
        recyclerViewDanhSachBaiHat = view.findViewById(R.id.recyclerviewBaiHatThuongNghe);
        tenBaiHat = view.findViewById(R.id.textviewBaiHatThuongNghe);
        GetData();
        return view;
    }


    private void GetData() {
        arrayBaihat = new ArrayList<>();
        arrayBaihat.clear();
        Cursor dataBaiHat = TrangChuActivity.databaseHelper.getData("SELECT MaBaiHat, TenBaiHat, HinhBaiHat, TenCaSi, LinkBaiHat FROM BaiHat ORDER BY ViewCount DESC LIMIT 5");
        while (dataBaiHat.moveToNext()) {
            int MaBaiHat = dataBaiHat.getInt(0);
            String TenBaiHat = dataBaiHat.getString(1);
            String HinhBaiHat = dataBaiHat.getString(2);
            String TenNgheSi = dataBaiHat.getString(3);
            String LinkBaiHat = dataBaiHat.getString(4);
            arrayBaihat.add(new BaiHatModel(MaBaiHat, TenBaiHat, HinhBaiHat, TenNgheSi, LinkBaiHat));
        }
        danhsachbaihatAdapter = new DsBaiHatThuongNgheAdapter(getActivity(), arrayBaihat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewDanhSachBaiHat.setLayoutManager(linearLayoutManager);
        recyclerViewDanhSachBaiHat.setAdapter(danhsachbaihatAdapter);
        dataBaiHat.close();
    }
}
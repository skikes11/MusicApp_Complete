package com.android.appmusic11.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.appmusic11.Adapter.BangXepHangAdapter;
import com.android.appmusic11.Model.BangXepHangModel;
import com.android.appmusic11.R;

import java.util.ArrayList;
import java.util.List;



public class Fragment_BangXepHang extends Fragment {
    View view;
    BangXepHangAdapter bangXepHangAdapter;
    RecyclerView recyclerViewbangxephang;
    TextView tenbangxephang;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bangxephang, container, false);
        recyclerViewbangxephang = view.findViewById(R.id.recyclerviewbangxephang);
        tenbangxephang = view.findViewById(R.id.txtbangxephang);
//        GetData();
        return view;
    }

//    private void GetData() {
//        Dataservice dataservice = APIService.getService();
//        Call<List<BangXepHangModel>> callback = dataservice.GetBangXepHangCurrent();
//        callback.enqueue(new Callback<List<BangXepHangModel>>() {
//            @Override
//            public void onResponse(Call<List<BangXepHangModel>> call, Response<List<BangXepHangModel>> response) {
//                ArrayList<BangXepHangModel> mangbangxephang = (ArrayList<BangXepHangModel>) response.body();
//                bangXepHangAdapter = new BangXepHangAdapter(getActivity(), mangbangxephang);
//
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//                recyclerViewbangxephang.setLayoutManager(linearLayoutManager);
//                recyclerViewbangxephang.setAdapter(bangXepHangAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<BangXepHangModel>> call, Throwable t) {
//
//            }
//        });
//    }

}

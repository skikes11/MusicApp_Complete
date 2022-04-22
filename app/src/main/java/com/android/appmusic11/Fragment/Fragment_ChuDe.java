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


import com.android.appmusic11.Adapter.ChuDeAdapter;
import com.android.appmusic11.Model.ChuDeModel;
import com.android.appmusic11.R;

import java.util.ArrayList;
import java.util.List;



public class Fragment_ChuDe extends Fragment {

    View view;
    ChuDeAdapter chuDeAdapter;
    RecyclerView recyclerViewChuDe;
    TextView tenChuDe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude, container, false);
        recyclerViewChuDe = view.findViewById(R.id.recyclerviewchude);
        tenChuDe = view.findViewById(R.id.txtchude);
//        GetData();
        return view;
    }

//    private void GetData() {
//        Dataservice dataservice = APIService.getService();
//        Call<List<ChuDeModel>> callback = dataservice.GetChuDeCurrent();
//        callback.enqueue(new Callback<List<ChuDeModel>>() {
//            @Override
//            public void onResponse(Call<List<ChuDeModel>> call, Response<List<ChuDeModel>> response) {
//                ArrayList<ChuDeModel> mangchude = (ArrayList<ChuDeModel>) response.body();
//                chuDeAdapter = new ChuDeAdapter(getActivity(), mangchude);
//
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//                recyclerViewChuDe.setLayoutManager(linearLayoutManager);
//                recyclerViewChuDe.setAdapter(chuDeAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<ChuDeModel>> call, Throwable t) {
//
//            }
//        });
//    }

}

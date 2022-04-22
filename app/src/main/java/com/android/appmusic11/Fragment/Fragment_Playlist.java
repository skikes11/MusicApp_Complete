package com.android.appmusic11.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
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

import com.android.appmusic11.Activity.TrangChuActivity;
import com.android.appmusic11.Adapter.PlaylistAdapter;
import com.android.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Playlist extends Fragment {

    TrangChuActivity hm;
    de.hdodenhof.circleimageview.CircleImageView imguser;
    View view;
    PlaylistAdapter playlistAdapter;
    RecyclerView recyclerViewplaylist;
    TextView tenPlaylist;
    String sql = "";
    private SQLiteDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist, container, false);
        db = getActivity().openOrCreateDatabase("NguoiDung.db", MODE_PRIVATE, null);
        recyclerViewplaylist = view.findViewById(R.id.recyclerviewplaylist);
        tenPlaylist = view.findViewById(R.id.txtplaylist);
        hm = (TrangChuActivity) getActivity();
        imguser = view.findViewById(R.id.imageviewuser);
//        GetData();
//        imguser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ShowDialogUpdate();
//            }
//        });
        return view;
    }

//    private void GetData() {
//        Dataservice dataservice = APIService.getService();
//        Call<List<PlaylistModel>> callback = dataservice.GetPlaylistCurrentDay();
//        callback.enqueue(new Callback<List<PlaylistModel>>() {
//            @Override
//            public void onResponse(Call<List<PlaylistModel>> call, Response<List<PlaylistModel>> response) {
//                ArrayList<PlaylistModel> mangplaylist = (ArrayList<PlaylistModel>) response.body();
//                playlistAdapter = new PlaylistAdapter(getActivity(), mangplaylist);
//
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//                recyclerViewplaylist.setLayoutManager(linearLayoutManager);
//                recyclerViewplaylist.setAdapter(playlistAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<PlaylistModel>> call, Throwable t) {
//
//            }
//        });
//    }


}

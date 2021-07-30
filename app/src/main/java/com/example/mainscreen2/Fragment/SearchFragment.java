package com.example.mainscreen2.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainscreen2.API.ApiService;
import com.example.mainscreen2.Adapter.SearchAdapter;
import com.example.mainscreen2.Model.Song;
import com.example.mainscreen2.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    View view;
    Toolbar toolbar;
    RecyclerView recyclerViewSearchBaiHat;
    TextView textViewKhongCoDuLieu;
    SearchAdapter searchBaiHatAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search,container,false);
        toolbar = view.findViewById(R.id.toolbarsearchbaihat);
        recyclerViewSearchBaiHat = view.findViewById(R.id.recycleviewsearchbaihat);
        textViewKhongCoDuLieu = view.findViewById(R.id.textviewkhongcodulieu);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_view,menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchBaiHat(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void searchBaiHat(String query){
        ApiService.apiService.searchSong(query).enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                ArrayList<Song> mangBaiHat = (ArrayList<Song>) response.body();
                if(mangBaiHat.size() > 0){
                    searchBaiHatAdapter = new SearchAdapter(getActivity(),mangBaiHat);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewSearchBaiHat.setLayoutManager(linearLayoutManager);
                    recyclerViewSearchBaiHat.setAdapter(searchBaiHatAdapter);
                    textViewKhongCoDuLieu.setVisibility(View.GONE);
                    recyclerViewSearchBaiHat.setVisibility(View.VISIBLE);
                }else{
                    recyclerViewSearchBaiHat.setVisibility(View.GONE);
                    textViewKhongCoDuLieu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }
}

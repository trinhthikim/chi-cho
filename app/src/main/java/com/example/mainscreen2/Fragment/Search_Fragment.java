//package com.example.mainscreen2.Fragment;
//
//import android.view.View;
//import android.widget.Toolbar;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class Search_Fragment extends Fragment {
//    View view;
//    Toolbar toolbar;
//    RecyclerView recyclerViewsearchsong;
//    View view;
//    Toolbar toolbar;
//    RecyclerView recyclerViewSearchBaiHat;
//    TextView textViewKhongCoDuLieu;
//    SearchAdapter searchBaiHatAdapter;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.fragment_tim_kiem,container,false);
//        toolbar = view.findViewById(R.id.toolbarsearchbaihat);
//        recyclerViewSearchBaiHat = view.findViewById(R.id.recycleviewsearchbaihat);
//        textViewKhongCoDuLieu = view.findViewById(R.id.textviewkhongcodulieu);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//        toolbar.setTitle("");
//        setHasOptionsMenu(true);
//        return view;
//    }
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.search_view,menu);
//        MenuItem menuItem = menu.findItem(R.id.menu_search);
//        SearchView searchView = (SearchView) menuItem.getActionView();
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                searchBaiHat(query);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    private void searchBaiHat(String query){
//        DataService dataService = APIService.getService();
//        Call<List<BaiHat>> callBack = dataService.getSearchBaiHat(query);
//        callBack.enqueue(new Callback<List<BaiHat>>() {
//            @Override
//            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
//                ArrayList<BaiHat> mangBaiHat = (ArrayList<BaiHat>) response.body();
//                if(mangBaiHat.size() > 0){
//                    searchBaiHatAdapter = new SearchBaiHatAdapter(getActivity(),mangBaiHat);
//                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//                    recyclerViewSearchBaiHat.setLayoutManager(linearLayoutManager);
//                    recyclerViewSearchBaiHat.setAdapter(searchBaiHatAdapter);
//                    textViewKhongCoDuLieu.setVisibility(View.GONE);
//                    recyclerViewSearchBaiHat.setVisibility(View.VISIBLE);
//                }else{
//                    recyclerViewSearchBaiHat.setVisibility(View.GONE);
//                    textViewKhongCoDuLieu.setVisibility(View.VISIBLE);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<BaiHat>> call, Throwable t) {
//
//            }
//        });
//    }
//
//
//}

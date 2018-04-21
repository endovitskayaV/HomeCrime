package vsu.ru.homecrime;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vsu.ru.homecrime.model.Crime;
import vsu.ru.homecrime.model.DataKeeper;

import static vsu.ru.homecrime.CrimeInfoActivity.CRIME_KEY;

public class MainFragment extends Fragment {

    private List<Crime> crimeList;
    private MyAdapter myAdapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crimeList = DataKeeper.getNewInstance().getCrimeList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = v.findViewById(R.id.crime_list_recycler_view);
        // как будут располагаться элементы списка
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        createAdapter();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        crimeList = DataKeeper.getNewInstance().getCrimeList();
        myAdapter.setCrimes(crimeList);
        myAdapter.notifyDataSetChanged();
    }

    private void createAdapter() {
        myAdapter = new MyAdapter((position, view) -> {
            Intent intent = CrimeInfoActivity.newIntent(getContext(), myAdapter.getCrimes().get(position).getId());
            startActivity(intent); //start crime info activity
        });
        recyclerView.setAdapter(myAdapter);
    }
}

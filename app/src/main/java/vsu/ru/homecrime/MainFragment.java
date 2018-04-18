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

    private final int REQUEST_CODE = 972;

    private List<Crime> crimeList;
    private MyAdapter myAdapter;
    private RecyclerView recyclerView;
    private Integer clickedElementPosition;
    private Crime changedCrime;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_CODE && intent != null)
            changedCrime = (Crime) intent.getSerializableExtra(CRIME_KEY);
        //  questions.get(questionCounter).setCheated(intent.getBooleanExtra(EXTRA_HAS_TAPPED, false));

    }

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
//        myAdapter = new MyAdapter(new MainFragment.OnClick() {
//            @Override
//            public void onClick(Crime crime, View view) {
//                Intent intent = CrimeInfoActivity.newIntent(getContext(), crime);
//                startActivity(intent);
//                //start crime info activity
//            }
//        });
//        myAdapter.setCrimes(crimeList);
//        recyclerView.setAdapter(myAdapter);
        createAdapter();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (clickedElementPosition == null) {
            crimeList = DataKeeper.getNewInstance().getCrimeList();
            myAdapter.setCrimes(crimeList);
            myAdapter.notifyDataSetChanged();
        } else {
            crimeList = DataKeeper.getNewInstance().editCrime(clickedElementPosition, changedCrime);
            myAdapter.setCrimes(crimeList);
            myAdapter.notifyItemChanged(clickedElementPosition);
        }
    }

    private void createAdapter() {
        myAdapter = new MyAdapter(new MainFragment.OnClick() {
            @Override
            public void onClick(int position, View view) {
                clickedElementPosition = position;
                Intent intent = CrimeInfoActivity.newIntent(getContext(), myAdapter.getCrimes().get(position));

                startActivityForResult(intent, REQUEST_CODE);
                // startActivity(intent); //start crime info activity
            }
        });
        recyclerView.setAdapter(myAdapter);
    }

    public interface OnClick {
        void onClick(int position, View view);
    }
}

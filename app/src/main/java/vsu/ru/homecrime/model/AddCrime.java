package vsu.ru.homecrime.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import vsu.ru.homecrime.R;

public class AddCrime extends Fragment {
    private TextView titleTextView;
    private TextView descriptionTextView;
    private Button okButton;
    private CheckBox isSolvedCheckBox;
    private List<Crime> crimeList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       crimeList=new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.crime_add, container, false);


       okButton=v.findViewById(R.id.ok_button);
       okButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               crimeList.add(new Crime())
           }
       });
        return v;
    }
}

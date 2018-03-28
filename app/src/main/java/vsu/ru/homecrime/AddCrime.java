package vsu.ru.homecrime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vsu.ru.homecrime.R;
import vsu.ru.homecrime.model.Crime;

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

        titleTextView=v.findViewById(R.id.title_text_view);
        descriptionTextView=v.findViewById(R.id.description_text_view);

       okButton=v.findViewById(R.id.ok_button);
       okButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               crimeList.add(new Crime(titleTextView.getText().toString(), descriptionTextView.getText().toString(), new Date(1311434)));
               Toast.makeText(v.getContext(), R.string.added, Toast.LENGTH_SHORT).show();
               okButton.setEnabled(false);
           }
       });
        return v;
    }
}

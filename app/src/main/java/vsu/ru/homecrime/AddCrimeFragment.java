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

import vsu.ru.homecrime.model.Crime;
import vsu.ru.homecrime.model.DataKeeper;


public class AddCrimeFragment extends Fragment {
    private TextView titleTextView;
    private TextView descriptionTextView;
    private Button okButton;
    private CheckBox isSolvedCheckBox;
    private List<Crime> crimes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crimes=new ArrayList<>(DataKeeper.getNewInstance().getCrimeList());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crime_add, container, false);

//        isSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                //crime.isSolved(isChecked)
//            }
//        });


//        titleTextView.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

        titleTextView = v.findViewById(R.id.title_edit_text);
        descriptionTextView = v.findViewById(R.id.description_edit_text_);

        okButton = v.findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTextValid(titleTextView.getText()))
                    Toast.makeText(getActivity(), R.string.empty_field, Toast.LENGTH_SHORT).show();
                else {
                    Crime crime = new Crime(titleTextView.getText().toString(), descriptionTextView.getText().toString(), new Date());
                    crimes.add(crime);
                    okButton.setText(crime.getDate().toString());
                    //   okButton.setText(SimpleDateFormat.("", crime.getDate()));
                    Toast.makeText(v.getContext(), R.string.added, Toast.LENGTH_SHORT).show();
                    okButton.setEnabled(false);
                }
            }
        });
        return v;
    }


    private boolean isTextValid(CharSequence text) {
        return text != null;
    }

}

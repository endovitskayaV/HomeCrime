package vsu.ru.homecrime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import vsu.ru.homecrime.model.Crime;
import vsu.ru.homecrime.model.DataKeeper;

import static vsu.ru.homecrime.CrimeInfoActivity.CRIME_KEY;

public class CrimeInfoFragment extends Fragment {
    private Crime crime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime_info, container, false);
        crime = (Crime) getArguments().get(CRIME_KEY);


         EditText titleEditText = v.findViewById(R.id.title_edit_text);
        titleEditText.setText(crime.getTitle());
        titleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                crime.setTitle(s.toString());
                DataKeeper.getNewInstance().editCrime(crime);
            }
        });

        final EditText descriptionEditText = v.findViewById(R.id.description_edit_text_);
        descriptionEditText.setText(crime.getDescription());

        final DatePicker datePicker = v.findViewById(R.id.date_date_picker);

        //DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        //  .setText(dateFormat.format(crime.getDate()));

        datePicker.init(crime.getDate().getYear(), crime.getDate().getMonth(), crime.getDate().getDay(), null);
        final CheckBox isSolvedCheckBox = v.findViewById(R.id.solved_check_box);
        isSolvedCheckBox.setChecked(crime.isSolved());

        Button okButton = v.findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTextValid(titleEditText.getText()) || !isTextValid(descriptionEditText.getText()))
                    Toast.makeText(getActivity(), R.string.empty_field, Toast.LENGTH_SHORT).show();
                else {
                   crime.setTitle(titleEditText.getText().toString());
                   crime.setDescription(descriptionEditText.getText().toString());
                   crime.setDate(new Date(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth()));
                   crime.setSolved(isSolvedCheckBox.isChecked());
                    Toast.makeText(v.getContext(), R.string.added, Toast.LENGTH_SHORT).show();
                    DataKeeper.getNewInstance().editCrime(crime);
                    getActivity().onBackPressed();
                 //   crimes.add(crime);
                    //return crime

                }
            }
        });

        return v;
    }

    public static CrimeInfoFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(CRIME_KEY, DataKeeper.getNewInstance().getCrimeList().get(position));
        CrimeInfoFragment fragment = new CrimeInfoFragment();
        fragment.setArguments(bundle); // после создания, перед add!!!!!
        return fragment;
    }

    private boolean isTextValid(CharSequence text) {
        return text != null;
    }
}

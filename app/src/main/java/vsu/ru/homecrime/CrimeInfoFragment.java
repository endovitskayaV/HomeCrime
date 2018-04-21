package vsu.ru.homecrime;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import vsu.ru.homecrime.model.Crime;
import vsu.ru.homecrime.model.DataKeeper;

import static vsu.ru.homecrime.CrimeInfoActivity.CRIME_KEY;

public class CrimeInfoFragment extends Fragment {
    private Crime crime;
    private DataKeeper dataKeeper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataKeeper = DataKeeper.getNewInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime_info, container, false);
        crime = DataKeeper.getNewInstance().getById((int) getArguments().get(CRIME_KEY));


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
                if (!s.toString().isEmpty()) {
                    crime.setTitle(s.toString());
                    dataKeeper.editCrime(crime);
                } else {
                    Toast.makeText(v.getContext(), R.string.empty_title, Toast.LENGTH_SHORT).show();
                }
            }
        });

        final EditText descriptionEditText = v.findViewById(R.id.description_edit_text_);
        descriptionEditText.setText(crime.getDescription());
        descriptionEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                crime.setDescription(s.toString());
                dataKeeper.editCrime(crime);
            }
        });


        TextView dateTextView = v.findViewById(R.id.date_text_view);
        DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        dateTextView.setText(dateFormat.format(crime.getDate()));

        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(year, monthOfYear, dayOfMonth);

                dateTextView.setText(dateFormat.format(calendar.getTime()));
                crime.setDate(calendar.getTime());
                dataKeeper.editCrime(crime);
            }
        };

        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar.setTime(crime.getDate());
                new DatePickerDialog(getContext(), dateSetListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH))
                        .show();
            }
        });

        final CheckBox isSolvedCheckBox = v.findViewById(R.id.solved_check_box);
        isSolvedCheckBox.setChecked(crime.isSolved());
        isSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                crime.setSolved(isChecked);
                dataKeeper.editCrime(crime);
            }
        });

        return v;
    }

    public static CrimeInfoFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(CRIME_KEY, DataKeeper.getNewInstance().getCrimeList().get(position).getId());
        CrimeInfoFragment fragment = new CrimeInfoFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}

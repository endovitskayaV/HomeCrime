package vsu.ru.homecrime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import vsu.ru.homecrime.model.Crime;

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
        crime = (Crime)getArguments().get(CRIME_KEY);


        TextView titleTextView = v.findViewById(R.id.title_text_view);
        titleTextView.setText(crime.getTitle());

        TextView descriptionTextView = v.findViewById(R.id.description_text_view);
        descriptionTextView.setText(crime.getDescription());

        TextView dateTextView = v.findViewById(R.id.date_text_view);
        DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        dateTextView.setText(dateFormat.format(crime.getDate()));

        TextView isSolvedTextView = v.findViewById(R.id.solved_text_view);
        setIsSolved(isSolvedTextView);

        return v;
    }

    private void setIsSolved(TextView isSolvedTextView) {
        if (crime.isSolved()) {
            isSolvedTextView.setText(R.string.solved);
            isSolvedTextView.setTextColor(ContextCompat.getColor(this.getContext(), R.color.green));
        } else {
            isSolvedTextView.setText(R.string.unsolved);
            isSolvedTextView.setTextColor(ContextCompat.getColor(this.getContext(), R.color.red));
        }
    }
}

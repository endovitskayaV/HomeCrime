package vsu.ru.homecrime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import vsu.ru.homecrime.model.Crime;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CrimeElementViewHolder> {
    private List<Crime> crimes = new ArrayList<>();

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    @Override
    public CrimeElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //создание объекта View по разметке
        return new CrimeElementViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.crime_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CrimeElementViewHolder holder, int position) {
        holder.bindTo(crimes.get(position));
    }

    @Override
    public int getItemCount() {
        return crimes.size();
    }


    public class CrimeElementViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView dateTextView;
        private CheckBox isSolvedCheckBox;

        public CrimeElementViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(itemView.getContext(), crimes.get(getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
                    //go to item info -> activity+ fragment
                }
            });
            titleTextView = itemView.findViewById(R.id.title);
            dateTextView = itemView.findViewById(R.id.date);
            isSolvedCheckBox = itemView.findViewById(R.id.is_solved_check_box);
        }

        public void bindTo(Crime crime) {
            DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
            titleTextView.setText(crime.getTitle());
            dateTextView.setText(dateFormat.format(crime.getDate()));
            isSolvedCheckBox.setChecked(crime.isSolved());
        }
    }

}

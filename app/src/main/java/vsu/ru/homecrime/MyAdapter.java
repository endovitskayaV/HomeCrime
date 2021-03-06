package vsu.ru.homecrime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import vsu.ru.homecrime.model.Crime;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CrimeElementViewHolder> {
    private List<Crime> crimes = new ArrayList<>();
    private OnClick onClick;

    public MyAdapter(OnClick onClick) {
        this.onClick = onClick;
    }

    void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    List<Crime> getCrimes() {
        return crimes;
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


    class CrimeElementViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView dateTextView;
        private ImageView isSolvedImageView;
        //  private CheckBox isSolvedCheckBox;

        CrimeElementViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //обработка нажатия на отдельные элементы списка
                    // go to item info -> activity+ fragment
                    onClick.onClick(getAdapterPosition(), v);

                }
            });
            titleTextView = itemView.findViewById(R.id.title);
            dateTextView = itemView.findViewById(R.id.date_text_view);
            isSolvedImageView = itemView.findViewById(R.id.is_solved_image_view);
        }

        void bindTo(Crime crime) {
            DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
            titleTextView.setText(crime.getTitle());
            dateTextView.setText(dateFormat.format(crime.getDate()));
            if (crime.isSolved()) {
                isSolvedImageView.setImageResource(R.drawable.ic_solved);
            } else {
                isSolvedImageView.setImageResource(R.drawable.ic_not_solved);
            }
        }
    }



    public interface OnClick {
        void onClick(int position, View view);
    }
}

package vsu.ru.homecrime;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import vsu.ru.homecrime.model.Crime;

public class MyHolder extends RecyclerView.ViewHolder {

    private TextView titleTextView;
    private TextView descriptionTextView;
    private CheckBox isSolvedCheckBox;

    public MyHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //go to item info
            }
        });
        titleTextView=itemView.findViewById(R.id.title_text_view);
        descriptionTextView=itemView.findViewById(R.id.description_text_view);
        isSolvedCheckBox=itemView.findViewById(R.id.is_solved_check_box);
    }

    public void bindTo(Crime crime){
     //  crime.s titleTextView.getText().toString()
        //crime`s data to text view
    }
}

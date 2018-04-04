package vsu.ru.homecrime;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class MyAdapter  extends RecyclerView.Adapter<MyHolder>{
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context){
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(layoutInflater.inflate(R.layout.crime_element, parent));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
       //holder.bindTo();данные (position)
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

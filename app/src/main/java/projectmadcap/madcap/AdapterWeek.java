package projectmadcap.madcap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nick on 4/3/2016.
 */
public class AdapterWeek extends RecyclerView.Adapter<AdapterWeek.MyViewHolder> {
    private LayoutInflater inflater;
    List<ModelWeek> data = Collections.emptyList();

    public AdapterWeek(Context context, List<ModelWeek> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_behavior_choose_template, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ModelWeek current = data.get(position);
        holder.week.setText(current.week);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView week;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            week = (TextView) itemView.findViewById(R.id.week_text);
            icon = (ImageView) itemView.findViewById(R.id.week_image);
        }
    }
}

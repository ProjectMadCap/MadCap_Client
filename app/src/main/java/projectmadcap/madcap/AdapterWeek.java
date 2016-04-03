package projectmadcap.madcap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nick on 4/3/2016.
 */
public class AdapterWeek extends RecyclerView.Adapter<AdapterWeek.MyViewHolder> {
    private ClickListener clickListener;
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
        holder.week.setText(current.getWeek());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView week;
        ImageView icon;
        RelativeLayout layout;
        public MyViewHolder(View itemView) {
            super(itemView);
            week = (TextView) itemView.findViewById(R.id.week_text);

            layout = (RelativeLayout) itemView.findViewById(R.id.behavior_holder);
            layout.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if (clickListener != null) {
                clickListener.matchClicked(v, getAdapterPosition());
            }

        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {

        void matchClicked(View view, int position);
    }

}

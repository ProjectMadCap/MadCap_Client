package projectmadcap.madcap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Atropos on 4/3/16.
 */
public class AdapterNotification  extends ArrayAdapter<BehaviorNotifications> {
    private Context context;
    private int resource;
    private BehaviorNotifications[] objects;
    public AdapterNotification(Context context,
                     int resource,
                     BehaviorNotifications[] objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater=
                ((Activity) context).getLayoutInflater();
        View row=inflater.inflate(resource,parent,false);
        TextView notification = (TextView) row.findViewById(R.id.behavior_notification_Button);
        notification.setText(
                objects[position].getText());
        return row;
    }
}

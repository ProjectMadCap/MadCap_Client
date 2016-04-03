package projectmadcap.madcap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projectmadcap.madcap.R;
/**
 * Created by Atropos on 4/2/16.
 */
public class FragmentNotificationUnitTemplate extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification_unit_template, container, false);

        return v;

    }
}

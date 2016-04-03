package projectmadcap.madcap;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Atropos on 4/3/16.
 */
public class BehaviorList extends ArrayList<Behavior>
{
    public BehaviorList()
    {
        super();
    }

    public void addBehavior(Behavior behaviorToAdd)
    {
        int count = 0;
        while(count < this.size() && behaviorToAdd.compareTo(this.get(count)) <= 0)
            count++;
        this.add(count, behaviorToAdd);
    }

    public Behavior getAtWeek(String weekToFind)
    {
        int count = 0;
        int position = 0;
        for(count = 0; count < this.size();count++)
            if(this.get(count).getWeek().equals(weekToFind) == true)
                position = count;
        return this.get(position);
    }

}

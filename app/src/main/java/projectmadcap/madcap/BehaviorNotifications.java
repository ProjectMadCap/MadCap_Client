package projectmadcap.madcap;

/**
 * Created by Atropos on 4/3/16.
 */
public class BehaviorNotifications
{

    public String text;
    public int weekId;
    public int positionInBehaviors;

    public BehaviorNotifications(int week, int positionInBehaviors)
    {
        weekId = week;
        text = "Week " + week + " Unread Behaviors";

    }

    public String getText()
    {
        return text;
    }

    public int getWeekId() { return weekId;}

    public int getPositionInBehaviors() { return positionInBehaviors;}
}

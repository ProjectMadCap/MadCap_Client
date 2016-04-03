package projectmadcap.madcap;

/**
 * Created by Atropos on 4/3/16.
 */
public class BehaviorNotifications
{

    public String text;

    public BehaviorNotifications(String week)
    {

        text = week + " Unread Behaviors";

    }

    public String getText()
    {
        return text;
    }
}

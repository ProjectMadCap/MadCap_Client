package projectmadcap.madcap;

/**
 * Created by Atropos on 4/3/16.
 */
public class Behavior
{
    public String week;
    public int weekNumber;
    public int performance;
    public String notes;
    public boolean pastViewed;

    public Behavior(String weekNumber, String performanceToAdd, String notesToAdd, boolean viewed)
    {
        //week = weekToAdd;
        performance = Integer.parseInt(performanceToAdd);
        notes = notesToAdd;
        pastViewed = viewed;
        this.weekNumber = Integer.parseInt(weekNumber);
        week = "Week " + weekNumber;
        //String[] tokens = week.split(" ");
        //weekNumber = Integer.parseInt(tokens[1]);
    }

    @Override
    public String toString() {
        return "Behavior{" +
                "notes='" + notes + '\'' +
                ", week='" + weekNumber + '\'' +
                ", performance=" + performance +
                '}';
    }

    public boolean isPastViewed() {
        return pastViewed;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    //public void setWeek(String week) {
    //   this.week = week;
    //}

    public String getNotes() {
        return notes;
    }

    public int getPerformance() {
        return performance;
    }

    public String getWeek() {
        return week;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public int compareTo(Behavior behaviorToCompare)
    {
        return this.weekNumber - behaviorToCompare.getWeekNumber();
    }
}

package projectmadcap.madcap;

/**
 * Created by Nick on 4/3/2016.
 */
public class ModelWeek {

    private String week;
    private int rating;
    boolean hasRead;

    public ModelWeek(String week, int rating) {
        this.week = week;
        this.rating = rating;
    }

    public String getWeek(){
        return this.week;
    }

    public int getRating() {return rating;}

    public ModelWeek[] getModelWeeks() {
        ModelWeek[] weeks = new ModelWeek[10];

        weeks[0] = new ModelWeek("Week 1", 1);
        weeks[1] = new ModelWeek("Week 2", 2);
        weeks[2] = new ModelWeek("Week 3", 3);
        weeks[3] = new ModelWeek("Week 4", 4);
        weeks[4] = new ModelWeek("Week 5", 5);
        weeks[5] = new ModelWeek("Week 6", 6);
        weeks[6] = new ModelWeek("Week 7", 7);
        weeks[7] = new ModelWeek("Week 8", 8);
        weeks[8] = new ModelWeek("Week 9", 9);
        weeks[9] = new ModelWeek("Week 10", 10);

        return weeks;
    }
}

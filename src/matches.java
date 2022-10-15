import javafx.collections.ObservableList;

public class matches {
    private int match;
    private int court;
    private int pOne;
    private int pTwo;
    private String date;
    private String res;

    public matches(int match, int court, int pOne, int pTwo, String date, String res) {
        this.match = match;
        this.court = court;
        this.pOne = pOne;
        this.pTwo = pTwo;
        this.date = date;
        this.res = res;
    }

    public int getMatch() {
        return match;
    }

    public int getCourt() {
        return court;
    }

    public int getPOne() {
        return pOne;
    }

    public int getPTwo() {
        return pTwo;
    }

    public String getDate() {
        return date;
    }

    public String getRes() {
        return res;
    }

    public static void add(ObservableList<matches> list) {
    }
}

package sample.Sports;

public class ModelTabelW  {
    String chest,name,depart,event,rank;
    public ModelTabelW(String chest,String name, String depart, String event, String rank) {
        this.chest = chest;
        this.name = name;
        this.depart = depart;
        this.event = event;
        this.rank = rank;

    }
    public String getChest() {
        return chest;
    }

    public String getName() {
        return name;
    }

    public String getDepart() {
        return depart;
    }

    public String getEvent() {
        return event;
    }

    public String getRank() {
        return rank;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


}

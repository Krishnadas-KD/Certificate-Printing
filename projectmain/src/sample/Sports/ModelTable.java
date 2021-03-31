package sample.Sports;

public class ModelTable {
    String Chestno,reno,name,depart,evnt1,evnt2,evnt3;

    public ModelTable(String Chestno,String reno, String name, String depart, String evnt1, String evnt2, String evnt3) {
        this.Chestno = Chestno;
        this.reno = reno;
        this.name = name;
        this.depart = depart;
        this.evnt1 = evnt1;
        this.evnt2 = evnt2;
        this.evnt3 = evnt3;
    }
    public String getChestno() {
        return Chestno;
    }
    public String getReno() {
        return reno;
    }
    public String getName() {
        return name;
    }
    public String getDepart() {
        return depart;
    }
    public String getEvnt1() {
        return evnt1;
    }
    public String getEvnt2() {
        return evnt2;
    }
    public String getEvnt3() {
        return evnt3;
    }
    public void setChestno(String Chestno) {
        this.Chestno = Chestno;
    }
    public void setReno(String reno) {
        this.reno = reno;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepart(String depart) {
        this.depart = depart;
    }
    public void setEvnt1(String evnt1) {
        this.evnt1 = evnt1;
    }
    public void setEvnt2(String evnt2) {
        this.evnt2 = evnt2;
    }
    public void setEvnt3(String evnt3) {
        this.evnt3 = evnt3;
    }


}
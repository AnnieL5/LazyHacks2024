public class Routine {
    private String name;
    private String stime,etime;


    public Routine(String name, String s,String e) {
        this.name = name;
        this.etime = e;
        this.stime = s;
    }

    public String getName() {
        return name;
    }

    public String getStime() {
        return stime;
    }

    public String getEtime() {
        return etime;
    }

    
    @Override
    public String toString() {
        return name+", from "+stime+" to "+etime;
    }

}

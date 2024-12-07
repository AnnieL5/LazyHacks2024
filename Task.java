class Task {
    private String name;
    private int month, date, year;
    private double hours;

    public Task(String name, int month, int date, int year, double hours) {
        this.name = name;
        this.month = month;
        this.date = date;
        this.year = year;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public int getYear() {
        return year;
    }

    public double getHours() {
        return hours;
    }

    public void usedHours(double h) {
        this.hours = hours-h;
    }

    @Override
    public String toString() {
        return name+" Due date: "+month+"/"+date+"/"+year+"  Need "+hours+" hours to complete";
    }

    public String getStime() {
        return null;
    }
}
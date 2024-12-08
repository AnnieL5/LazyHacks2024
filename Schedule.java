import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Schedule {

    ArrayList<Routine> routinearray;
    ArrayList<Task> taskarray;
    String[] schedule;

    public Schedule(ArrayList<Task> a, ArrayList<Routine> b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Task and routine arrays cannot be null.");
        }

        this.routinearray = b;
        this.taskarray = a;
        schedule = new String[24];
        for (int t = 0; t < 24; t++) {
            schedule[t] = "Free time!";
        }

        double[] hours = new double[24];
        for (int m = 0; m < 24; m++) {
            hours[m] = -1;
        }

        for (int i = 0; i < routinearray.size(); i++) {
            int stime = Integer.parseInt(routinearray.get(i).getStime());
            int etime = Integer.parseInt(routinearray.get(i).getEtime());
            if (stime >= 0 && stime < 24 && etime >= 0 && etime < 24 && stime <= etime) {
                for (int n = stime; n <= etime; n++) {
                    schedule[n] = routinearray.get(i).getName();
                    hours[n] = 0;
                }
            } else {
                System.out.println("Invalid routine times: " + stime + " to " + etime);
            }
        }

        for (int y = 0; y < 24; y++) {
            if (hours[y] < 0 && !taskarray.isEmpty()) {
                int taskIndex = y % taskarray.size();
                schedule[y] = taskarray.get(taskIndex).getName();
                taskarray.get(taskIndex).usedHours(1);  
            }
        }
        String text = "";
        for(int i = 0; i<24; i++){
            text += i+":00"+schedule[i]+"\n";
        }
        JOptionPane.showMessageDialog(null,text, "Updated Schedule", JOptionPane.INFORMATION_MESSAGE);

    }

    public String[] getSchedule() {
        return schedule;
    }
}

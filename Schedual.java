import java.util.ArrayList;

public class Schedual {


    ArrayList<Routine> routinearray;
    ArrayList<Task> taskarray;
    public Schedual(ArrayList<Task> a, ArrayList<Routine> b){

        this.routinearray = b;
        this.taskarray = a;
       String[] schedual = new String[24]; 
       double[] hours = new double[24]; 
        for (int m=0; m<24; m++){
            hours[m] = -1;
        }

       for(int i =0; i<routinearray.size();i++){
        int stime = Integer.parseInt(routinearray.get(i).getStime());
        int etime = Integer.parseInt(routinearray.get(i).getEtime());
        for(int n = stime; n <= etime;n++){
            schedual[n]=routinearray.get(i).getName();
            hours[n]= 0;
        }

       }

       for (int y=0; y<24; y++){
            if(hours[y]<0){
                schedual[y]=taskarray.get(y).getName();
                taskarray.get(y).usedHours(1);
            }
        }

    }
}
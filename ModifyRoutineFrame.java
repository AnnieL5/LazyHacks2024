import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifyRoutineFrame extends JFrame implements ActionListener {
   
    static ArrayList<Routine> array;
    JButton AddButton,DeleteButton;
    JTextField deletenum;
    
    public ModifyRoutineFrame(ArrayList<Routine> a) {
        this.setBounds(50, 60, 1000, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        array = a;
        
        JPanel display = new JPanel();
        display.setLayout(null);
        display.setSize(400, 200);
        this.add(display);


        for(int i = 0; i<array.size(); i++){
            AddRoutine(i,display);
        }

        AddButton = new JButton("Add Routine");
        AddButton.setBounds(700, 70, 200, 60);
        AddButton.addActionListener(this);
        display.add(AddButton);

        deletenum = new JTextField();
        deletenum.setBounds(650, 260, 50, 30);
        display.add(deletenum);
        DeleteButton = new JButton("Delete Routine");
        DeleteButton.setBounds(700, 250, 200, 60);
        DeleteButton.addActionListener(this);
        display.add(DeleteButton);



        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed"); 
        if (e.getSource() == AddButton) {
            try {
                new RoutineFrame(array);
                this.dispose();
            } catch (NumberFormatException ex) {
                // Handle invalid input case
                JOptionPane.showMessageDialog(this, "Invalid input! Please make sure all fields are filled correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == DeleteButton){
            try {
  
                int num = Integer.parseInt(deletenum.getText());
                Routine Routine = array.get(num-1);
                array.remove(num-1);
                this.dispose();
                JOptionPane.showMessageDialog(this, "Routine "+num+" "+ Routine.toString(), "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                new ModifyRoutineFrame(array);
            } catch (NumberFormatException ex) {
                // Handle invalid input case
                JOptionPane.showMessageDialog(this, "Invalid input! Please make sure all fields are filled correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        
        
    }

    public static void AddRoutine(int RoutineNum, JPanel display){
        int n = 100+(50*RoutineNum);
        Routine Routine = array.get(RoutineNum);
        int num = RoutineNum+1;

        JLabel description = new JLabel("Routine "+num+" "+Routine.toString());
        description.setBounds(100, n, 1000, 30);
        display.add(description);


    }

    

   
}

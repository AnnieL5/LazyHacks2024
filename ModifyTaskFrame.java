import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifyTaskFrame extends JFrame implements ActionListener {
   
    static ArrayList<Task> array;
    JButton AddButton,DeleteButton;
    JTextField deletenum;
    
    public ModifyTaskFrame(ArrayList<Task> a) {
        this.setBounds(50, 60, 1000, 600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        array = a;


        JPanel display = new JPanel();
        display.setLayout(null);
        display.setSize(400, 200);
        this.add(display);


        for(int i = 0; i<array.size(); i++){
            AddTask(i,display);
        }

        AddButton = new JButton("Add Task");
        AddButton.setBounds(700, 70, 200, 60);
        AddButton.addActionListener(this);
        display.add(AddButton);

        deletenum = new JTextField();
        deletenum.setBounds(650, 260, 50, 30);
        display.add(deletenum);
        DeleteButton = new JButton("Delete Task");
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
                new TaskFrame(array);
                this.dispose();
            } catch (NumberFormatException ex) {
                // Handle invalid input case
                JOptionPane.showMessageDialog(this, "Invalid input! Please make sure all fields are filled correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == DeleteButton){
            try {
  
                int num = Integer.parseInt(deletenum.getText());
                Task task = array.get(num-1);
                array.remove(num-1);
                this.dispose();
                JOptionPane.showMessageDialog(this, "Task "+num+" "+ task.toString(), "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                new ModifyTaskFrame(array);
            } catch (NumberFormatException ex) {
                // Handle invalid input case
                JOptionPane.showMessageDialog(this, "Invalid input! Please make sure all fields are filled correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        
        
    }

    public static void AddTask(int taskNum, JPanel display){
        int n = 100+(50*taskNum);
        Task task = array.get(taskNum);
        int num = taskNum+1;

        JLabel description = new JLabel("Task "+num+" "+task.toString());
        description.setBounds(100, n, 1000, 30);
        display.add(description);


    }

   
}

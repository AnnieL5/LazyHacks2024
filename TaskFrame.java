import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TaskFrame extends JFrame implements ActionListener {
    private JTextField textField, month, date, year, time;
    private ArrayList<Task> array;
    private JButton submitButton;

    public TaskFrame(ArrayList<Task> a) {
        this.setBounds(50, 60, 1000, 600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        array = a;

        JPanel display = new JPanel();
        display.setLayout(null);
        display.setSize(400, 200);
        this.add(display);

        JLabel nameLabel = new JLabel("Task Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        display.add(nameLabel);
        textField = new JTextField();
        textField.setBounds(150, 50, 200, 30);
        display.add(textField);

        JLabel dueDateLabel = new JLabel("Due Date (numbers):");
        dueDateLabel.setBounds(50, 100, 200, 30);
        display.add(dueDateLabel);

        JLabel monthLabel = new JLabel("Month");
        monthLabel.setBounds(190, 100, 70, 30);
        display.add(monthLabel);
        month = new JTextField();
        month.setBounds(235, 100, 50, 30);
        display.add(month);

        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(290, 100, 70, 30);
        display.add(dateLabel);
        date = new JTextField();
        date.setBounds(455, 100, 50, 30);
        display.add(date);

        JLabel yearLabel = new JLabel("Year");
        yearLabel.setBounds(410, 100, 70, 30);
        display.add(yearLabel);
        year = new JTextField();
        year.setBounds(345, 100, 50, 30);
        display.add(year);

        JLabel spinnerLabel = new JLabel("How many hours is this task expected to need:");
        spinnerLabel.setBounds(50, 150, 300, 30);
        display.add(spinnerLabel);
        time = new JTextField();
        time.setBounds(360, 150, 200, 30);
        display.add(time);

      

        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 200, 100, 30);
        submitButton.addActionListener(this);
        display.add(submitButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed"); 
        if (e.getSource() == submitButton) {
            try {

                System.out.println("trying..."); 
                String n =textField.getText();          
                int m = Integer.parseInt(month.getText());
                int d = Integer.parseInt(year.getText());
                int y = Integer.parseInt(date.getText());
                double t = Double.parseDouble(time.getText());
                System.out.println("d="+Integer.parseInt(date.getText()));
        
        
                System.out.println("Creating task");
                Task task = new Task(n, m, d, y, t);
                System.out.println("Task created"); 
                array.add(task);

                System.out.println("Task added: " + n + ", Due Date: " + m + "/" + d + "/" + y + ", Hours: " + t);
        
                JOptionPane.showMessageDialog(this, "Task Added: " + task.toString(), "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        
                this.dispose();
                new ModifyTaskFrame(array);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please make sure all fields are filled correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RoutineFrame extends JFrame implements ActionListener {
    private JTextField textField, stime, etime;
    private ArrayList<Routine> array;
    private JButton submitButton;

    public RoutineFrame(ArrayList<Routine> a) {
        this.setBounds(50, 60, 1000, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        array = a;

        JPanel display = new JPanel();
        display.setLayout(null);
        display.setSize(400, 200);
        this.add(display);

        JLabel nameLabel = new JLabel("Routine Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        display.add(nameLabel);
        textField = new JTextField();
        textField.setBounds(150, 50, 200, 30);
        display.add(textField);

        JLabel stimeLabel = new JLabel("(24h) Start Time:");
        stimeLabel.setBounds(110, 100, 150, 30);
        display.add(stimeLabel);
        stime = new JTextField();
        stime.setBounds(250, 100, 50, 30);
        display.add(stime);

        JLabel etimeLabel = new JLabel("End Time:");
        etimeLabel.setBounds(320, 100, 70, 30);
        display.add(etimeLabel);
        etime = new JTextField();
        etime.setBounds(455, 100, 50, 30);
        display.add(etime);


      

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
                String s = stime.getText();
                String E = etime.getText();
                
        
                System.out.println("Creating Routine");
                Routine Routine = new Routine(n, s, E);
                System.out.println("Routine created"); 
                array.add(Routine);
                
                String string = "Routine added! "+n+", from "+s+ " to "+E;
        
                JOptionPane.showMessageDialog(this,"Routine added:"+ Routine.toString(), "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        
                this.dispose();
                new ModifyRoutineFrame(array);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please make sure all fields are filled correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
}
import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Main {

    private static JFrame mainFrame = new JFrame("Task Manager");

    private static JPanel mainPanel = new JPanel(new GridLayout(1, 2));
    private static JPanel chatPanel = new JPanel(null);
    private static JPanel schedulePanel = new JPanel(new GridBagLayout());
    private static JPanel datePanel = new JPanel(new GridBagLayout());
    private static JPanel calendarPanel = new JPanel(null);
    private static JPanel buttonsPanel = new JPanel(null);

    private static JLabel dateText;

    private static Calendar date = Calendar.getInstance();

    public static void main(String[] args) {

        mainPanel.setBounds(mainFrame.getBounds());

        chatPanel.setBackground(new Color(255, 238, 238));
        mainPanel.add(chatPanel);

        schedulePanel.setBackground(new Color(238, 238, 255));

        GridBagConstraints constraintsSchedule = new GridBagConstraints();
        constraintsSchedule.gridx = 0;
        constraintsSchedule.gridy = 0;
        constraintsSchedule.fill = GridBagConstraints.BOTH;
        constraintsSchedule.weightx = 1.0;
        constraintsSchedule.weighty = 0.07;

        datePanel.setBackground(new Color(200, 238, 238));
        schedulePanel.add(datePanel, constraintsSchedule);
        constraintsSchedule.weighty = 0.75;
        constraintsSchedule.gridy++;


        DateFormat formatter = new SimpleDateFormat("EEEEEEEEE", Locale.getDefault());
        String dayOfWeek = formatter.format(date.getTime());


        dateText = new JLabel(dayOfWeek + ", " + date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + ", " + date.get(Calendar.DAY_OF_MONTH));
        dateText.setFont(dateText.getFont().deriveFont(Font.BOLD, 27f));
        datePanel.add(dateText, new GridBagConstraints());

        calendarPanel.setBackground(new Color(200, 200, 238));
        schedulePanel.add(calendarPanel, constraintsSchedule);
        constraintsSchedule.weighty = 0.125;
        constraintsSchedule.gridy++;

        buttonsPanel.setSize(mainFrame.getSize().width/2, mainFrame.getSize().height/6);
        buttonsPanel.setBackground(new Color(200, 238, 200));
        schedulePanel.add(buttonsPanel, constraintsSchedule);

        mainPanel.add(schedulePanel);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setExtendedState(mainFrame.MAXIMIZED_BOTH);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

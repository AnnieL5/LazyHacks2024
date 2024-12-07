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
    private static JPanel calendarPanel = new JPanel(new GridBagLayout());
    private static JPanel buttonsPanel = new JPanel(null);

    private static JLabel dateText;
    
    private static DateFormat formatter = new SimpleDateFormat("EEEEEEEEE", Locale.getDefault());
    private static Calendar date = Calendar.getInstance();
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

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
        constraintsSchedule.weighty = 0.06;

        GridBagConstraints constraintsCalendar = new GridBagConstraints();
        constraintsCalendar.gridx = 0;
        constraintsCalendar.gridy = 0;
        constraintsCalendar.fill = GridBagConstraints.BOTH;
        constraintsCalendar.weightx = 1.0/7.0;
        constraintsCalendar.weighty = 1.0/24.0;

        datePanel.setBackground(new Color(200, 238, 238));
        schedulePanel.add(datePanel, constraintsSchedule);
        constraintsSchedule.weighty = 0.1;
        constraintsSchedule.gridy+=2;

        dateText = new JLabel(formatter.format(date.getTime()) + ", " + date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + ", " + date.get(Calendar.DAY_OF_MONTH));
        dateText.setFont(dateText.getFont().deriveFont(Font.BOLD, 27f));
        datePanel.add(dateText, new GridBagConstraints());

        buttonsPanel.setSize(screenSize.width/2, screenSize.height/6);
        buttonsPanel.setBackground(new Color(200, 238, 200));
        schedulePanel.add(buttonsPanel, constraintsSchedule);
        constraintsSchedule.weighty = 0.9;
        constraintsSchedule.gridy--;

        calendarPanel.setBackground(new Color(200, 200, 238));
        calendarPanel.setPreferredSize(new Dimension((int)(screenSize.width/2.1), screenSize.height));
        schedulePanel.add(calendarPanel, constraintsSchedule);

        JScrollPane calendarScroll = new JScrollPane(calendarPanel);
        calendarScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        calendarScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        schedulePanel.add(calendarScroll, constraintsSchedule);

        mainPanel.add(schedulePanel);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) 
    { 
        g.drawRect(calendarPanel.getX(), calendarPanel.getY(), calendarPanel.getWidth()/7, calendarPanel.getHeight()/24); 
    } 

}

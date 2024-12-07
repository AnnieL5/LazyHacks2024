import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainFrame implements ActionListener{

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int rectSizeHeight = (screenSize.height/24 + 1);

    private JFrame mainFrame = new JFrame("Task Manager");

    private JPanel mainPanel = new JPanel(new GridLayout(1, 2));
    private JPanel chatPanel = new JPanel(null);
    private JPanel schedulePanel = new JPanel(new GridBagLayout()); //schedule is the right side of the screen
    private JPanel datePanel = new JPanel(new GridBagLayout());
    private JPanel calendarPanel = new JPanel(new GridBagLayout()) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i<24; i++) {
                g.setColor(new Color(98, 98, 98)); // dark gray
                g.drawRect(0, rectSizeHeight*i, calendarPanel.getWidth()/7, rectSizeHeight);
            }
        }
    };
    private JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));

    private JLabel dateText;
    private JLabel[] timeNumbers = new JLabel[24];
    
    private JButton tasksButton = new JButton("Manage Tasks");
    private JButton routineButton = new JButton("Manage Routine");

    private JTextField chatInput = new JTextField("Message");

    private ArrayList<Task> taskList;

    private DateFormat formatter = new SimpleDateFormat("EEEEEEEEE", Locale.getDefault());
    private Calendar date = Calendar.getInstance();

    public MainFrame() {

        taskList = new ArrayList<>();



        mainPanel.setBounds(mainFrame.getBounds());


        chatPanel.setBackground(new Color(255, 238, 238));
        mainPanel.add(chatPanel);
        chatInput.setBounds(10, (int)screenSize.getHeight() - 20 - 100, (int)screenSize.getWidth()/2 - 60, 50);
        chatPanel.add(chatInput);

        schedulePanel.setBackground(new Color(238, 238, 255));

        GridBagConstraints constraintsSchedule = new GridBagConstraints();
        constraintsSchedule.gridx = 0;
        constraintsSchedule.gridy = 0;
        constraintsSchedule.fill = GridBagConstraints.BOTH;
        constraintsSchedule.weightx = 1.0;
        constraintsSchedule.weighty = 0.06;

        datePanel.setBackground(new Color(200, 238, 238));
        schedulePanel.add(datePanel, constraintsSchedule);
        constraintsSchedule.weighty = 0.1;
        constraintsSchedule.gridy+=2;

        dateText = new JLabel(formatter.format(date.getTime()) + ", " + date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + ", " + date.get(Calendar.DAY_OF_MONTH));
        dateText.setFont(dateText.getFont().deriveFont(Font.BOLD, 27f));
        datePanel.add(dateText, new GridBagConstraints());

        buttonsPanel.setSize(screenSize.width/2, screenSize.height/6);

        tasksButton.setSize(new Dimension(buttonsPanel.getWidth(), buttonsPanel.getHeight()));
        tasksButton.addActionListener(this::actionPerformed);
        buttonsPanel.add(tasksButton);


        routineButton.setSize(new Dimension(buttonsPanel.getWidth(), buttonsPanel.getHeight()));
        routineButton.addActionListener(this::actionPerformedRoutine);
        // buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(routineButton);

        buttonsPanel.setBackground(new Color(200, 238, 200));
        schedulePanel.add(buttonsPanel, constraintsSchedule);
        constraintsSchedule.weighty = 0.9;
        constraintsSchedule.gridy--;

        calendarPanel.setBackground(new Color(200, 200, 238));
        calendarPanel.setPreferredSize(new Dimension((int)(screenSize.width/2.1), screenSize.height));
        // System.out.println(screenSize.width/2.1);
        schedulePanel.add(calendarPanel, constraintsSchedule);



        GridBagConstraints constraintsCalendar = new GridBagConstraints();
        constraintsCalendar.gridx = 0;
        constraintsCalendar.gridy = 0;
        constraintsCalendar.fill = GridBagConstraints.BOTH;
        constraintsCalendar.weightx = 1.0;
        constraintsCalendar.weighty = 1.0;

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

        for (int i = 0; i < timeNumbers.length; i++) {

            timeNumbers[i] = new JLabel(i + ":00");
            timeNumbers[i].setFont(timeNumbers[i].getFont().deriveFont(Font.BOLD, 30f));

            // timeNumbers[i].setSize((int)calendarPanel.getBounds().getWidth()*3/14, rectSizeHeight);
            calendarPanel.add(timeNumbers[i], constraintsCalendar);
            constraintsCalendar.gridy++;
            if (i<timeNumbers.length-1) {
                // constraintsCalendar.fill = GridBagConstraints.VERTICAL;
                calendarPanel.add(Box.createVerticalStrut((int)rectSizeHeight/10), constraintsCalendar);
                // constraintsCalendar.fill = GridBagConstraints.BOTH;
                constraintsCalendar.gridy++;
            }
        }

        for (int i = 0; i < 7; i++) {
            constraintsCalendar.gridx++;
            calendarPanel.add(Box.createHorizontalStrut((int)calendarPanel.getBounds().getWidth()/8), constraintsCalendar);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new ModifyTaskFrame(taskList);
    }

    public void actionPerformedRoutine(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

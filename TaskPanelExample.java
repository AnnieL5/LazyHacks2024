import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TaskPanelExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskPanelExample::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create an initial list of tasks
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "Description of Task 1"));
        tasks.add(new Task("Task 2", "Description of Task 2"));
        tasks.add(new Task("Task 3", "Description of Task 3"));

        // Create the panel to hold all tasks
        TaskPanel taskPanel = new TaskPanel(tasks);

        // Add the task panel to the frame
        frame.getContentPane().add(taskPanel, BorderLayout.CENTER);

        // Show the frame
        frame.setVisible(true);
    }
}

// Assuming this is your existing Task class
class Task {
    String name;
    String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Task(String n, int m, int d, int y, double t) {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void delete() {
        // You could add any logic here to delete a task if needed (e.g., remove from DB)
    }
}

// JPanel to display tasks
class TaskPanel extends JPanel {
    private ArrayList<Task> tasks;
    private JPanel taskListPanel;

    public TaskPanel(ArrayList<Task> tasks) {
        this.tasks = tasks;
        setLayout(new BorderLayout());

        // Create the panel that will hold each task and its delete button
        taskListPanel = new JPanel();
        taskListPanel.setLayout(new BoxLayout(taskListPanel, BoxLayout.Y_AXIS));
        updateTaskList();

        // Add the task list panel to the main panel
        JScrollPane scrollPane = new JScrollPane(taskListPanel);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Update the task list display
    public void updateTaskList() {
        taskListPanel.removeAll();  // Clear the panel before updating

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            JPanel taskPanel = new JPanel();
            taskPanel.setLayout(new FlowLayout());

            // Create a label for the task name and description
            JLabel taskLabel = new JLabel("<html><strong>" + task.getName() + "</strong>: " + task.getDescription() + "</html>");
            taskPanel.add(taskLabel);

            // Create a delete button for the task
            JButton deleteButton = new JButton("Delete");
            int taskIndex = i; // Final variable for lambda
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the task from the array and update the display
                    tasks.remove(taskIndex);
                    updateTaskList();  // Refresh the task list display
                }
            });
            taskPanel.add(deleteButton);

            // Add the task panel to the main task list panel
            taskListPanel.add(taskPanel);
        }

        // Refresh the UI
        revalidate();
        repaint();
    }
}

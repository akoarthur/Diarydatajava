package GUIProgramming;

import java.awt.FlowLayout;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Font;

public class NewDiaryRevised extends JFrame {

    private JLabel titleLabel;
    private JLabel idLabel;
    private JTextField idTextField;
    private JLabel dateLabel;
    private JTextField dateTextField;
    private JLabel contentLabel;
    private JTextArea contentTextArea;
    private JScrollPane contentScrollPane;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel buttonPanel;

    public NewDiaryRevised() {
        initComponents();
    }

    private void initComponents() {
        titleLabel = new JLabel("Create New Diary Entry");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        idLabel = new JLabel("Entry ID:");
        idTextField = new JTextField(10);

        dateLabel = new JLabel("Date (mm/dd/yyyy):");
        dateTextField = new JTextField(10);

        contentLabel = new JLabel("Your Thoughts:");
        contentTextArea = new JTextArea(5, 20);
        contentScrollPane = new JScrollPane(contentTextArea);

        saveButton = new JButton("Record Entry");
        cancelButton = new JButton("Discard");
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Align buttons to the right
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Set the main layout
        setLayout(new java.awt.GridLayout(5, 2, 5, 5)); // 5 rows, 2 columns, with gaps

        // Add components to the frame
        add(new JLabel()); // Empty label for spacing
        add(titleLabel);
        add(idLabel);
        add(idTextField);
        add(dateLabel);
        add(dateTextField);
        add(contentLabel);
        add(contentScrollPane);
        add(new JLabel()); // Empty label for spacing
        add(buttonPanel);

        // Add action listeners
        cancelButton.addActionListener(evt -> {
            this.dispose();
        });

        saveButton.addActionListener(evt -> {
            try {
                String id = idTextField.getText();
                String date = dateTextField.getText();
                String content = contentTextArea.getText();
                String data = id + " % " + date + " % " + content + "\n";
                FileWriter writer = new FileWriter("C:/data/diaryData.txt", true);
                writer.write(data);
                writer.close();
                JOptionPane.showMessageDialog(null, "Entry Saved Successfully.");
                clearFields();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error saving entry: " + e.getMessage());
                System.out.println(e.getMessage());
            }
        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Diary Entry");
        pack(); // Adjust window size to fit components
        setLocationRelativeTo(null);
    }

    private void clearFields() {
        idTextField.setText("");
        dateTextField.setText("");
        contentTextArea.setText("");
    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new NewDiaryRevised().setVisible(true);
        });
    }
}

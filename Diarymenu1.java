package GUIProgramming;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class DiaryMenuRevised2 extends JFrame {

    private JButton btnAddEntry;
    private JButton btnShowAll;
    private JButton btnFindEntry;
    private JButton btnClose;
    private JPanel buttonPanel;

    public DiaryMenuRevised2() {
        initComponents();
    }

    private void initComponents() {
        btnAddEntry = new JButton("Add New Entry");
        btnShowAll = new JButton("Show All Entries");
        btnFindEntry = new JButton("Find Entry");
        btnClose = new JButton("Close");
        buttonPanel = new JPanel();

        // Set the main layout to BorderLayout
        setLayout(new BorderLayout(5, 5)); // 5 pixels horizontal and vertical gap

        // Add the "Add New Entry" button to the NORTH
        add(btnAddEntry, BorderLayout.NORTH);

        // Create a JPanel with FlowLayout to hold "Show All Entries" and "Find Entry" buttons
        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 5));
        buttonPanel.add(btnShowAll);
        buttonPanel.add(btnFindEntry);

        // Add the button panel to the CENTER
        add(buttonPanel, BorderLayout.CENTER);

        // Add the "Close" button to the SOUTH
        add(btnClose, BorderLayout.SOUTH);

        // Add action listeners (you'll need to implement these)
        btnAddEntry.addActionListener(evt -> {
            // TODO: Add action for adding a diary entry
            NewDiary nd = new NewDiary();
            nd.setVisible(true);
        });

        btnShowAll.addActionListener(evt -> {
            // TODO: Add action for viewing all diaries
            ViewDiaries vd = new ViewDiaries();
            vd.setVisible(true);
        });

        btnFindEntry.addActionListener(evt -> {
            // TODO: Add action for viewing specific diaries
            ViewSpecificDiaries vsd = new ViewSpecificDiaries();
            vsd.setVisible(true);
        });

        btnClose.addActionListener(evt -> {
            // TODO: Add action for exiting
            System.exit(0);
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Diary Options"); 
        setSize(250, 200); 
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public static void Main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new DiaryMenuRevised2().setVisible(true);
        });
    }
}

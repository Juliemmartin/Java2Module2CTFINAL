import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.*;


public class ageCalcExample {
    public static void main(String[] args) {


        //Build new frame
        
        JFrame frame = new JFrame("Calculate Your Age!");

        frame.setSize(500, 150);
        
        //Exit application on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Build new panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        //Build label and text field for birthdate input with title, font, size and color
        JLabel birthDateLabel = new JLabel("Enter your birthdate in this pattern format (YYYY-MM-DD):");
        birthDateLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField birthDateField = new JTextField(10);
        birthDateField.setFont(new Font("Arial", Font.PLAIN, 16));

        //Build new button inlcuding title, font, color and size
        JButton calculateButton = new JButton("Your Age");

        calculateButton.setBackground(Color.GREEN);
        calculateButton.setForeground(Color.BLACK);

        calculateButton.setFont(new Font("Arial", Font.BOLD, 16));

        //Add components to the panel
        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(calculateButton);


        //Add panel to the frame
        frame.add(panel);

        //Add action listener for the button to re ceive the birthdate
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputDate = birthDateField.getText();
                try {

                    //Input date
                    LocalDate birthDate = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    LocalDate currentDate = LocalDate.now();

                    //Age calcuation using period
                    Period age = Period.between(birthDate, currentDate);

                    //Display the age in a dialog box
                    JOptionPane.showMessageDialog(frame, "Based on your birthdate, your age is: " + age.getYears() + " years old",
                            "Age Calculator", JOptionPane.INFORMATION_MESSAGE);

                //Error handling for inpu 
                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(frame, "Invalid format. Please use this pattern format: YYYY-MM-DD.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                }
        });

        //Show frame, set to "true" 
        frame.setVisible(true);
    }

 }
// Name: Amit Deri; ID: 316443548

package application;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import java.awt.Button;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

	

    @FXML
    private ComboBox<Integer> dayComb;

    @FXML
    private ComboBox<Integer> monthComb;

    @FXML
    private ComboBox<Integer> yearComb;
    
    @FXML
    private Button init;

    @FXML
    private TextArea writeReminder;
    
    
    @FXML
    public void initialize() {
    	createComboBox();
    }

    // define the combobox for each element as their values that can be in 
    private void createComboBox() {
    	dayComb.getItems().addAll(FXCollections.observableArrayList(createList(1, 31)));
    	monthComb.getItems().addAll(FXCollections.observableArrayList(createList(1, 12)));
    	yearComb.getItems().addAll(FXCollections.observableArrayList(createList(1997, 2100)));
    }

    private ArrayList<Integer> createList(int start, int end) {
        ArrayList<Integer> comboBoxList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            comboBoxList.add(i);
        }
        return comboBoxList;
    }
    
    // create a new HashMap for the saved results for the reminder for future use 
    private HashMap<MyDate, String> reminders = new HashMap<>();
    
    String reminderText = "";
    int day = 1;
    int month = 1;
    int year = 1997;

    
    //when we click save button what will happend is that we first check if the user
    // entered a text to be remind about and if so then check if there is a valid date for that
    // if so then the reminder will be set other wise will raise a notice
    @FXML
    void savedClicked(MouseEvent event) {
    	//System.out.println(reminderText);
    	try {
        reminderText = writeReminder.getText();
    	}catch (Exception e) {
    		System.out.println("Enter a reminder");
    	}
        try {
        day = dayComb.getValue();
        month = monthComb.getValue();
        year = yearComb.getValue();
        }catch (NullPointerException e) {
        	System.out.println("Enter a date please");
        }

        MyDate date = new MyDate(day, month, year);
        if (reminderText.isEmpty()) {
            // If the reminder text is empty, remove the reminder for the selected date
            reminders.remove(date);
            showAlert("Reminder removed for " + date.toString(), Alert.AlertType.INFORMATION);
        } else {
            // Save the reminder text only for the selected date
            reminders.put(date, reminderText);
            showAlert("Reminder saved for " + date.toString(), Alert.AlertType.INFORMATION);
        }
    }

    
    // when we click in the view button we will see in a specific date if there is a
    // reminders if there is a reminder we will see the reminder otherwise we will print
    // to the text box that there is no reminders
    @FXML
    void viewClicked(MouseEvent event) {
        try {
    	day = dayComb.getValue();
        month = monthComb.getValue();
        year = yearComb.getValue();
        }catch (NullPointerException e) {
        	System.out.println("Enter a date please");
        }
        MyDate date = new MyDate(day, month, year);

        String reminderText = reminders.get(date);

        if (reminderText == null || reminderText.isEmpty()) {
            reminderText = "No reminder found for " + date.toString();
        }

        writeReminder.setText(reminderText);

        showAlert(reminderText, Alert.AlertType.INFORMATION);
    }



    // this method is pop out a alert that shows us that the reminder is set/ removed 
    // for what we did about the reminder if we wrote something it will show saved 
    // else it show removed
    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Reminder App");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    

}

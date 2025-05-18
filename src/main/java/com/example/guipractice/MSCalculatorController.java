package com.example.guipractice;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MSCalculatorController {

    @FXML
    private TextField milestone1Field;

    @FXML
    private TextField milestone2Field;

    @FXML
    private TextField terminalAssessmentField;

    @FXML
    private Label resultLabel;

    @FXML
    private void calculateGrade() {
        try {
            double m1 = Double.parseDouble(milestone1Field.getText());
            double m2 = Double.parseDouble(milestone2Field.getText());
            double ta = Double.parseDouble(terminalAssessmentField.getText());

            if (m1 < 0 || m1 > 25 || m2 < 0 || m2 > 40 || ta < 0 || ta > 35) {
                showAlert("Invalid input", "Please enter values within the allowed ranges:\n"
                        + "- Milestone 1: 0–25\n"
                        + "- Milestone 2: 0–40\n"
                        + "- Terminal Assessment: 0–35");
                return;
            }

            double total = m1 + m2 + ta;
            resultLabel.setText("Final Grade: " + total + " / 100");

        } catch (NumberFormatException e) {
            showAlert("Invalid input", "Please enter numeric values for all milestones.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
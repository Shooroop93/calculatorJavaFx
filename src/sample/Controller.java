package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class Controller {

    @FXML
    private Label display;

    private double result = 0;
    private boolean start = true;
    private String operator = "=";

    @FXML
    private void nums(ActionEvent event) {
try {
        if (start) {
            display.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        display.setText(display.getText() + value);
}catch ( RuntimeException ignored) {}

    }


    @FXML
    private void operators(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        try {
        if (start) {
            if (operator.equals("-")) {
                display.setText(value);
                start = false;
            } else operator = value;
        } else {
            calculate(Double.parseDouble(display.getText()));
            operator = value;
            start = true;
        }
        }catch ( RuntimeException ignored) {}

    }


    @FXML
    public void clearText(ActionEvent actionEvent) {
        try {
        display.setText("");

        }catch ( RuntimeException ignored) {}

    }

    @FXML
    private void Delete() {

try {
    if (display.getText().length() == 1) {
        display.setText("0");
    } else {
        display.setText(display.getText().substring(0, display.getText().length() - 1));
    }
}catch ( RuntimeException ignored) {}

    }

    private void calculate(double x) throws  RuntimeException{
            double y = 0;
try {

        if (operator.equals("+")) result += x;

        else if (operator.equals("-")) result -= x;
        else if (operator.equals("*")) result *= x;
        else if (operator.equals("/")) result /= x;
        else if (operator.equals("=")) result = (double) x;
}catch(RuntimeException e){
    System.out.println("Enter value First");
}

       

        display.setText("" + result);
    }


}
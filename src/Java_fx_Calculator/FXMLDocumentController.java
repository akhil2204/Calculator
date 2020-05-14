/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_fx_Calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author akhil
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    public TextField input;
    @FXML
    private Button clear;
    @FXML
    private Button percentage;
    @FXML
    private Button add;
    @FXML
    private Button sub;
    @FXML
    private Button multiply;
    @FXML
    private Button divide;
    @FXML
    private Button point;
    @FXML
    private Button equal;
    @FXML
    private Button plus_minus;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button zero;

    int operation;
    float display, data, number;

    public void handleButtonAction(ActionEvent event) throws IOException {
        
        if((input.getText().equals("0")) || (input.getText().equals("Invalid operation")) ||
                (input.getText().equals("Error")) ||(input.getText().equals("You have entered incorrect input!"))) {
            input.clear();
        }
        
        if (event.getSource() == one) {
            input.setText(input.getText() + "1");
            number = 1;
        } else if (event.getSource() == two) {
            input.setText(input.getText() + "2");
            number = 2;
        } else if (event.getSource() == three) {
            input.setText(input.getText() + "3");
            number = 3;
        } else if (event.getSource() == four) {
            input.setText(input.getText() + "4");
            number = 4;
        } else if (event.getSource() == five) {
            input.setText(input.getText() + "5");
            number = 5;
        } else if (event.getSource() == six) {
            input.setText(input.getText() + "6");
            number = 6;
        } else if (event.getSource() == seven) {
            input.setText(input.getText() + "7");
            number = 7;
        } else if (event.getSource() == eight) {
            input.setText(input.getText() + "8");
            number = 8;
        } else if (event.getSource() == nine) {
            input.setText(input.getText() + "9");
            number = 9;
        } else if (event.getSource() == zero) {
            input.setText(input.getText() + "0");
            number = 0;
        } else if (event.getSource() == clear) {
            input.clear();
            number = 0;
            data = 0;
            input.setText("0");
        } else if (event.getSource() == add) {
            input.setText(input.getText() + "+");
            operation = 1;
        } else if (event.getSource() == sub) {
            input.setText(input.getText() + "-");
            operation = 2;
        } else if (event.getSource() == multiply) {
            input.setText(input.getText() + "*");
            operation = 3;
        } else if (event.getSource() == divide) {
            data = data + number;
            input.setText(input.getText() + "/");
            operation = 4;
        } else if (event.getSource() == percentage) {
            //input.setText("%");
            // calling equal operator
            equalOperator();
            
            double a = 0;
            String per = input.getText();
            try {
                a = Double.parseDouble(per);
                double display = a / 100;
                input.setText(String.valueOf(display));
            } catch (Exception err) {
                System.out.println("Invalid operation");
                input.setText("Invalid operation");
            }
        } else if (event.getSource() == plus_minus) {
            /*
            String str = input.getText();
            int j=0;
            String str1="";
            System.out.println(str);
            for (j = str.length() - 1; j >= 0 && (str.charAt(j) == '1' || str.charAt(j) == '2' || str.charAt(j) == '3' || str.charAt(j) == '4' || str.charAt(j) == '5' || str.charAt(j) == '6' || str.charAt(j) == '7' || str.charAt(j) == '8' || str.charAt(j) == '9' || str.charAt(j) == '0' || str.charAt(j) == '.' ) ; j--) {   
                    str1 = str1 + str.substring(j, j + 1);
            }
            System.out.println(str1);
            StringBuilder sb1 = new StringBuilder(str1);
            str1 = sb1.reverse().toString();
            System.out.println(str1);
             
             */
            double a = 0;
            String plsminus = input.getText();
            try {
                a = Double.parseDouble(plsminus);
                a = a * (-1);
                input.setText( Double.toString(a));
                //equalOperator();
            } catch (Exception err) {
                System.out.println("Invalid operation");
                input.setText("Invalid operation");
            }
        } else if (event.getSource() == point) {
            //input.setText(input.getText() + ".");
            String str = input.getText();
            String str1 = "";
            int count=0, j=0;
            for (j = str.length() - 1; j >= 0 && (str.charAt(j) == '1' || str.charAt(j) == '2' || str.charAt(j) == '3' || str.charAt(j) == '4' || str.charAt(j) == '5' || str.charAt(j) == '6' || str.charAt(j) == '7' || str.charAt(j) == '8' || str.charAt(j) == '9' || str.charAt(j) == '0' || str.charAt(j) == '.') ; j--) {   
                    str1 = str1 + str.substring(j, j + 1);
            }
            for(int i = str1.length() - 1; i >=0; i--){
                if(str1.charAt(i)=='.' ){
                    count++;
                }
            }
            if(count==0){
               input.setText(input.getText() + "."); 
            }
        }
        else if (event.getSource() == equal) {

            equalOperator();
            /*
            try {
                //System.out.println("input: " + input.getText());
                String input1 = " " + input.getText() + " ";
                String strr1 = division(input1);
                //System.out.println("strr1 is: " + strr1);
                strr1 = " " + strr1 + " ";
                String strr2 = multiply(strr1);
                //System.out.println("strr2 is: " + strr2);
                strr2 = " " + strr2 + " ";
                String strr3 = addition(strr2);
                strr3 = " " + strr3 + " ";
                //System.out.println("strr3 is: " + strr3);
                String strr4 = subtraction(strr3);
                //System.out.println("final ans is: " + strr4);

                input.setText(strr4.trim());

                String result = input1 + "=" + strr4;
                System.out.println("result" + result);
                writeUsingFile(result);
                
            } catch (Exception err) {
                System.out.println("You have entered incorrect input!");
                input.setText("You have entered incorrect input!");
            }
            */
        } 
    }
    
    public void equalOperator(){
        try {
                //System.out.println("input: " + input.getText());
                String input1 = " " + input.getText() + " ";
                String strr1 = division(input1);
                //System.out.println("strr1 is: " + strr1);
                strr1 = " " + strr1 + " ";
                String strr2 = multiply(strr1);
                //System.out.println("strr2 is: " + strr2);
                strr2 = " " + strr2 + " ";
                String strr3 = addition(strr2);
                strr3 = " " + strr3 + " ";
                //System.out.println("strr3 is: " + strr3);
                String strr4 = subtraction(strr3);
                //System.out.println("final ans is: " + strr4);

                input.setText(strr4.trim());

                String result = input1 + "=" + strr4;
                System.out.println("result" + result);
                writeUsingFile(result);
                
            } catch (Exception err) {
                System.out.println("You have entered incorrect input!");
                input.setText("You have entered incorrect input!");
            }
        
    }

    public static String division(String input) {
        String str1 = "";
        String str2 = "";
        String str3 = "";
        double a = 0,b = 0,result;
        int i = 0, j = 0, k = 0, count = 0;
        for (i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '/') {
                count++;
                for (j = i - 1; (input.charAt(j) == '1' || input.charAt(j) == '2' || input.charAt(j) == '3' || input.charAt(j) == '4' || input.charAt(j) == '5' || input.charAt(j) == '6' || input.charAt(j) == '7' || input.charAt(j) == '8' || input.charAt(j) == '9' || input.charAt(j) == '0' || input.charAt(j) == '.') && j >= 0; j--) {         //|| j!= '*' || j!= '-'
                    str1 = str1 + input.substring(j, j + 1);
                }

                for (k = i + 1; input.charAt(k) == '1' || input.charAt(k) == '2' || input.charAt(k) == '3' || input.charAt(k) == '4' || input.charAt(k) == '5' || input.charAt(k) == '6' || input.charAt(k) == '7' || input.charAt(k) == '8' || input.charAt(k) == '9' || input.charAt(k) == '0' || input.charAt(k) == '.'; k++) {
                    str2 = str2 + input.substring(k, k + 1);
                }
                StringBuilder sb1 = new StringBuilder(str1);
                str1 = sb1.reverse().toString();
                a = Double.parseDouble(str1);
                b = Double.parseDouble(str2);

                if (b == 0) {
                    return "Error";
                } else {
                    result = a / b;
                }
                
                str3 = input.substring(0, j + 1) + Double.toString(result) + input.substring((k), input.length());
                if (str3.contains("/")) {
                    str3 = division(str3);
                }
                return str3;
            }
        }
        if (count > 0) {
            return str3;
        } else {
            return input;
        }
    }

    public static String multiply(String input) {
        //for division
        String str1 = "";
        String str2 = "";
        String str3 = "";
        double a = 0;
        double b = 0;
        double result;
        int i = 0, j = 0, k = 0, count = 0;
        for (i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '*') {
                count++;
                for (j = i - 1; input.charAt(j) == '1' || input.charAt(j) == '2' || input.charAt(j) == '3' || input.charAt(j) == '4' || input.charAt(j) == '5' || input.charAt(j) == '6' || input.charAt(j) == '7' || input.charAt(j) == '8' || input.charAt(j) == '9' || input.charAt(j) == '0' || input.charAt(j) == '.'; j--) {         //|| j!= '*' || j!= '-'
                    str1 = str1 + input.substring(j, j + 1);
                }
                for (k = i + 1; input.charAt(k) == '1' || input.charAt(k) == '2' || input.charAt(k) == '3' || input.charAt(k) == '4' || input.charAt(k) == '5' || input.charAt(k) == '6' || input.charAt(k) == '7' || input.charAt(k) == '8' || input.charAt(k) == '9' || input.charAt(k) == '0' || input.charAt(k) == '.'; k++) {
                    str2 = str2 + input.substring(k, k + 1);
                }

                StringBuilder sb1 = new StringBuilder(str1);
                str1 = sb1.reverse().toString();
                a = Double.parseDouble(str1);
                b = Double.parseDouble(str2);
                result = a * b;
                str3 = input.substring(0, j + 1) + Double.toString(result) + input.substring((k), input.length());
                if (str3.contains("*")) {
                    str3 = multiply(str3);
                }
                return str3;

            }
        }
        if (count > 0) {
            return str3;
        } else {
            return input;
        }
    }

    public static String addition(String input) {
        //for division
        String str1 = "";
        String str2 = "";
        String str3 = "";
        double a = 0;
        double b = 0;
        double result;
        int i = 0, j = 0, k = 0, count = 0, z = 0;
        for (int x = 0; x < input.length(); x++) {
            if (input.charAt(x) == '+' && input.charAt(x - 1) == ' ') {
                z = x;
                break;
            } else {
                z = 0;
            }
        }

        for (i = z + 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+') {
                count++;
                for (j = i - 1; input.charAt(j) == '1' || input.charAt(j) == '2' || input.charAt(j) == '3' || input.charAt(j) == '4' || input.charAt(j) == '5' || input.charAt(j) == '6' || input.charAt(j) == '7' || input.charAt(j) == '8' || input.charAt(j) == '9' || input.charAt(j) == '0' || input.charAt(j) == '.'; j--) {         //|| j!= '*' || j!= '-'
                    if (input.charAt(j - 1) == '+' || input.charAt(j - 1) == '-') {
                        str1 = str1 + input.substring(j, j + 1);
                        str1 = str1 + input.substring(j - 1, j);
                    } else {
                        str1 = str1 + input.substring(j, j + 1);
                    }
                }

                for (k = i + 1; input.charAt(k) == '1' || input.charAt(k) == '2' || input.charAt(k) == '3' || input.charAt(k) == '4' || input.charAt(k) == '5' || input.charAt(k) == '6' || input.charAt(k) == '7' || input.charAt(k) == '8' || input.charAt(k) == '9' || input.charAt(k) == '0' || input.charAt(k) == '.'; k++) {
                    str2 = str2 + input.substring(k, k + 1);
                }

                StringBuilder sb1 = new StringBuilder(str1);
                str1 = sb1.reverse().toString();
                a = Double.parseDouble(str1);
                b = Double.parseDouble(str2);

                result = a + b;
                if (input.charAt(j) == '+' || input.charAt(j) == '-') {
                    if (result > 0) {
                        str3 = input.substring(0, j) + "+" + Double.toString(result) + input.substring((k), input.length());
                    } else if (result == 0) {
                        str3 = input.substring(0, j) + input.substring((k), input.length());
                    } else {
                        str3 = input.substring(0, j) + Double.toString(result) + input.substring((k), input.length());
                    }

                } else {
                    str3 = input.substring(0, j + 1) + Double.toString(result) + input.substring((k), input.length());
                }
                if (str3.contains("+")) {
                    str3 = addition(str3);
                }
                return str3;
            }
        }
        if (count > 0) {
            return str3;
        } else {
            return input;
        }
    }

    public static String subtraction(String input) {
        //for division
        String str1 = "";
        String str2 = "";
        String str3 = "";
        double a = 0;
        double b = 0;
        double result;
        int i = 0, j = 0, k = 0, count = 0, z = 0;
        for (int x = 0; x < input.length(); x++) {
            if (input.charAt(x) == '-' && input.charAt(x - 1) == ' ') {
                z = x;
                break;
            } else {
                z = 0;
            }
        }
        for (i = z + 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-') {
                count++;
                for (j = i - 1; input.charAt(j) == '1' || input.charAt(j) == '2' || input.charAt(j) == '3' || input.charAt(j) == '4' || input.charAt(j) == '5' || input.charAt(j) == '6' || input.charAt(j) == '7' || input.charAt(j) == '8' || input.charAt(j) == '9' || input.charAt(j) == '0' || input.charAt(j) == '.'; j--) {         //|| j!= '*' || j!= '-'
                    if (input.charAt(j - 1) == '+' || input.charAt(j - 1) == '-') {
                        str1 = str1 + input.substring(j, j + 1);
                        str1 = str1 + input.substring(j - 1, j);
                    } else {
                        str1 = str1 + input.substring(j, j + 1);

                    }
                }

                for (k = i + 1; input.charAt(k) == '1' || input.charAt(k) == '2' || input.charAt(k) == '3' || input.charAt(k) == '4' || input.charAt(k) == '5' || input.charAt(k) == '6' || input.charAt(k) == '7' || input.charAt(k) == '8' || input.charAt(k) == '9' || input.charAt(k) == '0' || input.charAt(k) == '.'; k++) {
                    str2 = str2 + input.substring(k, k + 1);
                }
                StringBuilder sb1 = new StringBuilder(str1);
                str1 = sb1.reverse().toString();
                a = Double.parseDouble(str1);
                b = Double.parseDouble(str2);
                result = a - b;

                if (input.charAt(j) == '+' || input.charAt(j) == '-') {
                    if (result > 0) {
                        str3 = input.substring(0, j) + "+" + Double.toString(result) + input.substring((k), input.length());
                    } else if (result == 0) {
                        str3 = input.substring(0, j) + input.substring((k), input.length());
                    } else {
                        str3 = input.substring(0, j) + Double.toString(result) + input.substring((k), input.length());
                    }

                } else {
                    str3 = input.substring(0, j + 1) + Double.toString(result) + input.substring((k), input.length());
                }

                if (str3.contains("-")) {
                    str3 = subtraction(str3);
                }
                return str3;
            }
        }
        if (count > 0) {
            return str3;
        } else {
            return input;
        }
    }

    public static void writeUsingFile(String s) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("Cal_Results.txt", true));
        
        out.write(s);
        out.newLine();
        out.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        input.setText("0");
    }

}

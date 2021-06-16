import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * This class is the main controller of the application
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class CalculatorController 
{
    /**
     * the first operand of the calculation
     */
    private double firstOperand = 0;

    /**
     * the operation of the calculation
     */
    private String operation = "";

    @FXML
    private Label label;

    @FXML
    void acPress(ActionEvent event) 
    {
        label.setText("0");
        firstOperand = 0;
    }

    @FXML
    void dotPress(ActionEvent event) 
    {
        label.setText(label.getText() + ".");
    }

    @FXML
    void equalsPress(ActionEvent event) 
    {
        double secondOperand = Double.parseDouble(label.getText()); 

        if(operation == "+")
        {
            double ans = firstOperand + secondOperand;
            if((ans == Math.floor(ans)) && !Double.isInfinite(ans)) 
            {
                String s = Double.toString(ans);
                s = s.substring(0, s.length() - 2);
                label.setText(s);
            }
            else
            {
                label.setText(Double.toString(ans));
            }
        }
        else if(operation == "-")
        {
            double ans = firstOperand - secondOperand;
            if((ans == Math.floor(ans)) && !Double.isInfinite(ans)) 
            {
                String s = Double.toString(ans);
                s = s.substring(0, s.length() - 2);
                label.setText(s);
            }
            else
            {
                label.setText(Double.toString(ans));
            }
        }
        else if(operation == "*")
        {
            double ans = firstOperand * secondOperand;
            if((ans == Math.floor(ans)) && !Double.isInfinite(ans)) 
            {
                String s = Double.toString(ans);
                s = s.substring(0, s.length() - 2);
                label.setText(s);
            }
            else
            {
                label.setText(Double.toString(ans));
            }
        }
        else if(operation == "/")
        {
            double ans = firstOperand / secondOperand;
            if((ans == Math.floor(ans)) && !Double.isInfinite(ans)) 
            {
                String s = Double.toString(ans);
                s = s.substring(0, s.length() - 2);
                label.setText(s);
            }
            else
            {
                label.setText(Double.toString(ans));
            }
        }
        else if (operation == "^")
        {
            double ans = Math.pow(firstOperand, secondOperand);
            if((ans == Math.floor(ans)) && !Double.isInfinite(ans)) 
            {
                String s = Double.toString(ans);
                s = s.substring(0, s.length() - 2);
                label.setText(s);
            }
            else
            {
                label.setText(Double.toString(ans));
            }
        }

        firstOperand = 0;
        operation = "";
    }

    @FXML
    void divPress(ActionEvent event) 
    {
        firstOperand = Double.parseDouble(label.getText());  
        label.setText("0");
        operation = "/";
    }
    
    @FXML
    void multPress(ActionEvent event) 
    {
        firstOperand = Double.parseDouble(label.getText());  
        label.setText("0");
        operation = "*";
    }
    
    @FXML
    void plusPress(ActionEvent event) 
    {
        firstOperand = Double.parseDouble(label.getText());  
        label.setText("0");
        operation = "+";
    }
    
    @FXML
    void powerPress(ActionEvent event) 
    {
        firstOperand = Double.parseDouble(label.getText());  
        label.setText("0");
        operation = "^";
    }
    
    @FXML
    void subPress(ActionEvent event) 
    {
        firstOperand = Double.parseDouble(label.getText());  
        label.setText("0");
        operation = "-";
    }
     
    @FXML
    void zeroPress(ActionEvent event) 
    {
        if(!label.getText().equals("0"))
        {
            label.setText(label.getText() + "0");
        }
        else
        {
            label.setText("0");
        }
    }
    
    @FXML
    void onePress(ActionEvent event) 
    {
        if(!label.getText().equals("0"))
        {
            label.setText(label.getText() + "1");
        }
        else
        {
            label.setText("1");
        }
    }
    
    @FXML
    void twoPress(ActionEvent event) 
    {
        if(!label.getText().equals("0"))
        {
            label.setText(label.getText() + "2");
        }
        else
        {
            label.setText("2");
        }
    }
    
    @FXML
    void threePress(ActionEvent event) 
    {
        if(!label.getText().equals("0"))
        {
            label.setText(label.getText() + "3");
        }
        else
        {
            label.setText("3");
        } 
    }
    
    @FXML
    void fourPress(ActionEvent event) 
    {
        if(!label.getText().equals("0"))
        {
            label.setText(label.getText() + "4");
        }
        else
        {
            label.setText("4");
        }  
    }
    
    @FXML
    void fivePress(ActionEvent event) 
    {
        if(!label.getText().equals("0"))
        {
            label.setText(label.getText() + "5");
        }
        else
        {
            label.setText("5");
        } 
    }
    
    @FXML
    void sixPress(ActionEvent event) 
    {
        if(!label.getText().equals("0"))
        {
            label.setText(label.getText() + "6");
        }
        else
        {
            label.setText("6");
        }
    }
    
    @FXML
    void sevenPress(ActionEvent event) 
    {
        if(!label.getText().equals("0"))
        {
            label.setText(label.getText() + "7");
        }
        else
        {
            label.setText("7");
        }
    }
    
    @FXML
    void eightPress(ActionEvent event)
    {
        if(!label.getText().equals("0"))
        {
            label.setText(label.getText() + "8");
        }
        else
        {
            label.setText("8");
        }
    }

    @FXML
    void ninePress(ActionEvent event) 
    {
        if(!label.getText().equals("0"))
        {
            label.setText(label.getText() + "9");
        }
        else
        {
            label.setText("9");
        }
    }
}

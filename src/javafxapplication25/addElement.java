package javafxapplication25;
import javafx.scene.control.CheckBox;            // For Creating Check Boxes
import javafx.scene.control.Spinner;             // For creating spinners
import javafx.scene.control.SpinnerValueFactory; // To set the values of spinners
import javafx.scene.layout.HBox;                 // To crwate HBoxes
public class addElement {                        // Name of Class
    CheckBox chk = new CheckBox();               // Create a check Box
    Spinner spin = new Spinner();                // Create spinner
    HBox hBox = new HBox();                      // Create HBox
    
    public addElement (String name, Boolean isMuffin,int spacing){ // Create a constructor for the class
    chk.setText(name);                                 // Set the check box name with the first paramiter of the constructor
    SpinnerValueFactory spinValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,20,0); // set the first number of the spinner 0 and last number 20 and the default number 0
    spin.setValueFactory(spinValue);                 
    spin.setPrefWidth(70);                            // the width of the spinner
    hBox.getChildren().addAll(chk,spin);              // put the check box and the spinner in a HBox
    hBox.setSpacing(spacing);                              // set the distance between the check box and the spinner to 20 pixels
    if(isMuffin== false)                              // if we create the coffee additions part
    {
        chk.setDisable(true);                         // to disable the additions check boxes by default
        spin.setDisable(true);                        // to disable the additions spinners by default
    }
    else                                              // if we create the muffin part
        spin.setDisable(true);                        // To disable spinners only not the check boxes like in coffee additions part
    chk.setOnAction(chkE ->{                          // Add a listner for the check box
       if (chk.isSelected())                          // if the user selected the check box
       {
               spin.setDisable(false);                // Enable spinner
               spin.getValueFactory().setValue(1);    // Make spinner value = 1
       }
       else{                                          // if the user didn't select the check box
               spin.setDisable(true);                 // disable spinner 
               spin.getValueFactory().setValue(0);    // make spinner value = 0
       }});
    }
    public HBox getHBox(){                            // A method for returning HBox to put it on the main scene
    return hBox;
    }
    public void setEnable(){                          // A method to enable the check box
        chk.setDisable(false);
    }
    public void setDisable(){                         // A method to disable the check box & spinner, unselect it and make the value of spinner =0
        chk.setSelected(false);
        chk.setDisable(true);
        spin.setDisable(true);
        spin.getValueFactory().setValue(0);
    }
    public Boolean isSelected(){                      // A method to know if the check box selected 
        return chk.isSelected();
    }
    public int getValue(){                            // A method to get the value of the spinner if its check box is selected
        if (chk.isSelected())
            return(int)spin.getValue();
        else
            return 0;
    }
}
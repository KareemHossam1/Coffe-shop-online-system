package javafxapplication25;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class JavaProjectCoffeShop extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Elements creation
        // Button
        Button btn = new Button("Calculate");
        btn.autosize();
        //Labels
        Label Welcome = new Label("\n\t\t\t\t    Welcome Our Customer!\n\t\t\t\t\t  Choose your order\n\t\t\t\t\t     Coffee = 3.00$\n\t\t\t\tCoffee Add-Ins = $0.25 a piece\n\t\t\t\t      Muffins = $2.25 a piece");
        Welcome.setStyle("-fx-font-weight: bold");        // to make the font Bold
        Label Muffin = new Label("Muffins");
        // Check boxes ans spinners
        addElement cream = new addElement("Cream",false,105);
        addElement sugar = new addElement("Sugar",false,109);
        addElement art = new addElement("Artificial Sweetener",false,20);
        addElement cinnamon = new addElement("Cinnamon",false,79);
        addElement caramel = new addElement("Caramel",false,92);
        addElement blue = new addElement("Blueberry",true,33);
        addElement chocolate = new addElement("Chocolate",true,30);
        addElement banana = new addElement("Banana Nut",true,20);        
        addElement bran = new addElement("Bran",true,67);
        CheckBox coffee = new CheckBox("Coffee");            // The coffee check box can't be from the class addElement so we should create it in the source code to make an event handler for it
        Spinner coffeeSpinner = new Spinner();
        SpinnerValueFactory spinValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,20,0);
        coffeeSpinner.setValueFactory(spinValue);
        coffeeSpinner.setPrefWidth(70);
        coffeeSpinner.setDisable(true);
        
        // Creatong Scene
        VBox btnV = new VBox();
        btnV.getChildren().add(btn);
        btnV.setPadding(new Insets (0,0,0,200));
        HBox coffeeH = new HBox();
        coffeeH.setSpacing(103);
        coffeeH.getChildren().addAll(coffee,coffeeSpinner);
        VBox coffeeV = new VBox();   
        coffeeV.setSpacing(20);
        coffeeV.getChildren().addAll(coffeeH,cream.getHBox(),sugar.getHBox(),art.getHBox(),cinnamon.getHBox(),caramel.getHBox());
        VBox muffinV = new VBox();      
        muffinV.setSpacing(20);
        muffinV.getChildren().addAll(Muffin,blue.getHBox(),chocolate.getHBox(),banana.getHBox(),bran.getHBox());
        HBox orders = new HBox();
        orders.setSpacing(40);
        orders.getChildren().addAll(coffeeV,muffinV);
        orders.setPadding(new Insets(0,0,0,10));
        VBox main = new VBox();
        main.getChildren().addAll(Welcome,orders,btnV);
        main.setSpacing(20);
        Scene scene = new Scene(main, 500, 500);
        
        // Coffee Event Handler
        coffee.setOnAction(coffeeE ->{
            if (coffee.isSelected())
            { 
               coffeeSpinner.setDisable(false);
               coffeeSpinner.getValueFactory().setValue(1);
               cream.setEnable();
               sugar.setEnable();
               art.setEnable();
               cinnamon.setEnable();
               caramel.setEnable();
            } 
            else{
               coffeeSpinner.setDisable(true);
               coffeeSpinner.getValueFactory().setValue(0);
               cream.setDisable();
               sugar.setDisable();
               art.setDisable();
               cinnamon.setDisable();
               caramel.setDisable();
            }});
        
        // Button Event Handler
        Alert price =new Alert(Alert.AlertType.INFORMATION);
        btn.setOnAction(btnE->{
            Double Total,tax,Price ;
            Total = 3.0 * (int)coffeeSpinner.getValue() + ( cream.getValue() + sugar.getValue()+art.getValue()+cinnamon.getValue()+caramel.getValue())*0.25+(blue.getValue()+banana.getValue()+bran.getValue()+chocolate.getValue())*2.25;
            tax = 0.07*Total;
            Price = Total + tax;
            price.setTitle("PRICE");
            price.setHeaderText("Sub-Total = "+Total+" $\nTax = "+tax+" $\nTotal : "+Price+" $");
            price.setContentText("");
            price.showAndWait();
        });
        
        primaryStage.setResizable(false);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
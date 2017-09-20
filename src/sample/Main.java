package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    //class fields for Click-Counter scene
    int iClickCount = 0;
    Label lblClicks;
    Button btnClickMe;
    Button btnSwitchToScene2;
    Scene scene1;
    Button btnClose;

    //class fields for Add-Subtract scene
    int iCounter = 0;
    Label lblCounter;
    Button btnAdd;
    Button btnSubtract;
    Scene scene2;

    //class field for the stage
    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;

        lblClicks = new Label();
        lblClicks.setText("You have not clicked the button");
        btnClickMe = new Button();
        btnClickMe.setText("Click On Me Please");
        btnClickMe.setOnAction(
                e -> btnClickMe_Click()
        );

        btnSwitchToScene2 = new Button();
        btnSwitchToScene2.setText("Switch!");
        btnSwitchToScene2.setOnAction(
                e -> btnSwitchToScene2_Click()
        );
        
        btnClose = new Button();
        btnClose.setText("Close");
        btnClose.setOnAction(e -> btnClose_Click());
        
        VBox pane1 = new VBox(10);
        pane1.getChildren().addAll(lblClicks, btnClickMe, btnSwitchToScene2, btnClose);
        
        scene1 = new Scene(pane1, 250, 150);
        
        // Build the Add-Subtract Scene
        
        lblCounter = new Label();
        lblCounter.setText(Integer.toString(iCounter));
        
        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(
                e -> btnAdd_Click()
        );
        
        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(
                e -> btnSubtract_Click()
        );

        btnSwitchToScene2 = new Button();
        btnSwitchToScene2.setText("Switch!");
        btnSwitchToScene2.setOnAction(
                e -> btnSwitchToScene1_Click()
        );

        HBox pane2 = new HBox(10);
        pane2.getChildren().addAll(lblCounter, btnAdd, btnSubtract, btnSwitchToScene2);

        scene2 = new Scene(pane2,300, 75);

        //Set the stage with scene 1 and show the stage
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Scene Switcher");
        primaryStage.setOnCloseRequest( event -> {
            event.consume();
            btnClose_Click();
        });
        primaryStage.show();
    }

    private void btnClose_Click() {

        boolean confirm = false;
        confirm = ConfirmationBox.show(
                "Are you sure you want to quit",
                "Confirmation",
                "Yes",
                "No"
        );

        if(confirm){

            stage.close();
        }
    }

    private void btnSwitchToScene1_Click() {
        stage.setScene(scene1);
    }

    private void btnSubtract_Click() {
        iCounter--;
        lblCounter.setText(Integer.toString(iCounter));
    }

    private void btnAdd_Click() {
        iCounter++;
        lblCounter.setText(Integer.toString(iCounter));
    }

    private void btnSwitchToScene2_Click() {
        stage.setScene(scene2);
    }

    private void btnClickMe_Click() {
        iClickCount++;
        if(iClickCount == 1){
            MessageBox.show("You have clicked Once", "Click!");
        }else{
            MessageBox.show("You have clicked "+iClickCount+" times", "Click");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

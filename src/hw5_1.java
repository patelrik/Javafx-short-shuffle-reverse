/*
Rudrik Patel
COP2805 HW - 5_1
03/05/2022
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.util.*;
import static java.util.Collections.reverseOrder;

public class hw5_1 extends Application { 
    //global variables
    protected TextField textField = new TextField();
    protected TextArea textArea = new TextArea();
    protected LinkedList<String> list = new LinkedList<>();
    
    @Override
    public void start(Stage primaryStage) {
        
        // Create three buttons
        Button bsort = new Button("Sort");
        Button bshuffle = new Button("Shuffle");
        Button breverse = new Button("Reverse");

        // Create Hbox for textfield
        HBox ptextfield = new HBox(10);
        ptextfield.setAlignment(Pos.CENTER);
        //assign textfield to hbox
        ptextfield.getChildren().addAll(new Label("Enter a String:"), textField);
        
        //create HBox for buttons
        HBox pbuttons = new HBox(5);
        pbuttons.setAlignment(Pos.CENTER);
        //assign buttons to Hbox
        pbuttons.getChildren().addAll(bsort, bshuffle, breverse);
        
        //set unable for input 
        textArea.setEditable(false);
        
        //create pane and assign HBox with location
        BorderPane pane = new BorderPane();
        pane.setTop(ptextfield);
        pane.setCenter(textArea);
        pane.setBottom(pbuttons);
        
        //title of the programme
        primaryStage.setTitle("HomeWork5_1");
        //create scene with size 
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //textfield event handler
        textField.setOnAction(e -> add()); //call add method
        
        //sortbuttons event handler
        bsort.setOnAction(e -> {
            Collections.sort(list); //sorting 
            displayText();
        });
        //shufflebutton event handler
        bshuffle.setOnAction(e -> {
            Collections.shuffle(list); //shuffle text
            displayText();
        });
        //reverse button event handler 
        breverse.setOnAction(e -> {
            Collections.sort(list, reverseOrder()); //text in reverse order
            displayText();
        });
    }
    public static void main(String[] args){ //main 
        launch(args);
    }
    
    private void add() {
        //extract user input from the textfield and assign to Linkedlist
	String s = textField.getText().toLowerCase();   
        for(String ss: s.split(" ")){
            if(!list.contains(ss))
                list.addLast(ss);
        }
        displayText();
    }

    private void displayText() {
        //display the Linkedlist into the textarea
        String text = " ";
        for(String s: list)
            text += s + " ";
        textArea.setText(text);
    }
}
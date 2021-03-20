


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.Serializable;

public class SavingAccount implements Serializable  {
	

	 SavingAccount(){
        Stage primaryStage=new Stage();
        TextField tfMemberName = new TextField();
        TextField tfAccountBalance = new TextField();
        TextField tfMaxwithLimit = new TextField();
        TextField tfSal = new TextField();
       Button Add=new Button("Click It");
        Label label1 = new Label("Enter Member Name");
        Label label2 = new Label("Enter Account Balance:");
        Label label3= new Label("Enter Max With limit");
      
        Add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                
				Main.bc. SavingsAccount(tfMemberName.getText(),Integer.parseInt(tfAccountBalance.getText()),Integer.parseInt(tfMaxwithLimit.getText()) );
			
            }
        });

        VBox layout = new VBox();
        tfMemberName.setMaxWidth(150);
        tfAccountBalance.setMaxWidth(150);
        tfMaxwithLimit.setMaxWidth(150);
       
        layout.getChildren().addAll(label1,tfMemberName,label2,tfAccountBalance,label3,tfMaxwithLimit);
        Scene SecondScene = new Scene(layout, 500, 250);
        Stage newWindow = new Stage();
        newWindow.setTitle("Enter Saving Account Data");
        newWindow.setScene(SecondScene);
       newWindow.setX(primaryStage.getX() + 350);
       newWindow.setY(primaryStage.getY() + 0);

        newWindow.show();
        
        
        

    }
}

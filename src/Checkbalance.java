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

public class Checkbalance implements Serializable  {
	

	Checkbalance(){
        Stage primaryStage=new Stage();
        TextField tfaccNum = new TextField();
       
     
       Button Add=new Button("Click It");
        Label label1 = new Label(" Enter Account Number:");
      
      
      
        Add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                
				Main.bc. getBalance(tfaccNum.getText() );
			
            }
        });

        VBox layout = new VBox();
        tfaccNum.setMaxWidth(150);
       
      
       
        layout.getChildren().addAll(label1,tfaccNum,Add);
        Scene SecondScene = new Scene(layout, 500, 250);
        Stage newWindow = new Stage();
        newWindow.setTitle("Enter Particular Account Data");
        newWindow.setScene(SecondScene);
       newWindow.setX(primaryStage.getX() + 350);
       newWindow.setY(primaryStage.getY() + 0);

        newWindow.show();
        
        
        

    }
}
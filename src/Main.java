
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    static String fileName="data.txt";

    public static void main(String[] args) {
       Bank bank=readData();
        Bank b=saveData(bank);


        launch(args);
    }
        Button CreateNewAccount;
        Button Deposit;
        Button Withdraw;
        Button Displayparticularaccount;
        Button Displayallaccountinfo;
        Button Checkbalance;
        Button Exit;
        static Bank bc= new Bank();

        @Override
        public void start(Stage primaryStage) {

        	CreateNewAccount= new Button("Create New Account");
        	Deposit = new Button("Deposit");
        	Withdraw = new Button("Withdraw");
        	Displayparticularaccount = new Button ("Display Particular Account Info");
        	Displayallaccountinfo = new Button("Display all account info");
        	Checkbalance = new Button("Check balance");
            Exit = new Button("Exit");
             Bank bc=new Bank();
             CreateNewAccount.setOnAction(new EventHandler<ActionEvent>() {

				@Override
                public void handle(ActionEvent event) {
					
                   new CreateNewAccount();
                 
                    
                }
            });
             Deposit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
               public void handle(ActionEvent actionEvent) {
               new Deposit();
                }
            });
             Withdraw.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                   new Withdraw();
                }
            });
             Displayparticularaccount.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent actionEvent) {
                    new Displayparticularaccount();
                 }
             });
             Displayallaccountinfo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                
                	Main.bc.display();
                }
            });
             Checkbalance.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent actionEvent) {
                   new Checkbalance();
                }
           });
            Exit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    saveData(bank);
                    System.out.println("Successfully Exit");
                    System.exit(0);
                }
            });

            VBox layout = new VBox();CreateNewAccount.setMaxSize(190,190);
            Deposit.setMaxSize(190,190);
            Withdraw.setMaxSize(190,190);
            Displayparticularaccount.setMaxSize(190, 190);
            Displayallaccountinfo.setMaxSize(190,190);
            Checkbalance.setMaxSize(190, 190);
            Exit.setMaxSize(190,190);
            layout.setPadding(new Insets(40, 0, 0, 130));

            layout.getChildren().addAll(CreateNewAccount,Deposit,Withdraw,Displayparticularaccount,Displayallaccountinfo, Checkbalance,Exit);

            Scene scene = new Scene(layout, 500, 250);

            primaryStage.setTitle("Bank Account");
            primaryStage.setScene(scene);
            primaryStage.show();
        
        }


   
	 Bank bank=new Bank();

    private static Bank readData() {
        Bank bank=new Bank();
        try{
            FileInputStream fis=new FileInputStream(fileName);
            ObjectInputStream ois=new ObjectInputStream(fis);
            bank=(Bank) ois.readObject();
           
        }catch (IOException | ClassNotFoundException e){
            System.out.println("No Data Available");
        }
        return bank;
    }
    public static Bank saveData(Bank b) {
        try {


            ObjectOutputStream p = new ObjectOutputStream(new FileOutputStream(fileName));
            p.writeObject(b);
            p.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return b;
        
        
    }

    }
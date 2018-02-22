//TEAM:
//Tamara Saldina 101006791  
//Anastasiia Roldugina 101095885

package javafxapplication1;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.TextArea;

public class JavaFXApplication1 extends Application implements EventHandler<ActionEvent> {
    private  Scene home,addScene,depositScene,withdrawScene,listScene,transferScene;
    Stage window;  
    Button btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,
            btnListMenu,btnAdd,btnHome,btnListHome, btnDeposit,btnWithdraw,
            btnTransfer,btnAddHome,btnDepositHome,btnWithdrawHome;
    TextField custName,custAccNum,custBalance, accNumDeposit, accNumWithdraw,
            depositAmnt, withAmnt,fromAccNum,transferAmnt,toAccNum;
    Bank b;
    TextArea accountList;
    public void init(){
        b = new Bank();
    }
    
    public void start(Stage primaryStage){
        window = primaryStage;
        // setting up Home Scene
        Label lblHomeMenu = new Label("Welcome to Trusty Bank. Please select an option from below");
        btnAddMenu = new Button("Add");btnAddMenu.setOnAction(this);btnAddMenu.setMaxWidth(Double.MAX_VALUE);
        btnDepositMenu = new Button("Deposit");btnDepositMenu.setOnAction(this);btnDepositMenu.setMaxWidth(Double.MAX_VALUE);
        btnWithdrawMenu = new Button("Withdraw");btnWithdrawMenu.setOnAction(this);btnWithdrawMenu.setMaxWidth(Double.MAX_VALUE);
        btnTransferMenu = new Button("Transfer");btnTransferMenu.setOnAction(this);btnTransferMenu.setMaxWidth(Double.MAX_VALUE);
        btnListMenu = new Button("List");btnListMenu.setOnAction(this);btnListMenu.setMaxWidth(Double.MAX_VALUE);
        VBox homeLayout = new VBox();
        homeLayout.setAlignment(Pos.CENTER);
        homeLayout.getChildren().addAll(lblHomeMenu,btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu);
        home = new Scene(homeLayout,500,500);
        
        // setting up Add Scene
        Label lblName =new Label("Name:");
        custName = new TextField();
        Label lblAccNum =new Label("Account#:");
        custAccNum=new TextField();
        Label lblBalance =new Label("Balance:");
        custBalance = new TextField();
        btnAdd = new Button("Add Account");btnAdd.setOnAction(this);
        btnAddHome = new Button("Back");btnAddHome.setOnAction(this);
        VBox addLayout =new VBox();
        addLayout.getChildren().addAll(lblName,custName,lblAccNum,custAccNum,lblBalance,custBalance,btnAdd,btnAddHome);
        addScene = new Scene(addLayout,500,500);
        
        // setting up List Scene
        Label lblShow = new Label("List of accounts...");
        accountList = new TextArea();
        accountList.setPrefRowCount(100);
        btnListHome = new Button("Back");btnListHome.setOnAction(this);btnListHome.setMaxWidth(Double.MAX_VALUE);
        VBox listLayout =new VBox();
        listLayout.getChildren().addAll(lblShow,accountList,btnListHome);
        listScene = new Scene (listLayout,500,500);
         
        // setting up Deposit Scene
        Label lblNum =new Label("Account #:");
        accNumDeposit = new TextField();
        Label lblDepAmnt =new Label("Deposit amount:");
        depositAmnt = new TextField();
        btnDeposit = new Button("Deposit");btnDeposit.setOnAction(this);
        btnDepositHome = new Button("Back");btnDepositHome.setOnAction(this);
        VBox depositLayout =new VBox();
        depositLayout.getChildren().addAll(lblNum,accNumDeposit,lblDepAmnt,depositAmnt,btnDeposit,btnDepositHome);
        depositScene = new Scene(depositLayout,500,500);
        
        // setting up Withdraw Scene
        Label lblWithAccNum =new Label("Account #:");
        accNumWithdraw = new TextField();
        Label lblWithAmnt =new Label("Withdraw amount:");
        withAmnt = new TextField();
        btnWithdraw = new Button("Withdraw");btnWithdraw.setOnAction(this);
        btnWithdrawHome = new Button("Back");btnWithdrawHome.setOnAction(this);
        VBox withdrawLayout =new VBox();
        withdrawLayout.getChildren().addAll(lblWithAccNum,accNumWithdraw,lblWithAmnt,withAmnt,btnWithdraw,btnWithdrawHome);
        withdrawScene = new Scene(withdrawLayout,500,500);
        
        // setting up Transfer Scene
        Label lblTransferFromAccNum =new Label("From Account #:");
        fromAccNum = new TextField();
        Label lblTransferToAccNum =new Label("To account:");
        toAccNum = new TextField();
        Label lbltransferAmount =new Label("Transfer amount:");
        transferAmnt = new TextField();
        btnTransfer = new Button("Transfer");btnTransfer.setOnAction(this);
        btnHome = new Button("Back");btnHome.setOnAction(this);
        VBox transferLayout =new VBox();
        transferLayout.getChildren().addAll(lblTransferFromAccNum,fromAccNum,lblTransferToAccNum,toAccNum,lbltransferAmount,transferAmnt,btnTransfer,btnHome);
        transferScene = new Scene(transferLayout,500,500);
        window.setScene(home);
        window.show();
    }
    
    public void stop(){
        
    }
    
    public void handle(ActionEvent e){
        if (e.getSource()==btnAddMenu){
            System.out.println("add Menu btn pressed (on menu scene)");
            window.setScene(addScene);
        }
        if (e.getSource()==btnAdd){
            System.out.println("add  btn pressed ");
            long accN = Long.valueOf(custAccNum.getText());
            double balance = Double.valueOf(custBalance.getText());
            String own = String.valueOf(custName.getText());
            b.addChequingAccount(accN, balance, own);
            window.setScene(addScene);
        }
        if (e.getSource()==btnDepositMenu){
            System.out.println("deposit menu btn pressed (on menu scene)");
            window.setScene(depositScene);
        }
        if (e.getSource()==btnDeposit){
            System.out.println("deposit btn pressed (on menu scene)");
            long acc = Long.valueOf(accNumDeposit.getText());
            double depAmnt = Double.valueOf(depositAmnt.getText());
            b.depositAccount(acc,depAmnt);
            window.setScene(depositScene);
        }
        if (e.getSource()==btnWithdrawMenu){
            System.out.println("withdraw menu btn pressed (on menu scene)");
            window.setScene(withdrawScene);
        }
        if (e.getSource()==btnWithdraw){ // NOT WORKING!!!!
            System.out.println("withdraw btn pressed (on menu scene)");     
            long acc = Long.valueOf(accNumWithdraw.getText());
            double withdrawAmnt = Double.valueOf(withAmnt.getText());
            b.withdrawAccount(acc,withdrawAmnt);
            System.out.println(b.accountList[b.findAccount(acc)].balance); 
            window.setScene(withdrawScene);
        } 
        if (e.getSource()==btnTransferMenu){
            System.out.println("transfer menu btn pressed (on menu scene)");
            window.setScene(transferScene);
        }
        if (e.getSource()==btnTransfer){ 
            System.out.println("transfer btn pressed (on menu scene)"); // BEING WEIRD
            long from = Long.valueOf(fromAccNum.getText());
            long to = Long.valueOf(toAccNum.getText());
            double trAmount = Double.valueOf(transferAmnt.getText());
            b.transfer(from, to, trAmount);
            window.setScene(transferScene);
        }
        if (e.getSource()==btnListMenu){
            System.out.println("list accounts btn pressed (on menu scene)");
            accountList.setText(b.printAccounts());
            window.setScene(listScene);
        }
        if (e.getSource()==btnHome||e.getSource()==btnListHome 
                || e.getSource()==btnAddHome || e.getSource()==btnDepositHome 
                || e.getSource()==btnWithdrawHome){
            System.out.println("add account btn pressed (on add scene or list scene)");
            window.setScene(home);
        }
    }
    
    public static void main(String[] args) {
      launch(args);
    }
    
}
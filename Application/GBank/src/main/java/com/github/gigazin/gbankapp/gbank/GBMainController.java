package com.github.gigazin.gbankapp.gbank;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidBalanceException;
import exceptions.InvalidInputException;
import gui.utils.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GBMainController {

    private double testBalance;
    private double testSavingsBalance;

    public GBMainController() {
        testBalance = 1000;
        testSavingsBalance = 500;
    }

    public double getTestBalance() {
        return this.testBalance;
    }

    public double getTestSavingsBalance() {
        return this.testSavingsBalance;
    }

    private boolean balanceCheck() {
        if (this.testBalance <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean inputValidation(String input) {
        boolean result = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                result = false;
                break;
            }
        }
        return result;
    }

    private void transfer(double amount) {
        this.testBalance -= amount;
    }

    private void withdraw(double amount) {
        this.testBalance -= amount;
    }

    private void deposit(double amount) {
        this.testBalance += amount;
    }

    private void savingsDeposit(double amount) { this.testSavingsBalance += amount; }

    private void savingsWithdraw(double amount) { this.testSavingsBalance -= amount; }

    /* ========== Button Area ========== */
    @FXML
    private Button logoutButton;

    @FXML
    private Button balanceButton;

    @FXML
    private Button withdrawButton;

    @FXML
    private Button depositButton;

    @FXML
    private Button transferButton;

    @FXML
    private Button gbSavingsWithdrawButton;

    @FXML
    private Button gbSavingsDepositButton;
    /* ========== Button Area ========== */

    /* ========== TextField Area ========== */
    @FXML
    private TextField withdrawAmount;

    @FXML
    private TextField depositAmount;

    @FXML
    private TextField transferAmount;

    @FXML
    private TextField savingsInput;
    /* ========== TextField Area ========== */

    /* ========== ImageView Area ========== */
    @FXML
    private ImageView gbLogo;
    /* ========== ImageView Area ========== */

    /* ========== Label Area ========== */
    @FXML
    private Label gbMainWelcome;

    @FXML
    private Label gbAccTxt;

    @FXML
    private Label gbAcc;

    @FXML
    private Label balanceInfo;

    @FXML
    private Label gbSavings;

    @FXML
    private Label gbSavingsBalanceInfo;

    @FXML
    private Label gbText;
    /* ========== Label Area ========== */

    /* ========== Control Area ========== */
    @FXML
    protected void onLogoutButtonClickAction(ActionEvent event) throws IOException { // Logging out.
        Alerts.showAlert("Logged Out", null, "Deslogado com sucesso!", Alert.AlertType.CONFIRMATION);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GB-Login-View.fxml"));
        Parent root = loader.load();
        GBLoginController gbLoginController = loader.getController();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } // Logging out.

    @FXML
    protected void onBalanceButtonClickAction() { // Clicked on Balance Button.
        balanceInfo.setVisible(true);
        gbSavingsBalanceInfo.setVisible(true);
        balanceInfo.setText("R$" + getTestBalance());
        gbSavingsBalanceInfo.setText("Saldo: R$" + getTestSavingsBalance());
    } // Clicked on Balance Button.

    @FXML
    protected void onWithdrawButtonClickAction() { // Withdraw Button Option.
        String withdrawInput = withdrawAmount.getText();
        double amount = 0;
        if (withdrawInput.equals("")) {
            Alerts.showAlert("Empty Input Error", null, """
                    Insira um valor antes de realizar o saque.
                                        
                    """ + new InvalidInputException("Tried to Enter an Empty Value."), Alert.AlertType.ERROR);
        } else if (!inputValidation(withdrawInput)) {
            Alerts.showAlert("Invalid Input Error", null, """
                    O valor inserido é inválido. Certifique-se de inserir apenas números.
                                        
                    """ + new InvalidInputException("Input Has Invalid Characters."), Alert.AlertType.ERROR);
        }
        if (!balanceCheck()) {
            Alerts.showAlert("Insufficient Balance Error", null, """
                    Seu saldo é insuficiente para esta transação.
                                        
                    """ + new InsufficientBalanceException("Account Balance is Zero or Negative."), Alert.AlertType.ERROR);
        } else {
            if (!withdrawInput.equals("") && inputValidation(withdrawInput)) {
                amount = Double.parseDouble(withdrawInput);
                if (amount <= 0) {
                    Alerts.showAlert("Invalid Value Error", null, """
                            O valor inserido é inválido. Certifique-se de inserir um valor positivo e maior que zero.
                                                
                            """ + new InvalidInputException("Input Has an Invalid Value."), Alert.AlertType.ERROR);
                } else if (amount > getTestBalance()) {
                    Alerts.showAlert("Insufficient Balance Error", null, """
                            A quantia para saque inserida é maior que o seu saldo.
                                                    
                            """ + new InsufficientBalanceException("Withdraw Amount Cannot be Higher Than Account Balance."), Alert.AlertType.ERROR);
                } else {
                    withdraw(amount);
                    Alerts.showAlert("Withdrawal Success", null, "Saque realizado com sucesso!", Alert.AlertType.CONFIRMATION);
                    balanceInfo.setText("R$" + getTestBalance());
                }
            }
        }
    } // Withdraw Button Option.

    @FXML
    protected void onDepositButtonClickAction() { // Deposit Button Option.
        String depositInput = depositAmount.getText();
        double amount = 0;
        if (depositInput.equals("")) {
            Alerts.showAlert("Empty Input Error", null, """
                    Insira um valor antes de realizar o depósito.
                                        
                    """ + new InvalidInputException("Tried to Enter an Empty Value."), Alert.AlertType.ERROR);
        } else if (!inputValidation(depositInput)) {
            Alerts.showAlert("Invalid Input Error", null, """
                    O valor inserido é inválido. Certifique-se de inserir apenas números.
                                        
                    """ + new InvalidInputException("Input Has Invalid Characters."), Alert.AlertType.ERROR);
        }
        if (!depositInput.equals("") && inputValidation(depositInput)) {
            amount = Double.parseDouble(depositInput);
            if (amount <= 0) {
                Alerts.showAlert("Invalid Value Error", null, """
                        O valor inserido é inválido. Certifique-se de inserir um valor positivo e maior que zero.
                                            
                        """ + new InvalidInputException("Input Has an Invalid Value."), Alert.AlertType.ERROR);
            } else {
                deposit(amount);
                Alerts.showAlert("Deposit Success", null, "Depósito realizado com sucesso!", Alert.AlertType.CONFIRMATION);
                balanceInfo.setText("R$" + getTestBalance());
            }
        }
    } // Deposit Button Option.

    @FXML
    protected void onTransferButtonClickAction() { // Transfer Button Option.
        String transferInput = transferAmount.getText();
        double amount = 0;
        if (transferInput.equals("")) {
            Alerts.showAlert("Empty Input Error", null, """
                    Insira um valor antes de realizar a transferência.
                                        
                    """ + new InvalidInputException("Tried to Enter an Empty Value."), Alert.AlertType.ERROR);
        } else if (!inputValidation(transferInput)) {
            Alerts.showAlert("Invalid Input Error", null, """
                    O valor inserido é inválido. Certifique-se de inserir apenas números.
                                        
                    """ + new InvalidInputException("Input Has Invalid Characters."), Alert.AlertType.ERROR);
        }
        if (!balanceCheck()) {
            Alerts.showAlert("ERROR 404 Saldo Not Found (yes, it's a meme)", null, """
                    Seu saldo é insuficiente para esta transação.
                                        
                    """ + new InsufficientBalanceException("Account Balance is Zero or Negative."), Alert.AlertType.ERROR);
        } else {
            if (!transferInput.equals("") && inputValidation(transferInput)) {
                amount = Double.parseDouble(transferInput);
                if (amount <= 0) {
                    Alerts.showAlert("Invalid Value Error", null, """
                            O valor inserido é inválido. Certifique-se de inserir um valor positivo e maior que zero.
                                                
                            """ + new InvalidInputException("Input Has an Invalid Value."), Alert.AlertType.ERROR);
                } else if (amount > getTestBalance()) {
                    Alerts.showAlert("Insufficient Balance Error", null, """
                            A quantia para transferência inserida é maior que o seu saldo.
                                                    
                            """ + new InsufficientBalanceException("Transfer Amount Cannot be Higher Than Account Balance."), Alert.AlertType.ERROR);
                } else {
                    transfer(amount);
                    Alerts.showAlert("Transfer Success", null, "Trasferência realizada com sucesso!", Alert.AlertType.CONFIRMATION);
                    balanceInfo.setText("R$" + getTestBalance());
                }
            }
        }
    } // Transfer Button Option.

    @FXML
    protected void onSavingsDepositButtonClickAction() { // Savings Deposit Button Option.
        String savingsDepositInput = savingsInput.getText();
        double amount = 0;
        if (savingsDepositInput.equals("")) {
            Alerts.showAlert("Empty Input Error", null, """
                    Insira um valor antes de realizar o depósito.
                                        
                    """ + new InvalidInputException("Tried to Enter an Empty Value."), Alert.AlertType.ERROR);
        } else if (!inputValidation(savingsDepositInput)) {
            Alerts.showAlert("Invalid Input Error", null, """
                    O valor inserido é inválido. Certifique-se de inserir apenas números.
                                        
                    """ + new InvalidInputException("Input Has Invalid Characters."), Alert.AlertType.ERROR);
        }
        if (!savingsDepositInput.equals("") && inputValidation(savingsDepositInput)) {
            amount = Double.parseDouble(savingsDepositInput);
            if (amount <= 0) {
                Alerts.showAlert("Invalid Value Error", null, """
                        O valor inserido é inválido. Certifique-se de inserir um valor positivo e maior que zero.
                                            
                        """ + new InvalidInputException("Input Has an Invalid Value."), Alert.AlertType.ERROR);
            } else {
                savingsDeposit(amount);
                Alerts.showAlert("Deposit Success", null, "Depósito realizado com sucesso!", Alert.AlertType.CONFIRMATION);
                gbSavingsBalanceInfo.setText("Saldo: R$" + getTestSavingsBalance());
            }
        }
    } // Savings Deposit Button Option.

    @FXML
    protected void onSavingsWithdrawButtonClickAction() { // Savings Withdraw Button Option.
        String savingsDepositInput = savingsInput.getText();
        double amount = 0;
        if (savingsDepositInput.equals("")) {
            Alerts.showAlert("Empty Input Error", null, """
                    Insira um valor antes de realizar o saque.
                                        
                    """ + new InvalidInputException("Tried to Enter an Empty Value."), Alert.AlertType.ERROR);
        } else if (!inputValidation(savingsDepositInput)) {
            Alerts.showAlert("Invalid Input Error", null, """
                    O valor inserido é inválido. Certifique-se de inserir apenas números.
                                        
                    """ + new InvalidInputException("Input Has Invalid Characters."), Alert.AlertType.ERROR);
        }
        if (!balanceCheck()) {
            Alerts.showAlert("Insufficient Balance Error", null, """
                    Seu saldo é insuficiente para esta transação.
                                        
                    """ + new InsufficientBalanceException("Account Balance is Zero or Negative."), Alert.AlertType.ERROR);
        } else {
            if (!savingsDepositInput.equals("") && inputValidation(savingsDepositInput)) {
                amount = Double.parseDouble(savingsDepositInput);
                if (amount <= 0) {
                    Alerts.showAlert("Invalid Value Error", null, """
                            O valor inserido é inválido. Certifique-se de inserir um valor positivo e maior que zero.
                                                
                            """ + new InvalidInputException("Input Has an Invalid Value."), Alert.AlertType.ERROR);
                } else if (amount > getTestSavingsBalance()) {
                    Alerts.showAlert("Insufficient Balance Error", null, """
                            A quantia para saque inserida é maior que o seu saldo.
                                                    
                            """ + new InsufficientBalanceException("Withdraw Amount Cannot be Higher Than Account Balance."), Alert.AlertType.ERROR);
                } else {
                    savingsWithdraw(amount);
                    Alerts.showAlert("Withdrawal Success", null, "Saque realizado com sucesso!", Alert.AlertType.CONFIRMATION);
                    gbSavingsBalanceInfo.setText("Saldo: R$" + getTestSavingsBalance());
                }
            }
        }
    } // Savings Withdraw Button Option.
    /* ========== Control Area ========== */

    /* ========== Misc Area ========== */
    public void initialize(URL url, ResourceBundle rb) { // Showing GBank logo at the Main screen.
        Image gb = new Image(getClass().getResourceAsStream("com/github/gigazin/gbankapp/gbank/GBLogo.png"));
        gbLogo.setImage(gb);
    } // Showing GBank logo at the Main screen.
    /* ========== Misc Area ========== */
}

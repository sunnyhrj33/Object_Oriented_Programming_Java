package com.example.order;

import OnlineFoodOrdering.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.DoubleStringConverter;

import java.io.*;
import java.lang.reflect.Method;

import static OnlineFoodOrdering.Methods.customerArrayList;


public class HelloApplication extends Application {
    static File data = new File("loginData.txt");
    static File menuData = new File("menuData.txt");
    Stage window;
    Scene mainPageScene, loginPageScene, registerPageScene, adminPageScene, menuPageScene, adminMenuPageScene,
            addMenuPageScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        //Main Page Scene
        Button loginButton = new Button("Login As An Existing Customer");
        Button registerButton = new Button("Register As A New Customer");
        Button adminButton = new Button("Login As An Administrator");
        Button exitButton = new Button("Exit");
        loginButton.setOnAction(e ->
        {
            window.setScene(loginPageScene);
        });
        registerButton.setOnAction(e -> {
            window.setScene(registerPageScene);
        });
        adminButton.setOnAction(e -> {
            window.setScene(adminPageScene);
        });
        exitButton.setOnAction(e -> {
            Platform.exit();
        });
        loginButton.setMinWidth(200);
        registerButton.setMaxWidth(200);
        adminButton.setMinWidth(200);
        exitButton.setMinWidth(200);
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(loginButton, registerButton, adminButton, exitButton);
        mainPageScene = new Scene(vbox, 480, 360);
        //Login Page Scene
        GridPane loginPage = new GridPane();
        loginPage.setPadding(new Insets(20, 20, 20, 20));
        loginPage.setVgap(10);
        loginPage.setHgap(10);
        loginPage.setAlignment(Pos.CENTER);
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton1 = new Button("Login");
        loginPage.add(usernameLabel, 0, 0);
        loginPage.add(usernameField, 1, 0);
        loginPage.add(passwordLabel, 0, 1);
        loginPage.add(passwordField, 1, 1);
        loginPage.add(loginButton1, 1, 2);
        Button home = new Button("Go To Home");
        HBox homeBox = new HBox(10);
        homeBox.getChildren().add(home);
        homeBox.setAlignment(Pos.TOP_LEFT);
        home.setOnAction(e -> {
            window.setScene(mainPageScene);
        });
        loginButton1.setOnAction(e -> {
            boolean loginStatus = validateUser(data, usernameField.getText(), passwordField.getText());
            System.out.println(loginStatus ? "authenticated" : "invalid username");
            if (loginStatus==true) {
                showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome " + usernameField.getText() + "!");
                window.setScene(menuPageScene);
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password. Please try again.");
            }
        });
        VBox login = new VBox();
        login.setPadding(new Insets(20, 20, 20, 20));
        login.setSpacing(10);
        login.getChildren().addAll(homeBox, loginPage);
        loginPageScene = new Scene(login, 480, 360);
        //Register Page Scene
        GridPane registerPage = new GridPane();
        registerPage.setPadding(new Insets(20, 20, 20, 20));
        registerPage.setVgap(10);
        registerPage.setHgap(10);
        registerPage.setAlignment(Pos.CENTER);
        Label enterDetailsLabel = new Label("Enter Your Details");
        Label enterUsernameLabel = new Label("Enter Username:");
        TextField enterUsernameField = new TextField();
        Label enterPasswordLabel = new Label("Enter Password:");
        PasswordField enterPasswordField = new PasswordField();
        Label enterEmailLabel = new Label("Enter Email:");
        TextField enterEmailField = new TextField();
        Label enterAddressLabel = new Label("Enter Address:");
        TextField enterAddressField = new TextField();
        Button registerButton1 = new Button("Register");
        registerPage.add(enterDetailsLabel, 0, 0);
        registerPage.add(enterUsernameLabel, 0, 1);
        registerPage.add(enterUsernameField, 1, 1);
        registerPage.add(enterPasswordLabel, 0, 2);
        registerPage.add(enterPasswordField, 1, 2);
        registerPage.add(enterEmailLabel, 0, 3);
        registerPage.add(enterEmailField, 1, 3);
        registerPage.add(enterAddressLabel, 0, 4);
        registerPage.add(enterAddressField, 1, 4);
        registerPage.add(registerButton1, 1, 5);
        Button home1 = new Button("Go To Home");
        HBox homeBox1 = new HBox(10);
        homeBox1.getChildren().add(home1);
        homeBox1.setAlignment(Pos.TOP_LEFT);
        home1.setOnAction(e -> {
            window.setScene(mainPageScene);
        });
        registerButton1.setOnAction(e -> {
            if (!validateUser(data, enterUsernameField.getText(), enterPasswordField.getText())) {
                if (!enterUsernameField.getText().contains(" ") && enterPasswordField.getText().length() >= 6
                        && !enterEmailField.getText().contains(" ") && !enterAddressField.getText().contains(" "))
                {
                    writeData(data, enterUsernameField.getText() + "\t" + enterPasswordField.getText() + "\t"
                            + enterEmailField.getText() + "\t" + enterAddressField.getText());
                    showAlert(Alert.AlertType.INFORMATION, "Registration Successful", "Welcome " + enterUsernameField.getText() +
                            "!\nYou Have Been Registered As A New User");
                    enterPasswordField.setText("");
                    enterEmailField.setText("");
                    enterAddressField.setText("");
                    enterUsernameField.setText("");
                } else
                    {System.out.println("Your Information Is Incomplete!!!");
                    showAlert(Alert.AlertType.WARNING, "Incomplete Information", "Your Information Is Incomplete");}
            } else {System.out.println("User Is Present");
                    showAlert(Alert.AlertType.INFORMATION, "User Already Exists", "The User You Are Trying To Register Already Exists");}
        });
        VBox register = new VBox();
        register.setPadding(new Insets(20, 20, 20, 20));
        register.setSpacing(10);
        register.getChildren().addAll(homeBox1, registerPage);
        registerPageScene = new Scene(register, 480, 360);
        //Admin Page Scene
        GridPane adminPage = new GridPane();
        adminPage.setPadding(new Insets(20, 20, 20, 20));
        adminPage.setVgap(10);
        adminPage.setHgap(10);
        adminPage.setAlignment(Pos.CENTER);
        Label adminNameLabel = new Label("Admin Username:");
        TextField adminNameField = new TextField();
        Label adminPasswordLabel = new Label("Admin Password:");
        PasswordField adminPasswordField = new PasswordField();
        Button adminLoginButton = new Button("Login As An Admin");
        adminPage.add(adminNameLabel, 0, 0);
        adminPage.add(adminNameField, 1, 0);
        adminPage.add(adminPasswordLabel, 0, 1);
        adminPage.add(adminPasswordField, 1, 1);
        adminPage.add(adminLoginButton, 1, 2);
        Button home2 = new Button("Go To Home");
        HBox homeBox2 = new HBox(10);
        homeBox2.getChildren().add(home2);
        homeBox2.setAlignment(Pos.TOP_LEFT);
        home2.setOnAction(e -> {
            window.setScene(mainPageScene);
        });
        adminLoginButton.setOnAction(e -> {
            boolean adminStatus = Methods.ifAdminPresent(adminNameField.getText(), adminPasswordField.getText());
            System.out.println(adminStatus ? "Approved" : "UnApproved");
            if (adminStatus == true){
                window.setScene(adminMenuPageScene);
            }
        });
        VBox admin = new VBox();
        admin.setPadding(new Insets(20, 20, 20, 20));
        admin.setSpacing(10);
        admin.getChildren().addAll(homeBox2, adminPage);
        adminPageScene = new Scene(admin, 480, 360);
        //Menu Selection Page
        GridPane menuPage = new GridPane();
        menuPage.setPadding(new Insets(20, 20, 20, 20));
        menuPage.setVgap(10);
        menuPage.setHgap(10);
        menuPage.setAlignment(Pos.CENTER);
        Label orderNow = new Label("Select An Option Please");
        orderNow.setMinWidth(200);
        Button selectFromStarters = new Button("Select Food From Starters");
        Button selectFromMainCourse = new Button("Select Food From Main-Course");
        Button selectFromDeserts = new Button("Select Food From Deserts");
        Button selectFromWhole = new Button("Select Food From Whole Menu");
        Button home3 = new Button("Go To Home");
        menuPage.add(orderNow,0,0);
        menuPage.add(selectFromStarters,0,1);
        menuPage.add(selectFromMainCourse,0,2);
        menuPage.add(selectFromDeserts,0,3);
        menuPage.add(selectFromWhole,0,4);
        menuPage.add(home3,0,5);
        selectFromStarters.setOnAction(e ->
        {
            window.setScene(loginPageScene);
        });
        selectFromMainCourse.setOnAction(e -> {
            window.setScene(registerPageScene);
        });
        selectFromDeserts.setOnAction(e -> {
            window.setScene(adminPageScene);
        });
        selectFromWhole.setOnAction(e -> {
            Platform.exit();
        });
        selectFromStarters.setMinWidth(200);
        selectFromDeserts.setMinWidth(200);
        HBox homeBox3 = new HBox(10);
        homeBox3.getChildren().add(home3);
        homeBox3.setAlignment(Pos.TOP_LEFT);
        home3.setOnAction(e -> {
            window.setScene(mainPageScene);
        });
        VBox menu = new VBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        menu.getChildren().addAll(homeBox3, menuPage);
        menuPageScene = new Scene(menu, 480, 360);
        //Admin Menu Selection
        GridPane adminMenuPage = new GridPane();
        adminMenuPage.setPadding(new Insets(20, 20, 20, 20));
        adminMenuPage.setVgap(10);
        adminMenuPage.setHgap(10);
        adminMenuPage.setAlignment(Pos.CENTER);
        Label adminMenuSelection = new Label("Select An Option Please");
        adminMenuSelection.setMinWidth(200);
        Button addMenu = new Button("Add Item To The Menu");
        Button removeMenu = new Button("Remove Item From The Menu");
        Button home4 = new Button("Go To Home");
        adminMenuPage.add(orderNow,0,0);
        adminMenuPage.add(addMenu,0,1);
        adminMenuPage.add(removeMenu,0,2);
        adminMenuPage.add(home4,0,5);
        addMenu.setOnAction(e ->
        {
            window.setScene(addMenuPageScene);
        });
        selectFromMainCourse.setOnAction(e -> {
            window.setScene(registerPageScene);
        });
        selectFromDeserts.setOnAction(e -> {
            window.setScene(adminPageScene);
        });
        selectFromWhole.setOnAction(e -> {
            Platform.exit();
        });
        addMenu.setMinWidth(200);
        removeMenu.setMaxWidth(200);
        HBox homeBox4 = new HBox(10);
        homeBox4.getChildren().add(home4);
        homeBox4.setAlignment(Pos.TOP_LEFT);
        home4.setOnAction(e -> {
            window.setScene(mainPageScene);
        });
        VBox adminMenu = new VBox();
        adminMenu.setPadding(new Insets(20, 20, 20, 20));
        adminMenu.setSpacing(10);
        adminMenu.getChildren().addAll(homeBox3, adminMenuPage);
        adminMenuPageScene = new Scene(adminMenu, 480, 360);
        //Add Menu Page Scene
        GridPane addMenuPage = new GridPane();
        addMenuPage.setPadding(new Insets(20, 20, 20, 20));
        addMenuPage.setVgap(10);
        addMenuPage.setHgap(10);
        addMenuPage.setAlignment(Pos.CENTER);
        Label enterItemDetailsLabel = new Label("Enter Item Details");
        Label enterItemNameLabel = new Label("Enter Item Name:");
        TextField enterItemNameField = new TextField();
        Label enterItemPriceLabel = new Label("Enter Password:");
        TextField enterItemPriceField = new TextField();
        //TextField doubleTextField = new TextField();
        // Create a TextFormatter with a DoubleStringConverter to restrict input to double values
        TextFormatter<Double> textFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0);
        enterItemPriceField.setTextFormatter(textFormatter);
        Label enterItemDescriptionLabel = new Label("Enter Item Description:");
        TextField enterItemDescriptionField = new TextField();
        Label enterItemCategory = new Label("Choose Item Category:");
        ComboBox<FoodItemType> foodItemTypeComboBox = new ComboBox<>(FXCollections.observableArrayList(FoodItemType.values()));
        foodItemTypeComboBox.setValue(FoodItemType.MAINCOURSE);
        Button addItem = new Button("Add Item To The Menu");
        addMenuPage.add(enterItemDetailsLabel, 0, 0);
        addMenuPage.add(enterItemNameLabel, 0, 1);
        addMenuPage.add(enterItemNameField, 1, 1);
        addMenuPage.add(enterItemPriceLabel, 0, 2);
        addMenuPage.add(enterItemPriceField, 1, 2);
        addMenuPage.add(enterItemDescriptionLabel, 0, 3);
        addMenuPage.add(enterItemDescriptionField, 1, 3);
        addMenuPage.add(enterItemCategory, 0, 4);
        addMenuPage.add(foodItemTypeComboBox, 1, 4);
        addMenuPage.add(addItem,0,5);
        Button home5 = new Button("Go To Home");
        HBox homeBox5 = new HBox(10);
        homeBox5.getChildren().add(home5);
        homeBox5.setAlignment(Pos.TOP_LEFT);
        home5.setOnAction(e -> {
            window.setScene(mainPageScene);
        });
        addItem.setOnAction(e -> {
            if (!enterItemNameField.getText().contains(" ") && !enterItemPriceField.getText().contains(" "))
                {
                    writeData(menuData, enterItemNameField.getText() + "\t" + enterItemPriceField.getText() + "\t"
                            + enterItemDescriptionField.getText()+"\t"+ foodItemTypeComboBox.getValue());

                    showAlert(Alert.AlertType.INFORMATION, "Menu Updated", enterItemNameField.getText()+"Has Been Added To The Menu");
                    enterItemNameField.setText("");
                    enterItemPriceField.setText("");
                    enterItemDescriptionField.setText("");
                } else
                {System.out.println("Your Information Is Incomplete!!!");
                    showAlert(Alert.AlertType.WARNING, "Incomplete Information", "Your Information Is Incomplete");}
            });
        VBox addMenuItem = new VBox();
        addMenuItem.setPadding(new Insets(20, 20, 20, 20));
        addMenuItem.setSpacing(10);
        addMenuItem.getChildren().addAll(homeBox5, addMenuPage);
        addMenuPageScene = new Scene(addMenuItem, 480, 360);



        //Primary Stage
        primaryStage.setTitle("Food-Hub");
        primaryStage.setScene(mainPageScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public static void writeData(File file, String text) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.newLine();
            bw.close();
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean validateUser(File file, String userName, String password) {
        boolean validated = false;

        try (FileReader fr = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fr)) {

            String temp;
            String[][] userDataArray = new String[10][]; // Assuming a maximum of 10 users
            int userIndex = 0;

            while ((temp = bufferedReader.readLine()) != null) {
                userDataArray[userIndex++] = temp.split("\t");
            }

            for (int i = 0; i < userIndex; i++) {
                if (userDataArray[i] != null && userDataArray[i].length >= 2) {
                    String storedUserName = userDataArray[i][0];
                    String storedPassword = userDataArray[i][1];

                    if (storedUserName.equals(userName) && storedPassword.equals(password)) {
                        validated = true;
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return validated;
    }
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }




}

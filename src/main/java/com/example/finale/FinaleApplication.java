/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2023A
  Assessment: Test 3
  Author: Dang Thanh Danh
  ID: 3979933
  Created  date: 29/05/23
  Acknowledgement: https://stackoverflow.com/questions/58854768/loading-and-editing-a-csv-file-in-java-into-a-list
*/


package com.example.finale;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FinaleApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // basic layout of the program
        Pane pane = new Pane();

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        HBox hbox = new HBox();
        hbox.setSpacing(20);
        hbox.setPadding(new Insets(20));

        VBox infoSide = new VBox();
        infoSide.setSpacing(20);
        VBox buttonSide = new VBox();


        // header text
        Text header = new Text("GENIE'S VIDEO STORE");
        header.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 60));
        header.setStroke(Color.BLUE); header.setStrokeWidth(1);
        header.setFill(Color.RED);


        // button list
        Button btItemList = new Button("Display Inventory");
        Button btCustomerList = new Button("Display Customer");
        Button btItemUpdate = new Button("Update Inventory");
        Button btCustomerUpdate = new Button("Update Customer");
        Button btItemClear = new Button("Clear Inventory");
        Button btCustomerClear = new Button("Clear Customer");
        buttonSide.setAlignment(Pos.BASELINE_RIGHT);
        Text info = new Text();
        buttonSide.getChildren().addAll(btItemList, btCustomerList, btItemUpdate, btCustomerUpdate, btItemClear, btCustomerClear, info);

        // button function
        btItemList.setOnAction((ActionEvent e) -> {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("C:\\Users\\micro\\IdeaProjects\\Finale\\src\\main\\java\\com\\example\\finale\\items.txt");
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = "";
            int lines = 0;
            // if there is info already on display, clear it before showing
            infoSide.getChildren().clear();
            while(true){
                try {
                    if (!((line=bufferedReader.readLine())!=null)) break;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                lines++;
                String [] columns = line.split(",");
                if(lines ==1 ) {
                    continue;
                }
                else {
                    // information pane for items
                    GridPane itemInfo = new GridPane();
                    itemInfo.setHgap(20.0);
                    Text itemID = new Text("ID: ");
                    Text itemTitle = new Text("Title: ");
                    Text itemRType = new Text("Rental Type: ");
                    Text itemLType = new Text("Loan Type: ");
                    Text itemCopies = new Text("Copies: ");
                    Text itemFee = new Text("Rental Fee: ");
                    Text itemStatus = new Text("Rental Status: ");
                    Text itemGenre = new Text("Genre: ");

                    TextField id = new TextField(columns[0]);
                    TextField title = new TextField(columns[1]);
                    TextField rType = new TextField(columns[2]);
                    TextField lType = new TextField(columns[3]);
                    TextField copies = new TextField(columns[4]);
                    TextField fee = new TextField(columns[5]);
                    TextField status = new TextField("");
                    TextField genre = new TextField(columns[6]);

                    itemInfo.add(itemID, 1, 1);
                    itemInfo.add(itemTitle, 3, 1);
                    itemInfo.add(itemRType, 1, 2);
                    itemInfo.add(itemLType, 3, 2);
                    itemInfo.add(itemCopies, 1, 3);
                    itemInfo.add(itemFee, 3, 3);
                    itemInfo.add(itemStatus, 1, 4);
                    itemInfo.add(itemGenre, 3, 4);

                    itemInfo.add(id, 2, 1);
                    itemInfo.add(title, 4, 1);
                    itemInfo.add(rType, 2, 2);
                    itemInfo.add(lType, 4, 2);
                    itemInfo.add(copies, 2, 3);
                    itemInfo.add(fee, 4, 3);
                    itemInfo.add(status, 2, 4);
                    itemInfo.add(genre, 4, 4);

                    Line itemLine = new Line(10.0, 0.0, 850.0, 0.0);

                    infoSide.getChildren().addAll(itemInfo,itemLine);
                }
            }
        });

        btCustomerList.setOnAction((ActionEvent e) -> {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("C:\\Users\\micro\\IdeaProjects\\Finale\\src\\main\\resources\\customers.txt");
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = "";
            int lines = 0;
            // if there is info already on display, clear it before showing
            infoSide.getChildren().clear();
            while(true){
                try {
                    if (!((line=bufferedReader.readLine())!=null)) break;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                lines++;
                String [] columns = line.split(",");
                if(lines ==1 ) {
                    continue;
                }
                else {
                    // information pane for customers
                    GridPane customerInfo = new GridPane();
                    customerInfo.setHgap(20);
                    Text customerID = new Text("Customer ID: ");
                    Text customerName = new Text("Name: ");
                    Text customerAddress = new Text("Address: ");
                    Text customerPhone = new Text("Phone: ");
                    Text customerRL = new Text("Rent List: ");
                    Text customerTier = new Text("Tier: ");

                    TextField cusId = new TextField(columns[0]);
                    TextField cusName = new TextField(columns[1]);
                    TextField cusAddress = new TextField(columns[2]);
                    TextField cusPhone = new TextField(columns[3]);
                    TextField cusRL = new TextField(columns[4]);
                    TextField cusTier = new TextField(columns[5]);

                    customerInfo.add(customerID, 1, 1);
                    customerInfo.add(customerName, 3, 1);
                    customerInfo.add(customerAddress, 1, 2);
                    customerInfo.add(customerPhone, 3, 2);
                    customerInfo.add(customerRL, 1, 3);
                    customerInfo.add(customerTier, 3, 3);

                    customerInfo.add(cusId, 2, 1);
                    customerInfo.add(cusName, 4, 1);
                    customerInfo.add(cusAddress, 2, 2);
                    customerInfo.add(cusPhone, 4, 2);
                    customerInfo.add(cusRL, 2, 3);
                    customerInfo.add(cusTier, 4, 3);

                    Line cusLine = new Line(10.0, 0.0, 850.0, 0.0);

                    infoSide.getChildren().addAll(customerInfo, cusLine);
                }
            }
        });

        btItemUpdate.setOnAction((ActionEvent e) -> {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("C:\\Users\\micro\\IdeaProjects\\Finale\\src\\main\\java\\com\\example\\finale\\items.txt");
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = "";
            int lines = 0;
            // if there is info already on display, clear it before showing
            while(true){
                try {
                    if (!((line=bufferedReader.readLine())!=null)) break;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                lines++;
                String [] columns = line.split(",");
                if(lines ==1 ) {
                    continue;
                }
                else {
                    Node itemPane = infoSide.getChildren().get(0);

                    //columns[0] = itemPane.id;

                    info.setText("Update Successfully");
                }
            }
        });

        btCustomerUpdate.setOnAction((ActionEvent e) -> {

        });

        btItemClear.setOnAction((ActionEvent e) -> {

        });

        btCustomerClear.setOnAction((ActionEvent e) -> {

        });







        // add all pane together
        hbox.getChildren().addAll(infoSide, buttonSide);
        vbox.getChildren().addAll(header, hbox);
        pane.getChildren().addAll(vbox);
        Scene scene = new Scene(pane, 1280, 720);
        stage.setTitle("INTE2512 OOP Group No.21");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
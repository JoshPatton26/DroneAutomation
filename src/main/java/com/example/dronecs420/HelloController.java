package com.example.dronecs420;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.image.ImageView;

import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private TreeView treeView;

    @FXML
    private Label welcomeText;

    @FXML
    private ImageView ImageView;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    void itemChangeDClick(ActionEvent event) {

    }

    @FXML
    void itemChangeLClick(ActionEvent event) {

    }

    @FXML
    void itemChangePClick(ActionEvent event) {

    }

    @FXML
    void itemDeleteClick(ActionEvent event) {
        
    }

    @FXML
    void itemRenameClick(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        TreeItem<String> rootItem = new TreeItem<>("Root");

        //Branch_Items
        TreeItem<String> Command_Center = new TreeItem<>("Command Center");
        TreeItem<String> Barn_Branch = new TreeItem<>("Barn");
        TreeItem<String> StorageBuilder_Branch = new TreeItem<>("Storage Builder");
        TreeItem<String> CropField_Branch = new TreeItem<>("Crop Field");

        //Leaf Items
        TreeItem<String> CommandCenter_LeafItem1 = new TreeItem<>("Drone");
        TreeItem<String> Barn_LeafItem1 = new TreeItem<>("Milk Storage");
        TreeItem<String> StorageBuilder_LeafItem1 = new TreeItem<>("Tractor");
        TreeItem<String> CropField_LeftItem1 = new TreeItem<>("Soy Crop");

        //Adding all the Branches & Leaves in the TreeView
        //Add all the Leaves
        Command_Center.getChildren().addAll(CommandCenter_LeafItem1);
        Barn_Branch.getChildren().addAll(Barn_LeafItem1);
        StorageBuilder_Branch.getChildren().addAll(StorageBuilder_LeafItem1);
        CropField_Branch.getChildren().addAll(CropField_LeftItem1);

        //Add all the Branches
        rootItem.getChildren().addAll(Command_Center, Barn_Branch, StorageBuilder_Branch, CropField_Branch);

        treeView.setRoot(rootItem);
    }

    //Printing out the Item Values when selecting each specific Item or Item Container
    public void selectItem(){
        TreeItem<String> item = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();

        if(item != null){
            System.out.println(item.getValue());
        }
    }
}
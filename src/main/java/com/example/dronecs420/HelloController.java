package com.example.dronecs420;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.net.URL;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;


import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private TreeView treeView;

    @FXML
    public AnchorPane Farm;

    @FXML
    private Label welcomeText;

    @FXML
    private ImageView ImageView;

    @FXML
    private VBox itemCmds;

    @FXML
    private VBox itemContCmds;

    private String name;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    void itemChangeDClick(ActionEvent event) {
        // Create dialog box.
        Dialog<Double> changeLoc = new Dialog<>();
        changeLoc.setTitle("Dimensions");
        changeLoc.setHeaderText("Enter the new dimensions: ");
        changeLoc.setResizable(true);
        //changeLoc.setWidth(1000.0);

        // Add the attributes of the dialog box.
        Label label1 = new Label("Width: ");
        Label label2 = new Label("Height: ");
        TextField width = new TextField();
        TextField height = new TextField();

        // Add the layout, and add the attributes to layout.
        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(width, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(height, 2, 2);
        changeLoc.getDialogPane().setContent(grid);

        // Add button to close dialog box after user enters values.
        ButtonType okButton = new ButtonType("Okay", ButtonData.OK_DONE);
        changeLoc.getDialogPane().getButtonTypes().add(okButton);

        Optional<Double> result = changeLoc.showAndWait();
        if(result.isPresent()){
            System.out.println(width.getText() + " " + height.getText());
        }
        //Drawing the Reactangle
        Rectangle rectangle = new Rectangle();


        //Assigning a new variable to change the txt field to double
        double user_width = Double.parseDouble(width.getText());
        double user_height = Double.parseDouble(height.getText());

        //Setting up the new rectangle
        rectangle.setX(150.0f);
        rectangle.setY(75.0f);
        rectangle.setWidth(user_width);
        rectangle.setHeight(user_height);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        //Adding the rectangle to the Panel
        Farm.getChildren().add(rectangle);

    }

    @FXML
    void itemChangeLClick(ActionEvent event) {
        // Create dialog box.
        Dialog<Double> changeDim = new Dialog<>();
        changeDim.setTitle("Location");
        changeDim.setHeaderText("Enter the new location: ");
        changeDim.setResizable(true);

        // Add the attributes of the dialog box.
        Label label1 = new Label("Change x: ");
        Label label2 = new Label("Change y: ");
        TextField xvalue = new TextField();
        TextField yvalue = new TextField();

        // Add the layout, and add the attributes to layout.
        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(xvalue, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(yvalue, 2, 2);
        changeDim.getDialogPane().setContent(grid);

        // Add button to close dialog box after user enters values.
        ButtonType okButton = new ButtonType("Okay", ButtonData.OK_DONE);
        changeDim.getDialogPane().getButtonTypes().add(okButton);

        Optional<Double> result = changeDim.showAndWait();
        if(result.isPresent()){
            System.out.println(xvalue.getText() + " " + yvalue.getText());
        }

        //Drawing the Rectangle
        Rectangle rectangle = new Rectangle();

        //Assigning a new variable to change the txt field to double
        double user_xvalue = Double.parseDouble(xvalue.getText());
        double user_yvalue = Double.parseDouble(yvalue.getText());

        //Setting up the new rectangle
        rectangle.setX(user_xvalue);
        rectangle.setY(user_yvalue);
        rectangle.setWidth(50.0f);
        rectangle.setHeight(50.0f);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        //Adding the rectangle to the Panel
        Farm.getChildren().add(rectangle);

    }

    @FXML
    void itemChangePClick(ActionEvent event) {
        // Create the TextInputDialog box.
        TextInputDialog priceItem = new TextInputDialog();
        priceItem.setTitle("New Price");
        priceItem.setHeaderText("Enter new price: ");
        priceItem.setContentText("Price: ");

        // Capture the users input
        Optional<String> result = priceItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
        }
    }

    @FXML
    void itemDeleteClick(ActionEvent event) {
        TreeItem delete = (TreeItem)treeView.getSelectionModel().getSelectedItem();
        System.out.println(delete);
        boolean remove = delete.getParent().getChildren().remove(delete);

    }

    @FXML
    void itemRenameClick(ActionEvent event) {
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Rename");
        renameItem.setHeaderText("Enter new name: ");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
        }

        // Rename TreeItem item value.
        TreeItem<String> item = selectItem();
        item.setValue(result.get());
    }

    @FXML
    void itemContAddItemCClick(ActionEvent event) {
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Add Item Container");
        renameItem.setHeaderText("Enter new item container name: ");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
        }

        // Create new TreeItem branch node.
        TreeItem<String> treeBranch = new TreeItem<>(result.get());

        // Get parent (root node)
        TreeItem<String> parent = selectItem();
        parent.getChildren().add(treeBranch);

        // Add default child so commands don't read it as a leaf.
        TreeItem<String> defaultchild = new TreeItem<>("Default");
        treeBranch.getChildren().add(defaultchild);

        //Drawing the Reactangle
        Rectangle rectangle = new Rectangle();

        rectangle.setX(150.0f);
        rectangle.setY(75.0f);
        rectangle.setWidth(90.0f);
        rectangle.setHeight(90.0f);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        Farm.getChildren().addAll(rectangle);

    }

    @FXML
    void itemContAddItemClick(ActionEvent event) {
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Add Item");
        renameItem.setHeaderText("Enter new item name: ");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());

        }
        // Create a new item.
        String itemName = result.get();
        ItemsClass item = new ItemsClass(itemName, 0, 0, 0, 0, 0, 0);
        System.out.println(item.getName());

        // Create new TreeItem leaf node.
        TreeItem<String> treeItem = new TreeItem<>(result.get());
        TreeItem<String> parent = selectItem();
        parent.getChildren().add(treeItem);

        //Drawing the Reactangle
        Rectangle rectangle = new Rectangle();

        rectangle.setX(150.0f);
        rectangle.setY(75.0f);
        rectangle.setWidth(50.0f);
        rectangle.setHeight(50.0f);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        Farm.getChildren().add(rectangle);

    }

    @FXML
    void itemContChangeDClick(ActionEvent event) {
        // Create dialog box.
        Dialog<Double> changeLoc = new Dialog<>();
        changeLoc.setTitle("Dimensions");
        changeLoc.setHeaderText("Enter the new dimensions: ");
        changeLoc.setResizable(true);
        //changeLoc.setWidth(1000.0);

        // Add the attributes of the dialog box.
        Label label1 = new Label("Width: ");
        Label label2 = new Label("Height: ");
        TextField width = new TextField();
        TextField height = new TextField();

        // Add the layout, and add the attributes to layout.
        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(width, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(height, 2, 2);
        changeLoc.getDialogPane().setContent(grid);

        // Add button to close dialog box after user enters values.
        ButtonType okButton = new ButtonType("Okay", ButtonData.OK_DONE);
        changeLoc.getDialogPane().getButtonTypes().add(okButton);

        Optional<Double> result = changeLoc.showAndWait();
        if(result.isPresent()){
            System.out.println(width.getText() + " " + height.getText());
        }
        //Drawing the Reactangle
        Rectangle rectangle = new Rectangle();

        //Assigning a new variable to change the txt field to double
        double user_width = Double.parseDouble(width.getText());
        double user_height = Double.parseDouble(height.getText());

        //Setting up the new rectangle
        rectangle.setX(150.0f);
        rectangle.setY(75.0f);
        rectangle.setWidth(user_width);
        rectangle.setHeight(user_height);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        TreeItem<String> item = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();

        Farm.getChildren().remove(item);

        //Adding the rectangle to the Panel
        Farm.getChildren().add(rectangle);

    }

    @FXML
    void itemContChangeLClick(ActionEvent event) {
        // Create dialog box.
        Dialog<Double> changeDim = new Dialog<>();
        changeDim.setTitle("Location");
        changeDim.setHeaderText("Enter the new location: ");
        changeDim.setResizable(true);

        // Add the attributes of the dialog box.
        Label label1 = new Label("Change x: ");
        Label label2 = new Label("Change y: ");
        TextField xvalue = new TextField();
        TextField yvalue = new TextField();

        // Add the layout, and add the attributes to layout.
        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(xvalue, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(yvalue, 2, 2);
        changeDim.getDialogPane().setContent(grid);

        // Add button to close dialog box after user enters values.
        ButtonType okButton = new ButtonType("Okay", ButtonData.OK_DONE);
        changeDim.getDialogPane().getButtonTypes().add(okButton);

        Optional<Double> result = changeDim.showAndWait();
        if(result.isPresent()){
            System.out.println(xvalue.getText() + " " + yvalue.getText());
        }

        //Drawing the Reactangle
        Rectangle rectangle = new Rectangle();

        //Assigning a new variable to change the txt field to double
        double user_xvalue = Double.parseDouble(xvalue.getText());
        double user_yvalue = Double.parseDouble(yvalue.getText());

        //Setting up the new rectangle
        rectangle.setX(user_xvalue);
        rectangle.setY(user_yvalue);
        rectangle.setWidth(90.0f);
        rectangle.setHeight(90.0f);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        //Adding the rectangle to the Panel
        Farm.getChildren().add(rectangle);

    }

    @FXML
    void itemContChangePClick(ActionEvent event) {
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("New Price");
        renameItem.setHeaderText("Enter new price: ");
        renameItem.setContentText("Price: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
        }
    }

    @FXML
    void itemContDeleteClick(ActionEvent event) {
        TreeItem delete = (TreeItem)treeView.getSelectionModel().getSelectedItem();
        boolean remove = delete.getParent().getChildren().remove(delete);
    }

    @FXML
    void itemContRenameClick(ActionEvent event) {
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Rename");
        renameItem.setHeaderText("Enter new name: ");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
        }

        // Rename TreeItem item container value.
        TreeItem<String> item = selectItem();
        item.setValue(result.get());
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        TreeItem<String> rootItem = new TreeItem<>("Root");
        rootItem.setExpanded(true);

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
    public TreeItem<String> selectItem(){
        TreeItem<String> item = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();

        if(item.isLeaf()){
            this.itemCmds.setVisible(true);
            this.itemContCmds.setVisible(false);
        }else{
            this.itemCmds.setVisible(false);
            this.itemContCmds.setVisible(true);
        }

        if(item != null){
            System.out.println(item.getValue());
        }

        return item;
    }
}
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
import javafx.scene.layout.StackPane;
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

    @FXML
    private VBox droneBtns;

    @FXML
    private VBox droneBtns2;

    @FXML
    private Button goHome;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    void goHomeClick(ActionEvent event) {

    }

    @FXML
    void scanFarmBtn(ActionEvent event) {

    }

    @FXML
    void visitItemBtn(ActionEvent event) {

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

        //Farm.getChildren().remove(2, 3);
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

        makeRectangle(result.get(), 0, 0, 100.0, 75.0);
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

        makeRectangle(result.get(), 0, 0, 100.0, 75.0);
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
        //Drawing the Rectangle
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

        // Farm.getChildren().remove(4, 6);
        // Farm.getChildren().remove(8, 10);

        // if(delete.getValue() == "Barn"){
        //     Farm.getChildren().remove(4, 6);
        //     Farm.getChildren().remove(8, 10);
        // }else if(delete.getValue() == "Storage Builder"){
        //     Farm.getChildren().remove(6, 8);
        //     Farm.getChildren().remove(10, 12);
        // }
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
        makeRectangle(Command_Center.getValue(), 150.0, 10.0, 120.0, 100.0); // Farm item #2 & 3
        TreeItem<String> Barn_Branch = new TreeItem<>("Barn");
        makeRectangle(Barn_Branch.getValue(), 20.0, 150.0, 100.0, 200.0); // Farm item #4 & 5
        TreeItem<String> StorageBuilder_Branch = new TreeItem<>("Storage Builder");
        makeRectangle(StorageBuilder_Branch.getValue(), 335.0, 150.0, 100.0, 200.0); // Farm item #6 & 7
        TreeItem<String> CropField_Branch = new TreeItem<>("Crop Field"); 
        makeRectangle(CropField_Branch.getValue(), 30.0, 400.0, 400.0, 200.0); // Farm item #8 & 9

        //Leaf Items
        TreeItem<String> CommandCenter_LeafItem1 = new TreeItem<>("Drone");
        TreeItem<String> Barn_LeafItem1 = new TreeItem<>("Milk Storage");
        makeRectangle(Barn_LeafItem1.getValue(), 20.0, 300.0, 100.0, 50.0); // Farm item #10 & 11
        TreeItem<String> StorageBuilder_LeafItem1 = new TreeItem<>("Tractor");
        makeRectangle(StorageBuilder_LeafItem1.getValue(), 350.0, 250.0, 50.0, 50.0); // Farm item #12 & 13
        TreeItem<String> CropField_LeftItem1 = new TreeItem<>("Soy Crop");
        makeRectangle(CropField_LeftItem1.getValue(), 350.0, 400.0, 80.0, 200.0); // Farm item #14 & 15

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

    public void makeRectangle(String name, double x, double y, double width, double height){
        //The text up top of the rectangle
        Text text = new Text(name);

        //Drawing the Reactangle
        Rectangle rectangle = new Rectangle();

        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        rectangle.setId(name);

        text.setLayoutX(rectangle.getX() + 5);
        text.setLayoutY(rectangle.getY() + 10);

        Farm.getChildren().add(rectangle);
        Farm.getChildren().add(text);
    } 

    public void removeRectangle(){

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

        if(item.getValue() == "Drone"){
            this.droneBtns2.setVisible(true);
        }else{
            this.droneBtns2.setVisible(false);
        }

        if(item != null){
            System.out.println(item.getValue());
        }

        return item;
    }
}
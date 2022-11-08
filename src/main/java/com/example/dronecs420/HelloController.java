package com.example.dronecs420;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;

import java.net.URL;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.transform.*;


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
    
    public String selectedItem = "";
    
    public List<Object> itemList = new ArrayList<Object>();
    //public List<ItemContainer> itemList = new ArrayList<ItemContainer>();

    @FXML
    private Label purchasePriceValue;

    @FXML
    private Label CurrentMarketValue;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("sWelcome to JavaFX Application!");
    }

    @FXML
    void goHomeClick(ActionEvent event) {
        
    }

    @FXML
    void launchSimBtn(ActionEvent event) {

    }

    @FXML
    void LaunchDroneBtn(ActionEvent event) {

    }

    private RotateTransition rotate = new RotateTransition();
    private PathTransition pathTransition = new PathTransition();
    @FXML
    void scanFarmBtn(ActionEvent event) {
        Path path = new Path();
        rotate.setNode(ImageView);
        rotate.setDuration(Duration.seconds(1));
        path.getElements().add(new MoveTo(-100,50));
        rotate.setByAngle(90);
        path.getElements().add(new VLineTo(525));
        path.getElements().add(new HLineTo(-75));
        path.getElements().add(new VLineTo(50));
        path.getElements().add(new HLineTo(-50));
        path.getElements().add(new VLineTo(525));
        path.getElements().add(new HLineTo(-25));
        path.getElements().add(new VLineTo(50));
        path.getElements().add(new HLineTo(0));
        path.getElements().add(new VLineTo(525));
        path.getElements().add(new HLineTo(25));
        path.getElements().add(new VLineTo(50));
        path.getElements().add(new HLineTo(50));
        path.getElements().add(new VLineTo(525));
        path.getElements().add(new HLineTo(75));
        path.getElements().add(new VLineTo(50));
        path.getElements().add(new HLineTo(100));
        path.getElements().add(new VLineTo(525));
        path.getElements().add(new HLineTo(125));
        path.getElements().add(new VLineTo(50));
        path.getElements().add(new HLineTo(150));
        path.getElements().add(new VLineTo(525));
        path.getElements().add(new HLineTo(175));
        path.getElements().add(new VLineTo(50));
        path.getElements().add(new HLineTo(200));
        path.getElements().add(new VLineTo(525));
        path.getElements().add(new HLineTo(225));
        path.getElements().add(new VLineTo(50));
        path.getElements().add(new ClosePath());
        pathTransition.setNode(ImageView);
        pathTransition.setDuration(Duration.seconds(15));
        pathTransition.setPath(path);
        pathTransition.play();
        rotate.play();
    }
    
    String[] getItemInfo() {
    	
    	int itemIndex = -1;
    	String type = "";
    	ItemsClass item = new ItemsClass(selectedItem, 0, 0, 0, 0, 0, 0, 0);
    	ItemContainer itemContainer = new ItemContainer(selectedItem, 0, 0, 0, 0, 0, 0);
    	for(int i = 0; i<itemList.size(); i++)
    	{
    		System.out.println(i + ": " + ((ItemsClass) itemList.get(i)).getName());
    	}
    	
    	if( itemList.indexOf(item) != -1) {
    		itemIndex = itemList.indexOf(item);
    		type = "item";
    	}else if( itemList.indexOf(itemContainer) != -1) {
    		itemIndex = itemList.indexOf(itemContainer);
    		type = "itemContainer";
    	}
    	
    	String[] info = new String[2];
    	info[0] = Integer.toString(itemIndex);
    	info[1] = type;
    	
    	return info;
    }

    @FXML
    void visitItemBtn(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);
    	String type = info[1];
    	
    	double x = -1;
        double y = -1;
    	
    	if(type == "item") {
    		x = ((ItemsClass) itemList.get(itemIndex)).getLx();
            y = ((ItemsClass) itemList.get(itemIndex)).getLy();
    	}else if (type == "itemContainer") {
    		x = ((ItemContainer) itemList.get(itemIndex)).getLx();
            y = ((ItemContainer) itemList.get(itemIndex)).getLy();
    	}
    	
    	System.out.println("x: " + x + ", y: " + y);
    }
    
  
    @FXML
    void itemChangeDClick(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);
    	
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
            System.out.println("Changed Width + Height of " + ((ItemsClass) itemList.get(itemIndex)).getName() + " " + ((ItemsClass) itemList.get(itemIndex)).getWidth() + " " + ((ItemsClass) itemList.get(itemIndex)).getHeight());
            ((ItemsClass) itemList.get(itemIndex)).setWidth(Integer.parseInt(width.getText()));
            ((ItemsClass) itemList.get(itemIndex)).setHeight(Integer.parseInt(height.getText()));
        }

        //Assigning a new variable to change the txt field to double
        double user_width = Double.parseDouble(width.getText());
        double user_height = Double.parseDouble(height.getText());

        // Delete old rectangle.
        deleteRectangle(selectItem().getValue().toString());

        makeRectangle(((ItemsClass) itemList.get(itemIndex)).getName(), ((ItemsClass) itemList.get(itemIndex)).getLx(), ((ItemsClass) itemList.get(itemIndex)).getLy(), ((ItemsClass) itemList.get(itemIndex)).getWidth(), ((ItemsClass) itemList.get(itemIndex)).getHeight());
    }

    @FXML
    void itemChangeLClick(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);
    	
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
            
            ((ItemsClass) itemList.get(itemIndex)).setLx(Integer.parseInt(xvalue.getText()));
            ((ItemsClass) itemList.get(itemIndex)).setLy(Integer.parseInt(yvalue.getText()));
            System.out.println("Changed X + Y of " + ((ItemsClass) itemList.get(itemIndex)).getName() + " " + ((ItemsClass) itemList.get(itemIndex)).getLx() + " " + ((ItemsClass) itemList.get(itemIndex)).getLy());
        }

        //Assigning a new variable to change the txt field to double
        double user_xvalue = Double.parseDouble(xvalue.getText());
        double user_yvalue = Double.parseDouble(yvalue.getText());

        // Delete old rectangle.
        deleteRectangle(selectItem().getValue().toString());

        makeRectangle(((ItemsClass) itemList.get(itemIndex)).getName(), ((ItemsClass) itemList.get(itemIndex)).getLx(), ((ItemsClass) itemList.get(itemIndex)).getLy(), ((ItemsClass) itemList.get(itemIndex)).getWidth(), ((ItemsClass) itemList.get(itemIndex)).getHeight());
    }

    @FXML
    void itemChangePClick(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);
    	
        // Create the TextInputDialog box.
        TextInputDialog priceItem = new TextInputDialog();
        priceItem.setTitle("New Price");
        priceItem.setHeaderText("Enter new price: ");
        priceItem.setContentText("Price: ");

        // Capture the users input
        Optional<String> result = priceItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
            
            ((ItemsClass) itemList.get(itemIndex)).setPrice(Integer.parseInt(result.get()));
            System.out.println("Changed Price of " + ((ItemsClass) itemList.get(itemIndex)).getName() + " " + ((ItemsClass) itemList.get(itemIndex)).getPrice());
        }
    }

    @FXML
    void itemDeleteClick(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);


    	itemList.remove(itemIndex);
    	
        TreeItem delete = (TreeItem)treeView.getSelectionModel().getSelectedItem();
        System.out.println(delete);
        boolean remove = delete.getParent().getChildren().remove(delete);

        // Delete rectangle.
        deleteRectangle(delete.getValue().toString());
    }

    @FXML
    void itemRenameClick(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);
    	
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Rename");
        renameItem.setHeaderText("Enter new name: ");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
            
            ((ItemsClass) itemList.get(itemIndex)).setName(result.get());
            System.out.println("Changed Name of " + ((ItemsClass) itemList.get(itemIndex)).getName());
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
        renameItem.setHeaderText("Enter new item container name: \nUse '_' instead of spaces");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
        }
        
        //Add Item Container
        ItemContainer container = new ItemContainer(result.get(), 0, 0, 0, 0, 100, 75);
        itemList.add(container);

        // Create new TreeItem branch node.
        TreeItem<String> treeBranch = new TreeItem<>(result.get());

        // Get parent (root node)
        TreeItem<String> parent = selectItem();
        parent.getChildren().add(treeBranch);

        // Add default child so commands don't read it as a leaf.
        TreeItem<String> defaultchild = new TreeItem<>("Default");
        treeBranch.getChildren().add(defaultchild);

        /* 
        //  IN PROGRESS -Josh
        String containerName = result.get();
        String childName = defaultchild.toString();

        // Create new ItemContainer
        ItemContainer container = new ItemContainer(containerName, 0, 50, 50, 50, 50, 50);
        System.out.println("ItemContainer name: "+container.getName());

        // // Create new item and add it to the item container.
        ItemsClass newitem = new ItemsClass();
        newitem.setName(childName);
        container.addItem(newitem);

        System.out.println(newitem.getName());
        */

        makeRectangle(result.get(), 0, 0, 100.0, 75.0);
    }

    @FXML
    void itemContAddItemClick(ActionEvent event) {
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Add Item");
        renameItem.setHeaderText("Enter new item name: \nUse '_' instead of spaces");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());

        }
        // Create a new item.
        String itemName = result.get();
        ItemsClass item = new ItemsClass(itemName, 0, 0, 0, 0, 100, 75, 0);
        itemList.add(item);

        System.out.println(item.getName());

        // Create new TreeItem leaf node.
        TreeItem<String> treeItem = new TreeItem<>(result.get());
        TreeItem<String> parent = selectItem();
        parent.getChildren().add(treeItem);

        makeRectangle(result.get(), 0, 0, 100.0, 75.0);
    }

    @FXML
    void itemContChangeDClick(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);
    	
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
            
            ((ItemContainer) itemList.get(itemIndex)).setWidth(Integer.parseInt(width.getText()));
            ((ItemContainer) itemList.get(itemIndex)).setHeight(Integer.parseInt(height.getText()));
            System.out.println("Changed Width + Height of " + ((ItemContainer) itemList.get(itemIndex)).getName() + " " + ((ItemContainer) itemList.get(itemIndex)).getWidth() + " " + ((ItemContainer) itemList.get(itemIndex)).getHeight());
        }

        // Delete old rectangle.
        deleteRectangle(selectItem().getValue().toString());
        
        makeRectangle(((ItemContainer) itemList.get(itemIndex)).getName(), ((ItemContainer) itemList.get(itemIndex)).getLx(), ((ItemContainer) itemList.get(itemIndex)).getLy(), ((ItemContainer) itemList.get(itemIndex)).getWidth(), ((ItemContainer) itemList.get(itemIndex)).getHeight());
    }

    @FXML
    void itemContChangeLClick(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);
    	
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
            
            ((ItemContainer) itemList.get(itemIndex)).setLx(Integer.parseInt(xvalue.getText()));
            ((ItemContainer) itemList.get(itemIndex)).setLy(Integer.parseInt(yvalue.getText()));
            System.out.println("Changed X + Y of " + ((ItemContainer) itemList.get(itemIndex)).getName() + " " + ((ItemContainer) itemList.get(itemIndex)).getLx() + " " + ((ItemContainer) itemList.get(itemIndex)).getLy());
        }

        double user_xvalue = Double.parseDouble(xvalue.getText());
        double user_yvalue = Double.parseDouble(yvalue.getText());

        // Create a temp variable to use lookup() function to find the rectangle id.
        String temp = "#"+selectItem().getValue().toString()+itemIndex;

        // Remove the rectangle and text based off the id.
        Farm.getChildren().remove(Farm.lookup(temp));
        Farm.getChildren().remove(Farm.lookup(temp+"text"));

        makeRectangle(((ItemContainer) itemList.get(itemIndex)).getName(), ((ItemContainer) itemList.get(itemIndex)).getLx(), ((ItemContainer) itemList.get(itemIndex)).getLy(), ((ItemContainer) itemList.get(itemIndex)).getWidth(), ((ItemContainer) itemList.get(itemIndex)).getHeight());
        // Delete old rectangle.
        deleteRectangle(selectItem().getValue().toString());
    }

    @FXML
    void itemContChangePClick(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);
    	
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("New Price");
        renameItem.setHeaderText("Enter new price: ");
        renameItem.setContentText("Price: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
            
            ((ItemContainer) itemList.get(itemIndex)).setPrice(Integer.parseInt(result.get()));
            System.out.println("Changed Price of " + ((ItemContainer) itemList.get(itemIndex)).getName() + " " + ((ItemContainer) itemList.get(itemIndex)).getPrice());
        }
    }

    @FXML
    void itemContDeleteClick(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);
    	
        if(Farm.getChildren() == null){
        	itemList.remove(itemIndex);
            TreeItem delete = (TreeItem)treeView.getSelectionModel().getSelectedItem();
            boolean remove = delete.getParent().getChildren().remove(delete);

            // Delete rectangle.
            deleteRectangle(delete.getValue().toString());
        }else{
            // Create dialog box.
            Dialog<Double> errmsg = new Dialog<>();
            errmsg.setTitle("ERROR");
            errmsg.setHeaderText("Delete all leaf nodes first");
            errmsg.setResizable(true);

            // Add button to close dialog box after user enters values.
            ButtonType okButton = new ButtonType("Okay", ButtonData.OK_DONE);
            errmsg.getDialogPane().getButtonTypes().add(okButton);

            // Display the dialog box.
            errmsg.showAndWait();
        }
    }

    @FXML
    void itemContRenameClick(ActionEvent event) {
    	String[] info = getItemInfo();
    	int itemIndex = Integer.parseInt(info[0]);
    	
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Rename");
        renameItem.setHeaderText("Enter new name: ");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
            
            ((ItemContainer) itemList.get(itemIndex)).setName(result.get());
            System.out.println("Changed Name of " + ((ItemContainer) itemList.get(itemIndex)).getName());
        }

        // Rename TreeItem item container value.
        TreeItem<String> item = selectItem();
        item.setValue(result.get());

        // Rename the itemContainer object.
        //ItemContainer item = searchItems(selectItem().toString(), item);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        TreeItem<String> rootItem = new TreeItem<>("Root");
        rootItem.setExpanded(true);

        //Branch_Items
        TreeItem<String> Command_Center = new TreeItem<>("Command_Center");
        ItemContainer itemContainer = new ItemContainer("Command_Center", 0, 150, 10, 0, 120, 100);
        itemList.add(itemContainer);
        makeRectangle(Command_Center.getValue(), 150.0, 10.0, 120.0, 100.0); // Farm item #2 & 3
        
        TreeItem<String> Barn_Branch = new TreeItem<>("Barn");
        itemContainer = new ItemContainer("Barn", 0, 20, 150, 0, 100, 200);
        itemList.add(itemContainer);
        makeRectangle(Barn_Branch.getValue(), 20.0, 150.0, 100.0, 200.0); // Farm item #4 & 5
        
        TreeItem<String> StorageBuilder_Branch = new TreeItem<>("Storage_Builder");
        itemContainer = new ItemContainer("Storage_Builder", 0, 335, 150, 0, 100, 200);
        itemList.add(itemContainer);
        makeRectangle(StorageBuilder_Branch.getValue(), 335.0, 150.0, 100.0, 200.0); // Farm item #6 & 7
        
        TreeItem<String> CropField_Branch = new TreeItem<>("Crop_Field");
        itemContainer = new ItemContainer("Crop_Field", 0, 30, 400, 0, 400, 200);
        itemList.add(itemContainer);
        makeRectangle(CropField_Branch.getValue(), 30.0, 400.0, 400.0, 200.0); // Farm item #8 & 9

        //Leaf Items
        TreeItem<String> CommandCenter_LeafItem1 = new TreeItem<>("Drone");
        
        TreeItem<String> Barn_LeafItem1 = new TreeItem<>("Milk_Storage");
        ItemsClass item = new ItemsClass("Milk_Storage", 0, 20, 300, 0, 100, 50, 0);
        itemList.add(item);
        makeRectangle(Barn_LeafItem1.getValue(), 20.0, 300.0, 100.0, 50.0); // Farm item #10 & 11
        
        TreeItem<String> StorageBuilder_LeafItem1 = new TreeItem<>("Tractor");
        item = new ItemsClass("Tractor", 0, 350, 250, 0, 50, 50, 0);
        itemList.add(item);
        makeRectangle(StorageBuilder_LeafItem1.getValue(), 350.0, 250.0, 50.0, 50.0); // Farm item #12 & 13
        
        TreeItem<String> CropField_LeftItem1 = new TreeItem<>("Soy_Crop");
        item = new ItemsClass("Soy_Crop", 0, 350, 400, 0, 80, 200, 0);
        itemList.add(item);
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
        text.setId(name+"text");

        Farm.getChildren().add(rectangle);
        Farm.getChildren().add(text);
    }

    public void deleteRectangle(String name){
        // Create a temp variable to use lookup() function to find the rectangle id.
        String temp = "#"+name;

        // Remove the rectangle and text based off the id.
        Farm.getChildren().remove(Farm.lookup(temp));
        Farm.getChildren().remove(Farm.lookup(temp+"text"));
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
            selectedItem = item.getValue();
        }

        return item;
    }
}
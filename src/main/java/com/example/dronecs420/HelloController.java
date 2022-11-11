package com.example.dronecs420;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
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

    public List<ItemsClass> itemList = new ArrayList<ItemsClass>();
    public List<ItemContainer> containerList = new ArrayList<ItemContainer>();

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
        TranslateTransition translate = new TranslateTransition();
        //TreeItem<Object> commandCenter = new TreeItem<Object>(new ItemContainer("Command Center", 0, 174, 32, 100, 76, 66));



        translate.setNode(ImageView);
        translate.setToX(174 - ImageView.getLayoutX());
        translate.setToY(32 - ImageView.getLayoutY());
        translate.play();
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

        ItemsClass item = new ItemsClass(selectItem().getParent().getValue(), selectedItem, 0, 0, 0, 0, 0, 0, 0);
        ItemContainer itemContainer = new ItemContainer(selectItem().getParent().getValue(), selectedItem, 0, 0, 0, 0, 0, 0);

        try {
        	for(int i=0; i<itemList.size(); i++) {
        		String name = itemList.get(i).getName();
        		if(name.equals(selectedItem)) {
            		type = "item";
            		itemIndex = i;
            	}
        	}
        }catch(IndexOutOfBoundsException e) {
        	for(int i=0; i<itemList.size();i++) {
        		System.out.println(itemList.get(i).getName());
        	}
        	System.out.println("Not an item");
        	System.out.println(e);
        }
        
        try {
        	for(int i=0; i<containerList.size(); i++) {
        		String name = containerList.get(i).getName();
        		if(name.equals(selectedItem)) {
            		type = "itemContainer";
            		itemIndex= i;
            	}
        	}
        }catch(IndexOutOfBoundsException e) {
        	System.out.println("Not an item container");
        	System.out.println(e);
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
            x = (itemList.get(itemIndex)).getLx();
            y = (itemList.get(itemIndex)).getLy();
        }else if (type == "itemContainer") {
            x = (containerList.get(itemIndex)).getLx();
            y = (containerList.get(itemIndex)).getLy();
        }

        System.out.println("x: " + x + ", y: " + y);
    }


    @FXML
    void itemChangeDClick(ActionEvent event) {
        String[] info = getItemInfo();
        int itemIndex = Integer.parseInt(info[0]);
        String type = info[1];

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
            if(type == "item") {
            	System.out.println("Changed Width + Height of " + (itemList.get(itemIndex)).getName() + " " + (itemList.get(itemIndex)).getWidth() + " " + (itemList.get(itemIndex)).getHeight());
                (itemList.get(itemIndex)).setWidth(Integer.parseInt(width.getText()));
                (itemList.get(itemIndex)).setHeight(Integer.parseInt(height.getText()));
                
                // Delete old rectangle.
                deleteRectangle(selectItem().getValue().toString());
                makeRectangle((itemList.get(itemIndex)).getName(), (itemList.get(itemIndex)).getLx(), (itemList.get(itemIndex)).getLy(), (itemList.get(itemIndex)).getWidth(), (itemList.get(itemIndex)).getHeight());
            }else if (type == "itemContainer") {
            	System.out.println("Changed Width + Height of " + (containerList.get(itemIndex)).getName() + " " + (containerList.get(itemIndex)).getWidth() + " " + (containerList.get(itemIndex)).getHeight());
                (containerList.get(itemIndex)).setWidth(Integer.parseInt(width.getText()));
                (containerList.get(itemIndex)).setHeight(Integer.parseInt(height.getText()));
                
             // Delete old rectangle.
                deleteRectangle(selectItem().getValue().toString());
                makeRectangle((containerList.get(itemIndex)).getName(), (containerList.get(itemIndex)).getLx(), (containerList.get(itemIndex)).getLy(), (containerList.get(itemIndex)).getWidth(), (containerList.get(itemIndex)).getHeight());
            }
        }
    }

    @FXML
    void itemChangeLClick(ActionEvent event) {
        String[] info = getItemInfo();
        int itemIndex = Integer.parseInt(info[0]);
        String type = info[1];

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
            
            if(type == "item") {
            	(itemList.get(itemIndex)).setLx(Integer.parseInt(xvalue.getText()));
                (itemList.get(itemIndex)).setLy(Integer.parseInt(yvalue.getText()));
                System.out.println("Changed X + Y of " + (itemList.get(itemIndex)).getName() + " " + (itemList.get(itemIndex)).getLx() + " " + (itemList.get(itemIndex)).getLy());
                
                // Delete old rectangle.
                deleteRectangle(selectItem().getValue().toString());
                makeRectangle((itemList.get(itemIndex)).getName(), (itemList.get(itemIndex)).getLx(), (itemList.get(itemIndex)).getLy(), (itemList.get(itemIndex)).getWidth(), (itemList.get(itemIndex)).getHeight());
            }else if (type == "itemContainer") {
            	(containerList.get(itemIndex)).setLx(Integer.parseInt(xvalue.getText()));
                (containerList.get(itemIndex)).setLy(Integer.parseInt(yvalue.getText()));
                System.out.println("Changed X + Y of " + (containerList.get(itemIndex)).getName() + " " + (containerList.get(itemIndex)).getLx() + " " + (containerList.get(itemIndex)).getLy());
                
                // Delete old rectangle.
                deleteRectangle(selectItem().getValue().toString());
                makeRectangle((containerList.get(itemIndex)).getName(), (containerList.get(itemIndex)).getLx(), (containerList.get(itemIndex)).getLy(), (containerList.get(itemIndex)).getWidth(), (containerList.get(itemIndex)).getHeight());
            }
        }
    }

    @FXML
    void itemChangePClick(ActionEvent event) {
        String[] info = getItemInfo();
        int itemIndex = Integer.parseInt(info[0]);
        String type = info[1];

        // Create the TextInputDialog box.
        TextInputDialog priceItem = new TextInputDialog();
        priceItem.setTitle("New Price");
        priceItem.setHeaderText("Enter new price: ");
        priceItem.setContentText("Price: ");

        // Capture the users input
        Optional<String> result = priceItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
            
            if(type == "item") {
                if(itemList.get(itemIndex).getPrice() == 0){
                    (itemList.get(itemIndex)).setPrice(Integer.parseInt(result.get()));
                    System.out.println("Changed Price of " + (itemList.get(itemIndex)).getName() + " " + (itemList.get(itemIndex)).getPrice());
                    (itemList.get(itemIndex)).setCur_price(Integer.parseInt(result.get()));
                    System.out.println("Changed Current Price of " + (itemList.get(itemIndex)).getName() + " " + (itemList.get(itemIndex)).getCur_price());
                }else{
                    (itemList.get(itemIndex)).setCur_price(Integer.parseInt(result.get()));
                    System.out.println("Changed Current Price of " + (itemList.get(itemIndex)).getName() + " " + (itemList.get(itemIndex)).getCur_price());
                }
            }else if (type == "itemContainer") {
            	(containerList.get(itemIndex)).setCur_price(Integer.parseInt(result.get()));
                System.out.println("Changed Price of " + (containerList.get(itemIndex)).getName() + " " + (containerList.get(itemIndex)).getCur_price());
            }
        }
    }

    @FXML
    void itemDeleteClick(ActionEvent event) {
        String[] info = getItemInfo();
        int itemIndex = Integer.parseInt(info[0]);
        String type = info[1];

        if(type == "item") {
        	itemList.remove(itemIndex);
        	
        	TreeItem delete = (TreeItem)treeView.getSelectionModel().getSelectedItem();
            System.out.println(delete);
            boolean remove = delete.getParent().getChildren().remove(delete);

            // Delete rectangle.
            System.out.println("item to be deleted string: " + delete.getValue().toString());
            deleteRectangle(delete.getValue().toString());
        }else if (type == "itemContainer") {
        	containerList.remove(itemIndex);
            
        	TreeItem delete = (TreeItem)treeView.getSelectionModel().getSelectedItem();
            System.out.println(delete);
            boolean remove = delete.getParent().getChildren().remove(delete);

            // Delete rectangle.
            System.out.println("item to be deleted string: " + delete.getValue().toString());
            deleteRectangle(delete.getValue().toString());
        }
    }

    @FXML
    void itemRenameClick(ActionEvent event) {
        String[] info = getItemInfo();
        int itemIndex = Integer.parseInt(info[0]);
        String type = info[1];

        // Store the old name before changing the ItemClass object name.
        String old_name = selectItem().getValue();

        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Rename");
        renameItem.setHeaderText("Enter new name: ");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
            
            if(type == "item") {
            	(itemList.get(itemIndex)).setName(result.get());
                System.out.println("Changed Name of " + (itemList.get(itemIndex)).getName());
                
             // Delete old rectangle.
                deleteRectangle(selectItem().getValue().toString());

                makeRectangle((itemList.get(itemIndex)).getName(), (itemList.get(itemIndex)).getLx(), (itemList.get(itemIndex)).getLy(), (itemList.get(itemIndex)).getWidth(), (itemList.get(itemIndex)).getHeight());
                
                // Rename TreeItem item value.
                TreeItem<String> item = selectItem();
                item.setValue(result.get());
            }else if (type == "itemContainer") {
            	(containerList.get(itemIndex)).setName(result.get());
                System.out.println("Changed Name of " + (containerList.get(itemIndex)).getName());
                
                // Delete old rectangle.
                deleteRectangle(selectItem().getValue().toString());

                makeRectangle((containerList.get(itemIndex)).getName(), (containerList.get(itemIndex)).getLx(), (containerList.get(itemIndex)).getLy(), (containerList.get(itemIndex)).getWidth(), (containerList.get(itemIndex)).getHeight());
                
                // Rename TreeItem item value.
                TreeItem<String> item = selectItem();
                item.setValue(result.get());
            }
        }
    }

    @FXML
    void itemContAddItemCClick(ActionEvent event) {
        
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Add Item Container");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
            
            // Create new TreeItem branch node.
            TreeItem<String> treeBranch = new TreeItem<>(result.get());

            // Get parent (root node)
            TreeItem<String> parent = selectItem();
            parent.getChildren().add(treeBranch);

            // Add default child so commands don't read it as a leaf.
            String childName = (result.get() + " Child");
            TreeItem<String> defaultchild = new TreeItem<>(childName);
            treeBranch.getChildren().add(defaultchild);
            
            //Add Item Container
            ItemContainer container = new ItemContainer(parent.getValue(), result.get(), 0, 0, 0, 0, 100, 75);
            containerList.add(container);

            // Add Default Item
            ItemsClass newitem = new ItemsClass(container.getName(), childName, 0, 0, 0, 0, 50, 35, 0);
            newitem.setName(result.get() +" Child");
            container.addItem(newitem);
            itemList.add(newitem);

            System.out.println(newitem.getName());
            
            //Make Container Rectangle
            makeRectangle(container.getName(), container.getLx(), container.getLy(), container.getWidth(), container.getHeight());
            
            //Make Child Rectangle
            makeRectangle(newitem.getName(), newitem.getLx(), newitem.getLy(), newitem.getWidth(), newitem.getHeight());
        }
    }

    @FXML
    void itemContAddItemClick(ActionEvent event) {
        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Add Item");
        renameItem.setContentText("Name: ");

        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());
            
            // Create a new item.
            String itemName = result.get();
            ItemsClass item = new ItemsClass(selectItem().getValue(), itemName, 0, 0, 0, 0, 100, 75, 0);
            itemList.add(item);

            System.out.println(item.getName());

            // Create new TreeItem leaf node.
            TreeItem<String> treeItem = new TreeItem<>(result.get());
            TreeItem<String> parent = selectItem();
            parent.getChildren().add(treeItem);

            makeRectangle(item.getName(), item.getLx(), item.getLy(), item.getHeight(), item.getWidth());
        }
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

            (containerList.get(itemIndex)).setWidth(Integer.parseInt(width.getText()));
            (containerList.get(itemIndex)).setHeight(Integer.parseInt(height.getText()));
            System.out.println("Changed Width + Height of " + (containerList.get(itemIndex)).getName() + " " + (containerList.get(itemIndex)).getWidth() + " " + (containerList.get(itemIndex)).getHeight());
            
         // Delete old rectangle.
            deleteRectangle(selectItem().getValue().toString());

            makeRectangle((containerList.get(itemIndex)).getName(), (containerList.get(itemIndex)).getLx(), (containerList.get(itemIndex)).getLy(), (containerList.get(itemIndex)).getWidth(), (containerList.get(itemIndex)).getHeight());
        }
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

            (containerList.get(itemIndex)).setLx(Integer.parseInt(xvalue.getText()));
            (containerList.get(itemIndex)).setLy(Integer.parseInt(yvalue.getText()));
            System.out.println("Changed X + Y of " + (containerList.get(itemIndex)).getName() + " " + (containerList.get(itemIndex)).getLx() + " " + (containerList.get(itemIndex)).getLy());
            
         // Delete old rectangle.
            deleteRectangle(selectItem().getValue().toString());

            makeRectangle((containerList.get(itemIndex)).getName(), (containerList.get(itemIndex)).getLx(), (containerList.get(itemIndex)).getLy(), (containerList.get(itemIndex)).getWidth(), (containerList.get(itemIndex)).getHeight());
        }
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

            if(containerList.get(itemIndex).getPrice() == 0){
                (containerList.get(itemIndex)).setPrice(Integer.parseInt(result.get()));
                System.out.println("Changed Price of " + (containerList.get(itemIndex)).getName() + " " + (containerList.get(itemIndex)).getPrice());
                (containerList.get(itemIndex)).setCur_price(Integer.parseInt(result.get()));
                System.out.println("Changed Current Price of " + (containerList.get(itemIndex)).getName() + " " + (containerList.get(itemIndex)).getCur_price());
            }else{
                (containerList.get(itemIndex)).setCur_price(Integer.parseInt(result.get()));
                System.out.println("Changed Current Price of " + (containerList.get(itemIndex)).getName() + " " + (containerList.get(itemIndex)).getCur_price());
            }
            
        }
    }

    @FXML
    void itemContDeleteClick(ActionEvent event) {
        String[] info = getItemInfo();
        int itemIndex = Integer.parseInt(info[0]);

        if(Farm.getChildren() == null){
            containerList.remove(itemIndex);
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

        // Store the old name before changing the ItemClass object name.
        String old_name = selectItem().getValue();

        // Create the TextInputDialog box.
        TextInputDialog renameItem = new TextInputDialog();
        renameItem.setTitle("Rename");
        renameItem.setHeaderText("Enter new name: ");
        renameItem.setContentText("Name: ");
        
        // Capture the users input.
        Optional<String> result = renameItem.showAndWait();
        if(result.isPresent()){
            System.out.println(result.get());

            (containerList.get(itemIndex)).setName(result.get());
            System.out.println("Changed Name of " + (containerList.get(itemIndex)).getName());
            
            // Delete old rectangle.
            deleteRectangle(selectItem().getValue().toString());

            makeRectangle((containerList.get(itemIndex)).getName(), (containerList.get(itemIndex)).getLx(), (containerList.get(itemIndex)).getLy(), (containerList.get(itemIndex)).getWidth(), (containerList.get(itemIndex)).getHeight());
            
            // Rename TreeItem item container value.
            TreeItem<String> item = selectItem();
            item.setValue(result.get());
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	String storagePath = "src/main/resources/com/example/dronecs420/storage.txt";
    	File storageFile = new File(storagePath);
    	FileReader fr = null;
    	BufferedReader reader = null;
    	
		try {
			fr = new FileReader(storageFile);
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Failed to open file reader for storage file");
			e.printStackTrace();
		}
    	
		reader = new BufferedReader(fr);
		String line = null;
		String current = null;
		String rest = null;
		ItemsClass item = null;
		ItemContainer container = null;
		List<TreeItem<String>> treeContainers = new ArrayList<TreeItem<String>>();
		
    	try {
    		while ((line = reader.readLine()) != null) {
    			current = line.substring(0, line.indexOf(","));
    			rest = line.substring(line.indexOf(",")+1, line.length());
    			
    			if(current.equals("item")) {
    				current = rest.substring(0, rest.indexOf(","));
    				String parent = current;
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				String name = current;
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				int price = Integer.parseInt(current);

    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				double x = Double.parseDouble(current);

    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				double y = Double.parseDouble(current);
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				int length = Integer.parseInt(current);
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				int width = Integer.parseInt(current);
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				int height = Integer.parseInt(current);
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(";"));
    				int initialPrice = Integer.parseInt(current);
    				
    				item = new ItemsClass(parent, name, price, x, y, length, width, height, initialPrice);
    		        itemList.add(item);
    		        
    		        TreeItem<String> node = new TreeItem<>(name);
    		        makeRectangle(name, x, y, width, height);
    		        
    		        treeContainers.add(node);
    			}else if(current.equals("itemContainer")) {
    				current = rest.substring(0, rest.indexOf(","));
    				String parent = current;
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				String name = current;
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				int price = Integer.parseInt(current);

    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				double x = Double.parseDouble(current);

    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				double y = Double.parseDouble(current);
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				int length = Integer.parseInt(current);
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(","));
    				int width = Integer.parseInt(current);
    				
    				rest = rest.substring(rest.indexOf(",")+1, rest.length());
    				current = rest.substring(0, rest.indexOf(";"));
    				int height = Integer.parseInt(current);
    				
    				container = new ItemContainer(parent, name, price, x, y, length, width, height);
    		        containerList.add(container);
    		        
    		        TreeItem<String> node = new TreeItem<>(name);
    		        makeRectangle(name, x, y, width, height);
    		        
    		        treeContainers.add(node);
    			}
    		 }
    		formTree(treeContainers);
		} catch (IOException e) {
			System.out.println("ERROR: Failed to read storage file");
			e.printStackTrace();
		}
    	
    	for(int i=0; i<itemList.size(); i++) {
    		System.out.println(itemList.get(i));
    	}
    	
    	System.out.println(itemList.size());		
    }
    
    public void formTree(List<TreeItem<String>> treeContainers){
    	List<TreeItem<String>> addedContainers = new ArrayList<TreeItem<String>>();
    	//Set root node
		TreeItem<String> rootItem = new TreeItem<>("Root");
        rootItem.setExpanded(true);
        
    	TreeItem<String> parent;
    	TreeItem<String> child;
    	for(int i=0; i<treeContainers.size(); i++) {
    		parent = treeContainers.get(i);
    		for(int j=0; j<treeContainers.size(); j++) {
        		child = treeContainers.get(j);
        		for(int z=0; z<itemList.size(); z++) {
        			if(itemList.get(z).getName().equals(child.getValue())) {
        				String itemParent = ((ItemsClass) itemList.get(z)).getParent();
        				if((itemParent.equals(parent.getValue()))) {
            				if(addedContainers.indexOf(child) == -1) {
            					addedContainers.add(child);
            					parent.getChildren().add(child);
                				System.out.println("added to container");
            				}
            			}else if((itemParent.equals("Root"))) {
            				if(addedContainers.indexOf(child) == -1) {
            					addedContainers.add(child);
            					rootItem.getChildren().add(child);
                				System.out.println("added to root");
            				}
            			}
        			}
  
        		}
        		for(int y=0; y<containerList.size(); y++) {
        			if(((containerList.get(y)).getName().equals(child.getValue()))) {
        				String containerParent = (containerList.get(y)).getParent();
        				if(((containerParent.equals(parent.getValue())))) {
        					if(addedContainers.indexOf(child) == -1) {
            					addedContainers.add(child);
            					parent.getChildren().add(child);
                				System.out.println("added to container");
            				}
            			}else if((containerParent.equals("Root"))) {
            				if(addedContainers.indexOf(child) == -1) {
            					addedContainers.add(child);
            					rootItem.getChildren().add(child);
                				System.out.println("added to root");
            				}
            			}
        			}
        		}
        	}
    	}
    	
    	treeView.setRoot(rootItem);
    }

    /*
     * Function used to create new rectangles and text within and adds them to the dashboard.
     * Accepts a string that will match the label within the rectangle, and will be the rectangle and labels ID.
     * Accepts X and Y coordinates that will be used to place the rectangle on the dashboard.
     * Accepts width and height which will be used to make the rectangle to a specific size.
     */
    public void makeRectangle(String name, double x, double y, double width, double height){
        //Make sure the rectangles name doesn't have spaces
    	  name = name.replaceAll(" ", "_");
    	
    	  //The text up top of the rectangle
        Text text = new Text(name);

        // Drawing the Rectangle
        Rectangle rectangle = new Rectangle();

        // Set up all the properties of the rectangle.
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        rectangle.setId(name);

        // Set up all the properties of the label contained within the rectangle.
        text.setLayoutX(rectangle.getX() + 5);
        text.setLayoutY(rectangle.getY() + 10);
        text.setId(name+"text");

        // Add objects to the AnchorPane.
        Farm.getChildren().add(rectangle);
        Farm.getChildren().add(text);
    }

    /*
     * Function used to delete the rectangles and text within on the dashboard.
     * Accepts a string that will match the label and rectangle id.
     */
    public void deleteRectangle(String name){
        // Create a temp variable to use lookup() function to find the rectangle id.
        String temp = "#"+name.replaceAll(" ", "_");

        // Remove the rectangle and text based off the id.
        Farm.getChildren().remove(Farm.lookup(temp));
        Farm.getChildren().remove(Farm.lookup(temp+"text"));
    }

    //Printing out the Item Values when selecting each specific Item or Item Container
    public TreeItem<String> selectItem(){
        TreeItem<String> item = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();

        // Check to see if the selected item is a branch or leaf and show the respective commands.
        if(item.isLeaf()){
            this.itemCmds.setVisible(true);
            this.itemContCmds.setVisible(false);

        }else{
            this.itemCmds.setVisible(false);
            this.itemContCmds.setVisible(true);
        }

        // If drone is selected, show the "go home" button.
        if(item.getValue() == "Drone"){
            this.droneBtns2.setVisible(true);
        }else{
            this.droneBtns2.setVisible(false);
        }

        // Testing purposes.
        if(item != null){
            System.out.println(item.getValue());
            selectedItem = item.getValue();
        }

        /* 
         * Loops through the itemList to find the matching item name and displays 
         * the pruchase price and current market price to dashboard
        */
        for(int i=0; i<itemList.size();i++){
            if(item.getValue() == ((ItemsClass) itemList.get(i)).getName()){
                purchasePriceValue.setText("$"+Integer.toString(((ItemsClass) itemList.get(i)).getPrice())+".00");
                CurrentMarketValue.setText("$"+Integer.toString(((ItemsClass) itemList.get(i)).getCur_price())+".00");
            }
        }

        for(int i=0; i<containerList.size();i++){
            if(item.getValue() == ((ItemsClass) containerList.get(i)).getName()){
                purchasePriceValue.setText("$"+Integer.toString(((ItemsClass) containerList.get(i)).getPrice())+".00");
                CurrentMarketValue.setText("$"+Integer.toString(((ItemsClass) containerList.get(i)).getCur_price())+".00");
            }
        }

        return item;
    }
}
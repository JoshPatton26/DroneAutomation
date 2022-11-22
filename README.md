# Drone Automation (Drone Farming)

Drone Automation (Drone Farming) Link to repository: https://github.com/JoshPatton26/DroneAutomation

HOW TO RUN:

To run this project you should have JavaFX set up with your IDE, as well as access to a DJI Tello Drone. 

We have done all our coding through Eclipse and VSCode, both of which can run the project just fine with no errors or warnings. The drone can be commanded using either IDE, however, we have not tested any other IDE's so test them at your own risk.

To begin, you will need to turn your drone on and get connected to the drone's respected WiFi. Once this is complete you can run the application and begin commanding the drone.

Do not fly the drone in dimly litted rooms, or anywhere where you will experience interference from anything such as other WiFI or Bluetooth emmiting devices as this will cause errors with the drone and make the drone land prematurely.

While using the application make sure that if you click any buttons that you have a TreeItem selected from the TreeView in the top left corner, otherwise you will get an NullPointerException. The application will continue to work but just keep this in mind while using.

ABOUT THE PROJECT:

This repository is part of a group project for CS420: Software Engineering course at The University of Alabama at Birmingham. My group consists of Eli Davis, Eric Dollar, Kodie Box, Joe Tiller, Josh Patton, John Tompkins, and Jesus Zubia. 

The purpose of this repository is to create a software and application to automate a drone to perform farming tasks. These tasks consist actions such as planting seeds, fertilizing crops, monitoring crops, locate water sources, locate land features, locate hazards, or locate livestock. 

We are using a Telo drone for this project and are writing everything in Java for the software and JavaFX for the application.

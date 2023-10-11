package Lab2;
import java.io.IOException;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;
public class FXDriver extends Application {


/**

* The main method for the GUI example program JavaFX version

* @param args not used

* @throws IOException

*/

public static void main(String[] args) {

launch(args); 

}


@Override

public void start(Stage stage) throws IOException {

//student Task #1:

// instantiate the FXMainPane, name it root

FXMainPane root = new FXMainPane();


// create a scene and set it to hold root

Scene scene = new Scene(root, 400, 200); // Set the width and height as per your requirement


// set stage title

stage.setTitle("Hello World GUI");


// set the scene for the stage

stage.setScene(scene);


// display the stage

stage.show();

}

}
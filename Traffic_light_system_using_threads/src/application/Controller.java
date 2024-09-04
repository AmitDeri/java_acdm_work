// Name: Amit Deri; ID: 316443548

package application;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Controller {
	
	// Define each traffic light
    @FXML
    private Circle carRedLightNorth;
    @FXML
    private Circle carGreenLightNorth;
    @FXML
    private Rectangle pedestrianRedLightNorth;
    @FXML
    private Rectangle pedestrianGreenLightNorth;
    
    @FXML
    private Circle carRedLightSouth;
    @FXML
    private Circle carGreenLightSouth;
    @FXML
    private Rectangle pedestrianRedLightSouth;
    @FXML
    private Rectangle pedestrianGreenLightSouth;
    
    @FXML
    private Circle carRedLightEast;
    @FXML
    private Circle carGreenLightEast;
    @FXML
    private Rectangle pedestrianRedLightEast;
    @FXML
    private Rectangle pedestrianGreenLightEast;
    
    @FXML
    private Circle carRedLightWest;
    @FXML
    private Circle carGreenLightWest;
    @FXML
    private Rectangle pedestrianRedLightWest;
    @FXML
    private Rectangle pedestrianGreenLightWest;

    private TrafficLight trafficLightNorth;
    private TrafficLight trafficLightSouth;
    private TrafficLight trafficLightEast;
    private TrafficLight trafficLightWest;

    
    // Create new traffic light object for each traffic
    // (4 directions) 
    public void initialize() {
        trafficLightNorth = new TrafficLight();
        trafficLightSouth = new TrafficLight();
        trafficLightEast = new TrafficLight();
        trafficLightWest = new TrafficLight();
        
        // Start the synchronization threads here
        // each thread start the main from the beginning
        Thread carLightThread = new Thread(() -> carLightCycle());
        carLightThread.setDaemon(true);
        carLightThread.start();
        Thread pedestrianLightThread = new Thread(() -> pedestrianLightCycle());
        pedestrianLightThread.setDaemon(true);
        pedestrianLightThread.start();
    }

    
    // In this method we set the opposite traffic light to be 
    // in every color, meaning first North and South red and 
    // East and West green after that we let the thread for that 
    // colors to sleep and change the colors.
    private void carLightCycle() {
        try {
            while (true) {
                trafficLightNorth.setCarGreen(false);
                trafficLightSouth.setCarGreen(false);
                trafficLightEast.setCarGreen(true);
                trafficLightWest.setCarGreen(true);
                updateUI();
                Thread.sleep(3000); 

                trafficLightNorth.setCarGreen(true);
                trafficLightSouth.setCarGreen(true);
                trafficLightEast.setCarGreen(false);
                trafficLightWest.setCarGreen(false);
                updateUI();
                Thread.sleep(3000); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    // In this method we are creating the blinking effect 
    // using changing from green to white colors
    // this method sends the right traffic lights to the correct 
    // place North and South for the same method the same for 
    // East and West
    private void pedestrianLightCycle() {
        try {
            while (true) {
                boolean carLightsAreGreenVertical = trafficLightNorth.isCarGreen() || trafficLightSouth.isCarGreen();
                boolean carLightsAreGreenHorizontal = trafficLightEast.isCarGreen() || trafficLightWest.isCarGreen();

                if (carLightsAreGreenVertical) {
                    setPedestrianLightsVertical(Color.RED, Color.WHITE);
                } else {
                    setPedestrianLightsVertical(Color.WHITE, Color.GREEN);
                    Thread.sleep(200); // Blinking effect for pedestrian light
                    setPedestrianLightsVertical(Color.WHITE, Color.WHITE);
                    Thread.sleep(200);
                }

                if (carLightsAreGreenHorizontal) {
                    setPedestrianLightsHorizontal(Color.RED, Color.WHITE);
                } else {
                    setPedestrianLightsHorizontal(Color.WHITE, Color.GREEN);
                    Thread.sleep(200); // Blinking effect for pedestrian light
                    setPedestrianLightsHorizontal(Color.WHITE, Color.WHITE);
                    Thread.sleep(200);
                }
                
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }






    // This method apply the color on the circle and the rectangle 
    private void setPedestrianLightsVertical(Color redLightNorthSouth, Color greenLightNorthSouth) {
        pedestrianRedLightNorth.setFill(redLightNorthSouth);
        pedestrianGreenLightNorth.setFill(greenLightNorthSouth);
        pedestrianRedLightSouth.setFill(redLightNorthSouth);
        pedestrianGreenLightSouth.setFill(greenLightNorthSouth);
    }
    
    // This method apply the color on the circle and the rectangle
    private void setPedestrianLightsHorizontal(Color redLightEastWest, Color greenLightEastWest) {
        pedestrianRedLightEast.setFill(redLightEastWest);
        pedestrianGreenLightEast.setFill(greenLightEastWest);
        pedestrianRedLightWest.setFill(redLightEastWest);
        pedestrianGreenLightWest.setFill(greenLightEastWest);
    }

    
    // This method apply the colors on the pane at the application
    private void updateUI() {
        if (trafficLightNorth.isCarGreen()) {
            carRedLightNorth.setFill(Color.WHITE);
            carGreenLightNorth.setFill(Color.GREEN);
        } else {
            carRedLightNorth.setFill(Color.RED);
            carGreenLightNorth.setFill(Color.WHITE);
        }
        
        if (trafficLightSouth.isCarGreen()) {
            carRedLightSouth.setFill(Color.WHITE);
            carGreenLightSouth.setFill(Color.GREEN);
        } else {
            carRedLightSouth.setFill(Color.RED);
            carGreenLightSouth.setFill(Color.WHITE);
        }
        
        if (trafficLightEast.isCarGreen()) {
            carRedLightEast.setFill(Color.WHITE);
            carGreenLightEast.setFill(Color.GREEN);
        } else {
            carRedLightEast.setFill(Color.RED);
            carGreenLightEast.setFill(Color.WHITE);
        }
        
        if (trafficLightWest.isCarGreen()) {
            carRedLightWest.setFill(Color.WHITE);
            carGreenLightWest.setFill(Color.GREEN);
        } else {
            carRedLightWest.setFill(Color.RED);
            carGreenLightWest.setFill(Color.WHITE);
        }
    }
}

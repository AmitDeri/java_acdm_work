// Name: Amit Deri; ID: 316443548

package application;


// In this class we are define the boolean values that 
// will tell us if the color is green else is red 
// we can define the color to be green with set and get methods
public class TrafficLight {
    private boolean isCarGreen;
    private boolean isPedestrianGreen;

    public TrafficLight() {
        // Initialize the traffic light states
        isCarGreen = false;
        isPedestrianGreen = false;
    }

    public synchronized void setCarGreen(boolean green) {
        isCarGreen = green;
    }

    public synchronized void setPedestrianGreen(boolean green) {
        isPedestrianGreen = green;
    }

    public synchronized boolean isCarGreen() {
        return isCarGreen;
    }

    public synchronized boolean isPedestrianGreen() {
        return isPedestrianGreen;
    }
}

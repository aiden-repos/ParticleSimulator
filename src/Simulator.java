import Particles.*;

public class Simulator {
    public static void main(String[] args) {
        // Create an instance of the Electron class
        Electron electron = new Electron();

        // Print the properties of the electron
        System.out.println("Electron Properties:");
        System.out.println("Spin: " + electron.getSpin());
        System.out.println("Charge: " + electron.getCharge());
        System.out.println("Mass: " + electron.getMass());
        System.out.println("Radius: " + electron.getRadius());
        System.out.println("Color: " + electron.getColor());
    }
}
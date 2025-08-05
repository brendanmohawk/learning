package brendanddev.oop.interfaces;

/**
 * Represents a Smartphone device, which implements the Device interface.
 */
public class Smartphone implements Device {

    private String model;

    public Smartphone(String model) {
        this.model = model;
    }

    @Override
    public void turnOn() {
        System.out.println(model + " is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println(model + " is now OFF.");
    }


}

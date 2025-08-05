package brendanddev.oop.interfaces;

public class Main {

    public static void main(String[] args) {

        // Basic demo of the Device interface and Smartphone class
        Device phone = new Smartphone("iPhone 14");
        phone.turnOn();
        phone.turnOff();
    }
}

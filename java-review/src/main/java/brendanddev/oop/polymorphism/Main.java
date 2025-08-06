package brendanddev.oop.polymorphism;

public class Main {

    public static void main(String[] args) {

        // Create instance of Vehicle and its subclasses
        Vehicle genericVehicle = new Vehicle("Generic Vehicle");
        Vehicle car = new Car("Toyota Camry");
        Vehicle car2 = new Car("Honda Accord");
        Car car3 = new Car("Ford Focus");
        Vehicle boat = new Boat("Sailboat");
        Vehicle boat2 = new Boat("Speedboat");
        Boat boat3 = new Boat("Yacht");

        // Create an array of Vehicle objects
        // Each object can be of type Vehicle or any subclass like Car or Boat
        Vehicle[] vehicles = {genericVehicle, car, boat};
        Vehicle[] vehicles2 = {car2, boat2};
        Vehicle[] vehicles3 = {car3, boat3};

        for (Vehicle vehicle : vehicles) {
            // Call the drive method on each Vehicle object
            // This demonstrates polymorphism: the correct drive method is called based on the actual object type
            vehicle.drive();
        }

        for (Vehicle vehicle : vehicles2) {
            // Call the drive method on each Vehicle object
            vehicle.drive();
        }

        for (Vehicle vehicle : vehicles3) {
            // Call the drive method on each Vehicle object
            vehicle.drive();
        }
    }
}

package brendanddev.oop.interfaces;


/**
 * An interface is a completely "abstract class" that is used to group related methods with empty bodies
 * 
 * The Device interface defines basic operations that any device should have.
 * Classes implementing this interface must provide their own versions of these methods.
 */
public interface Device {
    
    /**
     * Turns the device on.
     */
    void turnOn();

    /**
     * Turns the device off.
     */
    void turnOff();
    
}

package gui.utils;

public interface PixInterface {

    public void keyRegister();
    // Checks if a key is valid and registers it.

    public  boolean keyPortabilityRequest();
    // Requests the key portability.

    public  boolean keyRemove();
    // Removes a key.

    public String randomKeyGen();
    // Generates a random key.

    public boolean validateKey();
    // Checks if a key is valid.

    public boolean toSchedule();
    // Schedules a payment.

    public boolean scheduleCancel();
    // Cancels a schedule.

    public boolean demand();
    // Demands a payment.

    public boolean transfer();
    // Transfers money between accounts.

    public boolean giveBack();
    // Give back money to sender account.

}

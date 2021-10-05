package comands;

import exeptions.CollectioIsEmptyExeption;
import networking.Reciver;
import networking.Sender;
import system.Parcel;

/**
 * SumOfSalary command returns sum of all salary fields from collection
 */
public class SumOfSalary {

    /**
     * Executes command.
     */
    public static void sumOfSalary() {
        Parcel parcel = new Parcel("sum_of_salary");
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        String str = Reciver.reciver(sender.getS());
        System.out.println(str);
    }
}

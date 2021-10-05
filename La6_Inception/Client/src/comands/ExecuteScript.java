package comands;

import exeptions.ScriptErrorExeption;
import exeptions.ScriptReqursionExeption;
import networking.Reciver;
import networking.Sender;
import system.Parcel;


import java.util.ArrayList;

/**
 * ExecuteScript executes script from a file.
 */
public class ExecuteScript {


    /**
     * Executes the command.
     *
     * @param fillname faille with the script
     * @throws ScriptReqursionExeption
     * @throws ScriptErrorExeption
     */
    public static void executeScript(String fillname) {
        Parcel parcel = new Parcel("execute_script", fillname);
        Sender sender = new Sender();
        sender.sendToServer(parcel);
        Reciver.scriptReciver(sender.getS(), fillname);
    }


}

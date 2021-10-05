package comands;

import exeptions.ScriptErrorExeption;
import exeptions.ScriptReqursionExeption;
import networking.Hub;
import system.Coll;
import system.FilleOperation;

import java.util.ArrayList;

/**
 * ExecuteScript executes script from a file.
 */
public class ExecuteScript {

    private static ArrayList<String> scripts = new ArrayList<String>();

    /**
     * Executes the command.
     *
     * @param fillname   faille with the script
     * @param collection the collection the script is applied to
     * @param storage    faille the collection is stored in
     * @throws ScriptReqursionExeption
     * @throws ScriptErrorExeption
     */
    public static boolean executeScript(String fillname, Coll collection, String storage, Hub hub) throws ScriptReqursionExeption, ScriptErrorExeption {

        for (String scr : scripts) {
            if (scr.equals(fillname)) throw new ScriptReqursionExeption();
        }
        scripts.add(fillname);
        boolean t = FilleOperation.script(fillname, collection, storage, hub);
        scripts.remove(scripts.size() - 1);
        return t;


    }

    public static void deleteScripts() {
        scripts.clear();
    }

}

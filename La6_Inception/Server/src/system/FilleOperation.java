package system;

import exeptions.*;
import networking.Hub;

import java.io.*;
import java.beans.Encoder;
import java.beans.Expression;
import java.beans.PersistenceDelegate;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Class for all interactions with file input or output.
 */
public class FilleOperation {

    /**
     * Saves collection into given file.
     *
     * @param collection collection that needs to be saved.
     * @param fillename  name of file in witch collection will be saved.
     * @throws FileNotFoundException
     */
    public static void save_into_file(Coll collection, String fillename) throws FileNotFoundException {
        try {
            File file = new File(fillename);
            if (!file.exists()) throw new FileDoesntExistExeption();
            if (file.isDirectory()) throw new FileIsDirectoryExeption();
            if (!file.canWrite()) throw new UserRightsExeption();
            FileOutputStream out = new FileOutputStream(fillename);
            XMLEncoder xmlEncoder = new XMLEncoder(out);
            xmlEncoder.setPersistenceDelegate(LocalDateTime.class,
                    new PersistenceDelegate() {
                        @Override
                        protected Expression instantiate(Object obj, Encoder encdr) {
                            LocalDateTime localDateTime = (LocalDateTime) obj;
                            return new Expression(localDateTime,
                                    LocalDateTime.class,
                                    "of",
                                    new Object[]{localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond()});
                        }
                    });

            xmlEncoder.setPersistenceDelegate(LocalDateTime.class,
                    new PersistenceDelegate() {
                        @Override
                        protected Expression instantiate(Object obj, Encoder encdr) {
                            LocalDateTime localDateTime = (LocalDateTime) obj;
                            return new Expression(localDateTime,
                                    LocalDateTime.class,
                                    "of",
                                    new Object[]{localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond()});
                        }
                    });


            xmlEncoder.setPersistenceDelegate(LocalDate.class,
                    new PersistenceDelegate() {
                        @Override
                        protected Expression instantiate(Object obj, Encoder encdr) {
                            LocalDate localDate = (LocalDate) obj;
                            return new Expression(localDate,
                                    LocalDate.class,
                                    "of",
                                    new Object[]{localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()});
                        }
                    });


            xmlEncoder.writeObject(collection);
            xmlEncoder.close();
        } catch (FileDoesntExistExeption e) {
            System.out.println("Файл для сохранения не существует!");
        } catch (FileIsDirectoryExeption e) {
            System.out.println("Файл для сохранения является дерикотрией!");
        } catch (UserRightsExeption e) {
            System.out.println("У вас нет прав на запись в файл сохранения!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл для сохранения не найден!");
        } catch (IOException exception) {
            System.out.println("Файл для сохранения не может быть открыт!");
        }

    }


    /**
     * Acquires collection from a file.
     *
     * @param filleName name of file in witch collection is stored.
     * @return Coll type collection
     * @throws FileNotFoundException
     */
    public static Coll getFromFile(String filleName) throws FileNotFoundException {
        Object coll = new Object();
        Coll collection = new Coll();
        try {
            File file = new File(filleName);
            if (!file.exists()) throw new FileDoesntExistExeption();
            if (file.isDirectory()) throw new FileIsDirectoryExeption();
            if (!file.canRead()) throw new UserRightsExeption();
            FileInputStream in = new FileInputStream(filleName);
            XMLDecoder decoder = new XMLDecoder(in);
            coll = decoder.readObject();
            collection = (Coll) coll;
            decoder.close();
            return collection;
        } catch (FileDoesntExistExeption e) {
            System.out.println("Файл для сохранения не существует!");
            System.exit(0);
        } catch (FileIsDirectoryExeption e) {
            System.out.println("Файл для сохранения является дерикотрией!");
            System.exit(0);
        } catch (UserRightsExeption e) {
            System.out.println("У вас нет прав на чтение из файла!");
            System.exit(0);
        } catch (FileNotFoundException e) {
            System.out.println("Загрузочный файл не найден!");
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Загрузочный файл пуст или в нем хранится не коллекция!");
            System.exit(0);
        } catch (ClassCastException e) {
            System.out.println("В загрузочном файле хранится не коллекция!");
            System.exit(0);
        }

        return collection;
    }

    /**
     * Starts script execution from a file.
     *
     * @param fillname   name of file with script.
     * @param collection collection upon witch the script should be executed.
     * @param fillename  name of file in witch collection is stored.
     * @throws ScriptReqursionExeption
     * @throws ScriptErrorExeption
     */
    public static boolean script(String fillname, Coll collection, String fillename, Hub hub) throws ScriptReqursionExeption, ScriptErrorExeption {
        try {
            File f = new File(fillname);
            if (!f.exists()) throw new FileDoesntExistExeption();
            if (f.isDirectory()) throw new FileIsDirectoryExeption();
            if (!f.canRead()) throw new UserRightsExeption();
            Scanner in = new Scanner(f);
            boolean t = UserInteraction.getComandScript(in, collection, fillename, hub);
            return t;
        } catch (FileDoesntExistExeption e) {
            hub.sender("Файл не существует!");
        } catch (FileIsDirectoryExeption e) {
            hub.sender("Файл является дерикотрией!");
        } catch (UserRightsExeption e) {
            hub.sender("У вас нет прав на чтение из файла!");
        } catch (FileNotFoundException e) {
            hub.sender("Файл со скриптом не найден!");
        }
        return true;
    }
}

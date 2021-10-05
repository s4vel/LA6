import exeptions.NoSaveFileExeption;
import networking.Hub;
import system.*;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class La6Server {

    public static void main(String args[]) {
        try {
            if (args.length == 0) throw new NoSaveFileExeption();
            String filename = args[0];
            Coll collection = FilleOperation.getFromFile(filename);
            collection.setLastInitTime(LocalDateTime.now());
            Hub hub = new Hub();
            History history = new History();
            Scanner scanner = new Scanner(System.in);
            new Thread(() ->
            {
                while (true) {
                    if (UserInteraction.getServerComand(scanner, collection, filename)) {
                        hub.close();
                        System.out.println("Работа сервера завершина!");
                        System.exit(0);
                    }
                }
            }
            ).start();
            boolean t = true;
            while (t) {
                Parcel parcel = hub.reciver();
                if (parcel.getComName() != null) {
                    UserInteraction.getComand(parcel, collection, "TENET.xml", hub, history);
                }
            }
        } catch (NoSaveFileExeption e) {
            System.out.println("Необходимо при запуске програмы в аргументах указать файл для загрузки!");
        } catch (FileNotFoundException e) {
            System.out.println("Загрузочный файл не найден");
        }

    }

}

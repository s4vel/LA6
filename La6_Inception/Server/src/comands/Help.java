package comands;

import networking.Hub;

/**
 * Help command returns the list of commands user can use
 */
public class Help {

    /**
     * Executes the command.
     */
    public static void helpcomand(Hub hub) {
        hub.sender("add {element} - добавляет элемент в коллекцию\n"
                + "info - выводит информацию о коллекции\n"
                + "show - выводит все элементы коллекци в строковом формате\n"
                + "update (id) {element} - обновляет элемент колекции по его id\n"
                + "remove_by_id (id) - удаляет элемент коллекции по его id\n"
                + "clear - очищает коллекцию\n"
                + "execute_script (file_name) - выполняет программу из файла\n"
                + "exit - завершает работу программы без сохранения в файл\n"
                + "head - выводит первый элемент коллекции\n"
                + "remove_lower {element} - удаляет из коллекции все элементы, меньше чем заданный\n"
                + "history - выводит последние 8 команд (без их аргументов)\n"
                + "sum_of_salary - выводит сумму значений поля salary для всех элементов коллекции\n"
                + "min_by_id - выводит любой объект из коллекции, значение поля id которого является минимальным\n"
                + "count_greater_than_position (position) - выводит количество элементов, значение поля position которых больше заданного");
    }

}

package system;

import exeptions.*;
import collection_filler.*;

import java.io.Console;
import java.io.FileNotFoundException;
import java.text.*;

import comands.*;
import networking.Hub;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class witch interacts with user and script inputs.
 */
public class UserInteraction {


    /**
     * Gets Worker fields from user script.
     *
     * @param scanner scanner of script inputs.
     * @param id      ID of new worker.
     * @return new Worker element.
     * @throws ElementAddingInScriptExeption
     */
    public static Worker getElementScript(Scanner scanner, int id, Hub hub) throws ElementAddingInScriptExeption {
        Worker worker = new Worker();
        worker.setCreationDate(LocalDate.now());
        worker.setId(id);


        while (true) {

            try {
                String name = scanner.nextLine();
                if (name == "") throw new NotNullExeption();
                worker.setName(name);
                break;
            } catch (NotNullExeption e) {
                hub.sender("Поле имени должео быть заполнено");
                throw new ElementAddingInScriptExeption();
            }
        }

        Coordinates coordinates = new Coordinates();

        while (true) {

            try {
                String strX = scanner.nextLine();
                Long x = Long.parseLong(strX);
                if (x <= -327) throw new LowerThanShouldExeption();
                coordinates.setX(x);
                break;
            } catch (NumberFormatException e) {
                hub.sender("Координата X должна быть целым числом");
                throw new ElementAddingInScriptExeption();
            } catch (LowerThanShouldExeption e) {
                hub.sender("Координата X должна быть больше -327");
                throw new ElementAddingInScriptExeption();
            }
        }

        while (true) {

            try {
                String strY = scanner.nextLine();
                coordinates.setY(Long.parseLong(strY));
                break;
            } catch (NumberFormatException e) {
                hub.sender("Координата Y должна быть целым числом");
                throw new ElementAddingInScriptExeption();
            }
        }
        worker.setCoordinates(coordinates);


        while (true) {

            try {
                String strSalary = scanner.nextLine();
                float salary = Float.parseFloat(strSalary);
                if (salary <= 0) throw new LowerThanShouldExeption();
                worker.setSalary(salary);
                break;
            } catch (NumberFormatException e) {
                hub.sender("Зарлата должа быть целым числом");
                throw new ElementAddingInScriptExeption();
            } catch (LowerThanShouldExeption e) {
                hub.sender("Зарплаьа должна быть больше 0");
                throw new ElementAddingInScriptExeption();
            }
        }

        while (true) {

            try {
                String stringStartDate = scanner.nextLine();
                DateFormat dateFormat = new SimpleDateFormat("y/M/d");
                Date date = dateFormat.parse(stringStartDate);
                worker.setStartDate(date);
                break;

            } catch (ParseException e) {
                hub.sender("Дата должна быть в формате [год]/[месяц]/[день] :");
                throw new ElementAddingInScriptExeption();
            }
        }

        while (true) {

            try {
                String stringEndDate = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime endDate = LocalDateTime.parse(stringEndDate, formatter);
                worker.setEndDate(endDate);
                break;
            } catch (DateTimeParseException e) {
                hub.sender("Дату должна быть в формате [год]-[месяц]-[день] [часы]:[минуты]:[секунды] :");
                throw new ElementAddingInScriptExeption();
            }
        }

        boolean t = true;
        while (t) {

            String stringPosition = scanner.nextLine().trim();
            switch (stringPosition) {
                case ("LABORER"): {
                    worker.setPosition(Position.LABORER);
                    t = false;
                    break;
                }
                case ("ENGINEER"): {
                    worker.setPosition(Position.ENGINEER);
                    t = false;
                    break;
                }
                case ("HEAD_OF_DIVISION"): {
                    worker.setPosition(Position.HEAD_OF_DIVISION);
                    t = false;
                    break;
                }
                case ("HEAD_OF_DEPARTMENT"): {
                    worker.setPosition(Position.HEAD_OF_DEPARTMENT);
                    t = false;
                    break;
                }
                case ("DEVELOPER"): {
                    worker.setPosition(Position.DEVELOPER);
                    t = false;
                    break;
                }

                default: {
                    hub.sender("Введина должность не из списка!");
                    throw new ElementAddingInScriptExeption();
                }

            }
        }

        Organization organization = new Organization();

        while (true) {
            try {

                String orgName = scanner.nextLine();
                if (orgName == "") throw new NotNullExeption();
                if (orgName.length() > 1807) throw new ToLongExeption();
                organization.setFullName(orgName);
                break;
            } catch (NotNullExeption e) {
                hub.sender("У организации должео быть заполнено имя!");
                throw new ElementAddingInScriptExeption();

            } catch (ToLongExeption e) {
                hub.sender("В названии оргонизации должно быть меньше 1807 символов");
                throw new ElementAddingInScriptExeption();
            }
        }


        t = true;
        while (t) {

            String stringOrganizationType = scanner.nextLine().trim();
            switch (stringOrganizationType) {
                case ("COMMERCIAL"): {
                    organization.setType(OrganizationType.COMMERCIAL);
                    t = false;
                    break;
                }
                case ("PUBLIC"): {
                    organization.setType(OrganizationType.PUBLIC);
                    t = false;
                    break;
                }
                case ("GOVERNMENT"): {
                    organization.setType(OrganizationType.GOVERNMENT);
                    t = false;
                    break;
                }
                case ("TRUST"): {
                    organization.setType(OrganizationType.TRUST);
                    t = false;
                    break;
                }
                default: {
                    hub.sender("Введен тип организации не из списка!");
                    throw new ElementAddingInScriptExeption();
                }
            }

        }

        Address address = new Address();
        while (true) {
            try {

                String street = scanner.nextLine();
                if (street == "") throw new NotNullExeption();
                address.setStreet(street);
                break;
            } catch (NotNullExeption e) {
                hub.sender("Название улицы должно быть заполнено");
                throw new ElementAddingInScriptExeption();
            }
        }

        while (true) {

            try {
                String zip = scanner.nextLine();
                if (zip == "") throw new NotNullExeption();
                address.setZipCode(zip);
                break;
            } catch (NotNullExeption e) {
                hub.sender("Индекс должен быть заполнен");
                throw new ElementAddingInScriptExeption();
            }
        }


        organization.setOfficialAddress(address);

        worker.setOrganization(organization);

        return worker;
    }


    /**
     * Gets command from user inputs and starts it's execution.
     *
     * @param collection collection with witch user will operate.
     * @param fillname   name of file in witch collection is stored.
     */
    public static void getComand(Parcel parcel, Coll collection, String fillname, Hub hub, History history) {


        try {
            String comand = parcel.getComName();
            switch (comand) {

                case ("help"): {
                    history.add(comand);
                    Help.helpcomand(hub);
                    break;
                }

                case ("info"): {
                    history.add(comand);
                    Info.infoComand(collection, hub);
                    break;
                }

                case ("show"): {
                    history.add(comand);
                    Show.show(collection, hub);
                    break;
                }

                case ("add"): {
                    history.add(comand);
                    Add.addElement(collection, (Worker) parcel.getConArgs(), hub);
                    break;
                }


                case ("update"): {
                    history.add(comand);
                    UpdateID.updateID(collection, (Worker) parcel.getConArgs(), hub);
                    break;
                }

                case ("remove_by_id"): {
                    try {
                        history.add(comand);
                        int id = (Integer) parcel.getConArgs();
                        RemoveByID.removeByID(collection, id, hub);
                    } catch (NumberFormatException e) {
                        hub.sender("Необходимо ввести целое число");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        hub.sender("В одной строке с этой командой должнен быть введен ID ");
                    }
                    break;
                }

                case ("clear"): {
                    history.add(comand);
                    Clear.clear(collection, hub);
                    break;
                }


                case ("save"): {
                    history.add(comand);
                    Save.save(collection, fillname);
                    break;
                }

                case ("execute_script"): {
                    history.add(comand);
                    String f = parcel.getConArgs().toString();

                    try {
                        hub.sender("Исполняю скрипт из файла " + f);
                        ExecuteScript.executeScript(f, collection, fillname, hub);
                        hub.sender("Исполнение скрипта из файла " + f + " завершено");
                    } catch (ScriptReqursionExeption e) {
                        hub.sender("Скрипт не может быть рекурсивным!");
                        hub.sender("Исполнение скрипта из файла " + f + " завершено");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        hub.sender("В одной строке с этой командой должно быть введено название файла со скриптом!");
                        hub.sender("Исполнение скрипта из файла " + f + " завершено");
                    } catch (ScriptErrorExeption e) {
                        hub.sender("При исполнении скрипта произошла ошибка!");
                        hub.sender("Исполнение скрипта из файла " + f + " завершено");
                    }
                    ExecuteScript.deleteScripts();
                    break;
                }

                case ("head"): {
                    history.add(comand);
                    Head.head(collection, hub);
                    break;
                }

                case ("remove_lower"): {
                    history.add(comand);
                    RemoveLower.RemoveLower(collection, (Worker) parcel.getConArgs(), hub);
                    break;
                }

                case ("history"): {
                    String str = history.getStory();
                    history.add(comand);
                    hub.sender(str);
                    break;
                }

                case ("sum_of_salary"): {
                    history.add(comand);
                    SumOfSalary.sumOfSalary(collection, hub);
                    break;
                }

                case ("min_by_id"): {
                    history.add(comand);
                    MinByID.minById(collection, hub);
                    break;
                }

                case ("count_greater_than_position"): {
                    history.add(comand);
                    Position position = (Position) parcel.getConArgs();
                    try {
                        CountGreaterThanPosition.countGreaterThanPosition(collection, position, hub);
                    } catch (CollectioIsEmptyExeption e) {
                        hub.sender("Коллекция пуста!");
                    }

                    break;
                }

                default:
                    hub.sender("такой команды не существует, используйте команду help для получения инормации о существующих командах");
            }
        } catch (NoSuchElementException e) {
            hub.sender("Пользовательский ввод не обнаружен!");
        } catch (IllegalStateException e) {
            hub.sender("Непредвиденная ошибка!");
        }


    }

    /**
     * Gets command from user script and starts it's execution.
     *
     * @param scanner    scanner of script inputs.
     * @param collection collection with witch script will operate.
     * @param fillname   name of file in witch collection is stored.
     * @throws ScriptReqursionExeption
     * @throws ScriptErrorExeption
     */
    public static boolean getComandScript(Scanner scanner, Coll collection, String fillname, Hub hub) throws ScriptReqursionExeption, ScriptErrorExeption {
        History history = new History();

        while (scanner.hasNext()) {
            String strCom[] = scanner.nextLine().trim().split(" ", 2);
            String comand = strCom[0];
            switch (comand) {

                case ("help"): {
                    history.add(comand);
                    Help.helpcomand(hub);
                    break;
                }

                case ("info"): {
                    history.add(comand);
                    Info.infoComand(collection, hub);
                    break;
                }

                case ("show"): {
                    history.add(comand);
                    Show.show(collection, hub);
                    break;
                }

                case ("add"): {
                    history.add(comand);
                    try {
                        Add.addElement(collection, scanner, true, hub);
                    } catch (ElementAddingInScriptExeption e) {
                        hub.sender("Во время добавления элемента в коллекцию в скрипте была допущенна ошибка!");
                        throw new ScriptErrorExeption();
                    }
                    break;
                }

                case ("update"): {

                    try {
                        history.add(comand);
                        int id = Integer.parseInt(strCom[1].trim());
                        UpdateID.updateID(collection, id, scanner, true, hub);
                    } catch (ElementAddingInScriptExeption e) {
                        hub.sender("При введении лбновленного элемента в коллекцию в скрипте была допущенна ошибка!");
                        throw new ScriptErrorExeption();
                    } catch (NumberFormatException e) {
                        hub.sender("ID в команде update должно быть целым числом");
                        throw new ScriptErrorExeption();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        hub.sender("В одной строке с командой update должнен быть введен ID ");
                        throw new ScriptErrorExeption();
                    }

                    break;
                }

                case ("remove_by_id"): {
                    try {
                        history.add(comand);
                        int id = Integer.parseInt(strCom[1].trim());
                        RemoveByID.removeByID(collection, id, hub);
                    } catch (NumberFormatException e) {
                        hub.sender("ID в команде remove_by_id должен быть целым числом");
                        throw new ScriptErrorExeption();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        hub.sender("В одной строке с командой remove_by_id должнен быть введен ID ");
                        throw new ScriptErrorExeption();
                    }
                    break;
                }

                case ("clear"): {
                    history.add(comand);
                    Clear.clear(collection, hub);
                    break;
                }

                case ("execute_script"): {
                    history.add(comand);
                    try {
                        String f = strCom[1];
                        hub.sender("Исполняю скрипт из файла " + f);
                        boolean t = ExecuteScript.executeScript(f, collection, fillname, hub);
                        hub.sender("Исполнение скрипта из файла " + f + " завершено");
                        if (!t) return false;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        hub.sender("В одной строке с командой execute_script должно быть введено название файла со скриптом!");
                        throw new ScriptErrorExeption();
                    } catch (ScriptErrorExeption e) {
                        hub.sender("При исполнении скрипта была допущенна ошибка");
                    }

                    break;
                }

                case ("head"): {
                    history.add(comand);
                    Head.head(collection, hub);
                    break;
                }

                case ("remove_lower"): {
                    history.add(comand);
                    try {
                        RemoveLower.RemoveLower(collection, scanner, true, hub);
                    } catch (ElementAddingInScriptExeption e) {
                        hub.sender("Вовремя добавления элемента для сравнения в скрипте была допущенна ошибка!");
                        throw new ScriptErrorExeption();
                    }
                    break;
                }

                case ("history"): {
                    String str = history.getStory();
                    history.add(comand);
                    hub.sender(str);
                    break;
                }

                case ("sum_of_salary"): {
                    history.add(comand);
                    SumOfSalary.sumOfSalary(collection, hub);
                    break;
                }

                case ("min_by_id"): {
                    history.add(comand);
                    MinByID.minById(collection, hub);
                    break;
                }

                case ("count_greater_than_position"): {
                    history.add(comand);
                    boolean t = true;
                    Position position = Position.LABORER;
                    while (t) {
                        String stringPosition = scanner.nextLine();
                        switch (stringPosition) {
                            case ("LABORER"): {
                                position = Position.LABORER;
                                t = false;
                                break;
                            }
                            case ("ENGINEER"): {
                                position = Position.ENGINEER;
                                t = false;
                                break;
                            }
                            case ("HEAD_OF_DIVISION"): {
                                position = Position.HEAD_OF_DIVISION;
                                t = false;
                                break;
                            }
                            case ("HEAD_OF_DEPARTMENT"): {
                                position = Position.HEAD_OF_DEPARTMENT;
                                t = false;
                                break;
                            }
                            case ("DEVELOPER"): {
                                position = Position.DEVELOPER;
                                t = false;
                                break;
                            }
                            default:
                                hub.sender("Пзиция должна быть из списка!");
                        }
                    }
                    try {
                        CountGreaterThanPosition.countGreaterThanPosition(collection, position, hub);
                    } catch (CollectioIsEmptyExeption e) {
                        hub.sender("Коллекция пуста!");
                    }

                    break;
                }

                default:
                    hub.sender("такой команды не существует, используйте команду help для получения инормации о существующих командах");
            }

        }

        return true;
    }

    public static boolean getServerComand(Scanner scanner, Coll collection, String filename) {
        String str = scanner.nextLine();
        switch (str) {
            case ("save"): {
                Save.save(collection, filename);
                return false;
            }
            case ("exit"): {
                Save.save(collection, filename);
                return true;
            }
            default: {
                System.out.println("Такой команды не существует");
                return false;
            }
        }
    }
}

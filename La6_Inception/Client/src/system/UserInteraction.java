package system;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

import collection_filler.*;
import exeptions.*;
import comands.*;


/**
 * Class witch interacts with user inputs.
 */
public class UserInteraction {


    /**
     * Gets Worker fields from user inputs.
     *
     * @param scanner scanner of user inputs.
     * @param id      ID of new worker.
     * @return new Worker element.
     */
    public static Worker getElement(Scanner scanner, int id) {
        Worker worker = new Worker();
        worker.setCreationDate(LocalDate.now());
        worker.setId(id);
        while (true) {
            System.out.print("Введите имя: ");
            try {
                String name = scanner.nextLine();
                if (name == "") throw new NotNullExeption();
                worker.setName(name);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Это поле должео быть заполнено");
            }
        }

        Coordinates coordinates = new Coordinates();

        while (true) {
            System.out.print("Введите координату X: ");
            try {
                Long x = scanner.nextLong();
                if (x <= -327) throw new LowerThanShouldExeption();
                coordinates.setX(x);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число");
            } catch (LowerThanShouldExeption e) {
                System.out.println("Координата x должна быть больше -327");
            } catch (NoSuchElementException e) {
                System.out.println("IT's MOre then Long!");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.print("Введите координату Y: ");
            try {
                long y = scanner.nextLong();
                coordinates.setY(y);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число");
            } catch (NoSuchElementException e) {
                System.out.println("IT's MOre then Long!");
                scanner.nextLine();
            }
        }
        worker.setCoordinates(coordinates);


        while (true) {
            System.out.print("Введите зарплату: ");
            try {
                float salary = scanner.nextFloat();
                if (salary <= 0) throw new LowerThanShouldExeption();
                worker.setSalary(salary);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число");
            } catch (LowerThanShouldExeption e) {
                System.out.println("Зарплаьа должна быть больше 0");
            } catch (NoSuchElementException e) {
                System.out.println("IT's MOre then Float!");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.print("Введите дату начала в формате [год]/[месяц]/[день]: ");
            try {
                String stringStartDate = scanner.nextLine();
                DateFormat dateFormat = new SimpleDateFormat("y/M/d");
                Date date = dateFormat.parse(stringStartDate);
                worker.setStartDate(date);
                break;

            } catch (ParseException e) {
                System.out.println("необходимо ввести дату в формате [год]/[месяц]/[день] :");
            }
        }

        while (true) {
            System.out.print("Введите время конца в формате [год]-[месяц]-[день] [часы]:[минуты]:[секунды] - ");
            try {
                String stringEndDate = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime endDate = LocalDateTime.parse(stringEndDate, formatter);
                worker.setEndDate(endDate);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("необходимо ввести дату в формате [год]-[месяц]-[день] [часы]:[минуты]:[секунды] - ");
            }
        }

        boolean t = true;
        while (t) {
            System.out.print("Введите должность из списка " + Position.getString());
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
                    System.out.println("Введите название из списка!");
                }

            }
        }

        Organization organization = new Organization();

        while (true) {
            try {
                System.out.print("Введите название организации: ");
                String orgName = scanner.nextLine();
                if (orgName == "") throw new NotNullExeption();
                if (orgName.length() > 1807) throw new ToLongExeption();
                organization.setFullName(orgName);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Это поле должео быть заполнено");

            } catch (ToLongExeption e) {
                System.out.println("В названии оргонизации должно быть меньше 1807");
            }
        }


        t = true;
        while (t) {
            System.out.print("Введите тиа организации из списка " + OrganizationType.getString());
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
                    System.out.println("Введите тип из списка!");
                }
            }

        }

        Address address = new Address();
        while (true) {
            try {
                System.out.print("Укажите улицу: ");
                String street = scanner.nextLine();
                if (street == "") throw new NotNullExeption();
                address.setStreet(street);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Это поле должео быть заполнено");
            }
        }

        while (true) {
            System.out.print("Укажите индекс: ");
            try {
                String zip = scanner.nextLine();
                if (zip == "") throw new NotNullExeption();
                address.setZipCode(zip);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Это поле должео быть заполнено");
            }
        }


        organization.setOfficialAddress(address);

        worker.setOrganization(organization);

        return worker;
    }


    /**
     * Gets command from user inputs and starts it's execution.
     *
     * @param scanner scanner of user inputs.
     */
    public static void getComand(Scanner scanner) {


        boolean tr = true;
        while (tr) {
            try {
                String strCom[] = scanner.nextLine().trim().split(" ", 2);
                String comand = strCom[0];
                switch (comand) {

                    case ("help"): {
                        Help.helpcomand();
                        break;
                    }

                    case ("info"): {
                        Info.infoComand();
                        break;
                    }

                    case ("show"): {
                        Show.show();
                        break;
                    }

                    case ("add"): {
                        Add.addElement(scanner);
                        break;
                    }

                    case ("update"): {

                        try {
                            int id = Integer.parseInt(strCom[1].trim());
                            UpdateID.updateID(id, scanner);
                        } catch (NumberFormatException e) {
                            System.out.println("Необходимо ввести целое число");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("В одной строке с этой командой должнен быть введен ID ");
                        }

                        break;
                    }

                    case ("remove_by_id"): {
                        try {
                            int id = Integer.parseInt(strCom[1].trim());
                            RemoveByID.removeByID(id);
                        } catch (NumberFormatException e) {
                            System.out.println("Необходимо ввести целое число");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("В одной строке с этой командой должнен быть введен ID ");
                        }
                        break;
                    }

                    case ("clear"): {
                        Clear.clear();
                        break;
                    }

                    case ("execute_script"): {
                        try {
                            String f = strCom[1].trim();
                            ExecuteScript.executeScript(f);
                            break;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("В одной строке с этой командой должно быть введено название файла ");
                        }
                        break;
                    }

                    case ("exit"): {
                        scanner.close();
                        tr = false;
                        break;
                    }

                    case ("head"): {
                        Head.head();
                        break;
                    }

                    case ("remove_lower"): {
                        RemoveLower.removeLower(scanner);
                        break;
                    }

                    case ("history"): {
                        History.history();
                        break;
                    }

                    case ("sum_of_salary"): {
                        SumOfSalary.sumOfSalary();
                        break;
                    }

                    case ("min_by_id"): {
                        MinByID.minById();
                        break;
                    }

                    case ("count_greater_than_position"): {
                        boolean t = true;
                        Position position = Position.LABORER;
                        while (t) {
                            System.out.println("Введите позицию из списка: " + Position.getString());
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
                                    System.out.println("Пзиция должна быть из списка!");
                            }
                        }
                        CountGreaterThanPosition.countGreaterThanPosition(position);
                        break;
                    }

                    default:
                        System.out.println("такой команды не существует, используйте команду help для получения инормации о существующих командах");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Пользовательский ввод не обнаружен!");
                tr = false;
            } catch (IllegalStateException e) {
                System.out.println("Непредвиденная ошибка!");
            }
        }


    }


}


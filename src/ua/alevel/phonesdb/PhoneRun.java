package ua.alevel.phonesdb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PhoneRun {

    private PhoneController controller = new PhoneController();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void run() {
        createSomeBase();

        try {

            while (true) {

                System.out.println("\nChoose action, please: ");
                System.out.println("1 - add new phone");
                System.out.println("2 - update phone");
                System.out.println("3 - delete phone");
                System.out.println("4 - see some phones by criteria\n");

                String input = reader.readLine();

                switch (input) {
                    case "1":
                        addPhone(reader);
                        break;
                    case "2":
                        updatePhone(reader);
                        break;
                    case "3":
                        deletePhone(reader);
                        break;
                    case "4":
                        /*  many variants of queries  */
                        searchPhones(reader);
                        break;
                    case "q":
                        System.out.println("Exit!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Input 'q' to quit.\n");
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createSomeBase() {
        Phone p1 = new Phone("Apple", "IPhone 11 PRO",
                128, 900, 6.2, "Green");
        Phone p2 = new Phone("Nokia", "Asha 501",
                4, 50, 3.5, "Yellow");
        Phone p3 = new Phone("Apple", "Iphone 5s",
                16, 300, 4, "Space Gray");
        Phone p4 = new Phone("Xiaomi", "Note 4",
                16, 300, 5, "Black");
        Phone p5 = new Phone("Apple", "IPhone 6",
                16, 400, 4.7, "Rose Gold");

        controller.create(p1);
        controller.create(p2);
        controller.create(p3);
        controller.create(p4);
        controller.create(p5);
        showAll();
    }

    private void showAll() {
        System.out.println("");
        List<Phone> all = controller.findAll();
        all.forEach(System.out::println);
    }

    private void show(List<Phone> all) {
        System.out.println("");
        all.forEach(System.out::println);
    }

    private void addPhone(BufferedReader reader) {
        Phone phone = new Phone();
        System.out.println("Creating new phone...");

//            private String companyName;
//            private String model;
//            private int storageMemory;
//            private double price;
//            private double screenDiagonal;
//            private String color;

        try {
            System.out.print("Input phone's company name: ");
            String input = reader.readLine();
            phone.setCompanyName(input);

            System.out.print("Input phone's model name: ");
            input = reader.readLine();
            phone.setModel(input);

            System.out.print("Input phone's storage memory (GB): ");
            input = reader.readLine();
            phone.setStorageMemory(Integer.parseInt(input));

            System.out.print("Input phone's price ($): ");
            input = reader.readLine();
            phone.setPrice(Double.parseDouble(input));

            System.out.print("Input phone's screen diagonal: ");
            input = reader.readLine();
            phone.setScreenDiagonal(Double.parseDouble(input));

            System.out.print("Input phone's color: ");
            input = reader.readLine();
            phone.setColor(input);

        } catch (IOException e) {
            e.printStackTrace();
        }

        controller.create(phone);
        showAll();
    }

    private void updatePhone(BufferedReader reader) {
        Phone phone = new Phone();
        System.out.println("Updating phone...");

        try {
            System.out.print("Input phone's ID: ");
            String id = reader.readLine();
            phone.setID(Integer.parseInt(id));

            System.out.print("Input phone's company name: ");
            String input = reader.readLine();
            phone.setCompanyName(input);

            System.out.print("Input phone's model name: ");
            input = reader.readLine();
            phone.setModel(input);

            System.out.print("Input phone's storage memory (GB): ");
            input = reader.readLine();
            phone.setStorageMemory(Integer.parseInt(input));

            System.out.print("Input phone's price ($): ");
            input = reader.readLine();
            phone.setPrice(Double.parseDouble(input));

            System.out.print("Input phone's screen diagonal: ");
            input = reader.readLine();
            phone.setScreenDiagonal(Double.parseDouble(input));

            System.out.print("Input phone's color: ");
            input = reader.readLine();
            phone.setColor(input);

        } catch (IOException e) {
            e.printStackTrace();
        }

        controller.update(phone);
        showAll();
    }

    private void deletePhone(BufferedReader reader) {
        String id = "";
        System.out.println("Deleting phone...");

        try {
            System.out.print("Input phone's ID: ");
            id = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        controller.delete(Integer.parseInt(id));
        showAll();
    }

    private void searchPhones(BufferedReader reader) {
        System.out.println("Searching phones...");
        System.out.println("Choose criteria, please: ");
        System.out.println("0 - Phone's ID");
        System.out.println("1 - Company name");
        System.out.println("2 - Model");
        System.out.println("3 - Storage memory");
        System.out.println("4 - Price");
        System.out.println("5 - Screen diagonal (range)");
        System.out.println("6 - Screen diagonal (definite)");
        System.out.println("7 - Color");
        System.out.println("8 - show all");
        System.out.println("9 - few parameters\n");

        try {
            String input = reader.readLine();
            switch (input) {
                case "0":
                    System.out.println(findPhone(reader).toString());
                    break;
                case "1":
                    show(findByCompany(reader));
                    break;
                case "2":
                    show(findByModel(reader));
                    break;
                case "3":
                    show(findByStorageMemoryFrom(reader));
                    break;
                case "4":
                    show(findByPriceFromTo(reader));
                    break;
                case "5":
                    show(findByScreenDiagonalFrom(reader));
                    break;
                case "6":
                    show(findByScreenDiagonal(reader));
                    break;
                case "7":
                    show(findByColor(reader));
                    break;
                case "8":
                    showAll();
                    break;
                case "9":
                    show(findByFewParameters(reader));
                    break;
                case "q":
                    System.out.println("Exit!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input 'q' to quit.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Phone findPhone(BufferedReader reader) {
        String id = "";
        try {
            System.out.print("Input phone's ID: ");
            id = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return controller.findById(Integer.parseInt(id));
    }

    private List<Phone> findByCompany(BufferedReader reader) {
        String company = "";
        try {
            System.out.print("Input phone's company name: ");
            company = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return controller.findByCompany(company);
    }

    private List<Phone> findByModel(BufferedReader reader) {
        String model = "";
        try {
            System.out.print("Input phone's model name: ");
            model = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return controller.findByModel(model);
    }

    private List<Phone> findByStorageMemoryFrom(BufferedReader reader) {
        String storageMemory = "";
        try {
            System.out.print("Input minimal phone's storage memory: ");
            storageMemory = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return controller.findByStorageMemoryFrom(Integer.parseInt(storageMemory));
    }

    private List<Phone> findByPriceFromTo(BufferedReader reader) {
        String min = "";
        String max = "";

        try {
            System.out.print("Input minimal phone's price: ");
            min = reader.readLine();
            System.out.print("Input maximal phone's price: ");
            max = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return controller.findByPriceFromTo(Integer.parseInt(min), Integer.parseInt(max));
    }

    private List<Phone> findByScreenDiagonalFrom(BufferedReader reader) {
        String min = "";

        try {
            System.out.print("Input minimal phone's screen diagonal: ");
            min = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return controller.findByScreenDiagonalFrom(Integer.parseInt(min));
    }

    private List<Phone> findByScreenDiagonal(BufferedReader reader) {
        String screenDiagonal = "";
        try {
            System.out.print("Input phone's screen diagonal: ");
            screenDiagonal = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return controller.findByScreenDiagonal(Double.parseDouble(screenDiagonal));
    }

    private List<Phone> findByColor(BufferedReader reader) {
        String color = "";
        try {
            System.out.print("Input phone's color: ");
            color = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return controller.findByColor(color);
    }

    private List<Phone> findByFewParameters(BufferedReader reader) {
        List<Phone> byCompanyName = new ArrayList<>();
        List<Phone> byModel = new ArrayList<>();
        List<Phone> byMemory = new ArrayList<>();
        List<Phone> byPrice = new ArrayList<>();
        List<Phone> byDiagonal = new ArrayList<>();
        List<Phone> byColor = new ArrayList<>();

        try {
            System.out.println("Parameters are: ");
            System.out.println("1 - Company name");
            System.out.println("2 - Model");
            System.out.println("3 - Storage memory");
            System.out.println("4 - Price");
            System.out.println("5 - Screen diagonal (range)");
            System.out.println("6 - Color");
            System.out.print("\nInput parameters' numbers: ");

            String input = reader.readLine();

            if (input.contains("1")) {
                byCompanyName = findByCompany(reader);
            } else {
                byCompanyName.clear();
            }
            if (input.contains("2")) {
                byModel = findByModel(reader);
            } else {
                byModel.clear();
            }
            if (input.contains("3")) {
                byMemory = findByStorageMemoryFrom(reader);
            } else {
                byMemory.clear();
            }
            if (input.contains("4")) {
                byPrice = findByPriceFromTo(reader);
            } else {
                byPrice.clear();
            }
            if (input.contains("5")) {
                byDiagonal = findByScreenDiagonalFrom(reader);
            } else {
                byDiagonal.clear();
            }
            if (input.contains("6")) {
                byColor = findByColor(reader);
            } else {
                byColor.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return controller.fewParameters(byCompanyName, byModel, byMemory, byPrice, byDiagonal, byColor);
    }

}

package ua.alevel.phonesdb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        show();
    }

    private void show() {
        System.out.println("");
        List<Phone> all = controller.findAll();
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
        show();
    }

    private void updatePhone(BufferedReader reader) {
        Phone phone = new Phone();
        System.out.println("Updating phone...");

//            private String companyName;
//            private String model;
//            private int storageMemory;
//            private double price;
//            private double screenDiagonal;
//            private String color;

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
        show();
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
        show();
    }

    private void searchPhones(BufferedReader reader) {
        System.out.println("Searching phones...");
        System.out.println("\nChoose criteria, please: ");
        System.out.println("0 - Phone's ID");
        System.out.println("1 - Company name");
        System.out.println("2 - Model");
        System.out.println("3 - Storage memory");
        System.out.println("4 - Price");
        System.out.println("5 - Screen diagonal (range)");
        System.out.println("6 - Screen diagonal (definite)");
        System.out.println("7 - Color");
        System.out.println("8 - show all");

        try {
            String input = reader.readLine();
            switch (input) {
                case "0":
                    findPhone(reader);
                    break;
                case "1":
                    findByCompany(reader);
                    break;
                case "2":
                    findByModel(reader);
                    break;
                case "3":
                    findByStorageMemoryFrom(reader);
                    break;
                case "4":
                    findByPriceFromTo(reader);
                    break;
                case "5":
                    findByScreenDiagonalFromTo(reader);
                    break;
                case "6":
                    findByScreenDiagonal(reader);
                    break;
                case "7":
                    findByColor(reader);
                    break;
                case "8":
                    show();
                    break;
                case "q":
                    System.out.println("Exit!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input 'q' to quit.\n");
//                    searchPhones(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void findPhone(BufferedReader reader) {
        String id = "";
//        System.out.println("Searching phone...");

        try {
            System.out.print("Input phone's ID: ");
            id = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(controller.findById(Integer.parseInt(id)).toString());
    }

    private void findByCompany(BufferedReader reader) {
        String company = "";
        try {
            System.out.print("Input phone's company name: ");
            company = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");
        List<Phone> all = controller.findByCompany(company);
        all.forEach(System.out::println);
    }

    private void findByModel(BufferedReader reader) {
        String model = "";
        try {
            System.out.print("Input phone's model name: ");
            model = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");
        List<Phone> all = controller.findByModel(model);
        all.forEach(System.out::println);
    }

    private void findByStorageMemoryFrom(BufferedReader reader) {
        String storageMemory = "";
        try {
            System.out.print("Input minimal phone's storage memory: ");
            storageMemory = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");
        List<Phone> all = controller.findByStorageMemoryFrom(Integer.parseInt(storageMemory));
        all.forEach(System.out::println);
    }

    private void findByPriceFromTo(BufferedReader reader) {
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

        System.out.println("");
        List<Phone> all = controller.findByPriceFromTo(Integer.parseInt(min), Integer.parseInt(max));
        all.forEach(System.out::println);

    }

    private void findByScreenDiagonalFromTo(BufferedReader reader) {
        String min = "";
        String max = "";

        try {
            System.out.print("Input minimal phone's screen diagonal: ");
            min = reader.readLine();
            System.out.print("Input maximal phone's screen diagonal: ");
            max = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");
        List<Phone> all = controller.findByScreenDiagonalFromTo(Integer.parseInt(min), Integer.parseInt(max));
        all.forEach(System.out::println);
    }

    private void findByScreenDiagonal(BufferedReader reader) {
        String screenDiagonal = "";
        try {
            System.out.print("Input phone's screen diagonal: ");
            screenDiagonal = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");
        List<Phone> all = controller.findByScreenDiagonal(Double.parseDouble(screenDiagonal));
        all.forEach(System.out::println);
    }

    private void findByColor(BufferedReader reader) {
        String color = "";
        try {
            System.out.print("Input phone's color: ");
            color = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("");
        List<Phone> all = controller.findByColor(color);
        all.forEach(System.out::println);
    }


}

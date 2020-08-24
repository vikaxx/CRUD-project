package ua.alevel.phonesdb;

import java.util.List;

public interface PhoneService {
    void create(Phone phone);
    void update(Phone phone);
    void delete (int id);
    Phone findById(int id);

//    private String companyName;
//    private String model;
//    private int storageMemory;
//    private double price;
//    private double screenDiagonal;
//    private String color;

    List<Phone> findAll();
    List<Phone> findByCompany(String companyName);
    List<Phone> findByModel(String model);
    List<Phone> findByStorageMemoryFrom(int storageMemory);
    List<Phone> findByPriceFromTo(int from, int to);
    List<Phone> findByScreenDiagonalFromTo(double from, double to);
    List<Phone> findByScreenDiagonal(double screenDiagonal);
    List<Phone> findByColor(String color);

//    List<Phone> findByCompanyAndModel(String companyName, String model);
//    List<Phone> findByCompanyAndModelAndColor(String companyName, String model, String color);
//    List<Phone> findByCompanyAndPriceFromTo(String companyName, int from, int to);
//    List<Phone> findByPriceAndColor(int from, int to, String color);
//    List<Phone> findByCompanyAndScreenDiagonal(String companyName, double screenDiagonal);
//    List<Phone> findByPriceAndScreenDiagonal(int from, int to, double screenDiagonal);
}

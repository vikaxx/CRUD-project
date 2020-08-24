package ua.alevel.phonesdb;

import java.util.List;

public interface PhoneDao {
    void create(Phone phone);
    void update(Phone phone);
    void delete (int id);
    Phone findById(int id);

    List<Phone> findAll();
    List<Phone> findByCompany(String companyName);
    List<Phone> findByModel(String model);
    List<Phone> findByStorageMemoryFrom(int storageMemory);
    List<Phone> findByPriceFromTo(int from, int to);
    List<Phone> findByScreenDiagonalFromTo(double from, double to);
    List<Phone> findByScreenDiagonal(double screenDiagonal);
    List<Phone> findByColor(String color);

    public List<Phone> fewParameters(List<Phone>... PHONES);
}

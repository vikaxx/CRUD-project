package ua.alevel.phonesdb;

import java.util.List;

public interface PhoneService {
    void create(Phone phone);
    void update(Phone phone);
    void delete (int id);
    Phone findById(int id);

    List<Phone> findAll();
    List<Phone> findByCompany(String companyName);
    List<Phone> findByModel(String model);
    List<Phone> findByStorageMemoryFrom(int storageMemory);
    List<Phone> findByPriceFromTo(int from, int to);
    List<Phone> findByScreenDiagonalFrom(double from);
    List<Phone> findByScreenDiagonal(double screenDiagonal);
    List<Phone> findByColor(String color);

    List<Phone> fewParameters(List<Phone>... PHONES);
}

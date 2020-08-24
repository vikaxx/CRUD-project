package ua.alevel.phonesdb;

import java.util.List;

public class PhoneController {

    private final PhoneService phoneService = new PhoneServiceImpl();

     
    public void create(Phone phone) {
//        int size = phoneService.findAll().size();
//        phone.setID(++size);
        phoneService.create(phone);
    }

     
    public void update(Phone phone) {
        phoneService.update(phone);
    }

     
    public void delete(int id) {
        phoneService.delete(id);
    }

     
    public Phone findById(int id) {
        return phoneService.findById(id);
    }


     
    public List<Phone> findAll() {
        return phoneService.findAll();
    }

     
    public List<Phone> findByCompany(String companyName) {
        return phoneService.findByCompany(companyName);
    }

     
    public List<Phone> findByModel(String model) {
        return phoneService.findByModel(model);
    }

     
    public List<Phone> findByPriceFromTo(int from, int to) {
        return phoneService.findByPriceFromTo(from, to);
    }

     
    public List<Phone> findByScreenDiagonalFrom(double from) {
        return phoneService.findByScreenDiagonalFrom(from);
    }

     
    public List<Phone> findByScreenDiagonal(double screenDiagonal) {
        return phoneService.findByScreenDiagonal(screenDiagonal);
    }

     
    public List<Phone> findByStorageMemoryFrom(int storageMemory) {
        return phoneService.findByStorageMemoryFrom(storageMemory);
    }

     
    public List<Phone> findByColor(String color) {
        return phoneService.findByColor(color);
    }

    public List<Phone> fewParameters(List<Phone>... PHONES) {
        return phoneService.fewParameters(PHONES);
    }
}

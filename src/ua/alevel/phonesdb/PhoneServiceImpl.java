package ua.alevel.phonesdb;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {

    private final PhoneDaoImpl phoneDao = new PhoneDaoImpl();

    @Override
    public void create(Phone phone) {
        int newID = phoneDao.getLastID();
        phone.setID(++newID);
        phoneDao.create(phone);
    }

    @Override
    public void update(Phone phone) {
        phoneDao.update(phone);
    }

    @Override
    public void delete(int id) {
        phoneDao.delete(id);
    }

    @Override
    public Phone findById(int id) {
        return phoneDao.findById(id);
    }


    @Override
    public List<Phone> findAll() {
        return phoneDao.findAll();
    }

    @Override
    public List<Phone> findByCompany(String companyName) {
        return phoneDao.findByCompany(companyName);
    }

    @Override
    public List<Phone> findByModel(String model) {
        return phoneDao.findByModel(model);
    }

    @Override
    public List<Phone> findByPriceFromTo(int from, int to) {
        return phoneDao.findByPriceFromTo(from, to);
    }

    @Override
    public List<Phone> findByScreenDiagonalFrom(double from) {
        return phoneDao.findByScreenDiagonalFrom(from);
    }

    @Override
    public List<Phone> findByScreenDiagonal(double screenDiagonal) {
        return phoneDao.findByScreenDiagonal(screenDiagonal);
    }

    @Override
    public List<Phone> findByStorageMemoryFrom(int storageMemory) {
        return phoneDao.findByStorageMemoryFrom(storageMemory);
    }

    @Override
    public List<Phone> findByColor(String color) {
        return phoneDao.findByColor(color);
    }

    @Override
    public List<Phone> fewParameters(List<Phone> byCompanyName, List<Phone> byModel,
                                     List<Phone> byMemory, List<Phone> byPrice,
                                     List<Phone> byDiagonal, List<Phone> byColor) {
        return phoneDao.fewParameters(byCompanyName, byModel, byMemory, byPrice, byDiagonal, byColor);
    }
}

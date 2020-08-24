package ua.alevel.phonesdb;

import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao {

    private List<Phone> phones = new ArrayList<>();

    @Override
    public void create(Phone phone) {
        phones.add(phone);
    }

    public int getLastID() {
        if (phones.size() == 0) {
            return 0;
        }
        Phone tmpPhone = phones.get(phones.size() - 1);
        return tmpPhone.getID();
    }

    @Override
    public void update(Phone phone) {
        boolean exist = false;
        for (Phone currentPhone : phones) {
            if (currentPhone.getID() == phone.getID()) {
                currentPhone.setCompanyName(phone.getCompanyName());
                currentPhone.setModel(phone.getModel());
                currentPhone.setPrice(phone.getPrice());
                currentPhone.setScreenDiagonal(phone.getScreenDiagonal());
                currentPhone.setStorageMemory(phone.getStorageMemory());
                currentPhone.setColor(phone.getColor());
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(int id) {
        boolean exist = false;
        for (Phone currentPhone : phones) {
            if (currentPhone.getID() == id) {
                phones.remove(currentPhone);
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new RuntimeException();
        }
    }


    @Override
    public Phone findById(int id) {
        boolean exist = false;
        for (Phone currentPhone : phones) {
            if (currentPhone.getID() == id) {
                return currentPhone;
            }
        }
        if (!exist) {
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public List<Phone> findAll() {
        return phones;
    }

    @Override
    public List<Phone> findByCompany(String companyName) {
        List<Phone> tmpPhones = new ArrayList<>();
        for (Phone currentPhone : phones) {
            if (currentPhone.getCompanyName().equals(companyName)) {
                tmpPhones.add(currentPhone);
            }
        }
        return tmpPhones;
    }

    @Override
    public List<Phone> findByModel(String model) {
        List<Phone> tmpPhones = new ArrayList<>();
        for (Phone currentPhone : phones) {
            if (currentPhone.getModel().equals(model)) {
                tmpPhones.add(currentPhone);
            }
        }
        return tmpPhones;
    }

    @Override
    public List<Phone> findByPriceFromTo(int from, int to) {
        List<Phone> tmpPhones = new ArrayList<>();
        for (Phone currentPhone : phones) {
            if (currentPhone.getPrice() >= from && currentPhone.getPrice() <= to) {
                tmpPhones.add(currentPhone);
            }
        }
        return tmpPhones;
    }

    @Override
    public List<Phone> findByScreenDiagonalFromTo(double from, double to) {
        List<Phone> tmpPhones = new ArrayList<>();
        for (Phone currentPhone : phones) {
            if (currentPhone.getScreenDiagonal() >= from && currentPhone.getScreenDiagonal() <= to) {
                tmpPhones.add(currentPhone);
            }
        }
        return tmpPhones;
    }

    @Override
    public List<Phone> findByScreenDiagonal(double screenDiagonal) {
        return findByScreenDiagonalFromTo(screenDiagonal, screenDiagonal);
    }

    @Override
    public List<Phone> findByStorageMemoryFrom(int storageMemory) {
        List<Phone> tmpPhones = new ArrayList<>();
        for (Phone currentPhone : phones) {
            if (currentPhone.getStorageMemory() >= storageMemory) {
                tmpPhones.add(currentPhone);
            }
        }
        return tmpPhones;
    }

    @Override
    public List<Phone> findByColor(String color) {
        List<Phone> tmpPhones = new ArrayList<>();
        for (Phone currentPhone : phones) {
            if (currentPhone.getColor().equals(color)) {
                tmpPhones.add(currentPhone);
            }
        }
        return tmpPhones;
    }

    public List<Phone> fewParameters(List<Phone>... PHONES) {
        List<Phone> tmpPhones = phones;
        for (Phone currentPhone : tmpPhones) {
            for (int i = 0; i < PHONES.length; i++) {
                if (!PHONES[i].contains(currentPhone)) {
                    tmpPhones.remove(currentPhone);
                }
            }
        }
        return tmpPhones;
    }

}

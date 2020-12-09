import java.util.*;

public class PhoneBook {

    private HashMap <String, ArrayList<Person>> addContact = new HashMap <>();

    public void addContact(String surName, String phoneNum, String eMail){

        ArrayList<Person> tempListPerson= new ArrayList();
        if(addContact.get(surName) != null){
            tempListPerson = addContact.get(surName);
            tempListPerson.add(new Person(surName, phoneNum, eMail));
        }
        else{
            tempListPerson.add(new Person(surName, phoneNum, eMail));
        }
        addContact.put(surName, tempListPerson);
    }

    public ArrayList find_E_Mail(String surName){
        ArrayList<String> result = new ArrayList<>();
        for (Person item : addContact.get(surName)) {
            result.add(item.addeMail());
        }
        return result;
    }

    public ArrayList find_phone(String surName){
        ArrayList<String> result = new ArrayList<>();
        for (Person item : addContact.get(surName)) {
            result.add(item.addPhone());
        }
        return result;
    }
}

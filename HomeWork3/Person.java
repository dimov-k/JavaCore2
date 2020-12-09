public class Person {

    private String surName;
    private String phoneNum;
    private String eMail;

    Person(String surName, String phoneNum, String eMail){
        this.surName = surName;
        this.phoneNum = phoneNum;
        this.eMail = eMail;
    }

    public String getSurName() {
        return surName;
    }

    public String addPhone() {
        return phoneNum;
    }

    public String addeMail() {
        return eMail;
    }


}

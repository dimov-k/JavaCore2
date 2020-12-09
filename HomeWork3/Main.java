import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] randomWords = {
                "Become", "obsolete", "Europeans", "Evenki", "Haunting", "Бар", "Hitherto", "Kadit", "Kind of Maternal", "Starter", "Tsigeika",
                "Chock", "Starter", "Consultant", "Extern", "Frozen", "Lexicologist", "Haunting", "Бар", "Mythic", "Polesie", "Pond", "Splashing", "Strekot",
                "Бар", "Зимовать", "Лохмы", "Откуда-нибудь", "Подлесок", "obsolete", "Пробряцать", "Разор", "Подлесок", "Сварщик", "Зимовать", "Сговориться", "Утонуть"
        };
        HashMap<String, Integer> words = new HashMap<>();
        for (String x : randomWords) {
            words.put(x, words.getOrDefault(x, 0) + 1);
        }
        System.out.println("Слова:\n" + words);



        PhoneBook book = new PhoneBook();
        book.addContact("Смольный", "8(916)415-88-00", "test@gmail.com");
        book.addContact("Иванов", "8(920)653-78-96", "test2@gmail.com");
        book.addContact("Цукербер", "8(995)300-01-00", "test3@gmail.com");
        book.addContact("Смольный", "8(900)995-66-99","test4@gmail.com");
        book.addContact("Задорнов", "8(915)413-20-76","test5@gmail.com");
        book.addContact("Маск", "8(918)212-05-26","test7@gmail.com");

        System.out.println("\n***********PhoneBook************\n");
        System.out.println("\nПервый Контакт:\n");
        String surName = "Смольный";
        System.out.println("Фамилия:" + surName + "\nДоступные Номера:" +  book.find_phone(surName) + "\nДоступные Почты:"+ book.find_E_Mail(surName));

        System.out.println("\nВторой Контакт:\n");
         surName = "Маск";
        System.out.println("Фамилия:" + surName + "\nДоступные Номера:" +  book.find_phone(surName) + "\nДоступные Почты:"+ book.find_E_Mail(surName));
    }
}

package exercise;

import java.util.List;

public class App {
    public static Long getCountOfFreeEmails(List<String> emails) {
        long countOfmails = emails.stream()
                .filter(mail -> (mail.endsWith("gmail.com") || mail.endsWith("yandex.ru")
                        || mail.endsWith("hotmail.com")))
                .count();
        return countOfmails;
    }
}

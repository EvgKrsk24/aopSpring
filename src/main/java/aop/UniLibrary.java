package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {
    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary ");
        System.out.println("------------------------------------------");
    }

    public String returnBook() {
        int a = 10/0;
        System.out.println("Возвращаем книгу UniLibrary");
        return "Война и мир";

    }

    public void getMagazin() {
        System.out.println("Мы берем журнал из UniLibrary ");
        System.out.println("------------------------------------------");
    }

    public void returnMagazin() {
        System.out.println("Мы возвращаем журнал в UniLibrary ");
        System.out.println("------------------------------------------");
    }

    public void addBook(String person_name, Book book) {
        System.out.println("Мы добавляем книгу в UniLibrary ");
        System.out.println("------------------------------------------");
    }

    public void addMagazin() {
        System.out.println("Мы добавляем журнал в UniLibrary ");
        System.out.println("------------------------------------------");
    }
}

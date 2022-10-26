package Manager;

import Entity.Author;
import Entity.Book;
import Entity.History;
import Entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class HistoryManager {
    private final Scanner scanner;

    private Book[] books;

    public HistoryManager() {
        scanner = new Scanner(System.in);
    }

    public History takeOnBook(Book[] books, Reader[] readers){
        System.out.println("Список читателей: ");
        for (int i = 0; i < readers.length; i++) {
            System.out.println(i+1+". "+readers[i].getFirstname()+" "+readers[i].getLastname());
        }
        System.out.print("Выбери читателя: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список книг: ");
        for (int i = 0; i < books.length; i++) {
            System.out.print(i+1+". "+books[i].getBookName());
            for (Author author : books[i].getAuthors()) {
                System.out.printf("%s %s %d %d", author.getFirstname(), author.getLastname(), author.getBirthday(), books[i].getQuantity());
            }
            System.out.println();
        }

        System.out.print("Выбери номер книги: ");
        int numberBook = scanner.nextInt();scanner.nextLine();

        int QuantityCount = books[numberBook-1].getQuantity();

        if (QuantityCount > 0) {
            QuantityCount--;
            books[numberBook-1].setQuantity(QuantityCount);
            System.out.println(QuantityCount + " - Количество экзепляров у книги под комером:" + numberBook);
        }
        if (QuantityCount <= 0) {
            System.out.println("выдать книгу не возможно, так как экземпляров данной книги не осталось!");
        }

        History history = new History();
        history.setBook(books[numberBook - 1]);
        history.setReader(readers[numberReader-1]);
        history.setTakeOnBook(new GregorianCalendar().getTime());
        return history;
    }

    public void printReadingBooks(History[] histories){
        for (int i = 0; i < histories.length; i++) {
            if(histories[i].getReturnBook() == null){
                System.out.print(i+1+". "+histories[i].getBook().getBookName()+". ");
                for (Author author : histories[i].getBook().getAuthors()) {
                    System.out.printf("%s %s %d", author.getFirstname(), author.getLastname(), author.getBirthday());
                }
                System.out.println();
            }
        }
    }

    public History[] returnBook(History[] histories) {
        //выбрать номер истории с возвращаемой книгой
        //вставить текущую дату в поле returnBook
        System.out.println("Список выданных книг: ");
        this.printReadingBooks(histories);
        System.out.print("Выберите из списка номер возвращаемой книги: ");
        int numberReturnBook = scanner.nextInt();
        scanner.nextLine();
        int QuantityCount = histories[numberReturnBook - 1].getBook().getQuantity();
        if (QuantityCount >= 0) {
            QuantityCount++;
            histories[numberReturnBook - 1].getBook().setQuantity(QuantityCount);
            System.out.println(QuantityCount + " - Количество экзепляров у книги под комером:" + numberReturnBook);
        }
        histories[numberReturnBook - 1].setReturnBook(new GregorianCalendar().getTime());
        return histories;
    }
}
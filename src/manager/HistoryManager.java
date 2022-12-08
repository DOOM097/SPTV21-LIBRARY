

package manager;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;


public class HistoryManager {
private final Scanner scanner;

    public HistoryManager() {
        scanner = new Scanner(System.in);
    }
    
    public History takeOnBook(List<Book> books, List<Reader> readers){
        System.out.println("Список читателей: ");
        for (int i = 0; i < readers.size(); i++) {
            System.out.println(i+1+". "+readers.get(i).getFirstname()+" "+readers.get(i).getLastname());
        }
        System.out.print("Выбери читателя: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        System.out.println("Список книг: ");
        for (int i = 0; i < books.size(); i++) {
            System.out.print(i+1+". "+books.get(i).getBookName()+". ");
            for (int j = 0; j < books.get(i).getAuthors().size(); j++) {
                System.out.printf("%s %s %d", 
                        books.get(i).getAuthors().get(j).getFirstname(),
                        books.get(i).getAuthors().get(j).getLastname(),
                        books.get(i).getAuthors().get(j).getBirthday());

            }
            System.out.println();
        }
        System.out.print("Выбери номер книги: ");
        int numberBook = scanner.nextInt();scanner.nextLine();
        History history = new History();
        history.setBook(books.get(numberBook - 1));
        history.setReader(readers.get(numberReader-1));
        history.setTakeOnBook(new GregorianCalendar().getTime());
        return history;
    }
    
    public void printReadingBooks(List<History> histories){
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i).getReturnBook() == null){
                System.out.print(i+1+". "+histories.get(i).getBook().getBookName()+". ");
                for (int j = 0; j < histories.get(i).getBook().getAuthors().size(); j++) {
                    System.out.printf("%s %s %d", 
                            histories.get(i).getBook().getAuthors().get(j).getFirstname(),
                            histories.get(i).getBook().getAuthors().get(j).getLastname(),
                            histories.get(i).getBook().getAuthors().get(j).getBirthday()
                    );
                }
                System.out.println();
            }
        }
    }

    public List<History> returnBook(List<History> histories) {
        //выбрать номер истории с возвращаемой книгой
        //вставить текущую дату в поле returnBook
        System.out.println("Список выданных книг: ");
        this.printReadingBooks(histories);
        System.out.print("Выберите из списка номер возвращаемой книги: ");
        int numberReturnBook = scanner.nextInt();scanner.nextLine();
        histories.get(numberReturnBook - 1).setReturnBook(new GregorianCalendar().getTime());
        return histories;
    }
}

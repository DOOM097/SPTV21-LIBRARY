package sptv21library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.Scanner;
import manager.BookManager;
import manager.HistoryManager;
import manager.ReaderManager;

public class App {
    private final Scanner scanner;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;
    private Book[] books;
    private Reader[] readers;
    private History[] histories;

    public App() {
        scanner = new Scanner(System.in);
        bookManager = new BookManager();
        readerManager = new ReaderManager();
        historyManager = new HistoryManager();
        
        books = new Book[0];
        readers = new Reader[0];
        histories = new History[0];
    }
    
    public void run(){
        boolean repeat = true;
        do{
            System.out.println("Функции приложения:");
            System.out.println("0. Закрыть приложение");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("5. Список книг");
            System.out.println("6. Список читателей");
            System.out.println("7. Список выданных книг");
            System.out.println("8. Изменить данные читателя");
            System.out.println("9. Редактирование книги");
            System.out.print("Выберите номер функции: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    System.out.println("0. Закрыть приложение");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Выбрана задача: 1. Добавить книгу");
                    addBook(bookManager.createBook());
                    break;
                case 2:
                    System.out.println("2. Добавить читателя");
                    addReader(readerManager.createReader());
                    break;
                case 3:
                    System.out.println("3. Выдать книгу");
                    addHistories(historyManager.takeOnBook(readers,books));
                    break;
                case 4:
                    System.out.println("4. Вернуть книгу");
                    histories = historyManager.returnBook(histories);
                    break;
                case 5:
                    System.out.println("5. Список книг");
                    bookManager.printListBooks(books);
                    break;
                case 6:
                    System.out.println("6. Список читателей");
                    readerManager.printListReaders(readers);
                    break;
                case 7:
                    System.out.println("7. Список выданных книг");
                    historyManager.printListReadingBooks(histories);
                    break;
                case 8:
                    System.out.println("8. Изменить данные читателя");
                    readers = readerManager.changeReader(readers);
                    break;
                case 9:
                    System.out.println("9. Редактирование книги");
                    books = bookManager.changeBook(books);
                    break;
                default:
                    System.out.println("Выберите номер функции из списка!");
            }
        }while(repeat);
        System.out.println("Пока!");
    }

    private void addBook(Book book){
        books = Arrays.copyOf(books, books.length+1);
        books[books.length-1] = book;
    }
    
    private void addReader(Reader reader) {
        readers = Arrays.copyOf(readers, readers.length + 1);
        readers[readers.length - 1] = reader;
    }
    private void addHistories(History history) {
        histories = Arrays.copyOf(histories, histories.length + 1);
        histories[histories.length - 1] = history;
    }
    

    
}
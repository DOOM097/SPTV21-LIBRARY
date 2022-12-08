

package sptv21library;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.List;
import java.util.Scanner;
import manager.BaseDataManager;
import manager.BookManager;
import manager.FileDataManager;
import manager.HistoryManager;
import manager.ReaderManager;


public class App {
    private final Scanner scanner;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;
    //private final FileDataManager dataManager;
    private final BaseDataManager dataManager;
    //private Book[] books;
    private List<Book> books;
    //private Reader[] readers;
    private List<Reader> readers;
    private List<History> histories;

    public App() {
        scanner = new Scanner(System.in);
        //dataManager = new FileDataManager();
        dataManager = new BaseDataManager();
        books = dataManager.loadBooks();
//        readers = dataManager.loadReaders();
//        histories = dataManager.loadHistories();
        bookManager = new BookManager();
        readerManager = new ReaderManager();
        historyManager = new HistoryManager();
    }
    
    public void run(){
        boolean repeat = true;
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Закончить программу");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("5. Список выданных книг");
            System.out.println("6. Список книг");
            System.out.println("7. Список читателей");
            System.out.println("8. Редактировать книгу");
            System.out.println("9. Редактировать читателя");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. Добавить книгу");
                    books.add(bookManager.createBookWithAuthors());
                    dataManager.saveBooks(books);
                    break;
                case 2:
                    System.out.println("2. Добавить читателя");
                    readers.add(readerManager.createReader());
                    //dataManager.saveReaders(readers);
                    break;
                case 3:
                    System.out.println("3. Выдать книгу");
                    histories.add(historyManager.takeOnBook(books, readers));
                    //dataManager.saveHistories(histories);
                    break;
                case 4: 
                    System.out.println("4. Вернуть книгу");
                    histories = historyManager.returnBook(histories);
                    //dataManager.saveHistories(histories);
                    break;
                case 5: 
                    System.out.println("5. Список выданных книг");
                    historyManager.printReadingBooks(histories);
                    break;
                case 6:
                    System.out.println("6. Список книг");
                    bookManager.printListBooks(books);
                    break;
                case 7:
                    System.out.println("7. Список читателей");
                    readerManager.printListReaders(readers);
                    break;
                case 8:
                    System.out.println("8. Редактирование книги");
                    this.books = bookManager.changeBook(books);
                    dataManager.saveBooks(books);
                    break;
                case 9:
                    System.out.println("8. Редактирование читателя");
                    this.readers = readerManager.changeReader(readers);
                    //dataManager.saveReaders(readers);
                    break;
                default:
                    System.out.println("Выберите задачу из списка!");;
            }
        }while(repeat);
        System.out.println("Закрытие программы, пока!");
    }

//    private void addBook(Book book) {
//        this.books = Arrays.copyOf(this.books, this.books.length+1);
//        this.books[this.books.length - 1] = book;   
//    }
//    private void addReader(Reader reader) {
//        this.readers = Arrays.copyOf(this.readers, this.readers.length+1);
//        this.readers[this.readers.length - 1] = reader;   
//    }
//    private void addHistory(History histories) {
//        this.histories = Arrays.copyOf(this.histories, this.histories.length+1);
//        this.histories[this.histories.length - 1] = histories;   
//    }
}

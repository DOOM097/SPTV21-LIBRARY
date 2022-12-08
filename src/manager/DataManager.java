

package manager;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class DataManager {
    private final String BOOKS_FILE = "files/MyBooks";
    private final String READERS_FILE = "files/MyReaders";
    private final String HISTORIES_FILE = "files/MyHistories";

    public DataManager() {
        File file = new File("files");
        file.mkdirs();
    }
    
    public void saveBooks(List<Book> books) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(BOOKS_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(BOOKS_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books = (List<Book>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return books;
    }
    public void saveReaders(List<Reader> readers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(READERS_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(readers);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyReaders");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    public List<Reader> loadReaders() {
        List<Reader> readers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(READERS_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readers = (List<Reader>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return readers;
    }
    public void saveHistories(List<History> histories) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(HISTORIES_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(histories);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyReaders");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
    public List<History> loadHistories() {
        List<History> histories = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(HISTORIES_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            histories = (List<History>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет файла MyBooks");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода");
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс");
        }
        return histories;
    }

}
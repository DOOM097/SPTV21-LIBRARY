

package manager;

import entity.Author;
import entity.Book;
import java.util.List;
import java.util.Scanner;


public class BookManager {
    private final Scanner scanner;

    public BookManager() {
        scanner = new Scanner(System.in);
    }
    
    public Book createBookWithAuthors(){
        System.out.print("Введите название книги: ");
        String bookName = scanner.nextLine();
        System.out.print("Введите год издания книги: ");
        String publishedYear = scanner.nextLine();
        System.out.print("Введите количество экземпляров книги: ");
        String quantity = scanner.nextLine();

        Book book = createBook(bookName, new Integer(quantity), Integer.parseInt(publishedYear));
        System.out.print("Введите количество авторов книги:");
        int countAuthorsInBook = scanner.nextInt(); scanner.nextLine();
        for (int i = 0; i < countAuthorsInBook; i++) {
            System.out.print("Введите имя автора "+(i+1)+": ");
            String firstname = scanner.nextLine();
            System.out.print("Введите фамилию автора "+(i+1)+": ");
            String lastname = scanner.nextLine();
            System.out.print("Введите год рождения автора "+(i+1)+": ");
            String birthday = scanner.nextLine();
            book.addAuthor(createAuthor(firstname, lastname, new Integer(birthday)));
        }
        return book;
    }
    public void printListBooks(List<Book> books){
        for (int i = 0; i < books.size(); i++) {
            System.out.print(i+1+". "+books.get(i).getBookName()+". ");
            for (int j = 0; j < books.get(i).getAuthors().size(); j++) {
                System.out.printf("%s %s %d. ", 
                        books.get(i).getAuthors().get(i).getFirstname(),
                        books.get(i).getAuthors().get(i).getLastname(),
                        books.get(i).getAuthors().get(i).getBirthday());

            }
            System.out.println();
        }
    }
    public Book createBook(String bookName,int quantity, int publishedYear){
        Book book = new Book();
        book.setBookName(bookName);
        book.setPublishedYear(publishedYear);
        book.setQuantity(quantity);
        return book;
    }
    private Author createAuthor(String firstname, String lastname, int birthday){
        Author author = new Author();
        author.setBirthday(birthday);
        author.setFirstname(firstname);
        author.setLastname(lastname);
        return author;
    }
    public List<Book> changeBook(List<Book> books) {
        System.out.println("Список книг: ");
        printListBooks(books);
        System.out.print("Выберите номер книги для редактирования: ");
        int numBookForEdit = scanner.nextInt(); scanner.nextLine();
        System.out.print("Название книги: ");
        System.out.println(books.get(numBookForEdit - 1).getBookName());
        System.out.print("Изменить название книги? (y/n)");
        String edit = scanner.nextLine();
        if(edit.equals("y")){
            System.out.print("Введите новое название книги: ");
            books.get(numBookForEdit - 1).setBookName(scanner.nextLine());
        }
        System.out.print("Год издания книги: ");
        System.out.println(books.get(numBookForEdit - 1).getPublishedYear());
        System.out.print("Изменить год издания книги? (y/n)");
        edit = scanner.nextLine();
        if(edit.equals("y")){
            System.out.print("Введите новое название книги: ");
            books.get(numBookForEdit - 1).setPublishedYear(scanner.nextInt());scanner.nextLine();
        }
        System.out.print("Количество экземпляров книги: ");
        System.out.println(books.get(numBookForEdit - 1).getQuantity());
        System.out.print("Изменить количество экземпляров книги? (y/n)");
        edit = scanner.nextLine();
        if(edit.equals("y")){
            System.out.print("Введите другое количество книги: ");
            books.get(numBookForEdit - 1).setQuantity(scanner.nextInt());scanner.nextLine();
        }
        System.out.println("Авторов у книги "+books.get(numBookForEdit - 1).getAuthors().size());
        System.out.println("Изменить количество авторов? (y/n)");
        edit = scanner.nextLine();
        if(edit.equals("y")){// Меняем количество авторов
            System.out.print("Введите новое количество авторов: ");
            int newCountAuthorsInBook = scanner.nextInt();
            scanner.nextLine();
         // количество авторов может быть больше или меньше.
            if(newCountAuthorsInBook < books.get(numBookForEdit - 1).getAuthors().size()){
               //если меньше, выводим нумерованный список авторов и просим указать какого удалить
               // вычисляем на сколько меньше 
                int deltaAuthors = books.get(numBookForEdit - 1).getAuthors().size() - newCountAuthorsInBook;
                for (int n = 0; n < deltaAuthors; n++) {
                    //удаляем лишних (deltaAuthors) авторов из книги
                   books.set(numBookForEdit - 1,deleteAuthorBook(books.get(numBookForEdit - 1)));
                }
            }else{
                for (int i = 0; i < newCountAuthorsInBook; i++) {
                    //если счетчик больше количесвтва авторов
                    if(i >= books.get(numBookForEdit - 1).getAuthors().size()){
                        // добаляем нового автора в книгу
                        Author newAuthor = new Author();
                        System.out.print("Введите имя автора "+(i+1)+": ");
                        newAuthor.setFirstname(scanner.nextLine());
                        System.out.print("Введите фамилию автора "+(i+1)+": ");
                        newAuthor.setLastname(scanner.nextLine());
                        System.out.print("Введите год рождения автора "+(i+1)+": ");
                        newAuthor.setBirthday(scanner.nextInt()); scanner.nextLine();
                        books.get(numBookForEdit - 1).addAuthor(newAuthor);
                    }else if(i < books.get(numBookForEdit - 1).getAuthors().size()){
                        // изменяем существующих авторов книги
                        System.out.println(i+1+"-й автор: "
                            +books.get(numBookForEdit - 1).getAuthors().get(i).getFirstname()+" "+
                                   books.get(numBookForEdit - 1).getAuthors().get(i).getLastname());
                        System.out.print("Изменить имя автора? (y/n)");
                        edit = scanner.nextLine();
                        if(edit.equals("y")){
                            System.out.print("Введите другое имя автора: ");
                            books.get(numBookForEdit - 1).getAuthors().get(i).setFirstname(scanner.nextLine());
                        }    
                        System.out.print("Изменить фамилию автора? (y/n)");
                        edit = scanner.nextLine();
                        if(edit.equals("y")){
                            System.out.print("Введите другую фамилию автора: ");
                            books.get(numBookForEdit - 1).getAuthors().get(i).setLastname(scanner.nextLine());
                        }    
                        System.out.print("Изменить год рождения автора? (y/n)");
                        edit = scanner.nextLine();
                        if(edit.equals("y")){
                            System.out.print("Введите другой год рождения автора: ");
                            books.get(numBookForEdit - 1).getAuthors().get(i).setBirthday(scanner.nextInt());scanner.nextLine();
                        }    
                    }
                }
            }
        }
        return books;
    }
    private Book deleteAuthorBook(Book book) {
        for (int i = 0; i < book.getAuthors().size(); i++) {
            System.out.println(
                    i+1+". "+book.getAuthors().get(i).getFirstname()+" "+
                            book.getAuthors().get(i).getLastname());
        }
        System.out.println("Какого автора удалить? ");
        int numDeleteAuthor = scanner.nextInt();
        scanner.nextLine();
        book.removeAuthor(numDeleteAuthor);
        return book;
    }
}
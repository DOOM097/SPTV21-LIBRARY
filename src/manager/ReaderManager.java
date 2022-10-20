
package manager;

import entity.Reader;
import java.util.Scanner;


public class ReaderManager {
    private final Scanner scanner;

    public ReaderManager() {
        scanner = new Scanner(System.in);
    }
    
    public Reader createReader(){
        Reader reader = new Reader();
        System.out.print("Имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Фамилия читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Телефон читателя: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    } 
    public void printListReaders(Reader[] readers){
        for (int i = 0; i < readers.length; i++) {
            System.out.printf("%d. %s %a. Телефон: %s%n"
                    ,i+1
                    ,readers[i].getFirstname()
                    ,readers[i].getLastname()
                    ,readers[i].getPhone()
            );
        }
    }

    public Reader[] changeReader(Reader[] readers) {
        System.out.println("Список читателей: ");
        this.printListReaders(readers);
        System.out.print("Выберите номер читателя из списка: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        System.out.println("Имя: "+readers[numberReader - 1].getFirstname());
        System.out.print("Заменить? (y/n): ");
        String task = scanner.nextLine();
        if("y".equals(task)){
            System.out.print("Введите новое имя: ");
            readers[numberReader - 1].setFirstname(scanner.nextLine());
        }
        System.out.println("Фамилия: "+readers[numberReader - 1].getLastname());
        System.out.print("Заменить? (y/n): ");
        task = scanner.nextLine();
        if("y".equals(task)){
            System.out.print("Введите новую фамилию: ");
            readers[numberReader - 1].setLastname(scanner.nextLine());
        }
        System.out.println("Телефон: "+readers[numberReader - 1].getPhone());
        System.out.print("Заменить? (y/n): ");
        task = scanner.nextLine();
        if("y".equals(task)){
            System.out.print("Введите новый телефон: ");
            readers[numberReader - 1].setPhone(scanner.nextLine());
        }
        System.out.println("Измененный читатель: "+readers[numberReader - 1].toString());
        return readers;
    }
}
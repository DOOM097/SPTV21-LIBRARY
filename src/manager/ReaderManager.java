

package manager;

import entity.Reader;
import java.util.List;
import java.util.Scanner;


public class ReaderManager {
    private final Scanner scanner;

    public ReaderManager() {
        scanner = new Scanner(System.in);
    }
    
    public Reader createReader(){
        Reader reader = new Reader();
        System.out.print("Введите имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Введите телефон читателя: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    }
    
    public void printListReaders(List<Reader> readers){
        for (int i = 0; i < readers.size(); i++) {
            System.out.printf("%d. %s %s. Телефон: %s%n"
                    ,i+1
                    ,readers.get(i).getFirstname()
                    ,readers.get(i).getLastname()
                    ,readers.get(i).getPhone()
            );
        }
    }

    public List<Reader> changeReader(List<Reader> readers) {
        System.out.println("Список читателей: ");
        this.printListReaders(readers);
        System.out.print("Выберите номер читателя: ");
        int numberReader = scanner.nextInt();scanner.nextLine();
        System.out.println("Имя: "+readers.get(numberReader-1).getFirstname());
        System.out.print("Изменить? (y/n): ");
        String letter = scanner.nextLine();
        if(letter.equals("y")){
            System.out.println("Введите новое имя: ");
            readers.get(numberReader-1).setFirstname(scanner.nextLine());
        }
        System.out.println("Фамилия: "+readers.get(numberReader-1).getLastname());
        System.out.print("Изменить? (y/n): ");
        letter = scanner.nextLine();
        if(letter.equals("y")){
            System.out.println("Введите фамилию: ");
            readers.get(numberReader-1).setLastname(scanner.nextLine());
        }
        System.out.println("Телефон: "+readers.get(numberReader-1).getPhone());
        System.out.print("Изменить? (y/n): ");
        letter = scanner.nextLine();
        if(letter.equals("y")){
            System.out.println("Введите телефон: ");
            readers.get(numberReader-1).setPhone(scanner.nextLine());
        }
        return readers;
    }
}

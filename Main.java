import java.io;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Exception;
import java.io.IOException;
import java.io.FileNotFoundException;

import Toy.*;
import FileEngine.*;

class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(final String[] args) {
/*         //Ex.1
        final String diskCRootPath = "C:/";
        final String usersFoldrPath = "C:/Users/";
        final String userHomePath = System.getProperty("user.home");
        final String OOP_lab04Path = userHomePath + "/Documents/VSCodeProjects/Java/OOP_lab04-maxfps11/";

        try {       
            // Create the MyFile1
            out("Создание MyFile1");
            File f1 = new File(OOP_lab04Path, "MyFile1.txt");
            check(f1.createNewFile());

            // Create the MyFile2
            out("Создание MyFile2");
            File f2 = new File(diskCRootPath, "MyFile2.txt");
            check(f2.createNewFile());

            // Create the MyFile3
            out("Создание MyFile3");
            File f3 = new File(usersFoldrPath, "MyFile3.txt");
            check(f3.createNewFile());
            //Create third level folder
            out("Создание папки третьего уровня.");
            File f4 = new File(usersFoldrPath, "third");
            check(f4.mkdir());
        
            // Ex.2
            // Check on file and print name
            out("Проверка MyFile1.txt на файл и вывод имени");
            if (f1.isFile())
                out(f1.getName());
            
            // Check on folder and print name
            out("Проверка папки third на папку и вывод имени");
            if (f4.isDirectory())
                out(f4.getName());

            // Check the file on exist
            out("Проверка MyFile1.txt на существование");
            if (f1.exists())
                out("Существует.");
            else
                out("Не существует.");

            // Get full path to MyFile1.txt
            out("Вывод полного пути до MyFile1.txt");
            out(f1.getPath());

            // Get size the MyFile1.txt
            out("Получаем размер MyFile1.txt и комментируем тип файла.");
            out(f1.length() + " Байтов.");
            if (f1.isFile())
                out("Тип: Файл");
            else
                out("Тип: Папка.");
            
            // Create the folder of third level
            out("Создание папки в корне приложения.");
            File f5 = new File(OOP_lab04Path, "third");
            check(f5.mkdir());
 
            // Pring all file names from app root directory use the list().
            out("Сформировать массив файлов и вывести используя метод list()");
            File f6 = new File(OOP_lab04Path);
            String[] listFileNames = f6.list();

            for (String fileName : listFileNames) {
                out(fileName);
            };

            // // Pring all file names from app root directory use the listFiles()
            out("Сформировать массив файлов и вывести используя метод listFiles() и вывести колличество папок.");
            File[] listFiles = f6.listFiles();

            int folderCounter = 0;
            for (File file : listFiles) {
                if (file.isDirectory())
                    folderCounter++;

                out(file.toString());
            }
            out("Колличесво папок. = " + folderCounter);
 
            out("Удаляем файл MyFile1.txt");
            check(f1.delete());

            //out("Удаляем файл MyFile2.txt");
            //check(f2.delete());

            //out("Удаляем файл MyFile3.txt");
            //check(f3.delete());

            out("Удаляем папку 3-его уровня.");
            check(f4.delete());

            out("Удаляем папку из корневой папки приложения.");
            check(f5.delete());

        } catch (FileNotFoundException e) {
            out(e.getMessage());
        } catch (IOException e) {
            out(e.getMessage()); 
        } catch (Exception e) {
            out(e.getMessage());
        }
 */
        /*String firm = "None";
        float cost = 0;
        int ageStart = 0, ageFinish = 0;

        out("\nНатменование фирмы производителя: ");
        firm = in.nextLine();

        out("\nЦена: ");
        cost = in.nextFloat();

        out("\nНачальный возраст: ");
        ageStart = in.nextInt();
        
        out("\nКонечный возраст: ");
        ageFinish = in.nextInt();

        Toy toy1 = new Toy(firm, cost, ageStart, ageFinish);

        out("\nНатменование фирмы производителя: ");
        firm = in.next();

        out("\nЦена: ");
        cost = in.nextFloat();

        out("\nНачальный возраст: ");
        ageStart = in.nextInt();
        
        out("\nКонечный возраст: ");
        ageFinish = in.nextInt();

        Toy toy2 = new Toy(firm, cost, ageStart, ageFinish);

        out("\nНатменование фирмы производителя: ");
        firm = in.next();

        out("\nЦена: ");
        cost = in.nextFloat();

        out("\nНачальный возраст: ");
        ageStart = in.nextInt();
        
        out("\nКонечный возраст: ");
        ageFinish = in.nextInt();

        Toy toy3 = new Toy(firm, cost, ageStart, ageFinish); */

        FileEngine fEngine = new FileEngine();

        out("Введите название файла для записи: ");
        String fileName = in.next();

        check(fEngine.createFile(fileName));

        Toy t1 = new Toy("First", 100.f, 10, 12);
        Toy t2 = new Toy("Second", 200.f, 10, 12);
        Toy t3 = new Toy("Third", 300.f, 10, 12);

        ArrayList<Toy> toys = new ArrayList<Toy>();
        toys.add(t1);
        toys.add(t2);
        toys.add(t3);

        DataOutputStream dos = new DataOutputStream(fEngine.getDOStream(fileName));

        for (Toy toy : toys) {
            toy.writeToFile(dos);
        }

        DataInputStream dis = new DataInputStream(fEngine.getDIStream(fileName));

        ArrayList<Toy> toys2 = new ArrayList<Toy>();

        for (Toy toy : toys) {
            toy.readFromFile(dis);

            if (toy.isEqFirm("First"))
                toys2.add(toy);
        }

        for (Toy toy : toys2) {
            toy.printInfo();
        }
    }

    private static void check(boolean res) {
        if (res)
            out("Успешно.\n");
        else
            out("Неуспешно.\n");
    }

    private static <T> void out(T output) {
        System.out.print(output);
    }
}
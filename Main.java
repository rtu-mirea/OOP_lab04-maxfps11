import java.io;
import java.io.File;
import java.lang.Exception;
import java.io.IOException;
import java.io.FileNotFoundException;

class Main {
    public static void main(final String[] args) {
        //Ex.1
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


        } catch (FileNotFoundException e) {
            out(e.getMessage());
        } catch (IOException e) {
            out(e.getMessage());
        } catch (Exception e) {
            out(e.getMessage());
        }
    }

    private static void check(boolean res) {
        if (res)
            out("Успешно");
        else
            out("Неуспешно");
    }

    private static <T> void out(T output) {
        System.out.println(output);
    }
}
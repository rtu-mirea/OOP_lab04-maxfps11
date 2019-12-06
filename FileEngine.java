import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class FileEngine {
    final String projectDirectory = System.getProperty("user.home") + "/Documents/VSCodeProjects/Java/OOP_lab04-maxfps11/";

    FileEngine() {}

    File createFile(String fileName) {
        System.out.println("Создание файла.");

        try {
            File f = new File(projectDirectory, fileName);

            if (!isAlreadyExist(fileName)) {
                f.createNewFile();
                return f;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    boolean isAlreadyExist(String fileName) {
        System.out.println("Проверка файла на существование.");

        File f = new File(projectDirectory, fileName);

        if (f.exists()) {
            System.out.println("Файл с подобным именем уже существует.");
            return true;
        } else return false;
    }

    DataOutputStream getDOStream(String fileName) {
        System.out.println("Запись в " + fileName + "\n");

        try {
            File file = new File(projectDirectory, fileName);
            FileOutputStream fostream = new FileOutputStream(file);
            DataOutputStream dostream = new DataOutputStream(fostream);
            return dostream;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    DataInputStream getDIStream(String fileName) {
        System.out.println("Считываем из " + fileName + "\n");

        try {
            File file = new File(projectDirectory, fileName);
            FileInputStream fistream = new FileInputStream(file);
            DataInputStream distream = new DataInputStream(fistream);
            return distream;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
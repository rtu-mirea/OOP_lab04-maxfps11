import java.io;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

class Main {
    public static void main(final String[] args) {
        final String userHomePath = System.getProperty("user.home");
        final String OOP_lab04Path = userHomePath + "/Documents/VSCodeProjects/Java/OOP_lab04-maxfps11/";

        // Create the MyFile1
        final File MyFile1 = new File(OOP_lab04Path, "MyFile1.txt");

        out("Проверяем, существует ли MyFile1.txt по пути " + OOP_lab04Path);

        if (!MyFile1.isFile()) {
            out("Файл отсутствует.");
            try {
                out("Попытка создания файла.");
                MyFile1.createNewFile();
            } catch (FileNotFoundException e) {
                out(e.getMessage());
            } catch (IOException e) {
                out(e.getMessage());
            } catch (Exception e) {
                out(e.getMessage());
            } finally {
                // Checking the creation of MyFile1.
                if (MyFile1.isFile())
                    out("Файл успешно создан и расположен по " + MyFile1.getPath());
                else
                    out("Файл не был создан.");
            }
        } else {
            out("Подобный файл существует.");
        }


    }

    private static <T> void out(T output) {
        System.out.println(output);
    }
}
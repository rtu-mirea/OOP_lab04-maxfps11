import java.io;
import java.io.File;
import java.lang.Exception;
import java.io.IOException;
import java.io.FileNotFoundException;

class Main {
    public static void main(final String[] args) {
        final String diskCRootPath = "C:/";
        final String usersFoldrPath = "C:/Users/";
        final String userHomePath = System.getProperty("user.home");
        final String OOP_lab04Path = userHomePath + "/Documents/VSCodeProjects/Java/OOP_lab04-maxfps11/";

        try {
            // Create the MyFile1
            File f1 = new File(OOP_lab04Path, "MyFile1.txt");
            //check(f1.createNewFile());

            // Create the MyFile2
            File f2 = new File(diskCRootPath, "MyFile2.txt");
            //check(f2.createNewFile());

            // Create the MyFile3
            File f3 = new File(usersFoldrPath, "MyFile3.txt");
            //check(f3.createNewFile());
        
            //Create third level folder
            File f4 = new File(OOP_lab04Path, "third");
            //check(f4.mkdir());
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
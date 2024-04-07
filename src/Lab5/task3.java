package Lab5;
import java.io.*;


class FileCopier {
    public void copyFile(String sourceFile, String destinationFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class task3 {
    public static void task(){
        FileCopier f = new FileCopier();
        f.copyFile("test.txt","test1.txt");
    }

}

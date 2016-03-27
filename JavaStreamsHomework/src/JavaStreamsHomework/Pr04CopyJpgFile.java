package JavaStreamsHomework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Pr04CopyJpgFile {
    public static void main(String[] args) {
        FileInputStream input = null;
        FileOutputStream output = null;
        byte[] buffer = new byte[1024];
        try {
            input = new FileInputStream("res\\my-picture.jpg");
            output = new FileOutputStream("res\\my-copied-picture.jpg");
            int read = input.read(buffer, 0, buffer.length);
            while (read > 0)
            {
                output.write(buffer, 0, read);
                read = input.read(buffer, 0, buffer.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

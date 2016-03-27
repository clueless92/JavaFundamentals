package JavaStreamsHomework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Pr07CreateZipArchive {
    public static void main(String[] args) {
        ZipOutputStream zipOut = null;
        FileInputStream input = null;
        try {
            zipOut = new ZipOutputStream(new FileOutputStream("res\\text-files.zip"));
            String[] filesToZip = new String[] { "words.txt", "lines.txt", "count-chars.txt" };
            for (String fileName : filesToZip) {
                input = new FileInputStream("res\\" + fileName);
                int byteContainer = input.read();
                zipOut.putNextEntry(new ZipEntry(fileName));
                while (byteContainer != -1) {
                    zipOut.write(byteContainer);
                    byteContainer = input.read();
                }
                zipOut.closeEntry();
            }
            zipOut.finish();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (zipOut != null) {
                    zipOut.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

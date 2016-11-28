package BashSoft;

import javax.xml.ws.WebServiceException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {
    public static void main(String[] args) {

        try {
            InputReader.readCommands();
        } catch (IOException e) {
            OutputWriter.displayException(e.getMessage());
        }

        // lab 1 test (stacks and queues)
//        IOManager.traverseDirectory("C:\\Program Files (x86)\\Google");

        // lab 2 test (Sets and Maps)
//        StudentRepository.initializeData();
//        StudentRepository.getStudentsByCourse("Unity");

        // lab 3 test (Files and streams)
//        String test1Path = "D:\\OneDrive\\Workspace\\JavaInteliJ\\JavaAdvancedProblems\\src\\BashSoft\\res\\test1.txt";
//        String test2Path = "D:\\OneDrive\\Workspace\\JavaInteliJ\\JavaAdvancedProblems\\src\\BashSoft\\res\\test3.txt";
//        Tester.compareContent(test1Path, test2Path);
//        IOManager.createDirectoryInCurrentFolder("tosho");
//        IOManager.changeCurrentDirAbsolute("D:\\OneDrive");
//        System.out.println(SessionData.currentPath);
//        IOManager.changeCurrentDirRelativePath("..");
//        System.out.println(SessionData.currentPath);

        // lab 4 test (Exceptions)
//        String actualFilePath = "D:\\OneDrive\\Workspace\\JavaInteliJ\\JavaAdvancedProblems\\src\\BashSoft\\res\\actual.txt";
//        String expectedFilePath = "D:\\OneDrive\\Workspace\\JavaInteliJ\\JavaAdvancedProblems\\src\\BashSoft\\res\\expected.txt";
//        Tester.compareContent(actualFilePath, expectedFilePath);

//        IOManager.changeCurrentDirAbsolute("D:");
//        System.out.println(SessionData.currentPath);
//        IOManager.changeCurrentDirRelativePath("..");
//        System.out.println(SessionData.currentPath);

    }
}

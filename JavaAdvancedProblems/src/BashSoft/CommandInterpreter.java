package BashSoft;

import BashSoft.Network.DownloadManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandInterpreter {
    public static void interpredCommand(String command) {
        String[] data = command.split("\\s+");
        String keyWord = data[0];
        switch (keyWord) {
            case "open":
                tryOpenFile(command, data);
                break;
            case "mkdir":
                tryCreateDir(command, data);
                break;
            case "ls":
                tryTraverseSubfolders(command, data);
                break;
            case "cmp":
                tryCompareFiles(command, data);
                break;
            case "changeDirRel":
                tryChangeRelativePath(command, data);
                break;
            case "changeDir":
                tryChangeAbsPath(command, data);
                break;
            case "readDb":
                tryReadDbFromFile(command, data);
                break;
            case "help":
                printHelp();
                break;
            case "show":
                tryShowCourse(command, data);
                break;
            case "download":
                tryDownloadFile(command, data);
                break;
            case "downloadAsync":
                tryDownloadFileOnNewThread(command, data);
                break;
            default:
                displayInvalidCommandMessage(command);
                break;
        }
    }

    private static void tryDownloadFile(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String fileUrl = data[1];
        DownloadManager.Download(fileUrl);
    }

    private static void tryDownloadFileOnNewThread(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String fileUrl = data[1];
        DownloadManager.DownloadOnNewThread(fileUrl);
    }

    private static void tryShowCourse(String command, String[] commandArgs) {
        if (commandArgs.length != 2 && commandArgs.length != 3) {
            displayInvalidCommandMessage(command);
        }

        String courseName = commandArgs[1];
        if (commandArgs.length == 2) {
            StudentRepository.getStudentsByCourse(courseName);
            return;
        }

        String userName = commandArgs[2];
        StudentRepository.getStudentMarksInCourse(courseName, userName);
    }

    private static void tryReadDbFromFile(String command, String[] commandArgs) {
        if (commandArgs.length != 2) {
            displayInvalidCommandMessage(command);
            return;
        }

        String fileName = commandArgs[1];
        StudentRepository.initializeData(fileName);
    }

    private static void tryChangeAbsPath(String command, String[] commandArgs) {
        if (commandArgs.length != 2) {
            displayInvalidCommandMessage(command);
            return;
        }

        String path = commandArgs[1];
        IOManager.changeCurrentDirAbsolute(path);
    }

    private static void tryChangeRelativePath(String command, String[] commandArgs) {
        if (commandArgs.length != 2) {
            displayInvalidCommandMessage(command);
            return;
        }

        String path = commandArgs[1];
        IOManager.changeCurrentDirRelativePath(path);
    }

    private static void tryCompareFiles(String command, String[] commandArgs) {
        if (commandArgs.length != 3) {
            displayInvalidCommandMessage(command);
            return;
        }

        String first = commandArgs[1];
        String second = commandArgs[2];
        Tester.compareContent(first, second);
    }

    private static void tryTraverseSubfolders(String command, String[] commandArgs) {
        if (commandArgs.length != 1 && commandArgs.length != 2) {
            displayInvalidCommandMessage(command);
            return;
        }

        if (commandArgs.length == 1) {
            IOManager.traverseDirectory(0);
        }

        if (commandArgs.length == 2) {
            int depth = Integer.parseInt(commandArgs[1]);
            IOManager.traverseDirectory(depth);
        }
    }

    private static void tryCreateDir(String command, String[] commandArgs) {
        if (commandArgs.length != 2) {
            displayInvalidCommandMessage(command);
            return;
        }

        String folderName = commandArgs[1];
        IOManager.createDirectoryInCurrentFolder(folderName);
    }

    private static void tryOpenFile(String command, String[] commandArgs) {
        if (commandArgs.length != 2) {
            displayInvalidCommandMessage(command);
            return;
        }

        String fileName = commandArgs[1];
        String filePath = SessionData.currentPath + '\\' + fileName;
        File file = new File(filePath);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            OutputWriter.displayException(e.getMessage());
        }
    }

    private static void displayInvalidCommandMessage(String input) {
        String output = String.format("The command '%s' is invalid", input);
        OutputWriter.writeMessageOnNewLine(output);
    }

    public static void printHelp() {OutputWriter.writeMessageOnNewLine("mkdir path - make directory");
        OutputWriter.writeMessageOnNewLine("ls depth - traverse directory");
        OutputWriter.writeMessageOnNewLine("cmp path1 path2 - compare two files");
        OutputWriter.writeMessageOnNewLine("changeDirRel relativePath - change directory");
        OutputWriter.writeMessageOnNewLine("changeDir absolutePath - change directory");
        OutputWriter.writeMessageOnNewLine("readDb path - read students data base");
        OutputWriter.writeMessageOnNewLine("filterExcelent - filter excelent students (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("filterExcelent path - filter excelent students (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("filterAverage - filter average students (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("filterAverage path - filter average students (the output is written in a file)");
        OutputWriter.writeMessageOnNewLine("filterPoor - filter low grade students (the output is on the console)");
        OutputWriter.writeMessageOnNewLine("filterPoor path - filter low grade students (the output is written in a file)");
        OutputWriter.writeMessageOnNewLine("order - sort students in increasing order (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("order path - sort students in increasing order (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("decOrder - sort students in decreasing order (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("decOrder path - sort students in decreasing order (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("download pathOfFile - download file (saved in current directory)");
        OutputWriter.writeMessageOnNewLine("downloadAsync path - download file asynchronously (save in the current directory)");
        OutputWriter.writeMessageOnNewLine("help - get help");
        OutputWriter.writeEmptyLine();
    }
}

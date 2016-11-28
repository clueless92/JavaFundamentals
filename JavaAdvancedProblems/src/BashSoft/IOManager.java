package BashSoft;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class IOManager {
    public static void traverseDirectory(int depth) {
        Queue<File> subFolders = new ArrayDeque<>();
        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;
        File root = new File(path);
        subFolders.add(root);

        while (subFolders.size() > 0) {
            File currFile = subFolders.poll();
            int currIndent = currFile.toString().split("\\\\").length - initialIndentation;
            if (depth - currIndent < 0) {
                break;
            }
            OutputWriter.writeMessageOnNewLine(currFile.toString());

            if(currFile.listFiles() != null) {
                for (File file : currFile.listFiles()) {
                    if(file.isDirectory()) {
                        subFolders.add(file);
                    } else {
                        int indexOfLastSlash = file.toString().lastIndexOf('\\');
                        for (int i = 0; i < indexOfLastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }

                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }

//            OutputWriter.writeMessageOnNewLine(currFile.getAbsolutePath());
        }
    }

    public static void createDirectoryInCurrentFolder(String name) {
        String path = getCurrentDirectoryPath() + "\\" + name;
        File file = new File(path);
        file.mkdir();
    }

    public static String getCurrentDirectoryPath() {
        String currentPath = SessionData.currentPath;
        return currentPath;
    }

    public static void changeCurrentDirRelativePath(String relativePath) {
        if (relativePath.equals("..")) {
            try {
                String currentPath = SessionData.currentPath;
                int indexOflastSlash = currentPath.lastIndexOf('\\');
                String newPath = currentPath.substring(0, indexOflastSlash);
                SessionData.currentPath = newPath;
            } catch (StringIndexOutOfBoundsException ex) {
                OutputWriter.displayException(ExceptionMessages.INVALID_DESTINATION);
            }
        } else {
            String currPath = SessionData.currentPath;
            currPath += '\\' + relativePath;
            changeCurrentDirAbsolute(currPath);
        }
    }

    public static void changeCurrentDirAbsolute(String absPath) {
        File file = new File(absPath);
        if (!file.exists()) {
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
            return;
        }

        SessionData.currentPath = absPath;
    }
}

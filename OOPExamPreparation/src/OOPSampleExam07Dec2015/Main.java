package OOPSampleExam07Dec2015;

import OOPSampleExam07Dec2015.Core.CapitalistDatabase;
import OOPSampleExam07Dec2015.Core.CapitalistEngine;
import OOPSampleExam07Dec2015.Core.TerminalIO;
import OOPSampleExam07Dec2015.Interfaces.Database;
import OOPSampleExam07Dec2015.Interfaces.InputOutput;
import OOPSampleExam07Dec2015.Interfaces.Runnable;

public class Main {
    public static void main(String[] args) {

        Database db = new CapitalistDatabase();
        InputOutput io = new TerminalIO();
        Runnable capitalistEngine = new CapitalistEngine(db, io);
        capitalistEngine.run();
    }
}

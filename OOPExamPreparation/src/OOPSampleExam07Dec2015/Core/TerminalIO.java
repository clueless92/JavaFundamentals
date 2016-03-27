package OOPSampleExam07Dec2015.Core;

import OOPSampleExam07Dec2015.Interfaces.InputOutput;

import java.util.Scanner;

public class TerminalIO implements InputOutput {

    private Scanner sc;

    public TerminalIO() {
        this.sc = new Scanner(System.in);;
    }

    @Override
    public void printLine(String toPrint) {
        System.out.println(toPrint);
    }

    @Override
    public void print(String toPrint) {
        System.out.print(toPrint);
    }

    @Override
    public String scanLine() {
        String input = sc.nextLine();
        return input;
    }
}

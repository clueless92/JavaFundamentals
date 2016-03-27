package OOPSampleExam14Dec2015Empires.io;

import OOPSampleExam14Dec2015Empires.contracts.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
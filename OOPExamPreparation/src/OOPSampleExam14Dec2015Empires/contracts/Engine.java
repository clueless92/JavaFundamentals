package OOPSampleExam14Dec2015Empires.contracts;

public interface Engine {

    public void run();
    
    public void executeCommand(String commandName, String[] commandTokens);
}
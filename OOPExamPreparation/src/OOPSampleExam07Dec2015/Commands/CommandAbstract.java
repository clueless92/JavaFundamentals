package OOPSampleExam07Dec2015.Commands;

import OOPSampleExam07Dec2015.Interfaces.Database;
import OOPSampleExam07Dec2015.Interfaces.Executable;

public abstract class CommandAbstract implements Executable {

    protected Database db;

    protected CommandAbstract(Database db) {
        this.db = db;
    }

    protected String getIndent(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    @Override
    public abstract String execute() throws Exception;
}

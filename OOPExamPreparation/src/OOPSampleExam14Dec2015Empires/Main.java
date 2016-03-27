package OOPSampleExam14Dec2015Empires;

import OOPSampleExam14Dec2015Empires.contracts.BuildingFactory;
import OOPSampleExam14Dec2015Empires.contracts.Engine;
import OOPSampleExam14Dec2015Empires.contracts.InputReader;
import OOPSampleExam14Dec2015Empires.contracts.OutputWriter;
import OOPSampleExam14Dec2015Empires.contracts.ResourceFactory;
import OOPSampleExam14Dec2015Empires.contracts.UnitFactory;
import OOPSampleExam14Dec2015Empires.core.EmpiresEngine;
import OOPSampleExam14Dec2015Empires.core.factories.BuildingFactoryImpl;
import OOPSampleExam14Dec2015Empires.core.factories.ResourceFactoryImpl;
import OOPSampleExam14Dec2015Empires.core.factories.UnitFactoryImpl;
import OOPSampleExam14Dec2015Empires.io.ConsoleInputReader;
import OOPSampleExam14Dec2015Empires.io.ConsoleOutputWriter;

public class Main {

    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        ResourceFactory resourceFactory = new ResourceFactoryImpl();
        UnitFactory unitFactory = new UnitFactoryImpl();
        BuildingFactory buildingFactory = new BuildingFactoryImpl();

        Engine engine = new EmpiresEngine(reader, writer, resourceFactory, unitFactory, buildingFactory);
        engine.run();
    }
}
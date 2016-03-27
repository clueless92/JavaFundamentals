package OOPSampleExam14Dec2015Empires.contracts;

public interface BuildingFactory {

    public Building createBuilding(String buildingType, UnitFactory unitFactory, ResourceFactory resourceFactory);
}
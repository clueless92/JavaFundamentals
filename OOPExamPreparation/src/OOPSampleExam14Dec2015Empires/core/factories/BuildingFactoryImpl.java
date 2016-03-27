package OOPSampleExam14Dec2015Empires.core.factories;

import OOPSampleExam14Dec2015Empires.contracts.Building;
import OOPSampleExam14Dec2015Empires.contracts.BuildingFactory;
import OOPSampleExam14Dec2015Empires.contracts.ResourceFactory;
import OOPSampleExam14Dec2015Empires.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BuildingFactoryImpl implements BuildingFactory {
    private static final String BUILDINGS_PACKAGE_NAME = "OOPSampleExam14Dec2015Empires.models.buildings.";

    @Override
    public Building createBuilding(String buildingType, UnitFactory unitFactory, ResourceFactory resourceFactory) {

        char first = Character.toUpperCase(buildingType.charAt(0));
        buildingType = first + buildingType.substring(1);
        Building building = null;
        try {
            Class buildingClass = Class.forName(BUILDINGS_PACKAGE_NAME + buildingType);
            Constructor[] ctors = buildingClass.getConstructors();
            building = (Building) ctors[0].newInstance(unitFactory, resourceFactory);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return building;
    }
}
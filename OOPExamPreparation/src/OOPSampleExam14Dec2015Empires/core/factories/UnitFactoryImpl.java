package OOPSampleExam14Dec2015Empires.core.factories;

import OOPSampleExam14Dec2015Empires.contracts.Unit;
import OOPSampleExam14Dec2015Empires.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {
    private static final String UNITS_PACKAGE_NAME = "OOPSampleExam14Dec2015Empires.models.units.";

    @Override
    public Unit createUnit(String unitType) {

        char first = Character.toUpperCase(unitType.charAt(0));
        unitType = first + unitType.substring(1);
        Unit unit = null;
        try {
            Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor[] ctors = unitClass.getConstructors();
            unit = (Unit) ctors[0].newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return unit;
    }
}
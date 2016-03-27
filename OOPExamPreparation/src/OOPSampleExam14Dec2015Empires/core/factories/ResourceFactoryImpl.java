package OOPSampleExam14Dec2015Empires.core.factories;

import OOPSampleExam14Dec2015Empires.contracts.Resource;
import OOPSampleExam14Dec2015Empires.contracts.ResourceFactory;
import OOPSampleExam14Dec2015Empires.models.resources.ResourceImpl;
import OOPSampleExam14Dec2015Empires.models.resources.ResourceType;

public class ResourceFactoryImpl implements ResourceFactory {

    @Override
    public Resource createResource(String resourceType, int quantity) {
        this.validateQuantity(quantity);
        ResourceType type = ResourceType.fromString(resourceType);

        return new ResourceImpl(type, quantity);
    }

    private void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
    }
}
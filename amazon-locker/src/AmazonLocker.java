import java.awt.*;
import java.util.*;
import java.util.List;

public class AmazonLocker {

    private static AmazonLocker instance;
    private List<Compartment> compartments;
    private Map<String, Compartment> accessCodeMap;

    private AmazonLocker() {
        compartments = new ArrayList<>();
        accessCodeMap = new HashMap<>();

        Compartment compartment1 = new Compartment(1L, Size.LARGE);
        compartments.add(compartment1);

        Compartment compartment2 = new Compartment(2L, Size.LARGE);
        compartments.add(compartment2);

        Compartment compartment3 = new Compartment(3L, Size.LARGE);
        compartments.add(compartment3);

        Compartment compartment4 = new Compartment(4L, Size.MEDIUM);
        compartments.add(compartment4);

        Compartment compartment5 = new Compartment(5L, Size.MEDIUM);
        compartments.add(compartment5);

        Compartment compartment6 = new Compartment(6L, Size.MEDIUM);
        compartments.add(compartment6);

        Compartment compartment7 = new Compartment(7L, Size.SMALL);
        compartments.add(compartment7);

        Compartment compartment8 = new Compartment(8L, Size.SMALL);
        compartments.add(compartment8);

        Compartment compartment9 = new Compartment(9L, Size.SMALL);
        compartments.add(compartment9);
    }

    public static AmazonLocker getInstance() {
        if(instance == null) {
            return new AmazonLocker();
        }
        return instance;
    }

    public String deliverPackage(Long packageID, Size size) {
        Compartment compartment = getAvaialableCompartment(size);
        if(compartment != null) {
            compartment.open();
            /// Put Item in the container
            compartment.close();
            compartment.setContainerFilled();
            String accessToken = generateAccessToken();
            accessCodeMap.put(accessToken, compartment);
            notifyUser(accessToken);
            return accessToken;
        }
        return null;
    }

    public void collectPackage(Long packageID, String accessCode) {
        if(accessCode == null || accessCode.isEmpty()) {
            throw new IllegalArgumentException("Invalid accessCode");
        }
        Compartment compartment = accessCodeMap.get(accessCode);
        if(compartment == null) {
            throw new IllegalArgumentException("Invalid accessCode");
        }
        compartment.open();
        // Take our the package from compartment
        compartment.close();
        compartment.setContainerEmpty();
        accessCodeMap.remove(accessCode);
    }

    private Compartment getAvaialableCompartment(Size size) {
        for(Compartment compartment : compartments) {
            if(compartment.getIsEmpty() && compartment.getSize().equals(size)) {
                return compartment;
            }
        }
        throw new IllegalArgumentException("No available compartment found");
    }

    private String generateAccessToken() {
        return UUID.randomUUID().toString();
    }

    private void notifyUser(String accessToken) {}
}

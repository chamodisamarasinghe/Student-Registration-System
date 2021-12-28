package bo;

import bo.custom.impl.ProgrammeBOImpl;
import bo.custom.impl.StudentBOImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return (null == boFactory) ? boFactory = new BoFactory() : boFactory;
    }

    public static BoFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO> T getBO(BoTypes boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case PROGRAMME:
                return (T) new ProgrammeBOImpl();
            default:
                return null;
        }
    }

    public enum  BoTypes {
        STUDENT, PROGRAMME
    }
}

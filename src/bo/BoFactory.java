package bo;

import bo.custom.impl.ProgrammeBOImpl;
import bo.custom.impl.StudentBOImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return (null == boFactory) ? boFactory = new BoFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BoType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case PROGRAMME:
                return (T) new ProgrammeBOImpl();
            default:
                return null;
        }
    }
}

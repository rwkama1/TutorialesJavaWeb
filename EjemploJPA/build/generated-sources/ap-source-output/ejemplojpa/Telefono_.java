package ejemplojpa;

import ejemplojpa.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-19T19:22:25")
@StaticMetamodel(Telefono.class)
public class Telefono_ { 

    public static volatile SingularAttribute<Telefono, String> numero;
    public static volatile SingularAttribute<Telefono, Empleado> empleado;
    public static volatile SingularAttribute<Telefono, Integer> id;

}
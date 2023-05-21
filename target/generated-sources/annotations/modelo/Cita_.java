package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Medico;
import modelo.Paciente;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-05-21T18:40:16")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, Integer> idCita;
    public static volatile SingularAttribute<Cita, Paciente> idPaciente;
    public static volatile SingularAttribute<Cita, Medico> idMedico;
    public static volatile SingularAttribute<Cita, Integer> orden;

}
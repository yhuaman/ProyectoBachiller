/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.Cita;
import modelo.Medico;
import modelo.MedicoDTO;

/**
 *
 * @author Brandon
 */
public class MedicoDAO {

    public MedicoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<MedicoDTO> listarMedicoByEspecialidad(int idEspecialidad) {
        String jpql;
        EntityManager em = getEntityManager();
        List<MedicoDTO> medicosDTO;
        try {
            jpql = "SELECT M FROM Medico AS M where M.idEspecialidad.idEspecialidad=:idEspecialidad";
            TypedQuery<Medico> query = (TypedQuery<Medico>) this.getEntityManager().createQuery(jpql, Medico.class);
            query.setParameter("idEspecialidad", idEspecialidad);
            List<Medico> medicos = query.getResultList();
            medicosDTO = new ArrayList<>();

            medicos.stream().map(medico -> {
                MedicoDTO medicoDTO = new MedicoDTO();
                medicoDTO.setIdMedico(medico.getIdMedico());
                medicoDTO.setNombreMedico(medico.getNombreMedico());
                medicoDTO.setApellidoMat(medico.getApellidoMat());
                medicoDTO.setApellidoPat(medico.getApellidoPat());
                medicoDTO.setTelefono(medico.getTelefono());
                medicoDTO.setIdEspecialidad(medico.getIdEspecialidad().getIdEspecialidad());
                medicoDTO.setNombreEspecialidad(medico.getIdEspecialidad().getNombreEspecialidad());
// Mapea los demás campos necesarios
                return medicoDTO;
            }).forEachOrdered(medicoDTO -> {
                medicosDTO.add(medicoDTO);
            });
        } finally {
            em.close();
        }
        return medicosDTO;
    }

    public MedicoDTO findMedico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            Medico medico = em.find(Medico.class, id);
            MedicoDTO medicoDTO = new MedicoDTO();
            medicoDTO.setIdMedico(medico.getIdMedico());
            medicoDTO.setNombreMedico(medico.getNombreMedico());
            medicoDTO.setApellidoMat(medico.getApellidoMat());
            medicoDTO.setApellidoPat(medico.getApellidoPat());
            medicoDTO.setTelefono(medico.getTelefono());
            medicoDTO.setIdEspecialidad(medico.getIdEspecialidad().getIdEspecialidad());
            medicoDTO.setNombreEspecialidad(medico.getIdEspecialidad().getNombreEspecialidad());
            return medicoDTO;
        } finally {
            em.close();
        }
    }
}

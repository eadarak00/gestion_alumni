package uasz.alumni.ms_user.service;

import uasz.alumni.ms_user.dto.AlumniRequest;
import uasz.alumni.ms_user.dto.AlumniResponse;
import uasz.alumni.ms_user.model.Alumni;

import java.util.List;

public interface IAlumni {

    /** Crée un nouvel alumni */
    AlumniResponse create(AlumniRequest request);

    /** Récupère tous les alumni non supprimés */
    List<AlumniResponse> getAll();

    /** Récupère un alumni par son ID */
    AlumniResponse getById(Long id);

    /** Met à jour un alumni existant */
    AlumniResponse update(Long id, AlumniRequest request);

    /** Supprime un alumni (soft delete) */
    void delete(Long id);


}

package uasz.alumni.ms_user.mapper;

import org.springframework.stereotype.Component;
import uasz.alumni.ms_user.dto.AlumniRequest;
import uasz.alumni.ms_user.dto.AlumniResponse;
import uasz.alumni.ms_user.model.Alumni;

@Component
public class AlumniMapper {
    /** Convertit AlumniRequest → Alumni pour CREATE */
    public Alumni toEntity(AlumniRequest request){
        if (request == null) return null;
        Alumni alumni = new Alumni();
        alumni.setNom(request.getNom());
        alumni.setPrenom(request.getPrenom());
        alumni.setEmail(request.getEmail());
        alumni.setTelephone(request.getTelephone());
        alumni.setPassword(request.getPassword()); // hash dans le service
        alumni.setProfession(request.getProfession());
        alumni.setEntreprise(request.getEntreprise());
        return alumni;
    }

    /** Convertit Alumni → AlumniResponse */
    public AlumniResponse toResponse(Alumni alumni) {
        if (alumni == null) return null;

        AlumniResponse response = new AlumniResponse();
        response.setId(alumni.getId());
        response.setCreatedAt(alumni.getCreatedAt());
        response.setUpdatedAt(alumni.getUpdatedAt());
        response.setNom(alumni.getNom());
        response.setPrenom(alumni.getPrenom());
        response.setEmail(alumni.getEmail());
        response.setTelephone(alumni.getTelephone());
        response.setProfession(alumni.getProfession());
        response.setEntreprise(alumni.getEntreprise());

        return response;
    }
}

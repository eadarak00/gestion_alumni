package uasz.alumni.ms_user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uasz.alumni.ms_user.dto.AlumniRequest;
import uasz.alumni.ms_user.dto.AlumniResponse;
import uasz.alumni.ms_user.exception.AlumniExiste;
import uasz.alumni.ms_user.exception.AlumniNotfound;
import uasz.alumni.ms_user.mapper.AlumniMapper;
import uasz.alumni.ms_user.model.Alumni;
import uasz.alumni.ms_user.repository.AlumniRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlumniService{

    private final AlumniRepository repository;
    private final AlumniMapper mapper;

    
    public AlumniResponse create(AlumniRequest request) {
         Alumni alumni = repository.findByEmail(request.getEmail());
         if(alumni!=null)
             throw new AlumniExiste("Utilsateur existe!!");
         alumni=mapper.toEntity(request);
        return mapper.toResponse(repository.save(alumni));
    }

    
}

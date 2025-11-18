package uasz.alumni.ms_user.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import uasz.alumni.ms_user.dto.AlumniRequest;
import uasz.alumni.ms_user.dto.AlumniResponse;
import uasz.alumni.ms_user.service.AlumniService;

@RestController
@RequestMapping("api/v1/auth")
public class AlumniController {

    private final AlumniService serviceAlumni;

    public AlumniController(AlumniService serviceAlumni) {
        this.serviceAlumni = serviceAlumni;
    }

    @PostMapping("/inscription-alumni")
    public AlumniResponse create(@RequestBody @Valid AlumniRequest request) {
        return serviceAlumni.create(request);
    }
}

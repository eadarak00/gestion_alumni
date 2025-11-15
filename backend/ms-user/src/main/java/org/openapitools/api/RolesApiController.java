package org.openapitools.api;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.context.request.NativeWebRequest;


import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-14T21:47:29.555388808Z[Africa/Dakar]", comments = "Generator version: 7.17.0")
@Controller
@RequestMapping("${openapi.utilisateurService.base-path:/api/auth}")
public class RolesApiController implements RolesApi {

    private final NativeWebRequest request;

    @Autowired
    public RolesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}

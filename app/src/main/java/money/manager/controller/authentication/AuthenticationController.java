package money.manager.controller.authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import money.manager.controller.authentication.dto.LoginRequestDto;
import money.manager.controller.authentication.dto.LoginResponseDto;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid final LoginRequestDto input) {

        final var aServiceInput = LoginRequestToLoginServiceInputMapper.build().apply(input);

        final var aToken = authService.login(aServiceInput).token();

        final var aResponse = new LoginResponseDto(aToken);

        return ResponseEntity.ok(aResponse);
    }
    
}

package business.services.security;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Class defining LoginData used in the DonorServiceEndpoint
@Data
@NoArgsConstructor
@Getter
@Setter
public class LoginData {
    private String username;
    private String password;
}

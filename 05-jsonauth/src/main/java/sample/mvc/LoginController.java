package sample.mvc;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {
	private static final ResponseEntity<String> VALID = new ResponseEntity<String>("Success", HttpStatus.OK);
	public static final ResponseEntity<String> INVALID = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserCredentials user) {
		String username = user.getUsername();
		if(username == null || "missing".equals(username)) {
			return INVALID;
		}
		String password = user.getPassword();
		if("password".equals(password)) {
			// FIXME Authenticate the user
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
			SecurityContext context = null;
			UsernamePasswordAuthenticationToken authentication = null;
			return VALID;
		}
		return INVALID;
	}
}

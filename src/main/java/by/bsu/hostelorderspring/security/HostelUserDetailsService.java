package by.bsu.hostelorderspring.security;

import by.bsu.hostelorderspring.entity.HostelUser;
import by.bsu.hostelorderspring.service.HostelUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HostelUserDetailsService implements UserDetailsService {

    private final HostelUserService userService;
    /**
     * @param username the username identifying the user whose data is required.
     * @return {@link HostelUserDetails}
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HostelUser user = userService.getUserByEmail(username);

        return new HostelUserDetails(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getAuthority().name()))
        );
    }
}

package by.bsu.hostelorderspring.service;

import by.bsu.hostelorderspring.entity.HostelUser;
import by.bsu.hostelorderspring.repository.HostelUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostelUserService {

    private final HostelUserRepository userRepository;

    public HostelUser getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Cannot find user with id %d", id)
                ));
    }

    public HostelUser getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Cannot find user with email %s", email)
                ));
    }
}

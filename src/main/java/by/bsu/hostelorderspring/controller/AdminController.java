package by.bsu.hostelorderspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
}

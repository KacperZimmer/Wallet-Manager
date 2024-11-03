package org.example.walletmanagement.Controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SessionController {

    private final SessionRegistry sessionRegistry;

    public SessionController(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @GetMapping("/session-count")
    public int getCurrentSessionCount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            List<Object> sessions = Collections.singletonList(sessionRegistry.getAllSessions(authentication.getPrincipal(), false));
            return sessions.size();
        }

        return 0;
    }
}

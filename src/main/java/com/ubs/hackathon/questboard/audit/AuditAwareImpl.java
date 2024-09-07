package com.ubs.hackathon.questboard.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("QUESTBOARD_SYSTEM");
    }

//    public String getCurrentAuditor() {
//        return "Naresh";
//        // Can use Spring Security to return currently logged in user
//        // return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
//    }
}

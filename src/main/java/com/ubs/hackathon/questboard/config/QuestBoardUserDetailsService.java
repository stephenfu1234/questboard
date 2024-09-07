package com.ubs.hackathon.questboard.config;

import com.ubs.hackathon.questboard.entity.UbsUser;
import com.ubs.hackathon.questboard.repository.UbsUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestBoardUserDetailsService implements UserDetailsService {

    private final UbsUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String gpn) throws UsernameNotFoundException {
        UbsUser user = userRepository.findByGpn(gpn).orElseThrow(() -> new UsernameNotFoundException("User details not found for the user: " + gpn));
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole()));

        return new User(user.getGpn(), user.getPassword(), authorities);
    }
}

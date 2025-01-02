package com.example.BlogStart.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        // 데이터베이스에서 사용자 조회
        Optional<User> _user = this.userRepository.findByUsername(userId);

        if (_user.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + userId);
        }
        User user = _user.get();

        // 권한 목록 생성
        List<GrantedAuthority> authorities = new ArrayList<>();

        // 역할을 ROLE_ 접두어와 함께 부여
        if ("admin".equals(userId)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + UserRole.ADMIN.name()));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + UserRole.USER.name()));
        }

        // UserDetails 객체 반환
        return new org.springframework.security.core.userdetails.User(user.getUser_id(), user.getPassword(), authorities);
    }
}
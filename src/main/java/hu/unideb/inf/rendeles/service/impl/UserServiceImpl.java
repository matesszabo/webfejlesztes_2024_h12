package hu.unideb.inf.rendeles.service.impl;

import hu.unideb.inf.rendeles.data.repository.FelhasznaloRepository;
import hu.unideb.inf.rendeles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    FelhasznaloRepository repository;

    @Override
    public UserDetailsService userDetailsService() {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return repository.findByEmail(username);
            }
        };
    }
}

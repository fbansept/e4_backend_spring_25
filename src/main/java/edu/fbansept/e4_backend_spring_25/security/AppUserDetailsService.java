package edu.fbansept.e4_backend_spring_25.security;

import edu.fbansept.e4_backend_spring_25.dao.UtilisateurDao;
import edu.fbansept.e4_backend_spring_25.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UtilisateurDao utilisateurDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Utilisateur> utilisateurOptional = utilisateurDao.findByEmail(email);

        if (utilisateurOptional.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }

        return new AppUserDetails(utilisateurOptional.get());
    }
}

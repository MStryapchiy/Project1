package com.project1.Services;

import org.springframework.stereotype.Service;
@Service
public interface UserService {
    //@Autowired
    //private UserRepo userRepository;
    //@Autowired
    //private RoleRepository roleRepository;
    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*public UserDetails findUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(Role.USER));
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
     */
}

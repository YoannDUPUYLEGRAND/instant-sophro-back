package yoanndlg.java_instant_sophro.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsServiceConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user@example.com").password("{noop}password").roles("USER").build());
        manager.createUser(User.withUsername("admin@example.com").password("{noop}password").roles("ADMIN").build());
        return manager;
    }
}
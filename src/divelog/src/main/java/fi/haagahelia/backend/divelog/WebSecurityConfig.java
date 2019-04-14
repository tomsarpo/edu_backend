package fi.haagahelia.backend.divelog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .anyRequest()
//            .permitAll()
//            .and().csrf().disable();
    	
//    	http.authorizeRequests()
//    	.antMatchers("/", "/home").permitAll()
//    	.anyRequest().authenticated()
//    	.and()
//    	.formLogin()
//    	.loginPage("/login")
//    	.permitAll()
//    	.and()
//    	.authorizeRequests().antMatchers("**admin**").hasRole("ADMIN")
//    	.anyRequest().authenticated()
//    	.and()
//    	.logout()
//    	.permitAll();
    }
    
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//    @SuppressWarnings("deprecation")
//	UserDetails user = User.withDefaultPasswordEncoder()
//    .username("Tomi")
//    .password("123")
//    .roles("ADMIN")
//    .build();
//    return new InMemoryUserDetailsManager(user);
//    }
    
}
package com.group3.onlineShooping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("JPAUserDetailService")
    @Autowired
    UserDetailsService userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/", "/h2-console/**").permitAll()
                .and().formLogin();


        //Those two settings below is to enable access h2 database via browser
        http.csrf().disable();
        http.headers().frameOptions().disable();*/
        http.authorizeRequests().antMatchers("/h2/**").permitAll();
        http.authorizeRequests().antMatchers("/", "/login", "/registration", "/h2/**").permitAll()
                // .antMatchers("/cartItem/**").hasRole("SELLER")
                //.antMatchers("/SELLER/SELLER/**").hasRole("BUYER")
                //.antMatchers("/SELLER").hasAnyRole("SELLER", "USER")
                .antMatchers("/market/**").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/index")
                .and()
                .logout()
                .and().csrf()
                .ignoringAntMatchers("/h2/**") //don't apply CSRF protection to /h2-console
                .and()
                .exceptionHandling().accessDeniedPage("/error/access-denied");
        // http.rememberMe().rememberMeParameter("remember-me").key("uniqueAndSecret");
        http.headers().frameOptions().disable();


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

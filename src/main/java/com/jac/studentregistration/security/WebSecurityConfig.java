package com.jac.studentregistration.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.servlet.Filter;

/**
 * Created by sang on 2017/1/10.
 */
@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .antMatchers("/*/**").permitAll()
/*                .antMatchers("/level1/**").hasRole("MANAGER")
                .antMatchers("/level2/**").hasRole("USER")
                .antMatchers("/level3/**").hasRole("ADMIN")*/
                //没有login controller 直接转到login.html
/*                .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/user/loginform")
                .failureUrl("/login?error").permitAll()
                .and()
                .logout()
                .permitAll()*/
                .and()
                .csrf().disable();
    }

}

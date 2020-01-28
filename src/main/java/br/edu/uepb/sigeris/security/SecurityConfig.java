package br.edu.uepb.sigeris.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Cássio Oliveira
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public SystemUserDetailsService userDetailsService() {
        return new SystemUserDetailsService();
    }

    /**
     *  Referência das permissões a serem utilizadas
     *  
     *  ADMINISTRADORES
     *  MATEMATICA
     *  LETRAS
     *  CONTABEIS
     *  DIRECAO
     *  BIBLIOTECA
     *  CPD
     *  
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JsfLoginUrlAuthenticationEntryPoint jsfLoginEntry = new JsfLoginUrlAuthenticationEntryPoint();
        jsfLoginEntry.setLoginFormUrl("/login.xhtml");
        jsfLoginEntry.setRedirectStrategy(new JsfRedirectStrategy());
        
        JsfAccessDeniedHandler jsfDeniedEntry = new JsfAccessDeniedHandler();
        jsfDeniedEntry.setLoginPath("/acesso-negado.xhtml");
        jsfDeniedEntry.setContextRelative(true);
        
        http//
            .csrf().disable()
            .headers().frameOptions().sameOrigin()
            .and()
                
        .authorizeRequests()//
                .antMatchers("/login.xhtml", "/error.xhtml", "/javax.faces.resource/**").permitAll()
                .antMatchers("/inicio.xhtml","/acesso-negado.xhtml").authenticated()
                .antMatchers("/**").hasRole("ADMINISTRADORES")
                .and()
                
        .formLogin()//
                .loginPage("/login.xhtml")
                .failureUrl("/login.xhtml?invalid=true")
                .defaultSuccessUrl("/inicio.xhtml", true)
                .and()
                
        .logout()//
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                
        .exceptionHandling()//
                .accessDeniedPage("/acesso-negado.xhtml")
                .authenticationEntryPoint(jsfLoginEntry)
                .accessDeniedHandler(jsfDeniedEntry);
    }
}

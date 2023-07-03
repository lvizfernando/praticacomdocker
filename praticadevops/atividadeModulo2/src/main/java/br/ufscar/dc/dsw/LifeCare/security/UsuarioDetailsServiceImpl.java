package br.ufscar.dc.dsw.LifeCare.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.ufscar.dc.dsw.LifeCare.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.LifeCare.domain.Usuario;

public class UsuarioDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private IUsuarioDAO dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = dao.findByEmail(username);

        if(usuario == null){
            throw new UsernameNotFoundException("usuario não encontrado");
        }

        return new UsuarioDetails(usuario);
    }

}
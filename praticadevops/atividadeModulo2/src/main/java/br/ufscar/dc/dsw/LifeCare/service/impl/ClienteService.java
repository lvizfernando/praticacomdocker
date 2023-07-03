package br.ufscar.dc.dsw.LifeCare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.LifeCare.dao.IClienteDAO;
import br.ufscar.dc.dsw.LifeCare.dao.IConsultaDAO;
import br.ufscar.dc.dsw.LifeCare.domain.Cliente;
import br.ufscar.dc.dsw.LifeCare.service.spec.IClienteService;

@Service
@Transactional(readOnly = false)
public class ClienteService implements IClienteService {
    @Autowired
    IClienteDAO dao;

    @Autowired
    IConsultaDAO consultaDAO;

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return dao.findById(id.longValue());
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorEmail(String email) {
        return dao.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarTodos() {
        return dao.findAll();
    }

    public void salvar(Cliente cliente) {
        dao.save(cliente);
    }

    public void excluir(Long id) {
        consultaDAO.deleteAllByCliente(this.buscarPorId(id));
        dao.deleteById(id);
    }

}

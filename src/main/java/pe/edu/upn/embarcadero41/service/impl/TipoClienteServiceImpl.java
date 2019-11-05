package pe.edu.upn.embarcadero41.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.embarcadero41.model.entity.TipoCliente;
import pe.edu.upn.embarcadero41.model.repository.TipoClienteRepository;
import pe.edu.upn.embarcadero41.service.TipoClienteService;

@Service
public class TipoClienteServiceImpl implements TipoClienteService{

	@Autowired
	private TipoClienteRepository tipoClienteRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<TipoCliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipoClienteRepository.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<TipoCliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return tipoClienteRepository.findById(id);
	}

	@Transactional
	@Override
	public TipoCliente save(TipoCliente entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoClienteRepository.save(entity);
	}

	@Transactional
	@Override
	public TipoCliente update(TipoCliente entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoClienteRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tipoClienteRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		tipoClienteRepository.deleteAll();
		
	}

}

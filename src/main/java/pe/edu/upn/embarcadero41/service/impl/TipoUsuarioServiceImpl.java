package pe.edu.upn.embarcadero41.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.embarcadero41.model.entity.TipoPersonal;
import pe.edu.upn.embarcadero41.model.repository.TipoPersonalRepository;
import pe.edu.upn.embarcadero41.service.TipoPersonalService;

@Service
public class TipoUsuarioServiceImpl implements TipoPersonalService {

	@Autowired
	private TipoPersonalRepository tipoPersonalRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<TipoPersonal> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipoPersonalRepository.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<TipoPersonal> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return tipoPersonalRepository.findById(id);
	}

	@Transactional
	@Override
	public TipoPersonal save(TipoPersonal entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoPersonalRepository.save(entity);
	}

	@Transactional
	@Override
	public TipoPersonal update(TipoPersonal entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoPersonalRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		tipoPersonalRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		tipoPersonalRepository.deleteAll();
		
	}

}

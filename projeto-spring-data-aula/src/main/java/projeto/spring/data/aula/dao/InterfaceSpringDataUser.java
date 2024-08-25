package projeto.spring.data.aula.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.LockModeType;
import projeto.spring.data.aula.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {
	
	/* "UsuarioSpringData" -> é o nome da Classe; não é o nome da tabela no banco */
	@Transactional(readOnly = true)
	@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
	public List<UsuarioSpringData> buscaPorNome(String nome);
	
	@Lock(LockModeType.READ)
	@Transactional(readOnly = true)
	@Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
	public UsuarioSpringData buscaPorNomeParam(@Param("paramnome") String paramnome);
	
	
	default <S extends UsuarioSpringData> S saveAtual(S entity) {
		// processa qualquer coisa
		return save(entity);
	}
	
	@Modifying
	@Transactional
	@Query(value = "delete from UsuarioSpringData u where u.nome = ?1 ")
	public void deletePorNome(String nome);
	
	@Modifying
	@Transactional
	@Query(value = "update UsuarioSpringData u set u.email = ?2 where u.id = ?1 ")
	public void UpdateEmailPorId(Long id, String email);


}

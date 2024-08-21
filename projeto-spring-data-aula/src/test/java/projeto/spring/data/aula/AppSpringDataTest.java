package projeto.spring.data.aula;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void testeInsert() {
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("thiers.fb@gmail.com");
		usuarioSpringData.setIdade(36);
		usuarioSpringData.setLogin("thiersfb");
		usuarioSpringData.setSenha("thiers07");
		usuarioSpringData.setNome("Thiers Barizon");
		
		interfaceSpringDataUser.save(usuarioSpringData);
		
		System.out.println("Qtd Usuarios cadastrados no banco: " + interfaceSpringDataUser.count());
		
	}
	
	@Test
	public void testeConsulta() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);

		System.out.println("Id     :   "+ usuarioSpringData.get().getId());
		System.out.println("Nome   :   "+ usuarioSpringData.get().getNome());
		System.out.println("Idade  :   "+ usuarioSpringData.get().getIdade());
		System.out.println("Login  :   "+ usuarioSpringData.get().getLogin());
		System.out.println("Senha  :   "+ usuarioSpringData.get().getSenha());
		
		
	}

	@Test
	public void testeConsultaTodos() {
		
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println("Id     :   "+ usuarioSpringData.getId());
			System.out.println("Nome   :   "+ usuarioSpringData.getNome());
			System.out.println("Idade  :   "+ usuarioSpringData.getIdade());
			System.out.println("Login  :   "+ usuarioSpringData.getLogin());
			System.out.println("Senha  :   "+ usuarioSpringData.getSenha());
			System.out.println("----------------------------");
			
		}
		
	}
	

	@Test
	public void testeUpdate() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		UsuarioSpringData usuario = usuarioSpringData.get();
		
		usuario.setEmail("thiers.fb@gmail.com");

		interfaceSpringDataUser.save(usuario);
		
	}
	
}

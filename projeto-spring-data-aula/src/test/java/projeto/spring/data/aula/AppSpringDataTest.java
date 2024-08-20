package projeto.spring.data.aula;

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
		System.out.println("Iniciou spring com sucesso");
	}
	
}

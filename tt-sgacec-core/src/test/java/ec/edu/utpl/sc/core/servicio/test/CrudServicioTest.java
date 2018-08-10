package ec.edu.utpl.sc.core.servicio.test;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.servicio.test.config.CommonSpringConfigTest;
import ec.edu.utpl.sc.core.util.FwUtplFactory;
import ec.edu.utpl.sc.core.util.UtplException;

@RunWith(SpringJUnit4ClassRunner.class)
public class CrudServicioTest extends CommonSpringConfigTest implements Serializable {
	
	private static final long serialVersionUID = 3103551548610538479L;
	
	protected static final Logger log = Logger.getLogger(CrudServicioTest.class); 

	@Test
	public void createUsuario() {
		try {
			Usuario usuario = new Usuario();
			usuario.setUserName("scabrera");
			usuario.setCedulaRuc("1718834342");
			usuario.setNombres("Santiago");
			usuario.setApellidos("Cabrera");
			usuario.setEmail("santiago.cabrera.murillo@gmail.com");
			usuario.setDireccion("Los Mastodontes");
			usuario.setTelefonoConvencional("023441237");
			usuario.setTelefonoCelular("0993796917");
			usuario.setClaveUno("scabrera");
			usuario.setRespuestaSeguridad("scabrera");
			usuario.setFechaIngreso(new Date());
			
			FwUtplFactory.getIntance().getCrudService().create(usuario);
			
			log.info("Usuario creado exitosamente: " + usuario.getNombres());

		} catch (UtplException e) {
			log.error(e);
		}
	}

}

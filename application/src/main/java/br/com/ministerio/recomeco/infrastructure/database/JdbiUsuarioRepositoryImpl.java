package br.com.ministerio.recomeco.infrastructure.database;

import br.com.ministerio.recomeco.domain.dto.Usuario;
import br.com.ministerio.recomeco.port.UsuarioRepository;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.springframework.stereotype.Repository;

@UseClasspathSqlLocator
@Repository
public interface JdbiUsuarioRepositoryImpl extends UsuarioRepository {

    @Override
    @SqlQuery
    @RegisterBeanMapper(Usuario.class)
    Usuario obterUsername(@Bind String username);
}

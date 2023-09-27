package br.com.ministerio.recomeco.infrastructure.database;

import br.com.ministerio.recomeco.domain.dto.Usuario;
import br.com.ministerio.recomeco.port.UsuarioRepository;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@UseClasspathSqlLocator
@Repository
public interface JdbiUsuarioRepositoryImpl extends UsuarioRepository {

    @Override
    @SqlQuery
    @RegisterBeanMapper(Usuario.class)
    Usuario obterUsername(@Bind String username);

    @Override
    @SqlUpdate
    @RegisterBeanMapper(Usuario.class)
    void criar(@BindBean Usuario usuario);

}

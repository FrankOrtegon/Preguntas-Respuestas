package co.com.sofka.okr.c2.config;

import co.com.sofka.okr.c2.model.okrs.gateways.KRSRepository;
import co.com.sofka.okr.c2.model.okrs.gateways.OKRSRepository;
import co.com.sofka.okr.c2.model.usuarios.gateways.UsuariosRepository;
import co.com.sofka.okr.c2.usecase.okr.KRUseCase;
import co.com.sofka.okr.c2.usecase.okr.OKRUseCase;
import co.com.sofka.okr.c2.usecase.usuario.UsuarioUseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.sofka.okr.c2.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        public OKRUseCase okrUseCase(OKRSRepository repository){
                return new OKRUseCase(repository);
        }

        public KRUseCase krUseCase(KRSRepository repository){
                return new KRUseCase(repository);
        }

        public UsuarioUseCase userCase(UsuariosRepository usuariosRepository){
                return new UsuarioUseCase(usuariosRepository);
        }
}

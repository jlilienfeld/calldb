package com.jlilienfeld.calldb;

import com.jlilienfeld.calldb.rest.model.CallEntity;
import com.jlilienfeld.calldb.rest.model.CallMethodEntity;
import com.jlilienfeld.calldb.rest.model.CityEntity;
import com.jlilienfeld.calldb.rest.model.ParticipantRoleEntity;
import com.jlilienfeld.calldb.rest.model.PersonEntity;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class RestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {

        cors.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(false).maxAge(3600);
        config.exposeIdsFor(PersonEntity.class);
        config.exposeIdsFor(CityEntity.class);
        config.exposeIdsFor(ParticipantRoleEntity.class);
        config.exposeIdsFor(CallMethodEntity.class);
        config.exposeIdsFor(CallEntity.class);
    }

}
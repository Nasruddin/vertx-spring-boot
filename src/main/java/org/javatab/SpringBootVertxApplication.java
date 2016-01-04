package org.javatab;

import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootVertxApplication {

    @Autowired
    private StaticServer staticServer;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVertxApplication.class, args);
	}

    @PostConstruct
    public void deployVerticle() {
        Vertx.vertx().deployVerticle(staticServer);
    }
}

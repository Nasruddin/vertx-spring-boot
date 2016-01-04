package org.javatab;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

/**
 * Created by nasir on 4/1/16.
 */
public class StaticServer extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);

        //Serve static pages
        router.route().handler(StaticHandler.create());

        vertx.createHttpServer().requestHandler(router::accept).listen(8080, res ->
        {
            if (res.failed()) {
                System.err.println("Couldn't start the http server");
                return;
            } else {
                System.out.println("Http server is up and running");
            }
        });
    }
}

package xyz.yishe.pigeon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author owen
 * @date 2020-03-19 19:44
 */
@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        Environment env = app.run(args).getEnvironment();
        int port = Integer.parseInt(env.getProperty("server.port"));
        log.info(
                "Access URLs:\n----------------------------------------------------------\n\t"
                        + "Swagger-UI: http://127.0.0.1:{}/swagger-ui.html\n\t"
                        + "Local:      http://127.0.0.1:{}\n\t"
                        + "External:   http://{}:{}\n----------------------------------------------------------",
                port, port, InetAddress.getLocalHost().getHostAddress(), port
        );
    }
}

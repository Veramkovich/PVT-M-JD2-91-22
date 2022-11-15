package my.first.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.net.http.HttpClient;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Configuration
@ComponentScan(basePackages = "my.first.service")
public class ServiceContextConfig {

    @Bean(name = "httpClientWithTimeout")
    @Primary
    public HttpClient httpClient() {
        return HttpClient
                .newBuilder()
                .connectTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();
    }

    @Bean(name = "simpleHttpClient")
    public HttpClient httpClient1() {
        return HttpClient.newHttpClient();
    }

}

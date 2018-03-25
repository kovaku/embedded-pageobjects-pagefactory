package com.github.kovaku.config;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.github.kovaku")
public class TestConfig {

    @Bean(destroyMethod = "close")
    public WebDriver webDriver() {
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver();
    }
}

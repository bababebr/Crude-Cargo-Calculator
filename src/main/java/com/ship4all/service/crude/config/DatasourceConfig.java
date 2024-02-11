package com.ship4all.service.crude.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@Slf4j
@Component
public class DatasourceConfig {

  private String dataSourceUrl = "jdbc:postgresql://localhost:6541/CalibrationTable";
  private String dataSourceUsername = "root";
  private String dataSourcePassword = "root";

  @Bean
  @Primary
  public DataSource getDataSource() {
    final HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setMaximumPoolSize(2);
    hikariConfig.setJdbcUrl(dataSourceUrl);
    hikariConfig.setUsername(dataSourceUsername);
    hikariConfig.setPassword(dataSourcePassword);
    return new HikariDataSource(hikariConfig);
  }
}
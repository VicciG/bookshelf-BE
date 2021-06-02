package com.bookshelf.config;

import com.bookshelf.book.BookDao;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;


@Configuration
@ConfigurationProperties("db")
public class JDBIConfig {

    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(url)
                .username(user)
                .password(password)
                .build();
    }

    @Bean
    public Jdbi jdbi(DataSource dataSource)  {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(dataSource);
        Jdbi jdbi = Jdbi.create(proxy);
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }

    @Bean
    public BookDao bookDao(Jdbi jdbi) {
        return jdbi.onDemand(BookDao.class);
    }


}

package com.bookshelf.bookshelf.config;

import com.bookshelf.bookshelf.book.BookDao;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;


@Configuration
public class JDBIConfig {

    //TODO remove hard coded params
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/bookshelf")
                .username("postgres")
                .password("password")
                .driverClassName("org.postgresql.Driver")
        .build();
    }

    @Bean
    public Jdbi jdbi(DataSource dataSource)  {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(dataSource);
        Jdbi jdbi = Jdbi.create(proxy);
        jdbi.installPlugin(new PostgresPlugin());
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }

    @Bean
    public BookDao bookDao(Jdbi jdbi) {
        return jdbi.onDemand(BookDao.class);
    }


}

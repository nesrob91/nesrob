package mx.com.elektra.msd.qb.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DataSourceConfiguration {

    @Bean("DataSourceFirst")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Autowired
    @Bean("Firstjdbc")
    public JdbcTemplate firstJdbcTemplate(@Qualifier("DataSourceFirst") DataSource dataSourceFirst) {
        return new JdbcTemplate(dataSourceFirst);
    }
    
    
    @Primary
    @Bean("DataSourceUM")
    @ConfigurationProperties(prefix = "datasource.um")
    public DataSource umDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Autowired
    @Bean("um")
    public NamedParameterJdbcTemplate umNamedTemplate(@Qualifier("DataSourceUM") DataSource dataSourceUM) {
        return new NamedParameterJdbcTemplate(dataSourceUM);
    }
    
    @Bean("DataSourceSccp")
    @ConfigurationProperties(prefix = "datasource.sccp")
    public DataSource sccpDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Autowired
    @Bean("scpp")
    public NamedParameterJdbcTemplate sccpNamedTemplate(@Qualifier("DataSourceSccp") DataSource dataSourceSccp) {
        return new NamedParameterJdbcTemplate(dataSourceSccp);
    }

//	@Bean("DataSourceSecond")
//	@ConfigurationProperties(prefix = "second.datasource")
//	public DataSource firstDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//	@Autowired
//	@Bean("Secondjdbc")
//	public JdbcTemplate firstJdbcTemplate(@Qualifier("DataSourceSecond") DataSource dataSourceSecond) {
//		return new JdbcTemplate(dataSourceSecond);
//	}
}

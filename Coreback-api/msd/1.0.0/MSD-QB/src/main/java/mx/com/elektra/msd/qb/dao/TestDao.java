package mx.com.elektra.msd.qb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TestDao {

    @Autowired
    @Qualifier("Firstjdbc")
    JdbcTemplate jdbcTemplate;

//	@Autowired
//	@Qualifier("Secondjdbc")
//	JdbcTemplate jdbcTemplates;
    public String getTest() {
        return jdbcTemplate.queryForObject("SELECT DUMMY FROM DUAL", String.class);
    }

//	public String getTestSecond() {
//		return jdbcTemplates.queryForObject("SELECT DUMMY||'-Test2' FROM DUAL", String.class);
//	}
}

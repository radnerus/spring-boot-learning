//package com.example.demo.dao;
//
//import org.springframework.stereotype.Repository;
//
//@Repository("postgres")
//public class PersonDataAccessService implements PersonDao {
//
////	private final JdbcTemplate jdbcTemplate;
////
////	@Autowired
////	public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
////		super();
////		this.jdbcTemplate = jdbcTemplate;
////	}
////
////	@Override
////	public int insertPerson(UUID id, Person person) {
////		// TODO Auto-generated method stub
////		return 0;
////	}
////
////	@Override
////	public List<Person> selectAllPeople() {
////		final String sql = "SELECT id, name from person";
//////		List<Person> people = jdbcTemplate.query(sql, (resultSet, i) -> {
//////			UUID id = UUID.fromString(resultSet.getString("id"));
//////			String name = resultSet.getString("name");
////////			return new Person(id, name);
//////		});
//////
//////		return people;
////		return new ArrayList<Person>();
////	}
////
////	@Override
////	public Optional<Person> selectPersonById(UUID id) {
////		// TODO Auto-generated method stub
////		return null;
////	}
////
////	@Override
////	public int deletePersonById(UUID id) {
////		// TODO Auto-generated method stub
////		return 0;
////	}
////
////	@Override
////	public int updatePersonById(UUID id, Person person) {
////		// TODO Auto-generated method stub
////		return 0;
////	}
//
//}

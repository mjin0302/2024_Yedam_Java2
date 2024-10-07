package chap08;

public class DaoMain {

	public static void main(String[] args) {
		
		dbWork(new Oracle());
		dbWork(new MySql());
		
	}

	private static void dbWork(DataAccessObject dao) {
		
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		
	}

}

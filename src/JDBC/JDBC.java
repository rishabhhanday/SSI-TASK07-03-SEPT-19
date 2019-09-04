package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC {
	static int empNo = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// step-1 (Driver-Loading)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded");
			// step-2 (Connection Establishment)
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "rishabh", "abcd1234");
			System.out.println("Connected Successfully");
			// step-3 (Define SQL Statement)
			System.out.println("SENDING SQL TO DB......");
			outer: while (true) {
				System.out.println("1. Create table \n 2. Insert table \n 3.Delete table \n 4. Update Salary ");
				int option = sc.nextInt();
				String sql;
				switch (option) {
				case 1:
					sql = "CREATE TABLE EMP(EMPNO NUMBER PRIMARY KEY,EMPNAME VARCHAR2(20),EMPSALARY NUMBER,EMPDESG VARCHAR2(20))";
					// step-4 (Send the SQL statement to DB)
					Statement stmt = con.createStatement();
					int n = stmt.executeUpdate(sql);
					System.out.println(n + " Row Added");
					break;
				case 2:
					System.out.println("Enter ename");
					String name = sc.next();
					System.out.println("Enter emp salary");
					int salary = sc.nextInt();
					System.out.println("Enter emp designation");
					String desg = sc.next();
					sql = "INSERT INTO EMP(EMPNO,EMPNAME,EMPSALARY,EMPDESG) VALUES("+ (empNo++)+",'"+name+"'," +salary+ ",'"+desg+"')";
					// step-4 (Send the SQL statement to DB)
					Statement stmt1 = con.createStatement();
					int n1 = stmt1.executeUpdate(sql);
					System.out.println(n1 + " Row Added");
					break;
				case 3:
					System.out.println("Enter empno to delete");
					int empno = sc.nextInt();
					sql = "DELETE FROM EMP where EMPNO =" + empno;
					// step-4 (Send the SQL statement to DB)
					Statement stmt2 = con.createStatement();
					int n2 = stmt2.executeUpdate(sql);
					System.out.println(n2 + " Row Added");
					break;
				case 4:
					System.out.println("Enter empno to update");
					int empno1 = sc.nextInt();
					System.out.println("Enter new salary");
					int salary1 = sc.nextInt();
					sql = "UPDATE EMP SET EMPSALARY ="+salary1+" where EMPNO="+empno1;
					// step-4 (Send the SQL statement to DB)
					Statement stmt3 = con.createStatement();
					int n3 = stmt3.executeUpdate(sql);
					System.out.println(n3 + " Row Added");
					break;
				case 5:
					break outer;

				}
			}

			// step-5 (Close the Database Connection)
			con.close();

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}

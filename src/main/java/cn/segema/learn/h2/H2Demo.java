package cn.segema.learn.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

/**
 * @description H2
 * java -jar ~/h2-1.4.190.jar -tcpAllowOthers
 * TCP服务端口为9092，客户端的端口为8082，PG服务的端口为5435
 * @author wangyong
 * @createDate 2021/07/31
 */
public class H2Demo {

	public static void main(String[] args) {

		try {
			Class.forName("org.h2.Driver");
			// 嵌入式(本地文件)
			Connection connection = DriverManager.getConnection("jdbc:h2:~/h2test", "sa", "123456");
			// 内存模式(私有)
//			Connection connection = DriverManager.getConnection("jdbc:h2:mem:situation", "sa", "123456");
			//远程模式
//			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/h2test", "sa", "123456");

			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER_INFO ");
			while (rs.next()) {
				System.out.println(rs.getString("id") + "," + rs.getString("name")+ "," + rs.getString("sex"));
			}
			
			stmt.execute("DROP TABLE IF EXISTS USER_INFO");
			stmt.execute("CREATE TABLE USER_INFO(id VARCHAR(36) PRIMARY KEY,name VARCHAR(100),sex VARCHAR(4))");

			stmt.executeUpdate("INSERT INTO USER_INFO VALUES('" + UUID.randomUUID() + "','大日如来','男')");
			stmt.executeUpdate("INSERT INTO USER_INFO VALUES('" + UUID.randomUUID() + "','青龙','男')");
			stmt.executeUpdate("INSERT INTO USER_INFO VALUES('" + UUID.randomUUID() + "','白虎','男')");
			stmt.executeUpdate("INSERT INTO USER_INFO VALUES('" + UUID.randomUUID() + "','朱雀','女')");
			stmt.executeUpdate("INSERT INTO USER_INFO VALUES('" + UUID.randomUUID() + "','玄武','男')");
			stmt.executeUpdate("INSERT INTO USER_INFO VALUES('" + UUID.randomUUID() + "','苍狼','男')");
			
			stmt.executeUpdate("DELETE FROM USER_INFO WHERE name='大日如来'");
			stmt.executeUpdate("UPDATE USER_INFO SET name='孤傲苍狼' WHERE name='苍狼'");
			 
//			ResultSet rs = stmt.executeQuery("SELECT * FROM USER_INFO ");
//			while (rs.next()) {
//				System.out.println(rs.getString("id") + "," + rs.getString("name")+ "," + rs.getString("sex"));
//			}
			System.out.println("测试完成");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

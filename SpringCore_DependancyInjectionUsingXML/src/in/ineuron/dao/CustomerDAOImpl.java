package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import in.ineuron.bo.CustomerBO;

public class CustomerDAOImpl implements ICustomerDAO {

	private static final String REALTIMEDI_CUSTOMER_INSERT_QUERY = "insert into customer(`cname`,`caddress`,`pamt`,`rate`,`time`,`intrAmt`)values(?,?,?,?,?,?)";

	private DataSource dataSource;

	public CustomerDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Integer save(CustomerBO bo) throws Exception {

		int count = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(REALTIMEDI_CUSTOMER_INSERT_QUERY)) {

			prepareStatement.setString(1, bo.getCustomerName());
			prepareStatement.setString(2, bo.getCustomerAddress());
			prepareStatement.setFloat(3, bo.getPamt());
			prepareStatement.setFloat(4, bo.getRate());
			prepareStatement.setFloat(5, bo.getTime());
			prepareStatement.setFloat(6, bo.getIntrAmt());

			count = prepareStatement.executeUpdate();

		}
		return count;
	}

}

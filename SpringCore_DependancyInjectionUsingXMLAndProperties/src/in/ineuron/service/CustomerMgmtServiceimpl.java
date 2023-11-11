package in.ineuron.service;

import in.ineuron.bo.CustomerBO;
import in.ineuron.dao.ICustomerDAO;
import in.ineuron.dto.CustomerDTO;

public class CustomerMgmtServiceimpl implements ICustomerMgmtService {

	private ICustomerDAO dao;

	public CustomerMgmtServiceimpl(ICustomerDAO dao) {
		this.dao = dao;
	}

	@Override
	public String calSimpleInterest(CustomerDTO dto) throws Exception {

		Float intrAmt = (dto.getPamt() * dto.getRate() * dto.getTime()) / 100.0f;

		CustomerBO bo = new CustomerBO();
		bo.setCustomerName(dto.getCustomerName());
		bo.setCustomerAddress(dto.getCustomerAddress());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setIntrAmt(intrAmt);

		int count = dao.save(bo);

		return count == 0 ? "customer registration failed"
				: "customer registration succesfull---->SimpleInterestAmount::" + intrAmt;

	}

}

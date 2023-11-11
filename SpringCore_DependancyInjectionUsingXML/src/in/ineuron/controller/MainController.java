package in.ineuron.controller;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgmtService;
import in.ineuron.vo.CustomerVO;

public class MainController {

	private ICustomerMgmtService service;

	public MainController(ICustomerMgmtService service) {

		this.service = service;
	}

	public String processCustomer(CustomerVO vo) throws Exception {

		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerName(vo.getCustomerName());
		dto.setCustomerAddress(vo.getCustomerAddress());
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));

		String result = service.calSimpleInterest(dto);

		return result;

	}
}

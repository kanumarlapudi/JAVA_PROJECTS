package in.ineuron.bo;

//BO -> Business Object(it holds the actual data which needs to persisted for future usage)
public class CustomerBO {

	private String customerName;
	private String customerAddress;
	private Float pamt;
	private Float rate;
	private Float time;

	private Float intrAmt;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Float getPamt() {
		return pamt;
	}

	public void setPamt(Float pamt) {
		this.pamt = pamt;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getTime() {
		return time;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	public Float getIntrAmt() {
		return intrAmt;
	}

	public void setIntrAmt(Float intrAmt) {
		this.intrAmt = intrAmt;
	}

	@Override
	public String toString() {
		return "CustomerBO [customerName=" + customerName + ", customerAddress=" + customerAddress + ", pamt=" + pamt
				+ ", rate=" + rate + ", time=" + time + ", intrAmt=" + intrAmt + "]";
	}

}

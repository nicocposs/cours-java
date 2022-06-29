package services;

public class DeptPair {
	private String deptNum;
	private String deptName;
	
	public DeptPair(String deptNum, String deptName) {
		this.deptName = deptName;
		this.deptNum = deptNum;
	}

	public String getDeptNum() {
		return deptNum;
	}

	public String getDeptName() {
		return deptName;
	}
	
	
	
	
}

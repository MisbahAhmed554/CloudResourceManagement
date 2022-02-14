package net.javaguides.springboot.model;

public class UnitWiseType {
	private String techmDept;
	private int resourceCost;
	public UnitWiseType(String techmDept, int resourceCost) {
		super();
		this.techmDept = techmDept;
		this.resourceCost = resourceCost;
	}
	public String getTechmDept() {
		return techmDept;
	}
	public void setTechmDept(String techmDept) {
		this.techmDept = techmDept;
	}
	public int getResourceCost() {
		return resourceCost;
	}
	public void setResourceCost(int resourceCost) {
		this.resourceCost = resourceCost;
	}

}

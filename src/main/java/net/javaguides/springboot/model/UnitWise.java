package net.javaguides.springboot.model;


public class UnitWise {

	private String techmDept;

	private int sumUnit;

	public UnitWise(String techmDept, int sumUnit) {
		super();
		this.techmDept = techmDept;
		this.sumUnit = sumUnit;

	}

	public String getTechmDept() {
		return techmDept;
	}

	public void setTechmDept(String techmDept) {
		this.techmDept = techmDept;
	}

	public int getSumUnit() {
		return sumUnit;
	}

	public void setSumUnit(int sumUnit) {
		this.sumUnit = sumUnit;
	}

	public UnitWise() {

	}

}

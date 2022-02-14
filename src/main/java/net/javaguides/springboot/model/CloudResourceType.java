package net.javaguides.springboot.model;

public class CloudResourceType {
	private String resourceType;
	private int sumUnit;
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public int getSumUnit() {
		return sumUnit;
	}
	public void setSumUnit(int sumUnit) {
		this.sumUnit = sumUnit;
	}
	public CloudResourceType(String resourceType, int sumUnit) {
		super();
		this.resourceType = resourceType;
		this.sumUnit = sumUnit;
	}
	

}

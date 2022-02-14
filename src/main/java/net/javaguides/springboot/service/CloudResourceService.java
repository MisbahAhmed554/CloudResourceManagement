package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.model.CloudResource;
import net.javaguides.springboot.model.CloudResourceType;
import net.javaguides.springboot.model.UnitWise;
import net.javaguides.springboot.model.UnitWiseType;

public interface CloudResourceService {
	List<CloudResource> getAllCloudResources();

	void saveCloudResource(CloudResource cloudResource);

	CloudResource getCloudResourceById(long id);

	void deleteCloudResourceById(long id);

	Page<CloudResource> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

	public List<UnitWise> findUnitWise();
	
	public List<CloudResourceType> findCloudResource();
	public List<UnitWiseType> findView();

}

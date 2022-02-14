package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.CloudResource;

@Repository("cloudResourceRepository")
public interface CloudResourceRepository extends JpaRepository<CloudResource, Long> {

	@Query(nativeQuery = true, value = "select c.techm_dept as techmDept,sum(c.resource_cost) as sumUnit "
			+ " from cloudresource as c group by techm_dept")
	public List<Object[]> findUnitWise();

	@Query(nativeQuery = true, value = "select c.resource_type as resourcetype,sum(c.resource_cost) as sumUnit from cloudresource as c group by resourceType")
	public List<Object[]> findCloudResource();
	
	@Query(nativeQuery = true, value = "select techm_dept, resource_cost from cloudresource where techm_dept=techm_dept")
	public List<Object[]> findView();
	
}

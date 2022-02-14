package net.javaguides.springboot.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.CloudResource;
import net.javaguides.springboot.model.CloudResourceType;
import net.javaguides.springboot.model.UnitWise;
import net.javaguides.springboot.model.UnitWiseType;
import net.javaguides.springboot.repository.CloudResourceRepository;

@Service
public class CloudResourceServiceImpl implements CloudResourceService {

	@Autowired
	private CloudResourceRepository cloudResourceRepository;

	@Override
	public List<CloudResource> getAllCloudResources() {

		return cloudResourceRepository.findAll();
	}

	@Override
	public List<UnitWise> findUnitWise() {

		List<UnitWise> listUnitWise= new ArrayList<UnitWise>();
		
		List<Object[]> result = cloudResourceRepository.findUnitWise();
		
	//	List<Object[]> result = null;

		Map<String, Double> map = null;
		
		if (result != null && !result.isEmpty()) {
			map = new HashMap<String,Double>();
			for (Object[] object : result) {
				map.put(((String) object[0]), (Double)object[1]);
				String techm_dept=(String) object[0];
				Double b1=(Double)object[1];
				Integer sumUnit=b1.intValue();
				listUnitWise.add(new UnitWise(techm_dept,sumUnit));
			}
		}
		//listUnitWise.add(new UnitWise("AAA",5000));
		//listUnitWise.add(new UnitWise("BBB",6000));
		//listUnitWise.add(new UnitWise("CCC",7000));

		System.out.println("extracted values");
		return listUnitWise;
	}
	
	
	@Override
	public List<CloudResourceType> findCloudResource() { 
		List<CloudResourceType> listCloudResourceType= new ArrayList<CloudResourceType>();
	List<Object[]> result = cloudResourceRepository.findCloudResource();
	//List<Object[]> result = null; 
	Map<String, Double> map = null;
	if (result != null && !result.isEmpty()) {
	map = new HashMap<String,Double>();
	for (Object[] object : result) {
	map.put(((String) object[0]), (Double)object[1]);
	String resourceType=(String) object[0];
	Double b1=(Double)object[1];
	Integer sumUnit=b1.intValue();
	listCloudResourceType.add(new CloudResourceType(resourceType,sumUnit));
	}
	}
	//listCloudResourceType.add(new CloudResourceType("AAA",5000));
	//listCloudResourceType.add(new CloudResourceType("BBB",6000));
	//listCloudResourceType.add(new CloudResourceType("CCC",7000)); System.out.println("extracted values");
	return listCloudResourceType;
	}
	
	


	@Override
	public List<UnitWiseType> findView() {



	List<UnitWiseType> listUnitWiseView= new ArrayList<UnitWiseType>();

	List<Object[]> result = cloudResourceRepository.findView();

	// List<Object[]> result = null;



	Map<String, Integer> map = null;

	if (result != null && !result.isEmpty()) {
	map = new HashMap<String,Integer>();
	for (Object[] object : result) {
	map.put(((String) object[0]), (Integer)object[1]);
	String techm_dept=(String) object[0];
	Integer resourceCost=(Integer) object[1];


	//BigDecimal b1=(BigDecimal)object[1];
	// Integer resourceCost=b1.intValue();
	
	

	 listUnitWiseView.add(new UnitWiseType(techm_dept,resourceCost));
	}
	}
	// listUnitWise.add(new UnitWise("AAA",5000));
	// listUnitWise.add(new UnitWise("BBB",6000));
	// listUnitWise.add(new UnitWise("CCC",7000));



	System.out.println("extracted values");
	return listUnitWiseView;
	}
	
	@Override
	public void saveCloudResource(CloudResource cloudResource) {
		this.cloudResourceRepository.save(cloudResource);
	}

	@Override
	public CloudResource getCloudResourceById(long id) {
		Optional<CloudResource> optional = cloudResourceRepository.findById(id);
		CloudResource cloudResource = null;
		if (optional.isPresent()) {
			cloudResource = optional.get();
		} else {
			throw new RuntimeException(" Cloud Resource is not found for id :: " + id);
		}
		return cloudResource;
	}

	@Override
	public void deleteCloudResourceById(long id) {
		this.cloudResourceRepository.deleteById(id);
	}

	@Override
	public Page<CloudResource> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.cloudResourceRepository.findAll(pageable);
	}

}

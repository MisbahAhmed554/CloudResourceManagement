package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.CloudResource;
import net.javaguides.springboot.model.CloudResourceType;
import net.javaguides.springboot.model.UnitWise;
import net.javaguides.springboot.model.UnitWiseType;
import net.javaguides.springboot.service.CloudResourceService;

@Controller
public class CloudResourceController {

	@Autowired
	private CloudResourceService cloudResourceService;

	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {

		return findPaginated(1, "slNo", "asc", model);
	}

	// display list of employees
	@GetMapping("/UnitWiseResourceUtilization")
	public String viewUnitWiseReport(Model model) {

		//return findPaginatedUnitWise(1, "slNo", "asc", model);

		//int pageSize = 5;

		// Page<CloudResource> page = cloudResourceService.findPaginated(pageNo,
		// pageSize, sortField, sortDir);

		List<UnitWise> listCloudResourcesUnitWise = cloudResourceService.findUnitWise();

	//	model.addAttribute("currentPage", pageNo);
		// model.addAttribute("totalPages", page.getTotalPages());
		// model.addAttribute("totalItems", page.getTotalElements());

	//	model.addAttribute("sortField", sortField);
	//	model.addAttribute("sortDir", sortDir);
	//	model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listCloudResourcesUnitWise", listCloudResourcesUnitWise);
		return "unit_wise_report";
	}
		
	@GetMapping("/showFormForView")
	public String viewUnitWiseView(Model model) {
	List<UnitWiseType> listUnitWiseView = cloudResourceService.findView();
	model.addAttribute("listUnitWiseView", listUnitWiseView);
	return "UnitWiseView";
	
	}	
	
	@GetMapping("/CloudResourceWiseUtilization")
	public String viewCloudResource(Model model) {
	List<CloudResourceType> listCloudResourceType = cloudResourceService.findCloudResource();
	model.addAttribute("listCloudResourceType", listCloudResourceType);
	return "cloud_resource_entry_model";
	}
	

	@GetMapping("/showNewCloudResourceForm")
	public String showNewCloudResourceForm(Model model) {
		// create model attribute to bind form data
		CloudResource cloudResource = new CloudResource();
		model.addAttribute("cloudresource", cloudResource);
		return "new_cloudresource";
	}

	@GetMapping("/cloudresourcewiseutility")
	public String cloudResourceWiseUtility(Model model) {
		// create model attribute to bind form data
		CloudResource cloudResource = new CloudResource();
		model.addAttribute("cloudresource", cloudResource);
		return "cloud_resource_wise_utility";
	}

	@PostMapping("/saveCloudResource")
	public String saveCloudResource(@ModelAttribute("cloudresource") CloudResource cloudResource) {
		// save employee to database
		cloudResourceService.saveCloudResource(cloudResource);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		CloudResource cloudResource = cloudResourceService.getCloudResourceById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("cloudresource", cloudResource);
		return "update_cloudresource";
	}

	@GetMapping("/deleteCloudResource/{id}")
	public String deleteCloudResource(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.cloudResourceService.deleteCloudResourceById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<CloudResource> page = cloudResourceService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<CloudResource> listCloudResources = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listCloudResources", listCloudResources);
		return "index";
	}

	@GetMapping("/pageUnitWise/{pageNo}")
	public String findPaginatedUnitWise(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {
		//int pageSize = 5;

		// Page<CloudResource> page = cloudResourceService.findPaginated(pageNo,
		// pageSize, sortField, sortDir);

		List<UnitWise> listCloudResourcesUnitWise = cloudResourceService.findUnitWise();

		model.addAttribute("currentPage", pageNo);
		// model.addAttribute("totalPages", page.getTotalPages());
		// model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listCloudResourcesUnitWise", listCloudResourcesUnitWise);
		return "unit_wise_report";
	}
	
	@GetMapping("/pageCloudResource/{pageNo}")
	public String findPaginatedCloudResource(@PathVariable(value = "pageNo") int pageNo,
	@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {
	int pageSize = 5;



	// Page<CloudResource> page = cloudResourceService.findPaginated(pageNo,
	// pageSize, sortField, sortDir);



	List<CloudResourceType> listCloudResourceType = cloudResourceService.findCloudResource();



	model.addAttribute("currentPage", pageNo);
	// model.addAttribute("totalPages", page.getTotalPages());
	// model.addAttribute("totalItems", page.getTotalElements());



	model.addAttribute("sortField", sortField);
	model.addAttribute("sortDir", sortDir);
	model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");



	model.addAttribute("listCloudResourceType", listCloudResourceType);
	return "cloud_resource_entry_model";
	}
}



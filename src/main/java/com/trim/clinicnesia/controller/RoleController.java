package com.trim.clinicnesia.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trim.clinicnesia.model.Role;
import com.trim.clinicnesia.service.RoleService;

@Controller
public class RoleController {

	public static final Logger logger = LoggerFactory
			.getLogger(RoleController.class);

	@Autowired
	RoleService roleService;

	@GetMapping("roles/add")
	public String addRole(Model model) {
		Role role = new Role();
		model.addAttribute("role", role);
		return "roles/role_add";
	}

	@PostMapping("roles/add")
	public String createRole(@Valid @ModelAttribute("role") Role role,
			BindingResult bindingResult, RedirectAttributes redirectAttributes,
			Model model) {
		Role roleExist = roleService.findByRoleName(role.getRoleName());
		if (roleExist != null) {
			bindingResult.rejectValue("roleName", "error.role",
					"There is already role with role name "
							+ role.getRoleName());
		}
		if (bindingResult.hasErrors()) {
			return "roles/role_add";
		}
		roleService.save(role);
		role = new Role();
		logger.info("Created Role with role name {}", role.getRoleName());
		redirectAttributes.addFlashAttribute("info",
				"Role created successfully");
		model.addAttribute("role", role);
		return "redirect:/roles";

	}

	@GetMapping("roles")
	public String listRoles(
			@PageableDefault(sort = { "roleName" }, value = 10) Pageable page,
			ModelMap modelMap) {
		Iterable<Role> roles = roleService.findAll(page);
		modelMap.addAttribute("roles", roles);
		return "roles/roles";

	}

}

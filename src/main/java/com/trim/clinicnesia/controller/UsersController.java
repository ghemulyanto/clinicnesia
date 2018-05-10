package com.trim.clinicnesia.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trim.clinicnesia.model.User;
import com.trim.clinicnesia.service.RoleService;
import com.trim.clinicnesia.service.UserService;

@Controller
public class UsersController {

	public static final Logger logger = LoggerFactory
			.getLogger(UsersController.class);

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/users/add")
	public String addUser(Model model) {
		User user = new User();
		user.setUserExpired(new Date());
		model.addAttribute("user", user);
		model.addAttribute("allRoles", roleService.findAll());
		return "users/user_add";
	}

	@PostMapping("/users/add")
	public String createUser(@Valid @ModelAttribute("user") User user,
			BindingResult result, RedirectAttributes redirectAttributes,
			Model model) {
		User userExist = userService.findUserByUsername(user.getUsername());
		if (userExist != null) {
			result.rejectValue("username", "error.user",
					"There is already user registered with username "
							+ user.getUsername());
		} else if (userExist == null) {
			userExist = userService.findUserByEmail(user.getEmail());
			if (userExist != null) {
				result.rejectValue("email", "error.email",
						"There is already user registered with Email address "
								+ user.getEmail());
			}
		}
		if (result.hasErrors()) {
			return "redirect:/users";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreatedDate(new Date());
		userService.saveUser(user);
		logger.info("Created user with username : {} and email: {}",
				user.getUsername(), user.getEmail());
		user = new User();
		user.setUserExpired(new Date());
		redirectAttributes.addFlashAttribute("info",
				"User created successfully");
		model.addAttribute("allRoles", roleService.findAll());
		model.addAttribute("user", user);
		return "redirect:/users";
	}

	@GetMapping("/users")
	public String listUsers(@PageableDefault(sort={"fullname"},value=10) Pageable page, ModelMap modelMap ) {
		Iterable<User> users = userService.getAllUsers(page);
		modelMap.addAttribute("users", users);
		return "users/users";
	}

}

CREATE TABLE `clns_user` (
  `user_id` varchar(36) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `password_expired` datetime DEFAULT NULL,
  `password_failed` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `is_employee` tinyint(4) DEFAULT NULL,
  `employee_no` varchar(100) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `is_new_user` tinyint(4) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `user_expired` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `clns_role` (
  `role_id` varchar(36) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `clns_users_roles` (
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  KEY `FKgklaxc46l96jxnyo74pff5qw7` (`role_id`),
  KEY `FKq1yxxsj3ac3fbfst8m31xbpsx` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


INSERT INTO clns_role (role_id, role_name, role_description)
VALUES('b8fffbcd-5466-11e8-ba0c-40f02fd895f6', 'SUPERADMIN', 'SUPERMAN');

INSERT INTO clns_user
(user_id, created_by, created_date, description, email, is_employee, employee_no, fullname, ip_address, is_new_user, last_login, password, password_expired, password_failed, status, updated_by, updated_date, user_expired, username)
VALUES('4bad559e-5467-11e8-ba0c-40f02fd895f6', NULL, NULL, 'Description user', 'superadmin@clinicnesia.com', 1, '545454545', 'superadmin', NULL, 0, NULL, '$2a$10$GMcuhhGAwdcAFX90gSKbVOP.LlGi6RZxJb5kGSKY3vlh/tcfU3RO6', NULL, 0, 1, NULL, NULL, '2018-06-15 00:00:00.000', 'superadmin');

INSERT INTO clns_users_roles
(user_id, role_id)
VALUES('4bad559e-5467-11e8-ba0c-40f02fd895f6', 'b8fffbcd-5466-11e8-ba0c-40f02fd895f6');



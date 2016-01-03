insert into ap_auth_role_type (id, type) values (1, 'ROLE_ADMIN');

insert into ap_auth_user (id, password, username) values (1, 'admin', 'admin');

insert into ap_auth_roles (user_id, role_id) values (1, 1);

insert into ap_product (product_id, code, name, price) VALUES (1, 'astro', 'Astro', 100);
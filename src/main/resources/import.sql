insert into ap_auth_role_type (id, type) values (1, 'ROLE_ADMIN');

insert into ap_auth_user (id, password, username) values (1, 'admin', 'admin');

insert into ap_auth_roles (user_id, role_id) values (1, 1);

insert into ap_product (product_id, code, name, description, price) VALUES (1, 'astro-1', 'Astro 1', 'Astro Desctirtion 1', 100);
insert into ap_product (product_id, code, name, description, price) VALUES (2, 'astro-2', 'Astro 2', 'Astro Desctirtion 2', 100);

insert into ap_merchant (merchant_id, account, active, authorization_type, currency, domain_name, private_key) VALUES (1, 'qwe', true, 'at', 'UAH', 'dn', 'pk');

insert into ap_ord_status_type (id, type) VALUES (1, 'OPEN');
insert into ap_ord_status_type (id, type) VALUES (2, 'PAYED');
insert into ap_ord_status_type (id, type) VALUES (3, 'DONE');


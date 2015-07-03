--// Create Shiro Tables
CREATE TABLE shiro_user_role (user_id BIGINT NOT NULL AUTO_INCREMENT, role_id BIGINT NOT NULL, PRIMARY KEY (user_id, role_id));
CREATE TABLE shiro_role_permission (role_id BIGINT NOT NULL, permission VARCHAR(50) NOT NULL, PRIMARY KEY (role_id, permission));
CREATE TABLE shiro_user (id BIGINT NOT NULL AUTO_INCREMENT, userid VARCHAR(100) NOT NULL UNIQUE, email VARCHAR(100) NOT NULL UNIQUE, passphrase VARCHAR(100) NOT NULL, salt VARCHAR(100) NOT NULL, date_created DATE NOT NULL, PRIMARY KEY (id));
CREATE TABLE shiro_role (id BIGINT NOT NULL AUTO_INCREMENT, description VARCHAR(255), name VARCHAR(50) NOT NULL, PRIMARY KEY (id));
ALTER TABLE shiro_role_permission ADD CONSTRAINT fk_shiro_role_id FOREIGN KEY (role_id) REFERENCES shiro_role (id);
ALTER TABLE shiro_user_role ADD CONSTRAINT fk_shiro_user_role_user_id FOREIGN KEY (user_id) REFERENCES shiro_user (id);
ALTER TABLE shiro_user_role ADD CONSTRAINT fk_shiro_user_role_role_id FOREIGN KEY (role_id) REFERENCES shiro_role (id);
CREATE TABLE shiro_sequence (seq_name VARCHAR(50) NOT NULL, seq_count NUMERIC(38), PRIMARY KEY (seq_name));
INSERT INTO shiro_sequence (seq_name, seq_count) VALUES ('shiro_user_seq', 0);
INSERT INTO shiro_sequence (seq_name, seq_count) VALUES ('shiro_role_seq', 0);
--// Create a TestUser with a password of TestUserPassword
INSERT INTO shiro_user (userid, passphrase, salt, email, date_created) VALUES ('TestUser', 'M1IFzumVt5cZznXtuE7uBS5xFE62vpcQY939F12ZTGQuJS9/vrnGKOiTu+cJGDEZO1XfJQYATVLO7qQTDuiCfA==', 'Cv2YXgmaudkMcw0/10T0jw==', 'TestUser@test.com', CURDATE()); 
INSERT INTO shiro_role (description, name) VALUES ('Test Role', 'Test');
INSERT INTO shiro_role_permission (role_id, permission) VALUES ( (SELECT id FROM shiro_role where name = 'Test' ), 'read');
INSERT INTO shiro_user_role (user_id, role_id) VALUES ((SELECT id FROM shiro_user where userid = 'TestUser' ), (SELECT id FROM shiro_role where name = 'Test' ));
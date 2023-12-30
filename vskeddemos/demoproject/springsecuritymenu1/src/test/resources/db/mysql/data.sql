INSERT INTO `menu`
VALUES (1, '系统管理', 0,'/system', null);
INSERT INTO `menu`
VALUES (2, '菜单管理', 1,'/system/menuList', 1);
INSERT INTO `menu`
VALUES (3, '角色管理', 1, '/system/roleList', 1);
INSERT INTO `menu`
VALUES (4, '用户管理', 1,'/system/userList', 1);

INSERT INTO `menu`
VALUES (5, '获取菜单信息api', 2,'/system/menu', 2);
INSERT INTO `menu`
VALUES (6, '获取角色信息api', 2,'/system/role', 3);
INSERT INTO `menu`
VALUES (7, '获取用户信息api', 2,'/system/user', 4);
INSERT INTO `menu`
VALUES (8, '添加用户按钮', 3,'/system/user/addButton', 4);
INSERT INTO `menu`
VALUES (9, '添加菜单按钮', 3,'/system/menu/addMenu', 2);



INSERT INTO `role`
VALUES (1, '超级管理员');
INSERT INTO `role`
VALUES (2, '普通用户');

INSERT INTO `role_menu`
VALUES (1, 1);
INSERT INTO `role_menu`
VALUES (1, 2);
INSERT INTO `role_menu`
VALUES (1, 3);
INSERT INTO `role_menu`
VALUES (1, 4);
INSERT INTO `role_menu`
VALUES (1, 5);
INSERT INTO `role_menu`
VALUES (1, 6);
INSERT INTO `role_menu`
VALUES (1, 7);
INSERT INTO `role_menu`
VALUES (1, 8);
INSERT INTO `role_menu`
VALUES (1, 9);
INSERT INTO `role_menu`
VALUES (2, 4);
INSERT INTO `role_menu`
VALUES (2, 5);
INSERT INTO `role_menu`
VALUES (2, 9);

INSERT INTO `user`
VALUES (1, 'admin','$2a$10$E/BtCNcu2kIq9qdY3jhdOeWJVhjD.mhca8oXhqQxYMyC7hZopINDq',true,true,true,true);
INSERT INTO `user`
VALUES (2, 'myUser','$2a$10$w7xENj81O48vkcoXnAyIy.ogKFAZ7aP8hIYVyhoVNm9i87.Ujdkvm',true,true,true,true);

INSERT INTO `user_role`
VALUES (1,1);
INSERT INTO `user_role`
VALUES (2,2);

INSERT INTO `certificate`
VALUES (1,DATE_ADD(NOW(),INTERVAL 1 DAY));
INSERT INTO `certificate`
VALUES (2,DATE_ADD(NOW(),INTERVAL 1 DAY));

INSERT INTO `user_certificate`
VALUES (1,1);
INSERT INTO `user_certificate`
VALUES (2,2);

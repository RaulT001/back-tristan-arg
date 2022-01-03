
/* Creamos algunos usuarios con sus roles */
INSERT INTO `usuarios` (username, password, enable, nombre) VALUES ('gerenteAdmin','$2a$10$AQ9TN3Uh3QKWgtL2m3qtQePXrLYxd3ZbPvTWlFTjh6dNlybu2/Xp.',1, 'Señor Ronal');
INSERT INTO `usuarios` (username, password, enable, nombre) VALUES ('operacionalUser','$2a$10$AHQ.QsJn/xO4btytXi3ymOjNFYTPXqCfMF45MNpWZ5VPsKQgcYRV2',1, 'Señorita Alanis');
INSERT INTO `usuarios` (username, password, enable, nombre) VALUES ('testUser','$2a$10$04YsEG./epk3GH9kNKlf7.ooHepLdqVnio4s/N7AZiIPrDo2gBHmy',1, 'Señor Raul');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (3, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (3, 2);
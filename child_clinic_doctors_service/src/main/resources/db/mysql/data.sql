INSERT IGNORE INTO vets VALUES (1, 'Kerem', 'Erkinsoy');
INSERT IGNORE INTO vets VALUES (2, 'Egemen', 'Aydın');
INSERT IGNORE INTO vets VALUES (3, 'Erhan', 'Gültekin');
INSERT IGNORE INTO vets VALUES (4, 'Ayten', 'Durmaz');
INSERT IGNORE INTO vets VALUES (5, 'Oğuz', 'Türk');

INSERT IGNORE INTO specialties VALUES (1,'Pediatric Surgery');
INSERT IGNORE INTO specialties VALUES (2, 'Pediatric Nephrology');
INSERT IGNORE INTO specialties VALUES (3, 'Ear, Nose and Throat Specialist');
INSERT IGNORE INTO specialties VALUES (3, 'Child and Adolescent Psychiatry');

INSERT INTO vet_specialties VALUES (1, 2);
INSERT IGNORE INTO vet_specialties VALUES (2, 1);
INSERT IGNORE INTO vet_specialties VALUES (3, 2);
INSERT IGNORE INTO vet_specialties VALUES (3, 3);
INSERT IGNORE INTO vet_specialties VALUES (4, 4);
INSERT IGNORE INTO vet_specialties VALUES (5, 1);

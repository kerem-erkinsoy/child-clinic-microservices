INSERT INTO vets VALUES (1, 'Kerem', 'Erkinsoy');
INSERT INTO vets VALUES (2, 'Egemen', 'Aydın');
INSERT INTO vets VALUES (3, 'Erhan', 'Gültekin');
INSERT INTO vets VALUES (4, 'Ayten', 'Durmaz');
INSERT INTO vets VALUES (5, 'Oğuz', 'Türk');

INSERT INTO specialties VALUES (1, 'Pediatric Surgery');
INSERT INTO specialties VALUES (2, 'Pediatric Nephrology');
INSERT INTO specialties VALUES (3, 'Ear, Nose and Throat Specialist');
INSERT INTO specialties VALUES (4, 'Child and Adolescent Psychiatry');

INSERT INTO vet_specialties VALUES (2, 1);
INSERT INTO vet_specialties VALUES (1, 2);
INSERT INTO vet_specialties VALUES (3, 2);
INSERT INTO vet_specialties VALUES (3, 3);
INSERT INTO vet_specialties VALUES (4, 4);
INSERT INTO vet_specialties VALUES (5, 1);

-- ========= ZANR =========

-- 1
INSERT INTO public.zanr(naz_zanr)
	VALUES ('action');

-- 2
INSERT INTO public.zanr(naz_zanr)
	VALUES ('comedy');
	
-- 3
INSERT INTO public.zanr(naz_zanr)
	VALUES ('drama');
	
-- 4
INSERT INTO public.zanr(naz_zanr)
	VALUES ('romance');
	
-- 5
INSERT INTO public.zanr(naz_zanr)
	VALUES ('superhero');
	
-- 6
INSERT INTO public.zanr(naz_zanr)
	VALUES ('slice of life');
	
-- 7
INSERT INTO public.zanr(naz_zanr)
	VALUES ('mystery');
	
-- 8
INSERT INTO public.zanr(naz_zanr)
	VALUES ('fantasy');
	
-- 9
INSERT INTO public.zanr(naz_zanr)
	VALUES ('sci-fi');
	
-- 10
INSERT INTO public.zanr(naz_zanr)
	VALUES ('western');
	
-- 11
INSERT INTO public.zanr(naz_zanr)
	VALUES ('supernatural');
	

	
-- ========== SERIJAL ===========

-- 1
INSERT INTO public.serijal(nas_srj)
	VALUES ('Batman');
	
-- 2
INSERT INTO public.serijal(nas_srj)
	VALUES ('The Wicked + The Divine');
	
-- 3
INSERT INTO public.serijal(nas_srj)
	VALUES ('East of West');
	
-- 4
INSERT INTO public.serijal(nas_srj)
	VALUES ('Seed');
	
-- 5
INSERT INTO public.serijal(nas_srj)
	VALUES ('Monster');
	
-- 6
INSERT INTO public.serijal(nas_srj)
	VALUES ('Oyasumi Punpun');

-- 7
INSERT INTO public.serijal(nas_srj)
	VALUES ('Hand Jumper');
	
-- 8
INSERT INTO public.serijal(nas_srj)
	VALUES ('Chainsaw Man');
	
-- 9
INSERT INTO public.serijal(nas_srj)
	VALUES ('20th Century Boys');
	
-- ======= JE_ZANRA ========

-- batman 1
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (1, 1);
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (5, 1);
	
-- the wicked + the Divine 2
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (8, 2);
	
-- east of west 3
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (9, 3);
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (10, 3);
	
-- seed 4
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (9, 4);
	
-- monster 5
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (7, 5);
	
-- oyasumi punpun 6
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (3, 6);
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (6, 6);
	
-- hand jumper 7
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (11, 6);
	
-- chainsaw man 8
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (1, 8);
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (2, 8);
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (8, 8);
	
-- 20th century Boys 9
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (7, 9);
INSERT INTO public.je_zanra(
	zanr_id_zanr, serijal_sfr_srj)
	VALUES (9, 9);
	
-- ========= STRIP ==============

-- Batman 1
INSERT INTO public.strip(nas_str, dat_poc, dat_zav, vrsta_izdanja_id_vr_izd)
VALUES
    ('Batman: Year One', '1987-02-01', '1987-05-01', NULL),
    ('Batman: The Long Halloween', '1996-12-01', '1997-07-01', NULL),
    ('Batman: Dark Victory', '1999-11-01', '2000-12-01', NULL);

-- East of West 3
INSERT INTO public.strip(nas_str, dat_poc, dat_zav, vrsta_izdanja_id_vr_izd)
VALUES ('East of West', '2013-03-01', '2019-12-01', NULL);

-- Monster 5
INSERT INTO public.strip(nas_str, dat_poc, dat_zav, vrsta_izdanja_id_vr_izd)
VALUES ('Monster', '1994-12-01', '2001-12-01', NULL);

-- 20th Century Boys 9
INSERT INTO public.strip(nas_str, dat_poc, dat_zav, vrsta_izdanja_id_vr_izd)
VALUES
    ('20th Century Boys', '1999-10-04', '2006-04-24', NULL),
    ('21st Century Boys', '2006-01-01', '2007-01-01', NULL);

-- Hand Jumper 7
INSERT INTO public.strip(nas_str, dat_poc, dat_zav, vrsta_izdanja_id_vr_izd)
VALUES ('Hand Jumper', '2022-01-24', NULL, NULL);

-- Seed
INSERT INTO public.strip(nas_str, dat_poc, dat_zav, vrsta_izdanja_id_vr_izd)
VALUES
    ('Chapter 1', '2026-01-01', NULL, NULL),
    ('Chapter 2', '2026-02-01', NULL, NULL);

-- ===== PRIPADA =====
-- Batman (Serijal 1) → strips 1, 2, 3
INSERT INTO public.pripada(strip_sfr_str, serijal_sfr_srj) VALUES (1, 1);
INSERT INTO public.pripada(strip_sfr_str, serijal_sfr_srj) VALUES (2, 1);
INSERT INTO public.pripada(strip_sfr_str, serijal_sfr_srj) VALUES (3, 1);

-- East of West (Serijal 3) → strip 4
INSERT INTO public.pripada(strip_sfr_str, serijal_sfr_srj) VALUES (4, 3);

-- Monster (Serijal 5) → strip 5
INSERT INTO public.pripada(strip_sfr_str, serijal_sfr_srj) VALUES (5, 5);

-- 20th Century Boys (Serijal 9) → strips 6, 7
INSERT INTO public.pripada(strip_sfr_str, serijal_sfr_srj) VALUES (6, 9);
INSERT INTO public.pripada(strip_sfr_str, serijal_sfr_srj) VALUES (7, 9);

-- Hand Jumper (Serijal 7) → strip 8
INSERT INTO public.pripada(strip_sfr_str, serijal_sfr_srj) VALUES (8, 7);

-- Seed
INSERT INTO public.pripada(strip_sfr_str, serijal_sfr_srj)
VALUES
    (9, 4),
    (10, 4);

-- ===== DEO ======
-- Batman: Year One (strip 1) → 5 issues
INSERT INTO public.deo(nas_deo, ind_deo, dat_deo, strip_sfr_str) VALUES 
('Issue 1', 1, '1987-02-01', 1),
('Issue 2', 2, '1987-02-15', 1),
('Issue 3', 3, '1987-03-01', 1),
('Issue 4', 4, '1987-04-01', 1),
('Issue 5', 5, '1987-05-01', 1);

-- Batman: The Long Halloween (strip 2) → 4 issues
INSERT INTO public.deo(nas_deo, ind_deo, dat_deo, strip_sfr_str) VALUES
('Issue 1', 1, '1996-12-01', 2),
('Issue 2', 2, '1997-01-01', 2),
('Issue 3', 3, '1997-03-01', 2),
('Issue 4', 4, '1997-07-01', 2);

-- Batman: Dark Victory (strip 3) → 6 issues
INSERT INTO public.deo(nas_deo, ind_deo, dat_deo, strip_sfr_str) VALUES
('Issue 1', 1, '1999-11-01', 3),
('Issue 2', 2, '1999-12-01', 3),
('Issue 3', 3, '2000-01-01', 3),
('Issue 4', 4, '2000-03-01', 3),
('Issue 5', 5, '2000-06-01', 3),
('Issue 6', 6, '2000-12-01', 3);

-- East of West (strip 4) → 4 issues
INSERT INTO public.deo(nas_deo, ind_deo, dat_deo, strip_sfr_str) VALUES
('Issue 1', 1, '2013-03-01', 4),
('Issue 2', 2, '2014-06-01', 4),
('Issue 3', 3, '2016-03-01', 4),
('Issue 4', 4, '2019-12-01', 4);

-- Monster (strip 5) → 7 issues
INSERT INTO public.deo(nas_deo, ind_deo, dat_deo, strip_sfr_str) VALUES
('Issue 1', 1, '1994-12-01', 5),
('Issue 2', 2, '1995-03-01', 5),
('Issue 3', 3, '1996-07-01', 5),
('Issue 4', 4, '1997-11-01', 5),
('Issue 5', 5, '1998-09-01', 5),
('Issue 6', 6, '2000-01-01', 5),
('Issue 7', 7, '2001-12-01', 5);

-- 20th Century Boys (strip 6) → 5 issues
INSERT INTO public.deo(nas_deo, ind_deo, dat_deo, strip_sfr_str) VALUES
('Issue 1', 1, '1999-10-04', 6),
('Issue 2', 2, '2000-02-01', 6),
('Issue 3', 3, '2002-01-01', 6),
('Issue 4', 4, '2004-06-01', 6),
('Issue 5', 5, '2006-04-24', 6);

-- 21st Century Boys (strip 7) → 4 issues
INSERT INTO public.deo(nas_deo, ind_deo, dat_deo, strip_sfr_str) VALUES
('Issue 1', 1, '2006-01-01', 7),
('Issue 2', 2, '2006-04-01', 7),
('Issue 3', 3, '2006-10-01', 7),
('Issue 4', 4, '2007-01-01', 7);

-- Hand Jumper (strip 8) → 6 chapters
INSERT INTO public.deo(nas_deo, ind_deo, dat_deo, strip_sfr_str) VALUES
('Chapter 1', 1, '2022-01-24', 8),
('Chapter 2', 2, '2022-02-01', 8),
('Chapter 3', 3, '2022-02-15', 8),
('Chapter 4', 4, '2022-03-01', 8),
('Chapter 5', 5, '2022-03-15', 8),
('Chapter 6', 6, '2022-04-01', 8);


-- ======= KORISNIK =======
INSERT INTO public.korisnik(
	usrnm, sfr, dat_log, email, prof_ime, uloga_kor)
VALUES
('fmiller', 'fm_pass', '2025-02-10 10:15:00', 'frank.miller@dcmail.com', 'Frank Miller', 'Autor'),

('dmazzucchelli', 'dm_pass', '2025-02-10 10:20:00', 'david.mazzucchelli@comicart.com', 'David Mazzucchelli', 'Autor'),

('doneil', 'do_pass', '2025-02-10 10:25:00', 'dennis.oneil@dclegacy.com', 'Dennis O''Neil', 'Autor'),

('jloeb', 'jl_pass', '2025-02-10 10:30:00', 'jeph.loeb@marveldc.com', 'Jeph Loeb', 'Autor'),

('tsale', 'ts_pass', '2025-02-10 10:35:00', 'tim.sale@comicart.com', 'Tim Sale', 'Autor'),

('jhickman', 'jh_pass', '2025-02-10 10:40:00', 'jonathan.hickman@imagecomics.com', 'Jonathan Hickman', 'Autor'),

('ndragotta', 'nd_pass', '2025-02-10 10:45:00', 'nick.dragotta@imagecomics.com', 'Nick Dragotta', 'Autor'),

('nurasawa', 'nu_pass', '2025-02-10 10:50:00', 'naoki.urasawa@bigcomic.jp', 'Naoki Urasawa', 'Autor'),

('sleepacross', 'sa_pass', '2025-02-10 10:55:00', 'contact@sleepacross.com', 'SLEEPACROSS', 'Autor'),

('mivanovic', 'mi_pass', '2025-02-11 09:10:00', 'marko.ivanovic@email.com', 'Marko Ivanovic', 'Citalac'),

('ajovanovic', 'aj_pass', '2025-02-11 09:25:00', 'ana.jovanovic@email.com', 'Ana Jovanovic', 'Citalac'),

('ptomic', 'pt_pass', '2025-02-11 09:40:00', 'petar.tomic@email.com', 'Petar Tomic', 'Citalac');


-- ======= AUTOR =======
INSERT INTO public.autor(usrnm) VALUES
('fmiller'),
('dmazzucchelli'),
('doneil'),
('jloeb'),
('tsale'),
('jhickman'),
('ndragotta'),
('nurasawa'),
('sleepacross');


-- ======= CITALAC =====
INSERT INTO public.citalac(usrnm) VALUES
('mivanovic'),
('ajovanovic'),
('ptomic');

-- ====== RADI_NA ====
INSERT INTO public.radi_na(
	strip_sfr_str, deo_id_deo, deo_sfr_str, autor_usrnm, uloga_autor)
VALUES

-- Batman: Year One (strip 1, deo 1–5)
(1, 1, 1, 'fmiller', 'pisac'),
(1, 2, 1, 'fmiller', 'pisac'),
(1, 3, 1, 'fmiller', 'pisac'),
(1, 4, 1, 'fmiller', 'pisac'),
(1, 5, 1, 'fmiller', 'pisac'),

(1, 1, 1, 'dmazzucchelli', 'umetnik'),
(1, 2, 1, 'dmazzucchelli', 'umetnik'),
(1, 3, 1, 'dmazzucchelli', 'umetnik'),
(1, 4, 1, 'dmazzucchelli', 'umetnik'),
(1, 5, 1, 'dmazzucchelli', 'umetnik'),

(null, 1, 1, 'doneil', 'pomocnik'),
(null, 2, 1, 'doneil', 'pomocnik'),
(null, 3, 1, 'doneil', 'pomocnik'),
(null, 4, 1, 'doneil', 'pomocnik'),
(null, 5, 1, 'doneil', 'pomocnik'),

-- Long Halloween (strip 2, deo 6–9)
(2, 6, 2, 'jloeb', 'pisac'),
(2, 7, 2, 'jloeb', 'pisac'),
(2, 8, 2, 'jloeb', 'pisac'),
(2, 9, 2, 'jloeb', 'pisac'),

(2, 6, 2, 'tsale', 'umetnik'),
(2, 7, 2, 'tsale', 'umetnik'),
(2, 8, 2, 'tsale', 'umetnik'),
(2, 9, 2, 'tsale', 'umetnik'),

-- Dark Victory (strip 3, deo 10–15)
(3, 10, 3, 'jloeb', 'pisac'),
(3, 11, 3, 'jloeb', 'pisac'),
(3, 12, 3, 'jloeb', 'pisac'),
(3, 13, 3, 'jloeb', 'pisac'),
(3, 14, 3, 'jloeb', 'pisac'),
(3, 15, 3, 'jloeb', 'pisac'),

(3, 10, 3, 'tsale', 'umetnik'),
(3, 11, 3, 'tsale', 'umetnik'),
(3, 12, 3, 'tsale', 'umetnik'),
(3, 13, 3, 'tsale', 'umetnik'),
(3, 14, 3, 'tsale', 'umetnik'),
(3, 15, 3, 'tsale', 'umetnik'),

-- East of West (strip 4, deo 16–19)
(4, 16, 4, 'jhickman', 'pisac'),
(4, 17, 4, 'jhickman', 'pisac'),
(4, 18, 4, 'jhickman', 'pisac'),
(4, 19, 4, 'jhickman', 'pisac'),

(4, 16, 4, 'ndragotta', 'umetnik'),
(4, 17, 4, 'ndragotta', 'umetnik'),
(4, 18, 4, 'ndragotta', 'umetnik'),
(4, 19, 4, 'ndragotta', 'umetnik'),

-- Monster (strip 5, deo 20–26)
(5, 20, 5, 'nurasawa', 'pisac'),
(5, 21, 5, 'nurasawa', 'pisac'),
(5, 22, 5, 'nurasawa', 'pisac'),
(5, 23, 5, 'nurasawa', 'pisac'),
(5, 24, 5, 'nurasawa', 'pisac'),
(5, 25, 5, 'nurasawa', 'pisac'),
(5, 26, 5, 'nurasawa', 'pisac'),

(5, 20, 5, 'nurasawa', 'umetnik'),
(5, 21, 5, 'nurasawa', 'umetnik'),
(5, 22, 5, 'nurasawa', 'umetnik'),
(5, 23, 5, 'nurasawa', 'umetnik'),
(5, 24, 5, 'nurasawa', 'umetnik'),
(5, 25, 5, 'nurasawa', 'umetnik'),
(5, 26, 5, 'nurasawa', 'umetnik'),

-- 20th Century Boys (strip 6, deo 27–31)
(6, 27, 6, 'nurasawa', 'pisac'),
(6, 28, 6, 'nurasawa', 'pisac'),
(6, 29, 6, 'nurasawa', 'pisac'),
(6, 30, 6, 'nurasawa', 'pisac'),
(6, 31, 6, 'nurasawa', 'pisac'),

(6, 27, 6, 'nurasawa', 'umetnik'),
(6, 28, 6, 'nurasawa', 'umetnik'),
(6, 29, 6, 'nurasawa', 'umetnik'),
(6, 30, 6, 'nurasawa', 'umetnik'),
(6, 31, 6, 'nurasawa', 'umetnik'),

-- 21st Century Boys (strip 7, deo 32–35)
(7, 32, 7, 'nurasawa', 'pisac'),
(7, 33, 7, 'nurasawa', 'pisac'),
(7, 34, 7, 'nurasawa', 'pisac'),
(7, 35, 7, 'nurasawa', 'pisac'),

(7, 32, 7, 'nurasawa', 'umetnik'),
(7, 33, 7, 'nurasawa', 'umetnik'),
(7, 34, 7, 'nurasawa', 'umetnik'),
(7, 35, 7, 'nurasawa', 'umetnik'),

-- Hand Jumper (strip 8, deo 36–41)
(8, 36, 8, 'sleepacross', 'pisac'),
(8, 37, 8, 'sleepacross', 'pisac'),
(8, 38, 8, 'sleepacross', 'pisac'),
(8, 39, 8, 'sleepacross', 'pisac'),
(8, 40, 8, 'sleepacross', 'pisac'),
(8, 41, 8, 'sleepacross', 'pisac'),

(8, 36, 8, 'sleepacross', 'umetnik'),
(8, 37, 8, 'sleepacross', 'umetnik'),
(8, 38, 8, 'sleepacross', 'umetnik'),
(8, 39, 8, 'sleepacross', 'umetnik'),
(8, 40, 8, 'sleepacross', 'umetnik'),
(8, 41, 8, 'sleepacross', 'umetnik');

-- ====== JE_PROCITAO ======
INSERT INTO public.je_procitao
(citalac_usrnm, deo_id_deo, deo_sfr_str, je_procitao_id)
VALUES

-- =========================
-- mivanovic
-- =========================

-- Batman: Year One (strip 1) → read ALL 5 issues (deo_id 1–5)
('mivanovic', 1, 1, 1),
('mivanovic', 2, 1, 2),
('mivanovic', 3, 1, 3),
('mivanovic', 4, 1, 4),
('mivanovic', 5, 1, 5),

-- Batman: Dark Victory (strip 3) → read 3 random issues (11–13)
('mivanovic', 11, 3, 6),
('mivanovic', 12, 3, 7),
('mivanovic', 13, 3, 8),

-- Monster (strip 5) → read ALL 7 issues (20–26)
('mivanovic', 20, 5, 9),
('mivanovic', 21, 5, 10),
('mivanovic', 22, 5, 11),
('mivanovic', 23, 5, 12),
('mivanovic', 24, 5, 13),
('mivanovic', 25, 5, 14),
('mivanovic', 26, 5, 15),

-- =========================
-- ajovanovic
-- =========================

-- 20th Century Boys (strip 6) → read ALL (27–31)
('ajovanovic', 27, 6, 16),
('ajovanovic', 28, 6, 17),
('ajovanovic', 29, 6, 18),
('ajovanovic', 30, 6, 19),
('ajovanovic', 31, 6, 20),

-- 21st Century Boys (strip 7) → read 2 issues (32–33)
('ajovanovic', 32, 7, 21),
('ajovanovic', 33, 7, 22),

-- East of West (strip 4) → read ALL (16–19)
('ajovanovic', 16, 4, 23),
('ajovanovic', 17, 4, 24),
('ajovanovic', 18, 4, 25),
('ajovanovic', 19, 4, 26),

-- =========================
-- ptomic
-- =========================

-- Hand Jumper (strip 8) → read ALL (36–41)
('ptomic', 36, 8, 27),
('ptomic', 37, 8, 28),
('ptomic', 38, 8, 29),
('ptomic', 39, 8, 30),
('ptomic', 40, 8, 31),
('ptomic', 41, 8, 32),

-- Batman: Year One (strip 1) → read 1 issue (deo_id 1)
('ptomic', 1, 1, 33);

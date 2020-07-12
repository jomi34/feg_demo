INSERT INTO public.competitions VALUES (1, 'UEFA Champions League', 1);
INSERT INTO public.competitions VALUES (2, 'UEFA Europa League', 1);
INSERT INTO public.competitions VALUES (3, 'UEFA Nations League', 1);
INSERT INTO public.competitions VALUES (4, 'FIFA World Cup', 1);
INSERT INTO public.competitions VALUES (5, 'FIBA World Cup', 2);
INSERT INTO public.competitions VALUES (6, 'NBA', 2);
INSERT INTO public.competitions VALUES (7, 'Velux Champions League', 3);
INSERT INTO public.competitions VALUES (8, 'FIVB Nations League', 4);
INSERT INTO public.competitions VALUES (9, 'FINA World League', 5);
INSERT INTO public.competitions VALUES (10, 'IIHF World Championship', 6);
INSERT INTO public.competitions VALUES (11, 'Roland Garros', 7);
INSERT INTO public.competitions VALUES (12, 'Wimbledon', 7);
INSERT INTO public.competitions VALUES (13, 'Prva HNL', 1);
INSERT INTO public.competitions VALUES (14, 'Druga HNL', 1);
INSERT INTO public.competitions VALUES (15, 'Serie A', 1);
INSERT INTO public.competitions VALUES (16, 'ABA League', 2);
INSERT INTO public.competitions VALUES (17, 'Turkish Superleague', 1);
INSERT INTO public.competitions VALUES (18, 'English Premiership', 1);
INSERT INTO public.competitions VALUES (19, 'Scottish Premiership', 1);
INSERT INTO public.competitions VALUES (20, 'FA Cup', 1);
INSERT INTO public.competitions VALUES (21, 'Prva Hrvatska malonogometna liga', 8);



INSERT INTO public.matches (competition_id, kickoff, home, away, win, draw, lose) VALUES ( 17, timestamp '2020-07-07 20:00:00', 'Istanbul Basaksehir', 'Denizlispor',  1.4, 4.3, 8.0)
WHERE NOT EXISTS (SELECT match_id FROM public.matches WHERE home = 'Istanbul Basaksehir');
INSERT INTO public.matches (competition_id, kickoff, home, away, win, draw, lose) VALUES ( 18, timestamp '2020-07-07 19:00:00', 'Crystal Palace', 'Chelsea',  6.3, 4.0, 1.5)
WHERE NOT EXISTS (SELECT match_id FROM public.matches WHERE home = 'Crystal Palace');
INSERT INTO public.matches (competition_id, kickoff, home, away, win, draw, lose) VALUES ( 15, timestamp '2020-07-07 19:30:00', 'Lecce', 'Lazio',	9.00, 4.50, 1.35)
WHERE NOT EXISTS (SELECT match_id FROM public.matches WHERE home = 'Lecce');
INSERT INTO public.matches (competition_id, kickoff, home, away, win, draw, lose) VALUES ( 21, timestamp '2020-07-07 18:00:00', 'Olmissum', 'Vrgorac',	1.25, 7.0, 6.0)
WHERE NOT EXISTS (SELECT match_id FROM public.matches WHERE home = 'Olmissum');

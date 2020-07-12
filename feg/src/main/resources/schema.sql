CREATE TABLE public.competitions
(
    competition_id integer NOT NULL,
    competition_name character varying(64) NOT NULL,
    sport smallint NOT NULL,
    PRIMARY KEY (competition_id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.competitions
    OWNER to postgres;
	
CREATE TABLE public.matches
(
    match_id bigserial NOT NULL,
	competition_id integer NOT NULL,
	kickoff timestamp without time zone NOT NULL,
    home character varying(64) NOT NULL,
    away character varying(64) NOT NULL,
    win real,
    draw real,
    lose real,
    PRIMARY KEY (match_id),
	CONSTRAINT fk_match_competition FOREIGN KEY (competition_id)
        REFERENCES public.competitions (competition_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.matches
    OWNER to postgres;
	
CREATE TABLE public.tickets
(
    ticket_id bigserial NOT NULL,
    payment_time timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    stake real NOT NULL,
	prize real NULL,
    PRIMARY KEY (ticket_id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.tickets
    OWNER to postgres;
	
CREATE TABLE public.bets
(
    bet_id bigserial NOT NULL,
    ticket_id bigint NOT NULL,
    match_id bigint NOT NULL,
    outcome character(1) NOT NULL,
    odd real NOT NULL,
    PRIMARY KEY (bet_id),
    CONSTRAINT ticket_match UNIQUE (ticket_id, match_id),
	CONSTRAINT fk_bet_ticket FOREIGN KEY (ticket_id)
        REFERENCES public.tickets (ticket_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT fk_bet_match FOREIGN KEY (match_id)
        REFERENCES public.matches (match_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.bets
    OWNER to postgres;
	
CREATE TABLE public.scores
(
    match_id bigint NOT NULL,
    score_home integer,
    score_away integer,
    PRIMARY KEY (match_id),
    CONSTRAINT fk_score_match FOREIGN KEY (match_id)
        REFERENCES public.matches (match_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.scores
    OWNER to postgres;
	

CREATE TABLE IF NOT EXISTS public.authorities (
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);


ALTER TABLE public.authorities OWNER TO postgres;

CREATE SEQUENCE IF NOT EXISTS public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.hibernate_sequence OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.link (
    id bigint NOT NULL,
    display character varying(255),
    name character varying(255),
    project_id bigint
);


ALTER TABLE public.link OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.project (
    id bigint NOT NULL,
    available boolean NOT NULL,
    description text,
    image character varying(255),
    name character varying(255),
    status integer,
    tags character varying(255),
    year integer,
    type_id bigint
);


ALTER TABLE public.project OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.project_tech (
    project_id bigint NOT NULL,
    tech_id bigint NOT NULL
);


ALTER TABLE public.project_tech OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.tech (
    id bigint NOT NULL,
    image character varying(255),
    name character varying(255)
);


ALTER TABLE public.tech OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.type (
    id bigint NOT NULL,
    description text,
    name character varying(255)
);


ALTER TABLE public.type OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.type_projects (
    type_id bigint NOT NULL,
    projects_id bigint NOT NULL
);


ALTER TABLE public.type_projects OWNER TO postgres;


CREATE TABLE IF NOT EXISTS public.users (
    username character varying(50) NOT NULL,
    password character varying(500) NOT NULL,
    enabled boolean NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;


ALTER TABLE ONLY public.link
    ADD CONSTRAINT link_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.project_tech
    ADD CONSTRAINT project_tech_pkey PRIMARY KEY (project_id, tech_id);

ALTER TABLE ONLY public.tech
    ADD CONSTRAINT tech_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.type
    ADD CONSTRAINT type_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.type_projects
    ADD CONSTRAINT type_projects_pkey PRIMARY KEY (type_id, projects_id);


ALTER TABLE ONLY public.type_projects
    ADD CONSTRAINT uk_emwscpovy12p0ef0odp0tewng UNIQUE (projects_id);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);



CREATE UNIQUE INDEX ix_auth_username ON public.authorities USING btree (username, authority);


ALTER TABLE ONLY public.type_projects
    ADD CONSTRAINT fk6pss5obh0owrhf192cwp8leuc FOREIGN KEY (type_id) REFERENCES public.type(id);



ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES public.users(username);


ALTER TABLE ONLY public.project
    ADD CONSTRAINT fkep5xph311g03oeuyfa9w7nevl FOREIGN KEY (type_id) REFERENCES public.type(id);


ALTER TABLE ONLY public.project_tech
    ADD CONSTRAINT fkg1e83277kl2y382o3olm6yxnw FOREIGN KEY (project_id) REFERENCES public.project(id);


ALTER TABLE ONLY public.project_tech
    ADD CONSTRAINT fknhaktqbxa3w9ywkbh2323vcbx FOREIGN KEY (tech_id) REFERENCES public.tech(id);


ALTER TABLE ONLY public.link
    ADD CONSTRAINT fkns4w5peakgt35y9cg16fi2n6t FOREIGN KEY (project_id) REFERENCES public.project(id);


ALTER TABLE ONLY public.type_projects
    ADD CONSTRAINT fkshg5cl1ekxgvhwwu9v9s4xegs FOREIGN KEY (projects_id) REFERENCES public.project(id);


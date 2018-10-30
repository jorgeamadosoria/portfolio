--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.8
-- Dumped by pg_dump version 9.6.8

-- Started on 2018-10-30 00:21:34

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 43202)
-- Name: authorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authorities (
    username character varying(50) NOT NULL,
    authority character varying(50) NOT NULL
);


ALTER TABLE public.authorities OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 43306)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 43308)
-- Name: link; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.link (
    id bigint NOT NULL,
    display character varying(255),
    name character varying(255),
    project_id bigint
);


ALTER TABLE public.link OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 43316)
-- Name: project; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project (
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

--
-- TOC entry 190 (class 1259 OID 43324)
-- Name: project_tech; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_tech (
    project_id bigint NOT NULL,
    tech_id bigint NOT NULL
);


ALTER TABLE public.project_tech OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 43329)
-- Name: tech; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tech (
    id bigint NOT NULL,
    image character varying(255),
    name character varying(255)
);


ALTER TABLE public.tech OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 43337)
-- Name: type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type (
    id bigint NOT NULL,
    description text,
    name character varying(255)
);


ALTER TABLE public.type OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 43345)
-- Name: type_projects; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type_projects (
    type_id bigint NOT NULL,
    projects_id bigint NOT NULL
);


ALTER TABLE public.type_projects OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 43194)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    username character varying(50) NOT NULL,
    password character varying(500) NOT NULL,
    enabled boolean NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 2038 (class 2606 OID 43315)
-- Name: link link_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link
    ADD CONSTRAINT link_pkey PRIMARY KEY (id);


--
-- TOC entry 2040 (class 2606 OID 43323)
-- Name: project project_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_pkey PRIMARY KEY (id);


--
-- TOC entry 2042 (class 2606 OID 43328)
-- Name: project_tech project_tech_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_tech
    ADD CONSTRAINT project_tech_pkey PRIMARY KEY (project_id, tech_id);


--
-- TOC entry 2044 (class 2606 OID 43336)
-- Name: tech tech_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tech
    ADD CONSTRAINT tech_pkey PRIMARY KEY (id);


--
-- TOC entry 2046 (class 2606 OID 43344)
-- Name: type type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type
    ADD CONSTRAINT type_pkey PRIMARY KEY (id);


--
-- TOC entry 2048 (class 2606 OID 43349)
-- Name: type_projects type_projects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_projects
    ADD CONSTRAINT type_projects_pkey PRIMARY KEY (type_id, projects_id);


--
-- TOC entry 2050 (class 2606 OID 43351)
-- Name: type_projects uk_emwscpovy12p0ef0odp0tewng; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_projects
    ADD CONSTRAINT uk_emwscpovy12p0ef0odp0tewng UNIQUE (projects_id);


--
-- TOC entry 2035 (class 2606 OID 43201)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- TOC entry 2036 (class 1259 OID 43210)
-- Name: ix_auth_username; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX ix_auth_username ON public.authorities USING btree (username, authority);


--
-- TOC entry 2057 (class 2606 OID 43377)
-- Name: type_projects fk6pss5obh0owrhf192cwp8leuc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_projects
    ADD CONSTRAINT fk6pss5obh0owrhf192cwp8leuc FOREIGN KEY (type_id) REFERENCES public.type(id);


--
-- TOC entry 2051 (class 2606 OID 43205)
-- Name: authorities fk_authorities_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authorities
    ADD CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES public.users(username);


--
-- TOC entry 2053 (class 2606 OID 43357)
-- Name: project fkep5xph311g03oeuyfa9w7nevl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT fkep5xph311g03oeuyfa9w7nevl FOREIGN KEY (type_id) REFERENCES public.type(id);


--
-- TOC entry 2055 (class 2606 OID 43367)
-- Name: project_tech fkg1e83277kl2y382o3olm6yxnw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_tech
    ADD CONSTRAINT fkg1e83277kl2y382o3olm6yxnw FOREIGN KEY (project_id) REFERENCES public.project(id);


--
-- TOC entry 2054 (class 2606 OID 43362)
-- Name: project_tech fknhaktqbxa3w9ywkbh2323vcbx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_tech
    ADD CONSTRAINT fknhaktqbxa3w9ywkbh2323vcbx FOREIGN KEY (tech_id) REFERENCES public.tech(id);


--
-- TOC entry 2052 (class 2606 OID 43352)
-- Name: link fkns4w5peakgt35y9cg16fi2n6t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.link
    ADD CONSTRAINT fkns4w5peakgt35y9cg16fi2n6t FOREIGN KEY (project_id) REFERENCES public.project(id);


--
-- TOC entry 2056 (class 2606 OID 43372)
-- Name: type_projects fkshg5cl1ekxgvhwwu9v9s4xegs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type_projects
    ADD CONSTRAINT fkshg5cl1ekxgvhwwu9v9s4xegs FOREIGN KEY (projects_id) REFERENCES public.project(id);


-- Completed on 2018-10-30 00:21:34

--
-- PostgreSQL database dump complete
--


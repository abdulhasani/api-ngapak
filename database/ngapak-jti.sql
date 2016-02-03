--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.9
-- Dumped by pg_dump version 9.3.9
-- Started on 2016-02-03 11:20:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 171 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1939 (class 0 OID 0)
-- Dependencies: 171
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 75794)
-- Name: student; Type: TABLE; Schema: public; Owner: ngapak; Tablespace: 
--

CREATE TABLE student (
    id character varying(15) NOT NULL,
    nama character varying(255),
    alamat character varying(255),
    umur integer
);


ALTER TABLE public.student OWNER TO ngapak;

--
-- TOC entry 1931 (class 0 OID 75794)
-- Dependencies: 170
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: ngapak
--



--
-- TOC entry 1823 (class 2606 OID 75798)
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: ngapak; Tablespace: 
--

ALTER TABLE ONLY student
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 1938 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-02-03 11:20:05

--
-- PostgreSQL database dump complete
--


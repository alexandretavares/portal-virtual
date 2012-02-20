--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.2
-- Dumped by pg_dump version 9.1.2
-- Started on 2012-02-20 12:31:32

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1869 (class 1262 OID 16393)
-- Name: portal_virtual; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE portal_virtual WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE portal_virtual OWNER TO postgres;

\connect portal_virtual

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 165 (class 3079 OID 11639)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1872 (class 0 OID 0)
-- Dependencies: 165
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 164 (class 1259 OID 16415)
-- Dependencies: 5
-- Name: classe; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE classe (
    id_classe bigint NOT NULL,
    nome character varying(50) NOT NULL,
    id_filo bigint NOT NULL
);


ALTER TABLE public.classe OWNER TO postgres;

--
-- TOC entry 162 (class 1259 OID 16401)
-- Dependencies: 5
-- Name: filo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE filo (
    id_filo bigint NOT NULL,
    nome character varying(50) NOT NULL,
    id_reino bigint NOT NULL
);


ALTER TABLE public.filo OWNER TO postgres;

--
-- TOC entry 163 (class 1259 OID 16411)
-- Dependencies: 5
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 1873 (class 0 OID 0)
-- Dependencies: 163
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hibernate_sequence', 17, true);


--
-- TOC entry 161 (class 1259 OID 16394)
-- Dependencies: 5
-- Name: reino; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE reino (
    id_reino bigint NOT NULL,
    nome character varying(50) NOT NULL
);


ALTER TABLE public.reino OWNER TO postgres;

--
-- TOC entry 1866 (class 0 OID 16415)
-- Dependencies: 164
-- Data for Name: classe; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO classe (id_classe, nome, id_filo) VALUES (17, 'Hidrozoários', 4);


--
-- TOC entry 1865 (class 0 OID 16401)
-- Dependencies: 162
-- Data for Name: filo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO filo (id_filo, nome, id_reino) VALUES (4, 'Celenterados', 1);
INSERT INTO filo (id_filo, nome, id_reino) VALUES (5, 'Poríferos ou esponjas', 1);
INSERT INTO filo (id_filo, nome, id_reino) VALUES (6, 'Platelmintos ou vermes achatados', 1);
INSERT INTO filo (id_filo, nome, id_reino) VALUES (7, 'Nematelmintos ou vermes cilíndricos', 1);
INSERT INTO filo (id_filo, nome, id_reino) VALUES (8, 'Moluscos', 1);
INSERT INTO filo (id_filo, nome, id_reino) VALUES (9, 'Anelídeos', 1);
INSERT INTO filo (id_filo, nome, id_reino) VALUES (10, 'Artrópodes', 1);
INSERT INTO filo (id_filo, nome, id_reino) VALUES (11, 'Equinodermes', 1);
INSERT INTO filo (id_filo, nome, id_reino) VALUES (12, 'Cordados', 1);


--
-- TOC entry 1864 (class 0 OID 16394)
-- Dependencies: 161
-- Data for Name: reino; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO reino (id_reino, nome) VALUES (1, 'Animal');
INSERT INTO reino (id_reino, nome) VALUES (2, 'Vegetal');


--
-- TOC entry 1861 (class 2606 OID 16419)
-- Dependencies: 164 164
-- Name: id_classe; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY classe
    ADD CONSTRAINT id_classe PRIMARY KEY (id_classe);


--
-- TOC entry 1859 (class 2606 OID 16414)
-- Dependencies: 162 162
-- Name: id_filo; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY filo
    ADD CONSTRAINT id_filo PRIMARY KEY (id_filo);


--
-- TOC entry 1857 (class 2606 OID 16400)
-- Dependencies: 161 161
-- Name: id_reino; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY reino
    ADD CONSTRAINT id_reino PRIMARY KEY (id_reino);


--
-- TOC entry 1863 (class 2606 OID 16430)
-- Dependencies: 164 1858 162
-- Name: id_filo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY classe
    ADD CONSTRAINT id_filo FOREIGN KEY (id_filo) REFERENCES filo(id_filo);


--
-- TOC entry 1862 (class 2606 OID 16406)
-- Dependencies: 162 161 1856
-- Name: id_reino; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY filo
    ADD CONSTRAINT id_reino FOREIGN KEY (id_reino) REFERENCES reino(id_reino);


--
-- TOC entry 1871 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2012-02-20 12:31:33

--
-- PostgreSQL database dump complete
--


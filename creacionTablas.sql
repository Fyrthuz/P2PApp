CREATE TABLE public.Usuarios
(
    idusuarios character varying(20) COLLATE pg_catalog."default" NOT NULL,
    contrasena character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Usuarios_pkey" PRIMARY KEY (idusuarios)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;



CREATE TABLE public.Amigos
(
    codigo integer NOT NULL,
    amigo1 character varying(20) COLLATE pg_catalog."default" NOT NULL,
    amigo2 character varying(20) COLLATE pg_catalog."default" NOT NULL,
	aceptado boolean NOT NULL,
    CONSTRAINT "Amigos_pkey" PRIMARY KEY (codigo, amigo1, amigo2),
    CONSTRAINT Amigo1 FOREIGN KEY (amigo1)
        REFERENCES public.Usuarios (idusuarios) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT Amigo2 FOREIGN KEY (amigo2)
        REFERENCES public.Usuarios (idusuarios) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

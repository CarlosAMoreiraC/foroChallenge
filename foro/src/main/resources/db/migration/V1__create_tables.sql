
create table usuario(
    id bigint not null auto_increment PRIMARY KEY,
    nombre varchar(100),
    correo_electronico varchar(100),
    contrasenia varchar(100)
);

create table perfil(
    id bigint not null auto_increment,
    nombre varchar(100),

    primary key(id)
);

create table perfil_usuario(
    perfil_id bigint not null,
    usuario_id bigint not null,
    primary key(perfil_id, usuario_id),
    foreign key (perfil_id) references perfil(id),
    foreign key (usuario_id) references usuario(id)
);


create table curso(
    id bigint not null auto_increment PRIMARY KEY,
    nombre varchar(100),
    categoria varchar(200)
);


create table topico(
    id bigint not null auto_increment PRIMARY KEY,
    titulo varchar(100),
    mensaje text,
    fecha_creacion datetime,
    status varchar(100),
    curso_id bigint,
    autor_id bigint,

    constraint fk_topico_curso foreign key(curso_id) references curso(id),
    constraint fk_topico_usuario foreign key(autor_id) references usuario(id)
);



create table respuesta(
    id bigint not null auto_increment PRIMARY KEY,
    mensaje text,
    fecha_creacion datetime,
    solucion text,
    topico_id bigint,
    autor_id bigint,

    constraint fk_respuesta_topico_id foreign key(topico_id) references topico(id),
    constraint fk_respuesta_autor_id foreign key(autor_id) references usuario(id)

);
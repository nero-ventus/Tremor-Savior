drop database if exists tremor;
create database tremor;
use tremor;

create table dato_inicio(
    correo varchar(100) primary key,
    contra varchar(50) not null
);

create table ctipo_contacto(
	id_tipoc int primary key auto_increment,
    tipo varchar(20)
);
insert into ctipo_contacto values(0,'Correo');
insert into ctipo_contacto values(0,'Telefono Celular');

create table contacto(
	id_contacto int primary key auto_increment,
    contacto varchar(100),
    id_tipoc int,
    foreign key (id_tipoc) references ctipo_contacto (id_tipoc)
);

create table datos_vitales(
	id_dv int primary key auto_increment,
    tipo_sangre int,
    nss varchar(20),
    csecreta varchar(20)
);
/*	tipo_sangre
	1=A+
    2=A-
    3=B+
    4=B-
    5=AB+
    6=AB-
    7=O+
    8=O-
*/
create table usuario(
	id_usuario int primary key auto_increment,
    nombre varchar(20),
    apellido_p varchar(20),
    apellido_m varchar(20),
    fecha_n date,
    correo varchar(100),
    id_dv int,
    foreign key (id_dv) references datos_vitales (id_dv),
    foreign key (correo) references dato_inicio(correo)
);

create table contacto_confianza(
	id_contactoc int primary key auto_increment,
    nombre varchar(20),
    apellido_p varchar(20),
    apellido_m varchar(20)
);

create table r_contactoc_contacto(
	id_r_con_conc int primary key auto_increment,
    id_contactoc int,
    id_contacto int,
    foreign key (id_contactoc) references contacto_confianza (id_contactoc),
    foreign key (id_contacto) references contacto (id_contacto)
);

create table r_usuario_contactoc(
	id_r_usua_conc int primary key auto_increment,
    id_contactoc int,
    id_usuario int,
    foreign key (id_contactoc) references contacto_confianza (id_contactoc),
    foreign key (id_usuario) references usuario (id_usuario)
);

--------------------------------------------------------------------------------
drop procedure if exists sp_usuario;
delimiter **
create procedure sp_usuario(in tipo int,in nombreu varchar(20),in apellido_pu varchar(20),in apellido_mu varchar(20),in correou varchar(100),in contrau varchar(50),in fechau date,in nssu varchar(20),in clavesu varchar(20),in tsangreu int)
begin
declare validacorreo int;
declare ultimo int;
declare msj int;
if(tipo=0)then
	set validacorreo=(select count(tremor.dato_inicio.correo) from tremor.dato_inicio where tremor.dato_inicio.correo=correou);
    if(validacorreo=0) then
		insert into tremor.dato_inicio values(correou,contrau);
        insert into tremor.datos_vitales values(0,tsangreu,nssu,clavesu);
        set ultimo=(select ifnull(max(tremor.datos_vitales.id_dv),0) from tremor.datos_vitales);
        insert into tremor.usuario values(0,nombreu,apellido_pu,apellido_mu,fechau,correou,ultimo);
        set msj=1;
        select msj;
	else
		set msj=2;
        select msj;
	end if;
else
	if(tipo=1) then
		update tremor.dato_inicio set tremor.dato_inicio.contra=contrau where tremor.dato_inicio.correo=correou;
        update tremor.datos_vitales inner join tremor.usuario set tremor.datos_vitales.tipo_sangre=tsangreu,tremor.datos_vitales.nss=nssu,tremor.datos_vitales.csecreta=clavesu where binary tremor.datos_vitales.id_dv=tremor.usuario.id_dv and binary tremor.usuario.correo=correou;
        update tremor.usuario set tremor.usuario.nombre=nombreu,tremor.usuario.apellido_p=apellido_pu,tremor.usuario.apellido_m=apellido_mu,tremor.usuario.fecha_n=fechau where binary tremor.usuario.correo=correou;
        select 1;
    end if;
end if;
end;**
delimiter ;
/*-------------------------------------------------------------------------------------*/
drop procedure if exists sp_getusuario;
delimiter **
create procedure sp_getusuario(in correou varchar(100),in contrau varchar(50))
begin
select tremor.usuario.* from tremor.usuario inner join tremor.dato_inicio where binary tremor.dato_inicio.correo=correou and binary tremor.dato_inicio.contra=contrau and binary tremor.usuario.correo=tremor.dato_inicio.correo;
end;**
delimiter ;
/*-------------------------------------------------------------------------------------*/
drop procedure if exists sp_contacto_c;
delimiter **
create procedure sp_contacto_c(in tipo int,in correou varchar(100),in nombreu varchar(20),in apellido_pu varchar(20),apellido_mu varchar(20),in id_contaccu int)
begin
declare ultimo int;
declare ultimo2 int;
if(tipo=0) then
	insert into tremor.contacto_confianza values(0,nombreu,apellido_pu,apellido_mu);
    set ultimo=(select ifnull(max(tremor.contacto_confianza.id_contactoc),0) from tremor.contacto_confianza);
    set ultimo2=(select tremor.usuario.id_usuario from tremor.usuario where binary tremor.usuario.correo=correou);
    insert into tremor.r_usuario_contactoc values(0,ultimo,ultimo2);
    select ultimo;
else
	update tremor.contacto_confianza set tremor.contacto_confianza.nombre=nombreu,tremor.contacto_confianza.apellido_p=apellido_pu,tremor.contacto_confianza.apellido_m=apellido_mu where binary tremor.contacto_confianza.id_contactoc=id_contaccu;
    select 1;
end if;
end;**
delimiter ;
/*-------------------------------------------------------------------------------------*/
drop procedure if exists sp_contacto_cs;
delimiter **
create procedure sp_contacto_cs(in tipo int,in contactou varchar(100),in tipocu int,in id_cu int,in idcontacu int)
begin
declare ultimo int;
declare ultimo2 int;
if(tipo=0) then
	insert into tremor.contacto values(0,contactou,tipocu);
    set ultimo=(select ifnull(max(tremor.contacto.id_contacto),0) from tremor.contacto);
    insert into tremor.r_contactoc_contacto values(0,id_cu,ultimo);
else
	update tremor.contacto set tremor.contacto.contacto=contactou where binary tremor.contacto.id_contacto=idcontacu;
end if;
end;**
delimiter ;
/*-------------------------------------------------------------------------------------*/
drop procedure if exists sp_get_contactosc;
delimiter **
create procedure sp_get_contactosc(in correou varchar(100))
begin
declare validacorreo int;
set validacorreo=(select count(tremor.dato_inicio.correo) from tremor.dato_inicio where tremor.dato_inicio.correo=correou);
if(validacorreo=1) then
	select tremor.contacto_confianza.* from tremor.contacto_confianza inner join tremor.r_usuario_contactoc,tremor.usuario where binary tremor.r_usuario_contactoc.id_contactoc=tremor.contacto_confianza.id_contactoc and binary tremor.r_usuario_contactoc.id_usuario=tremor.usuario.id_usuario and binary tremor.usuario.correo=correou;
end if;
end;**
delimiter ;
/*-------------------------------------------------------------------------------------*/
drop procedure if exists sp_get_contactos;
delimiter **
create procedure sp_get_contactos(in id_contaccu int)
begin
select tremor.contacto.* from tremor.contacto inner join tremor.r_contactoc_contacto where binary tremor.contacto.id_contacto=tremor.r_contactoc_contacto.id_contacto and binary tremor.r_contactoc_contacto.id_contactoc=id_contaccu;
end;**
delimiter ;
/*-------------------------------------------------------------------------------------*/
drop procedure if exists sp_delete_contacto;
delimiter **
create procedure sp_delete_contacto(in id_contacu int)
begin
delete from tremor.r_contactoc_contacto where binary tremor.r_contactoc_contacto.id_contacto=id_contacu;
delete from tremor.contacto where binary tremor.contacto.id_contacto=id_contacu;
end;**
delimiter ;
/*-------------------------------------------------------------------------------------*/
drop procedure if exists sp_delete_contacto_c;
delimiter **
create procedure sp_delete_contacto_c(in id_contaccu int,in correou varchar(100))
begin
declare valida int;
set valida=(select count(tremor.r_usuario_contactoc.id_r_usua_conc) from tremor.r_usuario_contactoc inner join tremor.usuario where binary tremor.r_usuario_contactoc.id_contactoc=id_contaccu and binary tremor.r_usuario_contactoc.id_usuario=tremor.usuario.id_usuario and binary tremor.usuario.correo=correou);
if(valida=1) then
	delete from tremor.r_usuario_contactoc where tremor.r_usuario_contactoc.id_contactoc=id_contaccu;
    delete from tremor.contacto_confianza where tremor.contacto_confianza.id_contactoc=id_contaccu;
    select 1;
end if;
end;**
delimiter ;
/*-------------------------------------------------------------------------------------*/
drop procedure if exists sp_get_dv;
delimiter **
create procedure sp_get_dv(in correou varchar(100))
begin
select tremor.datos_vitales.* from tremor.datos_vitales inner join tremor.usuario where binary tremor.datos_vitales.id_dv=tremor.usuario.id_dv and binary tremor.usuario.correo=correou;
end;**
delimiter ;
/*-------------------------------------------------------------------------------------*/
drop procedure if exists sp_delete_usua;
delimiter **
create procedure sp_delete_usua(in correou varchar(100))
begin
delete from tremor.usuario where binary tremor.usuario.correo=correou;
delete from tremor.dato_inicio where binary tremor.dato_inicio.correo=correou;	
end;**
delimiter ;
/*-------------------------------------------------------------------------------------*/
drop procedure if exists sp_delete_dv;
delimiter **
create procedure sp_delete_dv(in iddvu int)
begin
delete from tremor.datos_vitales where binary tremor.datos_vitales.id_dv=iddvu;
end;**
delimiter ;
create type recorrencia_type as enum ('DIARIO', 'SEMANAL', 'QUINZENAL', 'MENSAL');

create table habito (
    id serial primary key,
    titulo varchar(255) not null,
    criado_em timestamp default current_timestamp,
    recorrencia recorrencia_type not null,
    ocorrencias int not null default 1
);
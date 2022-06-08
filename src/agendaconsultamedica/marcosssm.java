//  # Script para inicializar o banco de dados
//
//   create database if not exists marcosssm;
//
//   use marcosssm;
//
//   drop table if exists medico;
//   create table if not exists medico (
//	 idmedico int primary key auto_increment,
//       nome varchar(255) not null,
//       especialidade int not null,
//       crm int not null,
//       cpf varchar(255) not null
//   );
//
//   drop table if exists paciente;
//   create table if not exists paciente (
//       idpaciente int primary key auto_increment,
//       nome varchar(255) not null,
//       cpf varchar(255) not null,
//       idade int not null
//   );
//
//   drop table if exists consulta;
//   create table if not exists consulta (
//       idconsulta int primary key auto_increment,
//       idmedico int not null,
//       idpaciente int not null,
//       convenio varchar(255) not null,
//
//       foreign key (idmedico) references medico(idmedico) on delete cascade on update cascade,
//       foreign key (idpaciente) references paciente(idpaciente) on delete cascade on update cascade
//   );
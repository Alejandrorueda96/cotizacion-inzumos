/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Alejandro Rueda
 * Created: Jul 12, 2023
 */

create table proveedores( 
id bigint not null auto_increment,
nombre varchar(40) not null,
empresa varchar(100) not null,
primary key (id)
);
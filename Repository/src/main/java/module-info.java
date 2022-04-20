/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module Repository {
    requires spring.context;
    requires spring.data.jpa;
    requires tests.domain;
    
    exports sportstats.repository;
}

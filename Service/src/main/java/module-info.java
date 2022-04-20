/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module Service {
    exports sportstats.service;
    
    
    requires spring.context;
    requires Repository;
    requires transitive tests.domain;

}

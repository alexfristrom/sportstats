/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module sportstats.service {
    exports sportstats.service;
    exports sportstats.service.util;
    exports sportstats.service.season.holders;
    
    requires spring.context;
    requires sportstats.repository;
    requires transitive sportstats.domain;

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module sportstats.domain {
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires com.fasterxml.jackson.annotation;
    
    exports sportstats.domain;
    exports sportstats.handler;

}

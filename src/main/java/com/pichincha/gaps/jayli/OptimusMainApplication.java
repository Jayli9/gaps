package com.pichincha.gaps.jayli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Arquitectura tradicional para el recurso sda-msa-gaps-jayli extendiendo
 * de la interfaz generada.
 * <br/>
 * <b>Class</b>: PichinchaOptimusMainApplication<br/>
 * <b>Copyright</b>: &copy; 2025 Banco Pichincha<br/>
 *
 * @author Banco Pichincha <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 *
 * <li>Jayli</li>
 *
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 *
 * <li>Jun 3, 2025 Creaci&oacute;n de Clase.</li>
 *
 * </ul>
 * @version 1.0
 */
@SpringBootApplication

@ComponentScan(basePackages = {"com.pichincha.gaps.jayli",
        "com.pichincha.poc",
        "com.pichincha.services",
        "com.pichincha.common",
        "com.pichincha.transactionallog"
})

public class OptimusMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(OptimusMainApplication.class, args);
    }
}
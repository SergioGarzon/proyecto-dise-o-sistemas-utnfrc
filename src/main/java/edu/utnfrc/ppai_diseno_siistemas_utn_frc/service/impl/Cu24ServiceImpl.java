package edu.utnfrc.ppai_diseno_siistemas_utn_frc.service.impl;

import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.boundary.PantallaGenerarReporte;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.service.ICu24Service;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class Cu24ServiceImpl implements ICu24Service {

    private PantallaGenerarReporte pantallaGenerarReporte;


    @Override
    public void generarRankingDevinos() {
        pantallaGenerarReporte.generarRankingDevinos();
    }
}

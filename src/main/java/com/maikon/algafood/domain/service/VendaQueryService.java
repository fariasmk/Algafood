package com.maikon.algafood.domain.service;

import com.maikon.algafood.domain.filter.VendaDiariaFilter;
import com.maikon.algafood.domain.model.dto.VendaDiaria;

import java.util.List;

public interface VendaQueryService {

    List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro, String timeOffset);
}

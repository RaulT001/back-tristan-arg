package com.argmoviles.backend.models.dto;

import com.argmoviles.backend.models.entity.Activacion;
import com.argmoviles.backend.models.entity.Llamar;

public class LlamarDTO {

	private Llamar llamar;
	private Activacion activacion;
	
	public Llamar getLlamar() {
		return llamar;
	}
	public void setLlamar(Llamar llamar) {
		this.llamar = llamar;
	}
	
	public Activacion getActivacion() {
		return activacion;
	}
	public void setActivacion(Activacion activacion) {
		this.activacion = activacion;
	}
	
	
}

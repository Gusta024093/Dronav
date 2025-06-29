package br.dronav.cefet.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.dronav.cefet.model.Rota;

public class RotaDTO {
	
	public  Long id;
	public String codRota;
	public String nome;
	private String pontoInicial;
	private String pontoFinal;
	

	public RotaDTO(Rota rota)
	{
		this.setID(rota.getId());
		this.setcodRota(rota.getCodRota());
		this.setNome(rota.getNome());
		this.setPontoInicial(rota.getPontoInicial());
		this.setPontoFinal(rota.getPontoFinal());
	}

	public void setID(Long id) {
		this.id = id;
	}
	public void setcodRota(String codRota) {
		this.codRota = codRota;
	}

public static List<RotaDTO> converter(List<Rota> listaRota)
{
	List<RotaDTO> rotasDTO = new ArrayList<RotaDTO>();
	
	for (Iterator<Rota> iterator =  listaRota.iterator(); iterator.hasNext();) {
		Rota rota = (Rota) iterator.next();
		RotaDTO rotaDTO = new RotaDTO(rota);
		
		rotasDTO.add(rotaDTO);
	}
	return rotasDTO;
}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPontoInicial() {
		return pontoInicial;
	}

	public void setPontoInicial(String pontoInicial) {
		this.pontoInicial = pontoInicial;
	}

	public String getPontoFinal() {
		return pontoFinal;
	}

	public void setPontoFinal(String pontoFinal) {
		this.pontoFinal = pontoFinal;
	}

	public String getCodRota() {
		return codRota;
	}
	
}

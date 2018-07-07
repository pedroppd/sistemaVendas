package br.com.sistemaVendas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sistemaVendas.dao.Fornecedordao;
import br.com.sistemaVendas.domain.Fornecedor;

@FacesConverter("fornecedoresConverter")
public class FornecedorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
		try {

			Long codigo = Long.parseLong(valor);

			Fornecedordao dao = new Fornecedordao();

			Fornecedor fornecedor = dao.buscarPorCodigo(codigo);

			return fornecedor;

		} catch (RuntimeException ex) {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object object) {
		try {
			Fornecedor fornecedor = (Fornecedor) object;

			Long codigo = fornecedor.getId();

			return codigo.toString();

		} catch (RuntimeException ex) {
			return null;
		}

	}

}

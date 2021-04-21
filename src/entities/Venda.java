package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Venda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String saleId;
	private ArrayList<ItemVenda> itens = new ArrayList<>();
	private Vendedor salesName;
	
	public Venda() {
	}

	public Venda(String id, String saleId, Vendedor salesName) {
		super();
		this.id = id;
		this.saleId = saleId;
		this.salesName = salesName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public ArrayList<ItemVenda> getItens() {
		return itens;
	}

	public Vendedor getSalesName() {
		return salesName;
	}

	public void setSalesName(Vendedor salesName) {
		this.salesName = salesName;
	}

	public void addItem(ItemVenda item) {
		this.itens.add(item);
	}
	
	public void removeItem(ItemVenda item) {
		this.itens.remove(item);
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", saleId=" + saleId + ", itens=" + itens + ", salesName=" + salesName + "]";
	}
	
	

}

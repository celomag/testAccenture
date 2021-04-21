package aplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import entities.Cliente;
import entities.ItemVenda;
import entities.Venda;
import entities.Vendedor;

public class Bussines {

	private ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	private ArrayList<Venda> listaVendas = new ArrayList<Venda>();

	public Bussines() {
	}

	public void engine(String path) {

		// carregando a lista

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// obtendo linha do aquivo
			String linha = br.readLine();

			// percorrendo a linha
			while (linha != null) {

				// separando por ç
				String[] txt = linha.split("ç");

				// lista os dados do vendedor
				if (txt[0].equals("001")) {
					Vendedor vendedor = new Vendedor(txt[0], txt[1], txt[2], txt[3]);
					listaVendedores.add(vendedor);
				}
				// lista os dados do cliente
				if (txt[0].equals("002")) {
					Cliente cliente = new Cliente(txt[0], txt[1], txt[2], txt[3]);
					listaClientes.add(cliente);
				}
				// lista os dados da venda
				if (txt[0].equals("003")) {

					Vendedor vendedor = new Vendedor();
					vendedor.setNome(txt[3]);// posição que se encontra o nome do vendedor

					Venda venda = new Venda(txt[0], txt[1], vendedor);// id cpf vendedor

					// lista de vendas
					String[] itemVendaVetor = txt[2].split(",");// separa por ,

					// lista de itens por venda
					for (String unidade : itemVendaVetor) {
						String[] itemVendaUnidade = unidade.split("-");

						itemVendaUnidade[2] = itemVendaUnidade[2].replaceAll("]", "");

						ItemVenda item = new ItemVenda(itemVendaUnidade[0], itemVendaUnidade[1], itemVendaUnidade[2]);
						venda.addItem(item);
					}
					listaVendas.add(venda);
				}

				linha = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return;
	}

	public void gravar(String arquivo) throws Exception {

		File f = new File(".\\out\\" + arquivo + "_out.txt");
		if (f.exists()) {
			throw new Exception("Arquivo" + arquivo + "_out.txt ja existente.");
		}

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo), "UTF-8"));

		try {

			// grava resultado cliente
			out.write("Quantidade de clientes: " + listaClientes.size() + "\n");

			// grava resultado vendedor
			out.write("Quantidade de vendedores: " + listaVendedores.size() + "\n");

			// grava resultado ID da venda mais cara
			Venda maiorVenda = new Venda();
			Double total = 0.0;
			Double maiorAnterior = 0.0;
			Double piorAnterior = Double.MAX_VALUE;
			Venda piorVenda = new Venda();
			Double totalAnterior = 0.0;

			for (Venda venda : listaVendas) {

				for (ItemVenda itemVenda : venda.getItens()) {

					Double quantity = Double.valueOf(itemVenda.getQuantity());
					Double price = Double.valueOf(itemVenda.getPrice());
					total += quantity * price;
				}

				if (total > maiorAnterior) {
					maiorVenda = venda;
					maiorAnterior = total;
				}

				if (total < piorAnterior) {
					piorVenda = venda;
					piorAnterior = totalAnterior;
				}
				totalAnterior = total;

			}
			// grava resultado maior venda
			out.write("Maior venda: " + maiorVenda.getId() + "\n");
			// grava resultado pior vendedor
			out.write("Pior vendedor: " + piorVenda.getSalesName().getNome() + "\n");

		} catch (Exception e) {
			throw e;
		} finally {
			out.close();
		}
	}

}

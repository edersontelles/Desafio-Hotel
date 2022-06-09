/**
 * 
 */
package DesafioOO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ederson
 *
 */
public class Hotel {

	/**
	 * @param args
	 */

	static ArrayList<Cliente> arrClientes = new ArrayList<Cliente>();
	static ArrayList<Quarto> arrQuartos = new ArrayList<Quarto>();
	static ArrayList<Check> arrCheckIn = new ArrayList<Check>();

	public static void main(String[] args) throws IOException {

		boolean menu = true;
		int opcaoMenuPrincipal = 0;

		Scanner teclado = new Scanner(System.in);

		while (menu) {
			System.out.println("____________________________________________");
			System.out.println("_______________                _____________");
			System.out.println("______________( MENU PRINCIPAL )____________\n");
			System.out.println("1 - Cadastrar, editar ou excluir Clientes");
			System.out.println("2 - Cadastrar, editar ou excluir Quartos");
			System.out.println("3 - Verificar quartos disponiveis");
			System.out.println("4 - Realizar check-in");
			System.out.println("5 - Realizar check-out");
			System.out.println("6 - Relatorio geral");
			System.out.println("0 - Sair do sistema");

			System.out.print("Selecione a opção acima:");
			opcaoMenuPrincipal = teclado.nextInt();

			if (opcaoMenuPrincipal == 1) { // 1 - Cadastrar, editar ou excluir Clientes
				int opcaoCliente;
				System.out.println("\n*******************************");
				System.out.println("*********** CLIENTE ***********");
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Editar");
				System.out.println("3 - Excluir");
				System.out.println("4 - Listar");
				System.out.print("Selecione opção: ");
				opcaoCliente = teclado.nextInt();

				if (opcaoCliente == 1) { // Cadastrar Cliente
					cadastrarCliente();
				}
				if (opcaoCliente == 2) { // Editar Cliente
					System.out.println("\nEditar Cliente");
					editarCliente();
				}
				if (opcaoCliente == 3) { // Excluir Cliente
					System.out.println("\nExcluir Cliente");
					excluirCliente();
				}
				if (opcaoCliente == 4) { // Listar Cliente
					System.out.println("\nListar Cliente");
					listarCliente();
				}
			}
			if (opcaoMenuPrincipal == 2) { // 2 - Cadastrar, editar ou excluir Quartos
				int opcaoQuarto;
				System.out.println("\n*******************************");
				System.out.println("*********** QUARTO ***********");
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Editar");
				System.out.println("3 - Excluir");
				System.out.println("4 - Listar");
				System.out.print("Selecione opção: ");
				opcaoQuarto = teclado.nextInt();

				if (opcaoQuarto == 1) { // Cadastrar Quarto
					cadastrarQuarto();
				}
				if (opcaoQuarto == 4) { // Listar Quarto
					listarQuarto();
				}

			}
			if (opcaoMenuPrincipal == 3) {
				listarQuartoDilponivel();
			}
			if (opcaoMenuPrincipal == 4) {
				fazerCheckIn();
			}
			if (opcaoMenuPrincipal == 5) {
				fazerCheckOut();
			}
			if (opcaoMenuPrincipal == 6) {
				System.out.println("\n------------------------------------------------------------");
				System.out.println("----------------------- CLIENTE(s) -------------------------");
				listarCliente();
				System.out.println("\n----------------------- QUARTO(s) --------------------------");
				listarQuarto();
				System.out.println("\n----------------------- CHECK-IN ---------------------------");

				if (arrCheckIn.size() == 0)
					System.out.println("\nNENHUM CHECK-IN ENCONTRADO!");

				for (int i = 0; i < arrCheckIn.size(); i++) {
					if (arrCheckIn.get(i) != null) {
						// arrClientes.get(arrCheckIn.get(i).getIdCliente()).getNome();
						// System.out.println("Cliente: " + arrCheckIn.get(i).getIdCliente());
						System.out.println("Cliente: " + arrClientes.get(arrCheckIn.get(i).getIdCliente()).getNome());
						// System.out.println("Quarto : " + arrCheckIn.get(i).getIdQuarto());
						// arrQuartos.get(arrCheckIn.get(i).getIdQuarto()).getNome();
						// System.out.println("Quarto : " + arrCheckIn.get(i).getIdQuarto());
						System.out.println("Quarto : " + arrQuartos.get(arrCheckIn.get(i).getIdQuarto()).getNome());
						System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
					}
				}
				System.out.println(arrCheckIn);
				System.out.println("------------------------------------------------------------\n");
			}
			if (opcaoMenuPrincipal == 0) {
				menu = false;
				System.out.println("\nSISTEMA ENCERRADO!");
			}
		}

	}

	public static void cadastrarCliente() throws IOException {
		Cliente cliente = new Cliente();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Nome: ");
		cliente.setNome(br.readLine());
		// cliente.setDataNs(null);
		System.out.print("Fumante: ");
		cliente.setFumante(new Scanner(System.in).nextBoolean());
		// cliente.setEmail(null);
		// cliente.setTelefone(null);
		// cliente.setCidade(null);
		// cliente.setUf(null);
		cliente.setCheckInFeito(false);

		if (arrClientes.size() == 0) {
			cliente.setId(0);
			arrClientes.add(cliente);
		} else {
			int indiceListaNull = 0;
			Boolean posicaoListaNull = false;

			for (int i = 0; i < arrClientes.size(); i++) {
				if (arrClientes.get(i) == null) {
					indiceListaNull = i;
					posicaoListaNull = true;
					break;
				}

			}
			if (posicaoListaNull == true) {
				cliente.setId(indiceListaNull); // add onde a posição é null e id = numero da posisão
				arrClientes.set(indiceListaNull, cliente);
			} else {
				cliente.setId(arrClientes.size());// add no final da lista e id = tamanho da lista de clientes
				arrClientes.add(cliente);
			}
		}

	}

	public static void excluirCliente() {
		int contNull = 0;

		if (arrClientes.size() == 0) {
			System.out.println("NÃO HÁ CLIENTE CADASTRADO!");
		} else {
			for (int i = 0; i < arrClientes.size(); i++) {

				if (arrClientes.get(i) != null) {
					System.out.println(arrClientes.get(i).getId() + " - " + arrClientes.get(i).getNome());
				} else {
					contNull++;
				}
			}
			if (contNull == arrClientes.size()) {
				System.out.println("NÃO HÁ CLIENTE CADASTRADO!!!");
			} else {
				System.out.print("Digite nº do cliente: ");
				arrClientes.set(new Scanner(System.in).nextInt(), null);
			}
		}
	}

	public static void editarCliente() {
		Scanner teclado = new Scanner(System.in);

		if (arrClientes.size() == 0) {
			System.out.println("NÃO HÁ CLIENTE CADASTRADO!");
		} else {
			for (int i = 0; i < arrClientes.size(); i++) {

				if (arrClientes.get(i) != null) {
					System.out.println(arrClientes.get(i).getId() + " - " + arrClientes.get(i).getNome());
				}

			}
			int numeroCliente = teclado.nextInt();

			System.out.print("Nome: " + arrClientes.get(numeroCliente).getNome() + " alterar para: ");
			arrClientes.get(numeroCliente).setNome(teclado.next());
			System.out.print("Fumante: " + arrClientes.get(numeroCliente).getNome() + " alterar para: ");
			arrClientes.get(numeroCliente).setFumante(new Scanner(System.in).nextBoolean());
		}
	}

	public static void listarCliente() {
		Integer contNull = -1;
		
		if (arrClientes.size() == 0) {
			System.out.println("NÃO HÁ CLIENTE CADASTRADO!");
		} else {
			System.out.println("------------------------------------------------------------");
			for (int i = 0; i < arrClientes.size(); i++) {
				if (arrClientes.get(i) != null) {
					System.out.println("Id: " + arrClientes.get(i).getId() + " | Nome: " + arrClientes.get(i).getNome()
							+ " | Fumante: " + arrClientes.get(i).getFumante() + " | Check-in: "
							+ arrClientes.get(i).getCheckInFeito());
				}
			}
			if(arrClientes.size() == contNull)
				System.out.println("NÃO HÁ CLIENTE CADASTRADO!");
			System.out.println("------------------------------------------------------------");
		}
	}

	public static void cadastrarQuarto() throws IOException {
		Quarto quarto = new Quarto();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Nome: ");
		quarto.setNome(br.readLine());
		// cliente.setDataNs(null);
		System.out.print("Fumante: ");
		quarto.setFumante(new Scanner(System.in).nextBoolean());

		if (arrQuartos.size() == 0) {
			quarto.setId(0);
			quarto.setDisponive(true); // cadastra quarto como disponíveis
			arrQuartos.add(quarto);
		} else {
			int indiceListaNull = 0;
			Boolean posicaoListaNull = false;

			for (int i = 0; i < arrQuartos.size(); i++) {
				if (arrQuartos.get(i) == null) {
					indiceListaNull = i;
					posicaoListaNull = true;
					break;
				}

			}
			if (posicaoListaNull == true) {
				quarto.setId(indiceListaNull); // add onde a posição é null e id = numero da posisão
				quarto.setDisponive(true); // cadastra quarto como disponíveis
				arrQuartos.set(indiceListaNull, quarto);
			} else {
				quarto.setId(arrQuartos.size());// add no final da lista e id = tamanho da lista de quartos
				quarto.setDisponive(true); // cadastra quarto como disponíveis
				arrQuartos.add(quarto);
			}
		}
	}

	public static void excluirQuarto() {
		// implementar
	}

	public static void editarQuarto() {
		// implementar
	}

	public static void listarQuarto() {
		for (int i = 0; i < arrQuartos.size(); i++) {
			if (arrQuartos.get(i) != null) {
				System.out.println("Id: " + arrQuartos.get(i).getId() + " | Nome: " + arrQuartos.get(i).getNome()
						+ " | Fumante: " + arrQuartos.get(i).getFumante() + " | Disponível: "
						+ arrQuartos.get(i).getDisponive());
			}

		}
	}

	public static void listarQuartoDilponivel() {
		boolean disponibilidade = false;
		System.out.println("------------------------------------------------------------");
		for (int i = 0; i < arrQuartos.size(); i++) {
			if (arrQuartos.get(i) != null && arrQuartos.get(i).getDisponive() == true) {
				System.out.println("Id: " + arrQuartos.get(i).getId() + " | Nome: " + arrQuartos.get(i).getNome()
						+ " | Fumante: " + arrQuartos.get(i).getFumante() + " | Disponível: "
						+ arrQuartos.get(i).getDisponive());
				disponibilidade = true;
			}
		}
		System.out.println("------------------------------------------------------------");
		if (disponibilidade == false)
			System.out.println("\nNÃO HÁ QUARTO DISPONIVEL!");
	}

	public static void fazerCheckIn() {
		Check checkIn = new Check();
		Integer idCliente, idQuarto = null;

		// listar clientes sem check-in
		for (int i = 0; i < arrClientes.size(); i++) {
			if (arrClientes.get(i).getCheckInFeito() == false) {
				System.out.println(arrClientes.get(i).getId() + " - " + arrClientes.get(i).getNome());
			}
		}
		System.out.print("Selecione nº do Cliente: ");
		idCliente = new Scanner(System.in).nextInt();

		// verificar quartos disponiveis
		if (arrQuartos.size() == 0) {
			System.out.println("NÃO HÁ QUARTO CADASTRADO!");
		} else {
			for (int i = 0; i < arrQuartos.size(); i++) {
				// Verifica se tem quarto disponivel & se cliente e quarto tem a mesma categoria
				// (fumante/não fumante)
				if (arrQuartos.get(i).getDisponive().equals(true)
						&& arrQuartos.get(i).getFumante().equals(arrClientes.get(idCliente).getFumante())) {
					idQuarto = arrQuartos.get(i).getId();
					break;
				}
			}

			if (idQuarto != null) {
				checkIn.setIdCliente(idCliente);
				arrClientes.get(idCliente).setCheckInFeito(true);

				checkIn.setIdQuarto(idQuarto);
				arrQuartos.get(idQuarto).setDisponive(false);

				arrCheckIn.add(checkIn);
				System.out.println("\nCHECK-IN REALIZADO COM SUCESSO!");
			} else {
				System.out.println("\nNÃO HÁ QUARTO DISPONIVE!");
			}
		}
	}

	public static void fazerCheckOut() {

		Integer idCliente;

		// listar clientes com check-in
		for (int i = 0; i < arrClientes.size(); i++) {
			if (arrClientes.get(i).getCheckInFeito() == true) {
				System.out.println(arrClientes.get(i).getId() + " - " + arrClientes.get(i).getNome());
			}
		}
		System.out.print("Selecione nº do Cliente: ");
		idCliente = new Scanner(System.in).nextInt();

		// pegar posição do cliente na lista de arrCheckIn conforme idCliente
		for (int i = 0; i < arrCheckIn.size(); i++) {
			if (arrCheckIn.get(i).getIdCliente().equals(idCliente)) {
				// arrCheckIn.get(i).getIdQuarto();
				arrClientes.get(idCliente).setCheckInFeito(false);
				arrQuartos.get(arrCheckIn.get(i).getIdQuarto()).setDisponive(true);
				arrCheckIn.remove(i);
				System.out.println("\nCHECK-OUT REALIZADO COM SUCESSO!");
				break;
			}
		}
	}
}

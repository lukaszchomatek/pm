package orders.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import orders.entities.Client;

public class ClientService {
	static List<Client> clients = new ArrayList<Client>();
	
	static {
		clients.add(new Client("Jan", "Kowalski"));
		clients.add(new Client("Zbigniew", "Nowak"));
	}
	
	static List<Client> getClients() {
		return Collections.unmodifiableList(clients);
	}

	public static Client getClient(String clientName, String clientSurname) {
		int index = clients.indexOf(new Client(clientName, clientSurname));
		if (index == -1)
			return null;
		return clients.get(index);
	}
}

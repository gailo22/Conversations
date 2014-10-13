package eu.siacs.conversations.http;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import eu.siacs.conversations.AbstractConnectionManager;
import eu.siacs.conversations.entities.Message;
import eu.siacs.conversations.services.XmppConnectionService;

public class HttpConnectionManager extends AbstractConnectionManager {

	public HttpConnectionManager(XmppConnectionService service) {
		super(service);
	}

	private XmppConnectionService mXmppConnectionService;
	
	private List<HttpConnection> connections = new CopyOnWriteArrayList<HttpConnection>();
	
	
	public HttpConnection createNewConnection(Message message) {
		HttpConnection connection = new HttpConnection(this);
		connection.init(message);
		this.connections.add(connection);
		return connection;
	}
}

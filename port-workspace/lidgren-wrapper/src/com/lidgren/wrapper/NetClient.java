package com.lidgren.wrapper;

public class NetClient {

	public NetEventListener MessageReceivedEvent;

	public NetClient(NetPeerConfiguration _config) {
		// TODO Auto-generated constructor stub
	}

	public void Start() {
		// TODO Auto-generated method stub
		
	}

	public NetOutgoingMessage CreateMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void Connect(String serverIp, int port, NetOutgoingMessage init) {
		// TODO Auto-generated method stub
		
	}

	public NetOutgoingMessage CreateMessage(int bytecount) {
		// TODO Auto-generated method stub
		return null;
	}

	public void SendMessage(NetOutgoingMessage _outMessage,
			NetDeliveryMethod reliableordered) {
		// TODO Auto-generated method stub
		
	}

	public NetIncomingMessage ReadMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void Recycle(NetIncomingMessage _message) {
		// TODO Auto-generated method stub
		
	}

	public void Shutdown(String string) {
		// TODO Auto-generated method stub
		
	}

}
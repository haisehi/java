package callbackRMI;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class Client {
	public static void main(String[] args) throws Exception{
		//khởi tạo đối tượng
		AtClient client = new AtClientImpl();
		UnicastRemoteObject.exportObject(client,0);
		AtServer server=(AtServer)Naming.lookup("rmi://localhost/srvobj");
		//truyền t.chiếu của AtClient từ trình khách lên chủ
		//trình chủ không cần .lookup để truy tìm tc đến AtClient
		server.registerClient(client);
		server.callServerMethod("Client ContactServer");
	}
}

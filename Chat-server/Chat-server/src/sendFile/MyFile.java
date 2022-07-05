package sendFile;

public class MyFile {
	private int id;
	private String name;
	private byte[] data;
	private String fileExtension;
	
	//get,set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	
	//contructor
	public MyFile(int id, String name, byte[] data, String fileExtension) {
		this.id = id;
		this.name = name;
		this.data = data;
		this.fileExtension = fileExtension;
	}
}

package Com.SecurityAuthontiction.Exception;

public class ResourceNotFoundException extends RuntimeException{

	private String sourceName;
	private String fieldName;
	private long fieldValue;
	public ResourceNotFoundException(String sourceName, String fieldName, long fieldValue) {
		super(String.format("%s Not Found With This %s - %s ",sourceName,fieldName,fieldValue));
		this.sourceName = sourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	

}

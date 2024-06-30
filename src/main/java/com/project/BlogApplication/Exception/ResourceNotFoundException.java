package com.project.BlogApplication.Exception;

public class ResourceNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	String resourceName;
	String fieldname;
	long fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
//		super();
		super(String.format("%s not found with %s value as %s", resourceName, fieldName, fieldValue));
		resourceName = this.resourceName;
		fieldName = this.fieldname;
		fieldValue = this.fieldValue;
	}

}

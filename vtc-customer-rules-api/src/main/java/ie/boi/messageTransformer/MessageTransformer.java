package ie.boi.messageTransformer;

import org.mule.api.MuleMessage;
import org.mule.api.transport.PropertyScope;

public class MessageTransformer {
	public MuleMessage processMessage (MuleMessage message){
		String fullURI=message.getInboundProperty("http.request.path");
		//System.out.println("The full URI========="+fullURI);
		
		String[] parts = fullURI.split("/api");
		String result = parts[1];
		message.setProperty("visaURI", result, PropertyScope.SESSION);
		//System.out.println("The Processed URI========="+result);
			
		return message;
	}

}

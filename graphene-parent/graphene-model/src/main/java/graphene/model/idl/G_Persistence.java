/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package graphene.model.idl;

@SuppressWarnings("all")
/**  */
@org.apache.avro.specific.AvroGenerated
public interface G_Persistence {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"G_Persistence\",\"namespace\":\"graphene.model.idl\",\"doc\":\"\",\"types\":[{\"type\":\"enum\",\"name\":\"G_PersistenceState\",\"doc\":\"Persistence save state\",\"symbols\":[\"NEW\",\"MODIFIED\",\"NONE\",\"ERROR\"]}],\"messages\":{\"persistData\":{\"doc\":\"Saves the client state given a session UID.\\r\\n\\t \\r\\n\\t Service URL: /persist\\r\\n\\t HTTP Method: POST\\r\\n\\t \\r\\n\\t @param sessionId \\t\\tsession uid\\r\\n\\t @param data \\t\\t\\tstring representation of client state\\r\\n\\t @return\\t\\t\\t\\tstate of persistence for the sessionId\",\"request\":[{\"name\":\"sessionId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"data\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}],\"response\":\"G_PersistenceState\"},\"getData\":{\"doc\":\"Returns the last saved client state given a session UID.\\r\\n\\t \\r\\n\\t Service URL: /persist\\r\\n\\t HTTP Method: GET\\r\\n\\t \\r\\n\\t @param sessionId \\t\\tsession uid\\r\\n\\t @return \\t\\t\\t\\tclient state data\",\"request\":[{\"name\":\"sessionId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}],\"response\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}}}");
  /** Saves the client state given a session UID.
	 
	 Service URL: /persist
	 HTTP Method: POST
	 
	 @param sessionId 		session uid
	 @param data 			string representation of client state
	 @return				state of persistence for the sessionId */
  graphene.model.idl.G_PersistenceState persistData(java.lang.String sessionId, java.lang.String data) throws org.apache.avro.AvroRemoteException;
  /** Returns the last saved client state given a session UID.
	 
	 Service URL: /persist
	 HTTP Method: GET
	 
	 @param sessionId 		session uid
	 @return 				client state data */
  java.lang.String getData(java.lang.String sessionId) throws org.apache.avro.AvroRemoteException;

  @SuppressWarnings("all")
  /**  */
  public interface Callback extends G_Persistence {
    public static final org.apache.avro.Protocol PROTOCOL = graphene.model.idl.G_Persistence.PROTOCOL;
    /** Saves the client state given a session UID.
	 
	 Service URL: /persist
	 HTTP Method: POST
	 
	 @param sessionId 		session uid
	 @param data 			string representation of client state
	 @return				state of persistence for the sessionId */
    void persistData(java.lang.String sessionId, java.lang.String data, org.apache.avro.ipc.Callback<graphene.model.idl.G_PersistenceState> callback) throws java.io.IOException;
    /** Returns the last saved client state given a session UID.
	 
	 Service URL: /persist
	 HTTP Method: GET
	 
	 @param sessionId 		session uid
	 @return 				client state data */
    void getData(java.lang.String sessionId, org.apache.avro.ipc.Callback<java.lang.String> callback) throws java.io.IOException;
  }
}
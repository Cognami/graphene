package graphene.augment.mitie.dao;

import graphene.business.commons.exception.DataAccessException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;

public interface MITIERestAPIConnection {

	public abstract String performQuery(String inputText)
			throws DataAccessException, UnsupportedEncodingException,
			ClientProtocolException, IOException;

}
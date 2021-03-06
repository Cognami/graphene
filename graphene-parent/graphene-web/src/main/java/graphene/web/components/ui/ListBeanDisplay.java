package graphene.web.components.ui;

import graphene.dao.StyleService;
import graphene.util.validator.ValidationUtils;

import java.util.Collection;
import java.util.List;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.PropertyConduit;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.beaneditor.PropertyModel;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.slf4j.Logger;

@SupportsInformalParameters
public class ListBeanDisplay {

	@Inject
	private BeanModelSource modelSource;

	@Inject
	protected StyleService style;

	@Property
	@Parameter(required = true, autoconnect = true)
	private Collection<Object> listOfThings;
	@Property
	@Parameter(required = true, autoconnect = true)
	private String listName;
	@Parameter(value = "componentResources")
	@Property(write = false)
	private ComponentResources overrides;
	@Property
	private Object currentThing;

	boolean foundOneProperty = false;

	@Inject
	private Logger logger;

	public boolean isValidList() {
		if (!ValidationUtils.isValid(listOfThings)) {
			return false;
		}
		foundOneProperty = false;
		for (final Object i : listOfThings) {
			final BeanModel<? extends Object> model = modelSource
					.createDisplayModel(i.getClass(),
							overrides.getContainerMessages());
			final List<String> names = model.getPropertyNames();
			for (final String p : names) {
				final PropertyModel pm = model.get(p);
				final PropertyConduit conduit = pm.getConduit();
				final Object propertyValue = conduit.get(i);
				if (ValidationUtils.isValid(propertyValue)) {
					if (propertyValue.getClass().isAssignableFrom(
							Collection.class)) {
						// logger.debug("found a collection called " + p);
					} else { // a non list sub object
						return true;
					}
				}
			}
		}
		return foundOneProperty;
	}
}

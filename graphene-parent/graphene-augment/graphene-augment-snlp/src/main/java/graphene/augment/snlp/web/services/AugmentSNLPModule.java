package graphene.augment.snlp.web.services;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import graphene.augment.snlp.services.NERService;
import graphene.augment.snlp.services.NERServiceImpl;

import org.apache.tapestry5.ioc.ServiceBinder;

public class AugmentSNLPModule {

	public static void bind(ServiceBinder binder) {

		binder.bind(NERService.class, NERServiceImpl.class);
	}

	public static CRFClassifier<CoreLabel> buildCRFClassifier() {
		String serializedClassifier = "C:/Users/djue/Documents/GitHub/graphene/graphene-parent/graphene-augment/graphene-augment-snlp/src/main/resources/edu/stanford/nlp/models/ner/english.all.3class.caseless.distsim.crf.ser.gz";
		CRFClassifier<CoreLabel> classifier = CRFClassifier
				.getClassifierNoExceptions(serializedClassifier);
		return classifier;
	}
}

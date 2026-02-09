package org.training.jalo;

import org.training.constants.QuestionsBackofficeConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

public class QuestionsBackofficeManager extends GeneratedQuestionsBackofficeManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( QuestionsBackofficeManager.class.getName() );
	
	public static final QuestionsBackofficeManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (QuestionsBackofficeManager) em.getExtension(QuestionsBackofficeConstants.EXTENSIONNAME);
	}
	
}

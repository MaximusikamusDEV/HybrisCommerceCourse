/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.training.constants;

import de.hybris.platform.acceleratorcms.model.components.CMSProductListComponentModel;
import org.training.model.QuestionsCMSComponentModel;

import java.util.Locale;

public interface QuestionsControllerConstants
{
	String ADDON_PREFIX = "addon:/questions/";

	interface Actions {
		interface Cms {
			String _Prefix = "/view/";
			String _Suffix = "Controller";
			String QuestionsCMSComponent = _Prefix + QuestionsCMSComponentModel._TYPECODE + _Suffix;
			String CMSProductListComponent = _Prefix + CMSProductListComponentModel._TYPECODE + _Suffix;
		}
	}

	interface Views {
		interface Cms {
			String CMSProductListComponentView = CMSProductListComponentModel._TYPECODE.toLowerCase();
		}
	}
}

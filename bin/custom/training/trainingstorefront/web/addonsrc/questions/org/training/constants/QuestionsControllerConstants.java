/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.training.constants;

public interface QuestionsControllerConstants
{
	String ADDON_PREFIX = "addon:/questions";

	interface Actions {
		interface Cms {
			String _Prefix = "/view/";
			String _Suffix = "Controller";
			String ProductQuestionsComponent = _Prefix + "ProductQuestionsComponent" + _Suffix;
		}
	}

	interface Views {
		interface Cms {
			String ComponentPrefix = "cms/";
		}
	}
}

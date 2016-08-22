package com.sky.catalogue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Spring Rest controller for UI navigation requests
 * 
 * @author Ranjan Lal
 *
 */
@Controller
@RequestMapping("/")
public class UIRestController {

	/**
	 * Maps home page URL
	 * 
	 * @return name of index page view
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		return "SkyProductCatalogueIndex";
	}

	/**
	 * Maps template page URL
	 * 
	 * @param templateName
	 *            name of template view to load
	 * @return name of template page view
	 */
	@RequestMapping(value = "/pages/{templateName}", method = RequestMethod.GET)
	public String getTemplatePage(@PathVariable("templateName") String templateName) {
		return templateName;
	}

}